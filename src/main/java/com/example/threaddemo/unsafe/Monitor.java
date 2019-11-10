package com.example.threaddemo.unsafe;

import sun.misc.Unsafe;

public class Monitor {

    public static String o ="lock";
    public static void main(String[] args) {
        Unsafe.getUnsafe().monitorEnter(o);
        //isSystemDomainLoader 检查AppClass加载器
        existsEnter();
    }


    public static void existsEnter()
    {
        try{
            String a="1";
            System.out.println("lock");
            //逻辑代码
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            System.out.println("unlock");
            Unsafe.getUnsafe().monitorExit(o);
        }
    }
}
