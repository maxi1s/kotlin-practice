package day04_inheritance

/*
 * ДЕНЬ 04 — Наследование, абстрактные классы, интерфейсы, полиморфизм (10.10, Сб, 4–5 ч)
 *
 * Ключевые слова дня: open, abstract, override, super, interface, default-методы интерфейса.
 * Запуск:  ./gradlew test --tests "day04_inheritance.*"
 *
 * Каркасы объявлены, чтобы проект компилировался. Твоя работа — тела и правильные
 * модификаторы. Если понимаешь, что каркас можно сделать лучше (например, name через
 * override val в конструкторе) — делай, тесты смотрят только на поведение.
 */

/** Фигура. describe() -> "<name> with area <area с 2 знаками>", напр. "Circle with area 3.14". */
abstract class Shape {
    abstract fun area(): Double
    abstract val name: String
    open fun describe(): String = TODO()
}

class Circle(val radius: Double) : Shape() {
    override val name: String get() = TODO()
    override fun area(): Double = TODO()
}

class Rect(val width: Double, val height: Double) : Shape() {
    override val name: String get() = TODO()
    override fun area(): Double = TODO()
}

/** Формула Герона. Если треугольника с такими сторонами не существует — IllegalArgumentException в init. */
class Triangle(val a: Double, val b: Double, val c: Double) : Shape() {
    init {
        TODO("проверить неравенство треугольника")
    }
    override val name: String get() = TODO()
    override fun area(): Double = TODO()
}

/** Сумма площадей — полиморфизм: один цикл/sumOf, никаких проверок `is`. */
fun totalArea(shapes: List<Shape>): Double = TODO()

/** Сотрудник. monthlySalary() = baseSalary. */
open class Employee(val name: String, val baseSalary: Double) {
    open fun monthlySalary(): Double = TODO()
}

/** Менеджер: monthlySalary() = зарплата родителя (через super) + bonus. */
class Manager(name: String, baseSalary: Double, val bonus: Double) : Employee(name, baseSalary) {
    override fun monthlySalary(): Double = TODO()
}

/** Фонд зарплат за месяц. */
fun payroll(staff: List<Employee>): Double = TODO()

/**
 * Интерфейс с методом по умолчанию.
 * logError(msg) — default-реализация: log("ERROR: $msg").
 */
interface Logger {
    fun log(message: String)
    fun logError(message: String) { TODO() }
}

/** Копит все сообщения в `lines`, ничего не печатает. */
class ConsoleLogger : Logger {
    val lines = mutableListOf<String>()
    override fun log(message: String) { TODO() }
}

/**
 * Два интерфейса с одинаковым default-методом — конфликт надо разрулить явно
 * через super<A>.hello() и super<B>.hello(). Ожидается "A+B".
 */
interface A { fun hello(): String = "A" }
interface B { fun hello(): String = "B" }
class AB : A, B {
    override fun hello(): String = TODO()
}
