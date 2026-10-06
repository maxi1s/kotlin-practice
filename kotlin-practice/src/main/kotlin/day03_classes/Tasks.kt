package day03_classes

/*
 * ДЕНЬ 03 — Классы, конструкторы, свойства, init (08.10, Чт, 3–4 ч)
 *
 * Из заметок 28.09: `value + 1` без присваивания; val в конструкторе = поле; Unit вместо return;
 * перепутал area/perimeter. Всё это здесь, но уже под тестами.
 * Запуск:  ./gradlew test --tests "day03_classes.*"
 *
 * ВНИМАНИЕ: здесь каркасы классов уже объявлены, чтобы тесты компилировались.
 * Твоя задача — реализовать тела (TODO) и, где сказано, поменять модификаторы.
 */

/**
 * Прямоугольник. В `init` проверить, что стороны > 0, иначе IllegalArgumentException
 * (подсказка: require(...)).
 */
class Rectangle(val width: Double, val height: Double) {
    init {
        TODO("проверить стороны")
    }

    fun area(): Double = TODO()
    fun perimeter(): Double = TODO()

    /** Свойство с геттером, не функция. */
    val isSquare: Boolean
        get() = TODO()
}

/**
 * Счётчик. `value` можно читать снаружи, но менять — только через методы.
 * Сейчас `var value` открыт на запись — тест проверит только поведение, а ТЫ сделай сеттер private
 * (`var value: Int = 0` + `private set`). Это и есть инкапсуляция.
 */
class Counter(start: Int = 0) {
    var value: Int = start

    fun increment() { TODO() }
    fun decrement() { TODO() }
    fun reset() { TODO() }
}

/**
 * Банковский счёт.
 * - balance снаружи только читается;
 * - deposit(amount): amount <= 0 -> IllegalArgumentException;
 * - withdraw(amount): amount <= 0 -> IllegalArgumentException; amount > balance -> IllegalStateException;
 * - history: список строк вида "deposit 100.0", "withdraw 30.0" — в порядке операций.
 */
class BankAccount(val owner: String, initialBalance: Double = 0.0) {
    var balance: Double = initialBalance
        private set

    private val _history = mutableListOf<String>()
    val history: List<String> get() = _history

    fun deposit(amount: Double) { TODO() }
    fun withdraw(amount: Double) { TODO() }
}

/**
 * Стек целых на MutableList. pop/peek на пустом стеке -> NoSuchElementException.
 */
class IntStack {
    private val items = mutableListOf<Int>()

    val size: Int get() = TODO()
    fun isEmpty(): Boolean = TODO()
    fun push(x: Int) { TODO() }
    fun pop(): Int = TODO()
    fun peek(): Int = TODO()
}

/**
 * Точка. Вторичный конструктор без аргументов создаёт (0, 0).
 * distanceTo — евклидово расстояние. toString -> "(x, y)", например "(1.0, 2.0)".
 */
class Point(val x: Double, val y: Double) {
    constructor() : this(TODO(), TODO())

    fun distanceTo(other: Point): Double = TODO()
    override fun toString(): String = TODO()
}
