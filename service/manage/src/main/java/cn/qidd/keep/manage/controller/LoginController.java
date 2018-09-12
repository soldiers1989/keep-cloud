package cn.qidd.keep.manage.controller;

import cn.qidd.keep.domain.core.Constants;
import cn.qidd.keep.domain.core.Result;
import cn.qidd.keep.domain.entity.jpa.JpaUser;
import cn.qidd.keep.domain.util.SessionStore;
import cn.qidd.keep.manage.model.LoginModel;
import cn.qidd.keep.manage.model.LoginParams;
import cn.qidd.keep.manage.repository.jpa.JpaUserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Api
@RestController
@RequestMapping("/api/login")
@ApiModel(description = "登陆")
public class LoginController {


    @Autowired
    private JpaUserRepository jpaUserRepository;

    @PostMapping("/login")
    @ApiOperation(value = "登陆", notes = "登陆")
    public Result<LoginModel> login(@RequestBody LoginParams loginParams, HttpServletRequest request) {
        LoginModel loginModel = new LoginModel();
        JpaUser user = jpaUserRepository.findJpaUserByUserName(loginParams.getUserName());
        if (Objects.isNull(user)) {
            return new Result<>(Result.Status.FAILURE, "用户不存在");
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (!passwordEncoder.matches(loginParams.getPassword(), user.getPassword())) {
            return new Result<>(Result.Status.FAILURE, "密码错误");
        }
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(60 * 60);
        session.setAttribute(Constants.SESSION_USER, user);
        String token = String.format("%s%s%s", user.getUserName(), "_", session.getId());
        loginModel.setToken(token);
        loginModel.setUser(user);
        SessionStore.getInstance().addUser(token, session);
        return new Result<>(Result.Status.SUCCESS, loginModel);
    }

    @GetMapping("/getUserInfoByToken")
    @ApiOperation(value = "根据token获取用户信息", notes = "根据token获取用户信息")
    public Result<LoginModel> getUserInfoByToken(@RequestHeader("X-UserToken") String token) {
        SessionStore instance = SessionStore.getInstance();
        HttpSession session = instance.getSession(token);
        if (session == null) {
            return new Result<>(Result.Status.FAILURE, "请重新登陆");
        }
        JpaUser user = (JpaUser)session.getAttribute(Constants.SESSION_USER);
        LoginModel loginModel = new LoginModel();
        loginModel.setToken(token);
        loginModel.setUser(user);
        return new Result<>(Result.Status.SUCCESS, loginModel);
    }
}
