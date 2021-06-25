package proxy.cglib;

public class main {
    public static void main(String[] args) {
        //目标对象
        JavaCoder target = new JavaCoder("will");
        System.out.println(target.getClass());
        //代理对象
        JavaCoder proxy = (JavaCoder) new ProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());
        //执行代理对象方法
        proxy.implDemands("Add username");
    }
}
