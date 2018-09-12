package cn.qidd.keep.manage.model;

import cn.qidd.keep.domain.entity.jpa.JpaUser;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LoginModel {
    @ApiModelProperty("token")
    private String token;
    @ApiModelProperty("用户信息")
    private JpaUser user;
}
