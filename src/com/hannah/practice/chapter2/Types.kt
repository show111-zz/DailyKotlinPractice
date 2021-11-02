package com.hannah.practice.chapter2

/**
 * created by huilee on 2021-11-01
 */

// 基本类型： Byte(8), Short(16), Int(32), Long(64), Float(32), Double(64)
// Char, Boolean, Array

/** 显式转换
toByte(): Byte
toShort(): Short
toInt(): Int
toLong(): Long
toFloat(): Float
toDouble(): Double
toChar(): Char
 * */


/** 位运算 : 只用于 Int 与 Long

shl(bits) – 有符号左移
shr(bits) – 有符号右移
ushr(bits) – 无符号右移
and(bits) – 位与
or(bits) – 位或
xor(bits) – 位异或
inv() – 位非
 */
val y = (1 shl 2) and 0x000FF000

// Char
fun decimalDigitValue(c: Char): Int {
    if (c !in '0'..'9') {
        throw IllegalStateException("Out of Range")
    }
    return c.toInt() - '0'.toInt()
}

// Boolean: true, false.
// ||, &&, ！

// Array
// arrayOf(1,2,3)
// arrayOfNulls() ,指定大小，所有元素为空的数组
// 创建一个 Array<String> 初始化为 ["0", "1", "4", "9", "16"]
val asc = Array(5) { i -> (i * i).toString() }

//原生类型数组
val a: IntArray = intArrayOf(1, 2, 3)

//a[0] = a[1] + a[2]
val arr1 = IntArray(5) // [0,0,0,0,0]
val arr2 = IntArray(5) { 32 } // [32,32,32,32,32]
val arr3 = IntArray(5) { it * 1 } // [0,1,2,3,4]

// String
val text = """
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """.trimMargin()

// for
fun useForLoop(){
    val array = arrayOf(3,4,7)
    for ((index, value) in array.withIndex()) {
        println("the element at $index is $value")
    }
}

// while   for..while
fun useWhile(){
    var x = 9
    while (x > 0) {
        x--
    }

    do {
//        val y = retrieveData()
    } while (y != null) // y 在此处可见
}


/**
 * 返回和跳转: return, break, continue
 */

// 标签 : abc@, fooBar@, loop@
fun useLabel(){
    loop@ for (i in 1..10){
        for (j in 1..20){
            if (i != j) break@loop
        }
    }
}

//return
fun foo(){
    listOf(1,2,3,4,5).forEach {
        if (it ==3) return
        print(it)
    }
    println("this point is unreachable")
}

fun foo1(){
    listOf(1,2,3,4,5).forEach lit@{
        if (it == 3) return@lit // 局部返回到该 lambda 表达式的调用者，即 forEach 循环
    }
}

// 隐式标签
fun foo2(){
    listOf(1,2,3,4,5).forEach {
        if (it == 3) return@forEach
    }
}

// 匿名函数
fun foo3(){
    listOf(1,2,3,4,5).forEach(fun(value: Int){
        if (value ==3) return // 局部返回到匿名函数的调用者，即 forEach 循环
    })
}

// 当要返一个回值的时候 return@a 1
fun foo4(){
    run loop@{
        listOf(1,2,3,4,5).forEach {
            if (it ==3) return@loop  // 从传入 run 的 lambda 表达式非局部返回
        }
    }
}









