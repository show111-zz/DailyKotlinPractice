package com.hannah.practice.chapter1

import java.awt.Rectangle
import java.io.File
import java.math.BigDecimal
import java.nio.file.Files
import java.nio.file.Paths

/**
 * created by huilee on 2021-10-30
 */
fun main() {
//    iteratorMap()
    switchVariables()
}

/**
 * DTOs / POJOs
 * - 所有属性的 getters （对于 var 定义的还有 setters）
 * - copy()
 */
data class Customer(val name: String, val email: String)

// 函数的默认参数
fun foo(a: Int = 0, b: String = "") {}

// 过滤list
fun filterList() {
    val list = listOf(1, -2, 4, 0, 9)
    val positives1 = list.filter { x -> x > 0 }
    val positives2 = list.filter { it > 0 }
}

// 检测元素是否在集合中
fun elementInList() {
    //只读 list
    val emailsList = listOf("h1@example.com", "h2@example.com")
    if ("h2@example.com" in emailsList) {
        print("exist")
    }
    if ("h3@example.com" !in emailsList) {
        print("not exist")
    }
}

// 类型判断
fun checkType() {
    when (x) {
//        is Foo //->
//        is Bar //
//        else  //
    }
}

// 遍历 map/pair型list
fun iteratorMap() {
    //只读 map
    val map = mapOf("a" to 1, "b" to 2, "c" to 3)
    for ((k, v) in map) {
        println("$k -> $v")
    }
    // 访问map
    println(map["a"])
}

// 延迟属性： 第一次调用get() 会执行已传递给 lazy() 的 lambda 表达式并记录结果， 后续调用get() 只是返回记录的结果。
val p: String by lazy {
    "Hello"
}

// 扩展函数
fun String.spaceToCamelCase() {}
//"Convert this to camelcase".spaceToCamelCase()

// 创建单例
object Resource {
    val name = "lee"
}

// 缩写
fun checkNullAbbr() {
    val files = File("Test").listFiles()
    // if not null 缩写
    println(files?.size)
    // If not null and else 缩写
    println(files?.size ?: "empty")

    // if not null 执行代码
    files?.let {
        print("假如files不为null代码会执行到此处")
    }
    // 映射可空值（如果非空的话
//    val mapped = files?.let { transformValue(it) } ?: defaultValue

    // if null 执行一个语句
    val values = mapOf("email" to 1, "phone" to 2, "address" to 3)
    val email = values["email"] ?: throw IllegalStateException("Email is missing")
}

// 在可能会空的集合中取第一元素
fun getFirstElement() {
    val emails = listOf("h1@example.com", "h2@example.com")
    val mainEmail = emails.firstOrNull() ?: ""
}

// when
fun transform(color: String): Int {
    return when (color) {
        "Red" -> 1
        "Green" -> 2
        "Blue" -> 3
        else -> throw IllegalStateException("Invalid color param value")
    }
}

// if
fun foo(param: Int) {
    val result = if (param == 1) {
        "One"
    } else if (param == 2) {
        "Two"
    } else {
        "Three"
    }
}

/** 返回类型为 Unit 的方法的 Builder 风格用法 */
fun arrayOfMinusOnes(size: Int): IntArray {
    return IntArray(size).apply { fill(-1) }
}

/** 对一个对象实例调用多个方法 （with）*/
class Turtle {
    fun penDown() {}
    fun penUp() {}
    fun turn(degrees: Double) {}
    fun forward(pixels: Double) {}
}

fun invokeMultipleMethods() {
    val turtle = Turtle()
    with(turtle) {
        penDown()
        for (i in 1..4) {
            forward(100.0)
            turn(90.0)
        }
        penUp()
    }
}

/** 配置对象的属性（apply） */
val myRectangle = Rectangle().apply {
    x = 0
    y = 0
    width = 100
    height = 50
}

//try-catch
fun test() {
    val result = try {
        //count()
    } catch (e: ArithmeticException) {
        throw IllegalStateException(e)
    }
}

// try with resources
fun test2() {
    val stream = Files.newInputStream(Paths.get("some/file.txt"))
    stream.buffered().reader().use { reader ->
        println(reader.readLines())
    }
}

// 对于需要泛型信息的泛型函数的适宜形式
//inline fun <refied T : Any>Gson.fromJson(json: JsonElement) : T = this.fromJson(json, T::class.java)

// 使用可空布尔
fun boolNullCheck() {
    val b: Boolean? = true
    if (b == true) {

    } else {
        // b 是false或者Null
    }
}

/**
 * 交换两个变量
 *
 * 解释： kotlin中一切都是对象。
 * b = a : 让b这个对象变量指向了原来a对象,
 * 但原始的b对象本身还在
 * a=this（原始的b）就达到了a，b交换
 */
fun switchVariables() {
    var a = 1
    var b = 2
    a = b.also { b = a }
    println("a value is $a, b value is $b")
}

// to do
fun calcTaxes(): BigDecimal = TODO("Waiting for feedback from accounting")













