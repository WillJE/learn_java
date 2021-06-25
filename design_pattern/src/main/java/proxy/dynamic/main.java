package proxy.dynamic;

import proxy.ICoder;
import proxy.staticmode.JavaCoder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class main {
    public static void main(String[] args) {
        //要代理的真实对象
        ICoder coder = new JavaCoder("Zhang");
        //创建中介类实例
        InvocationHandler handler = new CoderDynamicProxy(coder);
        //获取类加载器（这里使用了反射的知识）
        ClassLoader cl = coder.getClass().getClassLoader();
        //动态产生一个代理类
        ICoder proxy = (ICoder) Proxy.newProxyInstance(cl, coder.getClass().getInterfaces(), handler);
        //通过代理类，执行doSomething方法；
        proxy.implDemands("Modify user management");
    }
}
