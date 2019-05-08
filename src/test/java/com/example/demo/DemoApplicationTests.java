package com.example.demo;

import com.example.controller.TestProducer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private TestProducer producer;

    @Autowired
    private JedisPool jedisPool;

    /**
     * 测试 activemq
     */
    @Test
    public void contextLoads() {
        producer.sendMessage("testmq789456", "12322222");
    }

    @Test
    public void testRedis() {
        Jedis jedis = jedisPool.getResource();
        String name = jedis.get("name");
        System.out.println(name);
        jedis.close();
    }

}

