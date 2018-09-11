package cn.qidd.keep.manage.controller;

import cn.qidd.keep.domain.entity.elastic.ELUser;
import cn.qidd.keep.domain.entity.jpa.User;
import cn.qidd.keep.manage.repository.elastic.UserElasticRepository;
import cn.qidd.keep.manage.repository.jpa.UserJpaRepository;
import cn.qidd.keep.manage.repository.mongo.UserMongoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Api
@RestController
@RequestMapping("/api/test/")
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private UserJpaRepository userJpaRepository;
    @Autowired
    private UserMongoRepository userMongoRepository;
    @Autowired
    private UserElasticRepository userElasticRepository;

    @GetMapping("sayHello")
    @ApiOperation(value = "sayHello")
    public ResponseEntity sayHello() {
        LOGGER.debug("debug say hello");
        LOGGER.info("info say hello");
        LOGGER.warn("warn say hello");
        LOGGER.error("error say hello");
        LOGGER.trace("trace say hello");
        return ResponseEntity.ok().body("hello");
    }

    @GetMapping("jpaTest")
    @ApiOperation(value = "jpaTest")
    public ResponseEntity jpaTest() {
        Optional<User> byId = userJpaRepository.findById("8");
        return byId.map(ResponseEntity::ok).orElse(null);
    }

    @PostMapping("mongoSaveTest")
    @ApiOperation(value = "mongoSaveTest")
    public ResponseEntity mongoSaveTest() {
        cn.qidd.keep.domain.entity.mongo.User user = new cn.qidd.keep.domain.entity.mongo.User();
        user.setId("2");
        user.setUserName("test");
        userMongoRepository.save(user);
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("mongoTest")
    @ApiOperation(value = "mongoTest")
    public ResponseEntity<List<cn.qidd.keep.domain.entity.mongo.User>> mongoTest() {
        List<cn.qidd.keep.domain.entity.mongo.User> all = userMongoRepository.findAll();
        return ResponseEntity.ok().body(all);
    }

    @PostMapping("elasticSaveTest")
    @ApiOperation(value = "elasticSaveTest")
    public ResponseEntity elasticSaveTest() {
        ELUser elUser = new ELUser();
        elUser.setId("1");
        elUser.setUserName("EL");
        userElasticRepository.save(elUser);
        return ResponseEntity.ok().body(null);
    }
}
