package com.example.threaddemo.Volatile;

public class happensBefor {

    public static void test(){
        /**
         * as-if-serial语义的意思是：不管怎么重排序（编译器和处理器为了提高并行度），（单线程）
         * 程序的执行结果不能被改变。编译器、runtime和处理器都必须遵守as-if-serial语义。
         */
        double a = 3.0;
        double b = 1.0;
        double c = a+b;
        System.out.println(c);;

    }

    public static void main(String[] args) {
        test();
    }
}
