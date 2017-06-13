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
    var x = 1  // 自动推断出 `Int` 类型


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

        println(x++)
        println(compare(a, b))
        println(compares(a, c))

        forLoop()

        whileLoop()

        println(whenDescribe(111111111111111))

        base()
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

    //使用条件表达式
    fun compare(a: Int, b: Int): Int {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    //使用 if 作为表达式
    fun compares(a: Int, b: Int) = if (a > b) a else b

    fun forLoop() {
        //for循环
        val items = listOf("Apple", "Banana", "kiwi")
        for (item in items) {
            println(item)
        }

        for (index in items.indices) {
            println("item at $index is ${items[index]}")
        }
    }

    //while 循环
    fun whileLoop() {
        val items = listOf("apple", "orange", "banana")
        var index = 0
        while (index < items.size) {
            println("item at $index is ${items[index]}")
            index++
        }
    }

    fun whenDescribe(obj: Any): String =
            when (obj) {
                1 -> "One"
                "hello" -> "Greeting"
                is Long -> "Long"
                !is String -> "not a string"
                else -> "Unknown"
            }

    fun base(){
        val oneMillion=1_000_000
        val creditCardNumber=1234_5678_9012_3456L
        /**
         *  ===相当于Java中的==
         *  ==相当于Java中的equal()
         *
         *
         */

        val a: Int =1000


       // println(a is Int);
        val boxeda: Int? =a
        val anotherBoxeda: Int? =a
        println ("10===${boxeda===anotherBoxeda}") //true
        println(boxeda===anotherBoxeda)//false

        val b: Int =10


        //println(b is Int)
        val boxedb: Int? =b
        val anotherBoxedb: Int? =b
        println("1000===${boxedb===anotherBoxedb}")  //true
        println(boxedb===anotherBoxedb)//true
        //关于1000和10====中false和true中 是因为缓存-128~127之间的整数，不会生成新的对象，而是从缓存中取出对象。这样可以提高性能

        //if的详细使用
        val c : Byte =1

        /**
         * toByte()  Byte
         * toShort() Short
         * toInt()    Int
         * toLong()   Long
         * toFloat()  Float
         * toDouble() Double
         * toChar()   Char
         */
        val i : Int =c.toInt();

        val l=1L+3 //Long+Int +>Long

        val x=(8 shl 3)
        println("有符号左移<<的值：${x}")

        val y=(8 shr 3)
        println("有符号右移>>的值：${y}")

        val z=(8 ushr 3)
        println("无符号右移>>>的值：${z}")

       //and(bits) – 位与
       // or(bits) – 位或
        //xor(bits) – 位异或
        //inv() – 位非

        //字符
        /**
         * 字符字面值用单引号括起来: '1'。
         * 特殊字符可以用反斜杠转义。
         * 支持这几个转义序列：\t、 \b、\n、\r、\'、\"、\\ 和 \$。
         * 编码其他字符要用 Unicode 转义序列语法：'\uFF00'。
         */
        val d : Char ='2'
        if (d !in '0'..'9')
            throw IllegalArgumentException("Out of range")
        println("显示转换为数字${d.toInt()-'0'.toInt()}");

        /**
         *  字符串
         *  表达式以美元符（$）开头，由一个简单的名字
         *  或者用花括号扩起来的任意表达式
         *  果你需要在原生字符串中表示字面值 $ 字符（它不支持反斜杠转义）
         */
        val e=10
        println("e=$e")

        val f="abc"
        println("$f.length is ${f.length}")

        val price=""" ${'$'}9.99"""
        println("价格为$price")

    }

}