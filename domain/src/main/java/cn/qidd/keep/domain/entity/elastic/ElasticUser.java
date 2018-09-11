package cn.qidd.keep.domain.entity.elastic;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@Document(indexName = "user", type = "user")
public class ElasticUser implements Serializable {
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
