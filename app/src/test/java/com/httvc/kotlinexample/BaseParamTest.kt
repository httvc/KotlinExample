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

        //if 表达式
        //在Kotlin中，if是一个表达式，即它会返回一个值。因此就不需要三元运算符，普通if就可以

        var max=a
        if(a<b) max=b

        var max1: Int
        if(a>b){
            max=a
        }else{
            max=b
        }

        //表达式
        val max2=if(a>b) a else b

        //if的分支可以是代码块，最后的表达式作为该块的值

        val max3=if(a>b){
            println("Choose a")
            a
        }else{
            println("Choose b")
            b
        }

        println(max3)
        //如果你使用 if 作为表达式而不是语句（例如：返回它的值或者把它赋给变量），该表达式需要有 else 分支

        //when 表达式
       // when 取代了类C语言的switch操作符。其最简单的形式如下：
        val p: Int ?=3
        when(p){
            1-> println("x==1")
            2-> println("x==2")
            else->{//注意这个块
                println("x is neither 1 nor 2")
            }
        }

       //如果很多分支需要用相同的方式处理，则可以把多个分支条件放在一起，用逗号分隔
        when(p){
            0,1-> println("x==0 or x==1")
            else-> println("otherwise")
        }

       // 我们也可以检测一个值在（in）或者不在（!in）一个区间或者集合中：
        when(p){
            in 1..10-> println("x is in 1 to 10 the range")
            !in 10..20-> println("x is outside 10 to 20 the range")
            else -> println("none of the above")
        }

        //检测一个值是（is）或者不是（!is）一个特定类型的值
        //你可以访问该类型的方法和属性而无需任何额外的检测
        val s="1"
        when(s){
            is String -> s.startsWith("prdex")
            else -> false
        }

        //when 也可以用来取代 if-else if链。
        // 如果不提供参数，所有的分支条件都是简单的布尔表达式，而当一个分支的条件为真时则执行该分支
       /* when {
            s::isOdd() -> print("x is odd")
            x.isEven() -> print("x is even")
            else -> print("x is funny")
        }*/

        //Kotlin 也有无装箱开销的专门的类来表示原生类型数组: ByteArray、 ShortArray、IntArray 等等。
        //这些类和 Array 并没有继承关系，但是它们有同样的方法属性集。它们也都有相应的工厂方法:
        val array: IntArray = intArrayOf(1,2,3,4,5)
        val array1: ByteArray = byteArrayOf(1,2,3,4)
        val asc=Array(5,{i->(i*i).toString()})
        for (item in array.iterator()){
            println(item)
        }

        /**
         * return 默认从最直接包围它的函数或者匿名函数返回
         *
         * break 终止最直接包围它的循环
         *
         * continue 继续下一次最直接包围它的循环
         */

        //Break 和 Continue 标签
        //在 Kotlin 中任何表达式都可以用标签（label）来标记。 标签的格式为标识符后跟 @ 符号
        //标签限制的 break 跳转到刚好位于该标签指定的循环后面的执行点。 continue 继续标签指定的循环的下一次迭代。
        loop@ for(i in 1..100){
            for (j in 1..20){
                if (i==j){
                    println("$i------$j")
                    continue@loop
                }else{
                    println("$i------$j")
                    break@loop
                }
            }
        }



    }
    //标签处返回
    //直接返回  标签限制的 return 允许我们从外层函数返回。
    //返回到一层 加@


}