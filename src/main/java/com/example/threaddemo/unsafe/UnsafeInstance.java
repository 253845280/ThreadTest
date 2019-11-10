package com.example.threaddemo.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;


public class UnsafeInstance {

    public static Unsafe reflectGetUnsafe() {
        try {
            //获取反射Unsafe测成员变量
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            //设置为可存取
            field.setAccessible(true);
            //
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
