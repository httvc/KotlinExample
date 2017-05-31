package com.httvc.kotlinexample

/**
 *Created by Android Studio
 *Project：KotlinExample
 *Author：Jiafujie
 *Email：jfjie2013@163.com
 *Date：2017/5/31.
 */
class BaseParamTest {

    //带有两个 Int 参数、返回 Int 的函数
    fun sum(a: Int,b:Int):Int{
        return a+b
    }

    //将表达式作为函数体、返回值类型自动推断的函数
    fun by(a: Int,b: Int)=a*b

    //函数返回无意义的值：
    fun printBy(a:Int,b:Int):Unit{
        println("by of $a and $b is ${a*b}")
    }

    //Unit 返回类型可以省略：
    fun printSum(a: Int,b: Int){
        print("sum of $a and $b is ${a+b}")
    }


}