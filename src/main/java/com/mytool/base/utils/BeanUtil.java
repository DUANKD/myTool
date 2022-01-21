package com.mytool.base.utils;

/**
 * @author duankd
 * @ClassName BeanUtil
 * @date 2021-02-05 10:45:52
 */
public class BeanUtil {

    public static <T> void getBeanClass(T bean) {
        Class<?> clazz = bean.getClass();
        System.out.println(clazz);
    }
}
