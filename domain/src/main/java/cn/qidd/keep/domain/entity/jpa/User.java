package cn.qidd.keep.domain.entity.jpa;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Table
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(generator = "myIdStrategy")
    @GenericGenerator(name = "myIdStrategy", strategy = "uuid")
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
