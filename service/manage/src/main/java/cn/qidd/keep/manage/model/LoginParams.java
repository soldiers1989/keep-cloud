package cn.qidd.keep.manage.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginParams {
    @ApiModelProperty(notes = "用户名", required = true)
    @NotBlank
    private String userName;
    @ApiModelProperty(notes = "密码", required = true)
    @NotBlank
    private String password;
}
