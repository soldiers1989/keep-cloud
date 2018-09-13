package cn.qidd.keep.manage.controller.system;

import cn.qidd.keep.domain.core.Constants;
import cn.qidd.keep.domain.core.Result;
import cn.qidd.keep.domain.entity.jpa.JpaUser;
import cn.qidd.keep.domain.util.MD5;
import cn.qidd.keep.manage.model.LoginModel;
import cn.qidd.keep.manage.model.system.UserSearchParams;
import cn.qidd.keep.manage.repository.jpa.JpaUserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sun on 2018/5/20.
 */
@RestController
@RequestMapping("/api/user")
@Api(value = "UserController",description = "用户管理")
public class UserController {

    @Autowired
    private JpaUserRepository jpaUserRepository;

    @PostMapping("/createUser")
    @ApiOperation(value = "新增用户", notes = "新增用户")
    public Result<LoginModel> createUser(@RequestBody JpaUser userParams) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userParams.setPassword(passwordEncoder.encode(MD5.MD5Encode(Constants.DEFAULT_PASSWORD)));
        jpaUserRepository.save(userParams);
        return new Result<>(Result.Status.SUCCESS, "新增成功");
    }

    @PostMapping("/findUsersByPage")
    @ApiOperation(value = "分页查询用户", notes = "分页查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "status", example = "", paramType = "integer", type = "header")
    })
    public Result<List<JpaUser>> findUsersByPage(@Validated @RequestBody UserSearchParams params) {
//        Result<List<User>> usersByPage = findUsersByPage(params);
        return new Result<>(Result.Status.SUCCESS, "新增成功");
    }
}
