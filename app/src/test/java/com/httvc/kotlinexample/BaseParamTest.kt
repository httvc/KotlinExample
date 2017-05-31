package com.httvc.kotlinexample

import org.junit.Test

/**
 *Created by Android Studio
 *Project：KotlinExample
 *Author：Jiafujie
 *Email：jfjie2013@163.com
 *Date：2017/5/31.
 */
class BaseParamTest {
    //可变变量：
    var x=1  // 自动推断出 `Int` 类型



    @Test
    @Throws(Exception::class)
    fun main() {

        //一次赋值（只读）的局部变量
        val a: Int = 1 //立即赋值
        val b = 2;    // 自动推断出 `Int` 类型
        val c: Int //如果没有初始值类型不能省略
        c = 3       // 明确赋值

        println(sum(a, b))
        println(by(a, b))
        printBy(a, c)
        printSum(a, c)

        print(x++)
    }


    //带有两个 Int 参数、返回 Int 的函数
    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    //将表达式作为函数体、返回值类型自动推断的函数
    fun by(a: Int, b: Int) = a * b

    //函数返回无意义的值：
    fun printBy(a: Int, b: Int): Unit {
        println("by of $a and $b is ${a * b}")
    }

    //Unit 返回类型可以省略：
    fun printSum(a: Int, b: Int) {
        print("sum of $a and $b is ${a + b}")
    }

    fun compare(a: Int,b: Int): Int{
        if(a>b){
            return a;
        }else{
            return b;
        }
    }

    fun compares(a: Int,b: Int)=if(a>b)a else b

}