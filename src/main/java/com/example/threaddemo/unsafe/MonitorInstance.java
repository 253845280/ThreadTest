package com.example.threaddemo.unsafe;

import sun.misc.Unsafe;

public class MonitorInstance {

    public static String o ="lock";
    public static void main(String[] args) {
        UnsafeInstance.reflectGetUnsafe().monitorEnter(o);
        existsEnter();
    }


    public static void existsEnter()
    {
        try{
            System.out.println("lock");
            //逻辑代码
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            System.out.println("unlock");
            UnsafeInstance.reflectGetUnsafe().monitorExit(o);
        }
    }
}
