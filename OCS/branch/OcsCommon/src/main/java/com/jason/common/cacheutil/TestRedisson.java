package com.jason.common.cacheutil;
import com.jason.common.dbutil.DbUtil;
import redis.clients.jedis.Jedis;

import java.util.List;

import static java.lang.Thread.sleep;


public class TestRedisson {

    public static void main(String[] args) throws InterruptedException {
//        Config config = new Config();
//        config.setTransportMode(TransportMode.NIO);
//        config.useSingleServer().setAddress("redis://192.168.0.114:6379");
//        RedissonClient client = Redisson.create(config);
//        RAtomicLong aLong = client.getAtomicLong("redisson-aa");
//        aLong.set(100L);
//        System.out.println("---------"+aLong.get());

//
//        Config config = new Config();
//
//        config.useSingleServer().setAddress("redis://192.168.0.114:6379");
//        config.useSingleServer().setConnectionMinimumIdleSize(5);
//
//        RedissonClient redisson = Redisson.create(config);
//        RAtomicLong aLong = redisson.getAtomicLong("redisson-aa");
//
//        aLong.set(100L);
//
//        System.out.println("---------"+aLong.get());
//
//        System.out.println(redisson.getConfig());

         String key="messgae#jerry";
         Jedis jedis=new Jedis("192.168.0.114",6379);
         String content=jedis.get(key);
        System.out.println(content);
         if(content==null)
         {
             System.out.println("缓存没有命中");
             DbUtil   util=new DbUtil();
             String  info=util.queryUserInfoByName("jerry");
             System.out.println(info+"key"+key);
             String result=jedis.set(key,info);
             System.out.println("result"+result);
             //jedis.expire(key,20);
         }



//         jedis.lpush("message","tom","jerry","jason");
//         jedis.expire("message",10);

//        List<String> messages=jedis.lrange("message",0,10);
//        System.out.println(messages.size());
//
//         sleep(10);
//         messages.clear();
//
//         messages=jedis.lrange("message",0,10);
//
//         for(String message:messages)
//         {
//             System.out.println(message);
//         }


        }

    }
