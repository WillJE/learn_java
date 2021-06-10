package util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * https://www.cnblogs.com/-beyond/p/10991139.html
 * Jedis连接池
 */
public class JedisUtils {
    private static JedisPool jedisPool;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(5);
        config.setMaxIdle(3);
        config.setMinIdle(2);

        jedisPool = new JedisPool(config, "localhost",6379);
    }

    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}
