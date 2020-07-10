package com.example.asd.config.redis;

import com.example.asd.common.constant.Constant;
import com.example.asd.exception.CustomException;
import com.example.asd.util.common.SerializableUtil;
import com.example.asd.util.common.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Map;
import java.util.Set;

@Component
public class JedisUtil {


    /**
     * 静态注入JedisPool连接池
     * 本来是正常注入JedisUtil，可以在Controller和Service层使用，但是重写Shiro的CustomCache无法注入JedisUtil
     * 现在改为静态注入JedisPool连接池，JedisUtil直接调用静态方法即可
     * https://blog.csdn.net/W_Z_W_888/article/details/79979103
     */
    private static JedisPool jedisPool;

    @Autowired
    public void setJedisPool(JedisPool jedisPool) {
        JedisUtil.jedisPool = jedisPool;
    }

    /**
     * 获取Jedis实例
     * @param
     * @return redis.clients.jedis.Jedis
     * @author dolyw.com
     * @date 2018/9/4 15:47
     */
    public static synchronized Jedis getJedis() {
        try {
            if (jedisPool != null) {
                return jedisPool.getResource();
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new CustomException("获取Jedis资源异常:" + e.getMessage());
        }
    }

    /**
     * 释放Jedis资源
     * @param
     * @return void
     * @author dolyw.com
     * @date 2018/9/5 9:16
     */
    public static void closePool() {
        try {
            jedisPool.close();
        } catch (Exception e) {
            throw new CustomException("释放Jedis资源异常:" + e.getMessage());
        }
    }

    /**
     * 获取redis键值-object
     * @param key
     * @return java.lang.Object
     * @author dolyw.com
     * @date 2018/9/4 15:47
     */
    public static Object getObject(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            byte[] bytes = jedis.get(key.getBytes());
            if (StringUtils.isNotNullByteArr(bytes)) {
                return SerializableUtil.unserializable(bytes);
            }
        } catch (Exception e) {
            throw new CustomException("获取Redis键值getObject方法异常:key=" + key + " cause=" + e.getMessage());
        }
        return null;
    }

    /**
     * 设置redis键值-object
     * @param key
     * @param value
     * @return java.lang.String
     * @author dolyw.com
     * @date 2018/9/4 15:49
     */
    public static String setObject(String key, Object value) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.set(key.getBytes(), SerializableUtil.serializable(value));
        } catch (Exception e) {
            throw new CustomException("设置Redis键值setObject方法异常:key=" + key + " value=" + value + " cause=" + e.getMessage());
        }
    }

    /**
     * 设置redis键值-object-expiretime
     * @param key
     * @param value
     * @param expiretime
     * @return java.lang.String
     * @author dolyw.com
     * @date 2018/9/4 15:50
     */
    public static String setObject(String key, Object value, int expiretime) {
        String result;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.set(key.getBytes(), SerializableUtil.serializable(value));
            if (Constant.OK.equals(result)) {
                jedis.expire(key.getBytes(), expiretime);
            }
            return result;
        } catch (Exception e) {
            throw new CustomException("设置Redis键值setObject方法异常:key=" + key + " value=" + value + " cause=" + e.getMessage());
        }
    }

    /**
     * 获取redis键值-Json
     * @param key
     * @return java.lang.Object
     * @author dolyw.com
     * @date 2018/9/4 15:47
     */
    public static String getJson(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.get(key);
        } catch (Exception e) {
            throw new CustomException("获取Redis键值getJson方法异常:key=" + key + " cause=" + e.getMessage());
        }
    }

    /**
     * 设置redis键值-Json
     * @param key
     * @param value
     * @return java.lang.String
     * @author Wang926454
     * @date 2018/9/4 15:49
     */
    public static String setJson(String key, String value) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.set(key, value);
        } catch (Exception e) {
            throw new CustomException("设置Redis键值setJson方法异常:key=" + key + " value=" + value + " cause=" + e.getMessage());
        }
    }

    /**
     * 设置redis键值-Json-expiretime
     * @param key
     * @param value
     * @param expiretime
     * @return java.lang.String
     * @author Wang926454
     * @date 2018/9/4 15:50
     */
    public static String setJson(String key, String value, int expiretime) {
        String result;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.set(key, value);
            if (Constant.OK.equals(result)) {
                jedis.expire(key, expiretime);
            }
            return result;
        } catch (Exception e) {
            throw new CustomException("设置Redis键值setJson方法异常:key=" + key + " value=" + value + " cause=" + e.getMessage());
        }
    }

    /**
     * 删除key
     * @param key
     * @return java.lang.Long
     * @author Wang926454
     * @date 2018/9/4 15:50
     */
    public static Long delKey(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.del(key.getBytes());
        } catch (Exception e) {
            throw new CustomException("删除Redis的键delKey方法异常:key=" + key + " cause=" + e.getMessage());
        }
    }

    /**
     * key是否存在
     * @param key
     * @return java.lang.Boolean
     * @author Wang926454
     * @date 2018/9/4 15:51
     */
    public static Boolean exists(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.exists(key.getBytes());
        } catch (Exception e) {
            throw new CustomException("查询Redis的键是否存在exists方法异常:key=" + key + " cause=" + e.getMessage());
        }
    }

    /**
     * 模糊查询获取key集合(keys的速度非常快，但在一个大的数据库中使用它仍然可能造成性能问题，生产不推荐使用)
     * @param key
     * @return java.util.Set<java.lang.String>
     * @author Wang926454
     * @date 2018/9/6 9:43
     */
    public static Set<String> keysS(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.keys(key);
        } catch (Exception e) {
            throw new CustomException("模糊查询Redis的键集合keysS方法异常:key=" + key + " cause=" + e.getMessage());
        }
    }

    /**
     * 模糊查询获取key集合(keys的速度非常快，但在一个大的数据库中使用它仍然可能造成性能问题，生产不推荐使用)
     * @param key
     * @return java.util.Set<java.lang.String>
     * @author Wang926454
     * @date 2018/9/6 9:43
     */
    public static Set<byte[]> keysB(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.keys(key.getBytes());
        } catch (Exception e) {
            throw new CustomException("模糊查询Redis的键集合keysB方法异常:key=" + key + " cause=" + e.getMessage());
        }
    }

    /**
     * 获取过期剩余时间
     * @param key
     * @return java.lang.String
     * @author Wang926454
     * @date 2018/9/11 16:26
     */
    public static Long ttl(String key) {
        Long result = -2L;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.ttl(key);
            return result;
        } catch (Exception e) {
            throw new CustomException("获取Redis键过期剩余时间ttl方法异常:key=" + key + " cause=" + e.getMessage());
        }
    }

    /**
     * 往set集合中添加数据
     * @param key
     * @param values
     * @return
     */
    public static Long addSet(String key , String... values ){
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.sadd(key,values);
        } catch (Exception e) {
            throw new CustomException("设置Set方法异常:key=" + key + " values=" + values + " cause=" + e.getMessage());
        }
    }

    /**
     * 删除set集合某个数据
     * @param key
     * @param values
     * @return
     */
    public static Long delSet(String key , String... values ){
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.srem(key, values);
        } catch (Exception e) {
            throw new CustomException("设置Set方法异常:key=" + key + " values=" + values + " cause=" + e.getMessage());
        }
    }

    /**
     * 判断值是否存在
     * @param key
     * @param value
     * @return
     */
    public static boolean checkValueIsInSet(String key , String value ){
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.sismember(key, value);
        } catch (Exception e) {
            throw new CustomException("设置Set方法异常:key=" + key + " value=" + value + " cause=" + e.getMessage());
        }
    }

    /**
     * 查询set集合数据
     * @param key
     * @return
     */
    public static Set<String> getSet(String key ){
        Set<String> set = null;
        try (Jedis jedis = jedisPool.getResource()) {
            set = jedis.smembers(key);
        } catch (Exception e) {
            throw new CustomException("设置Set方法异常:key=" + key + " cause=" + e.getMessage());
        }
        return set;
    }



    /**
     * 往hash集合中添加数据
     * @param key
     * @param field
     * @param value
     * @return
     */
    public static Long addHSet(String key, String field, String value) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.hset(key, field, value);
        } catch (Exception e) {
            throw new CustomException(
                    "新增hash方法异常:key=" + key + " field=" + field + " value=" + value + " cause=" + e.getMessage());
        }
    }


    /**
     * 为哈希表 key 中的指定字段的整数值加上增量 increment 。
     * @param key
     * @param field
     * @param value
     * @return
     */
    public static Long addHincrBy(String key, String field, long value) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.hincrBy(key, field, value);
        } catch (Exception e) {
            throw new CustomException(
                    "新增hash方法异常:key=" + key + " field=" + field + " value=" + value + " cause=" + e.getMessage());
        }
    }


    /**
     * 删除一个或多个哈希表字段
     * @param key
     * @param fields
     * @return
     */
    public static Long delHSet(String key , String... fields){
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.hdel(key, fields);
        } catch (Exception e) {
            throw new CustomException("删除一个或多个哈希表字段方法异常:key=" + key + " fields=" + fields + " cause=" + e.getMessage());
        }
    }

    /**
     * 查看哈希表 key 中，指定的字段是否存在。
     * @param key
     * @param field
     * @return
     */
    public static boolean checkValueIsInHexists(String key , String field ){
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.hexists(key, field);
        } catch (Exception e) {
            throw new CustomException("查看哈希表 key 中，指定的字段是否存在方法异常:key=" + key + " field=" + field + " cause=" + e.getMessage());
        }
    }

    /**
     * 获取在哈希表中指定 key 的所有字段和值
     * @param key
     * @return
     */
    public static Map<String, String> getHGetAll(String key){
        Map<String, String> map = null;
        try (Jedis jedis = jedisPool.getResource()) {
            map = jedis.hgetAll(key);
        } catch (Exception e) {
            throw new CustomException("获取在哈希表中指定 key 的所有字段和值方法异常:key=" + key + " cause=" + e.getMessage());
        }
        return map;
    }

    /**
     * 获取存储在哈希表中指定字段的值。
     * @param key
     * @param field
     * @return
     */
    public static String getHGet(String key, String field){
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.hget(key, field);
        } catch (Exception e) {
            throw new CustomException("获取Set方法异常:key=" + key + " cause=" + e.getMessage());
        }
    }
}
