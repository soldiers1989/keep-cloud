package cn.qidd.keep.common.controller;

import cn.qidd.keep.common.repository.elastic.ElasticUserRepository;
import cn.qidd.keep.common.repository.jpa.JpaUserRepository;
import cn.qidd.keep.common.repository.mongo.MongoUserRepository;
import cn.qidd.keep.domain.entity.elastic.ElasticUser;
import cn.qidd.keep.domain.entity.jpa.JpaUser;
import cn.qidd.keep.domain.entity.mongo.MongoUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Api
@RestController
@RequestMapping("/api/test")
public class TestController {


    private final static Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private JpaUserRepository jpaUserRepository;
    @Autowired
    private MongoUserRepository mongoUserRepository;
    @Autowired
    private ElasticUserRepository elasticUserRepository;

    @GetMapping("jpaTest")
    @ApiOperation(value = "jpaTest")
    public ResponseEntity jpaTest() {
        Optional<JpaUser> byId = jpaUserRepository.findById("8");
        return byId.map(ResponseEntity::ok).orElse(null);
    }

    @PostMapping("mongoSaveTest")
    @ApiOperation(value = "mongoSaveTest")
    public ResponseEntity mongoSaveTest() {
        MongoUser mongoUser = new MongoUser();
        mongoUser.setId("2");
        mongoUser.setUserName("test");
        mongoUserRepository.save(mongoUser);
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("mongoTest")
    @ApiOperation(value = "mongoTest")
    public ResponseEntity<List<MongoUser>> mongoTest() {
        List<MongoUser> all = mongoUserRepository.findAll();
        return ResponseEntity.ok().body(all);
    }

    @PostMapping("elasticSaveTest")
    @ApiOperation(value = "elasticSaveTest")
    public ResponseEntity elasticSaveTest() {
        ElasticUser elasticUser = new ElasticUser();
        elasticUser.setId("1");
        elasticUser.setUserName("EL");
        elasticUserRepository.save(elasticUser);
        return ResponseEntity.ok().body(null);
    }
}
