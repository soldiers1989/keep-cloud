package cn.qidd.keep.config;

import cn.qidd.keep.domain.entity.jpa.JpaUser;
import cn.qidd.keep.manage.ManageApplication;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by sunyanping on 2018/9/13
 */
@SpringBootTest(classes = ManageApplication.class)
@RunWith(SpringRunner.class)
@Component
public class RedisConfigTest {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void redisTest() {
        JpaUser user = new JpaUser();
        user.setId("111");
        user.setCreateTime(new Date());
        user.setUserName("孙艳平");
        redisTemplate.opsForValue().set(user.getId(), user);
    }

    @Test
    public void stringRedisTest() {
        stringRedisTemplate.opsForValue().set("test:string", "束制导什么");
    }
}
