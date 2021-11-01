package com.hannah.practice.chapter1

import javafx.scene.shape.Rectangle

/**
 * created by huilee on 2021-10-29
 */

fun main() {
    println("Hello World")
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sum2(a: Int, b: Int) = a + b

fun printSum(a: Int, b: Int): Unit {
    println("sub of $a and $b is ${a + b}")
}

// val 只能赋值一次
fun setVariables() {
    val a: Int = 1
    val b = 2
    val c: Int
    c = 3
}

fun setModifiedVariable() {
    var x = 5
    x += 1
}

/**
 * 顶层变量
 */
val PI = 3.14
var x = 0
fun incrementX() {
    x += 1
}

fun setStringSample() {
    var a = 1
    val s1 = "a is $a"
    a = 2
    val s2 = "${s1.replace("is", "was")}, but now is $a"
}

/**
 * 条件表达式
 */
fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

fun maxOf2(a: Int, b: Int) = if (a > b) a else b

/**
 * 空值与null检测
 */
fun parseInt(str: String): Int? {
    return null
}

fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    if (x != null && y != null) {
        println(x * y)
    } else {
        println(" '$arg1' or '$arg2' is not a number ")
    }
}

fun printProduct2(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    if (x == null) {
        println("Wrong number format in arg1 : '$arg1'")
        return
    }
    if (y == null) {
        println("Wrong number format in arg2 : '$arg2'")
        return
    }
    println(x * y)
}

/**
 * 类型检测与自动类型转换 ：  is
 */
fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        return obj.length
    }
    return null
}

fun getStringLength2(obj: Any): Int? {
    if (obj !is String) return null
    return obj.length
}

fun getStringLength3(obj: Any): Int? {
    if (obj is String && obj.length > 0) return obj.length
    return null
}

/**
 * for， while
 */
fun iteratorItems() {
    val items = listOf("apple", "banana", "kiwifruit")
    //for loop
    for (item in items) {
        println(item)
    }
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }

    // while loop
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }
}

/**
 * when
 */
fun describe(obj: Any): String =
    when (obj) {
        1 -> "One"
        "Hello" -> " Greeting"
        is Long -> " Long"
        !is String -> "Not a String"
        else -> "Unknown"
    }

/**
 * 区间 range
 * for (i in 1..100) { …… }  // 闭区间：包含 100
 * for (i in 1 until 100) { …… } // 半开区间：不包含 100
 */
fun checkInRange() {
    val x = 10
    val y = 9
    if (x in 1..y + 1) {
        println("fits in range")
    }
}

fun checkOutRange() {
    val list = listOf<String>("a", "b", "c")
    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range, too")
    }
}

fun iteratorRange() {
    for (x in 1..5) {
        print(x)
    }
    for (x in 1..10 step 2) {
        print(x)
    }
    for (x in 9 downTo 0 step 3) {
        print(x)
    }
}

/**
 * 集合
 */
fun iteratorList() {
    val items = listOf("apple", "banana", "kiwifruit")
    for (item in items) {
        println(item)
    }

    when {
        "orange" in items -> println("Juicy")
        "apple" in items -> println("apple is fine too")
    }

    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.toUpperCase() }
        .forEach { println(it) }
}

/**
 * 创建基本类型和实例
 */
fun creatObject(){
    val rectangle = Rectangle(5.0,2.0)
}



