package cn.qidd.keep.message.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping("/api/test")
public class TestController {


    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("sayHello")
    @ApiOperation(value = "sayHello")
    public ResponseEntity sayHello() {
        return ResponseEntity.ok().body("hello");
    }
}
