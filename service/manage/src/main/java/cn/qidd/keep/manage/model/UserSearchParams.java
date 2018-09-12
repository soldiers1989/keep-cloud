package cn.qidd.keep.manage.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class UserSearchParams {
    @ApiModelProperty(value = "用户名", required = true, allowableValues = "张三，李四")
    private String userName;
    @ApiModelProperty("用户昵称")
    @NotBlank
    private String nickName;
    @ApiModelProperty("用户手机号")
    private String tel;
    @Min(0)
    @Max(100)
    private Integer age;
}
