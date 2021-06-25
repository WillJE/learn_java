package com.will.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestAnnotation {
    String test();

    int number() default 66;
}
/**
 * 参考文档：
 * https://segmentfault.com/a/1190000038172702
 *
 */
