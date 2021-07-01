package com.will.gc;

/**
 * https://learnjava.baimuxym.cn/#/articles\JVM\%E7%B1%BB%E5%8A%A0%E8%BD%BD%E8%BF%87%E7%A8%8B%E5%92%8C%E5%8F%8C%E4%BA%B2%E5%A7%94%E6%B4%BE%E6%A8%A1%E5%9E%8B
 */
public class HelloCoder {
    public static int staticValue = 123;
    public static final int  finalValue = 456;

    public static void main(String[] args) {
        System.out.println(staticValue);
        System.out.println(finalValue);
    }
}
