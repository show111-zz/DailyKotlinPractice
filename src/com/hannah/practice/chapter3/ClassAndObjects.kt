package com.hannah.practice.chapter3


/**
 * created by huilee on 2021-11-02
 */
// class
class ClassAndObjects {

}

// 主构造函数 / 次构造函数
class Person(val name: String) {
    var children: MutableList<Person> = mutableListOf()

    constructor(name: String, parent: Person) : this(name) {
        parent.children.add(this)
    }
}

// 继承： open    默认情况下，Kotlin 类是最终（final）的
open class Base(p: Int) // 该类开放继承

class Derived(p: Int) : Base(p)


// 如果派生类没有主构造函数，那么每个次构造函数必须使用 super 关键字初始化其基类型
//class MyView : View {
//    constructor(ctx: Context) : super(ctx)
//    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)
//}

// override 覆盖方法
open class Shape {
    open val vertexCount: Int = 0
    open fun draw() {}
    fun fill() {}
}

class Circle() : Shape() {
    override fun draw() {
        super.draw()
    }
//    fun fill(){}  // final
}

open class Rectangle() : Shape() {
    override var vertexCount: Int = 4

    // 禁止再次覆盖，final
    final override fun draw() {
        super.draw()
    }
}

// override 覆盖属性
interface Shape2 {
    val vertexCount: Int
}

class Rectangle2(override val vertexCount: Int = 4) : Shape2

class Polygon : Shape2 {
    override val vertexCount: Int = 0
}

// 设计一个基类时，应该避免在构造函数、属性初始化器以及 init 块中使用 open 成员。
open class Base2(val name: String) {
    init {
        println("Initializing Base")
    }

    open val size: Int =
        name.length.also {
            println("Initializing size in Base: $it")
        }

    // getter setter
    val isEmpty get() = this.size ==0

    var setterVisibility: String = "abc"
        private set

    var setterWithAnnotation: Any? = null
//        @Inject set
}

class Derived2(
    name: String,
    val lastName: String,
) : Base2(name.capitalize().also { println("Argument for Base2 : $it") }) {
    init {
        println("Initializing Derived")
    }

    override val size: Int =
        (super.size + lastName.length).also {
            println("Initializing size in Derived: $it")
        }
}

// 调用超类实现
open class Rectangle3{
    open fun draw(){
        println("Drawing a rectangle3")
    }
    val borderColor: String get() = "black"
}

class FilledRectangle3 : Rectangle3() {
    override fun draw() {
        super.draw()
        println("Filling the rectangle")
    }
    val fillColor : String get() = super.borderColor
}

// 在一个内部类中访问外部类的超类: super .   super@Outer
class FilledRectangle4: Rectangle3(){
    override fun draw() {
        super.draw()
    }
    inner class Filler{
        fun fill(){ println("Filling") }
        fun drawAndFill(){
            super@FilledRectangle4.draw() // 调用 Rectangle 的 draw() 实现
            fill()
            println("Drawn a filled rectangle with color ${super@FilledRectangle4.borderColor}")
        }
    }
}

//覆盖规则: 实现继承由下述规则规定：如果一个类从它的直接超类继承相同成员的多个实现， 它必须覆盖这个成员并提供其自己的实现
// super<Base>
open class Rectangle5{
    open fun draw(){}
}

interface Polygon5{
    fun draw(){} //  接口成员默认就是“open”的
}

class Square(): Rectangle5(), Polygon5{
    override fun draw() {
        super<Rectangle5>.draw()
        super<Polygon5>.draw()
    }
}

// abstract
// 类以及其中的某些成员可以声明为 abstract。 抽象成员在本类中可以不用实现.
// 我们并不需要用 open 标注一个抽象类或者函数
open class Polygon6{
    open fun draw(){}
}

//用一个抽象成员覆盖一个非抽象的开放成员
abstract class Rectangle6 : Polygon6(){
    abstract override fun draw()
}

//  幕后字段 : field -> 只能用在属性的访问器内 todo 不太理解
fun useBackingField(){
    var count = 0 // 注意：这个初始器直接为幕后字段赋值
//    set(value){
//        if (value >= 0) field = value
//    }
}

/**
 * 编译期常量： const
 *
 * 这种属性需要满足以下要求：
      1.位于顶层或者是 object 声明 或 companion object 的一个成员
      2.以 String 或原生类型值初始化
      3.没有自定义 getter
  */
const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"
@Deprecated(SUBSYSTEM_DEPRECATED) fun foo() { }

// 延迟初始化属性与变量: lateinit todo 需多练习
public class MyTest {
//    lateinit var subject: TestSubject

//    @SetUp fun setup() {
//        subject = TestSubject()
//    }
//
//    @Test fun test() {
//        subject.method()  // 直接解引用
//    }
}

// 要检测一个 lateinit var 是否已经初始化过: -> .isInitialized
fun testInit(){
//    if (foo::bar.isInitialized) {
//        println(foo.bar)
//    }
}

















