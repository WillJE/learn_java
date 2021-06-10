package usage.bloomfilter;

import redis.clients.jedis.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 布隆过滤器
 */
public class BloomTest {
    private String chars;
    {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 26; i++){
            builder.append((char)('a'+i));
        }
        chars = builder.toString();
    }

    private String randomString(int n){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++){
            int i1 = ThreadLocalRandom.current().nextInt(chars.length());
            builder.append(chars.charAt(i1));
        }
        return builder.toString();
    }

    private List<String> randomUsers(int n){
        List<String> users = new ArrayList<>();
        for(int i = 0; i < 100000; i++){
            users.add(randomString(64));
        }
        return users;
    }
    public static void main(String[] args) {
        BloomTest bloomTest = new BloomTest();
        List<String> users = bloomTest.randomUsers(100000);
        List<String> userTrain = users.subList(0, users.size() / 2);
        List<String> usersTest = users.subList(users.size() / 2, users.size());
        Client client = new Client();
    }
}
