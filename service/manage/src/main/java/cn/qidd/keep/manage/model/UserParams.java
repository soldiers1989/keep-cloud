package cn.qidd.keep.manage.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserParams {
    @ApiModelProperty("用户名")
    @NotNull
    @Size(min = 6, message = "用户名最少6位")
    private String userName;
    @ApiModelProperty("用户昵称")
    private String nickName;
    @ApiModelProperty("用户手机号")
    private String tel;
    @ApiModelProperty("备注")
    private String remark;
}
