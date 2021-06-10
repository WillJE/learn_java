package usage.hypherlog;

import redis.clients.jedis.Jedis;
import util.JedisUtils;

public class PFTest {
    public static void main(String[] args) {
        Jedis jedis = JedisUtils.getJedis();
        for (int i = 0; i < 1000; i++){
            jedis.pfadd("codehole","user"+i);
            long codehole = jedis.pfcount("codehole");
            if (codehole != i+1){
                System.out.printf("%d%d\n",codehole,i+1);
                break;
            }
        }
        jedis.close();
    }
}
