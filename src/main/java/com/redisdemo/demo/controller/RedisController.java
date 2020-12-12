package com.redisdemo.demo.controller;

import com.redisdemo.demo.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RedisController {
    protected static Logger logger = (Logger) LoggerFactory.getLogger(RedisController.class);

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    // 例如：http://localhost:9090/set?key=name&value=minbo英文名
    @RequestMapping("/set")
    public void setKeyAndValue(String key, String value) {
        logger.debug("访问set:key={},value={}", key, value);
        RedisUtil.set(this.redisTemplate, key, value);

    }

    // 例如：http://localhost:9090/get?key=name
    @RequestMapping("/get")
    public String getKey(String key) {
        logger.debug("访问get:key={}", key);
        String result = (String) RedisUtil.get(this.redisTemplate, key);
        logger.debug("get result=" + result);
        return result;
    }
    @GetMapping("redis")
    public Object getRedis(){

        //RedisUtil.set(redisTemplate,"stuname","Tom");
        return RedisUtil.get(redisTemplate,"stuname");
    }

}
