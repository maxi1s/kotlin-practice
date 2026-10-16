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
        if (width>0 && height>0) {
        } else {
            throw IllegalArgumentException("Width and height must be greater than 0")
        }
    }

    fun area(): Double = width*height
    fun perimeter(): Double = 2*(width+height)

    /** Свойство с геттером, не функция. */
    val isSquare: Boolean
        get() = width == height
}

/**
 * Счётчик. `value` можно читать снаружи, но менять — только через методы.
 * Сейчас `var value` открыт на запись — тест проверит только поведение, а ТЫ сделай сеттер private
 * (var value: Int = 0 + private set`). Это и есть инкапсуляция.
 */
class Counter(start: Int = 0) {
    var value: Int = start
        private set
    fun increment() {value++}
    fun decrement() {value--}
    fun reset() { value=0 }
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

    fun deposit(amount: Double) {
        if (amount > 0) {
            _history.add("deposit $amount")
            balance += amount
        }
        else throw IllegalArgumentException("Amount must be greater than 0") }
    fun withdraw(amount: Double) { if (amount > 0) {
        if (amount <= balance){
            _history.add("withdraw $amount")
            balance -= amount }
        else throw IllegalStateException("Insufficient funds") } else throw IllegalArgumentException("Amount must be greater than 0") }
}

/**
 * Стек целых на MutableList. pop/peek на пустом стеке -> NoSuchElementException.
 */
class IntStack {
    private val items = mutableListOf<Int>()

    val size: Int get() = items.size
    fun isEmpty(): Boolean = items.isEmpty()
    fun push(x: Int) { items.add(x) }
    fun pop(): Int = {items.removeAt(items.size - 1)}.invoke()
    fun peek(): Int = {items.last()}.invoke()
}

/**
 * Точка. Вторичный конструктор без аргументов создаёт (0, 0).
 * distanceTo — евклидово расстояние. toString -> "(x, y)", например "(1.0, 2.0)".
 */
class Point(val x: Double, val y: Double) {
    constructor() : this(0.0, 0.0)

    fun distanceTo(other: Point): Double = TODO()
    override fun toString(): String = "($x, $y)"
}
