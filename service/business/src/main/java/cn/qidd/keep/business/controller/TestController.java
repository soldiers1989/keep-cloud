package cn.qidd.keep.business.controller;

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
@RequestMapping("/api/test/")
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

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
}
