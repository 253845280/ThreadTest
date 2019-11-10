package com.example.threaddemo.SynchronizedLock;

public class test {
    StringBuffer stb = new StringBuffer();


    public void test1(){
        //jvm的优化，锁的粗化
        stb.append("1");
        stb.append("2");
        stb.append("3");
        stb.append("4");
    }

    /**
     * 锁的消除
     */
    public void test2(){
        //jvm的优化，JVM不会对同步块进行加锁
        synchronized (new Object()) {
            //jvm是否会加锁？
        }
    }

    public static void main(String[] args) {
        test t = new test();
    }
}
