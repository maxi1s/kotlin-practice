package day01_basics

/*
 * ДЕНЬ 01 — Разминка: переменные, функции, циклы, when (06.10, Вт, 3–4 ч)
 *
 * Цель дня: проверить, что база из первой недели реально в руках, а не в голове.
 * Правила: не гуглить готовые решения, доки по стандартной библиотеке — можно.
 * Запуск проверки:  ./gradlew test --tests "day01_basics.*"
 *
 * Замени каждое TODO() на реализацию. Тесты лежат в src/test/kotlin/day01_basics.
 */

/** Классика: "Fizz" если делится на 3, "Buzz" если на 5, "FizzBuzz" если на оба, иначе число строкой. */
fun fizzBuzz(n: Int): String = TODO()

/** Простое ли число. Для n < 2 — false. */
fun isPrime(n: Int): Boolean = TODO()

/** Сумма цифр числа. Отрицательные — по модулю: sumOfDigits(-123) == 6. */
fun sumOfDigits(n: Long): Int = TODO()

/** n-е число Фибоначчи: fib(0)=0, fib(1)=1, fib(10)=55. Без рекурсии (цикл). */
fun fibonacci(n: Int): Long = TODO()

/**
 * Оценка по баллам через `when`:
 * 90..100 -> "A", 80..89 -> "B", 70..79 -> "C", 60..69 -> "D", 0..59 -> "F".
 * Вне 0..100 — бросить IllegalArgumentException.
 */
fun gradeFor(score: Int): String = TODO()

/** Перевернуть строку. Без reversed() — руками, через цикл или StringBuilder. */
fun reverseManually(s: String): String = TODO()

/** Максимум в списке. Пустой список -> null. Без max()/maxOrNull() — руками. */
fun maxManually(numbers: List<Int>): Int? = TODO()
