package cn.qidd.keep.domain.entity.mongo;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@Document
public class User implements Serializable {
    @Id
    private String id;
    private String userName;
    private String password;
    private String nickName;
    private String tel;
    private String remark;
    private String roleId;
    private Date createTime;
    private Date updateTime;
    private String operatorId;
}
