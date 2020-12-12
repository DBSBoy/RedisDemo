package com.redisdemo.demo.test;

import org.springframework.data.redis.core.RedisTemplate;

public class redisTest {
    public static void main(String[] args){
        RedisTemplate<String,Object> redisTemplate=new RedisTemplate<>();
        redisTemplate.opsForValue().set("name","marry");
        System.out.println(redisTemplate.opsForValue().get("name"));
    }
}
