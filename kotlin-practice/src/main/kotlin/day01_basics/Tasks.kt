package day01_basics

import kotlin.math.absoluteValue

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
fun fizzBuzz(n: Int): String{
    if (n>=3) {
        if (n % 3 == 0 && n % 5 == 0)
            return "FizzBuzz"
        else if (n % 5 == 0)
            return "Buzz"
        else if (n % 3 == 0)
            return "Fizz"
    }
    return n.toString()
}

/** Простое ли число. Для n < 2 — false. */
fun isPrime(n: Int): Boolean{
    var c = 0
    if (n >= 2){
        for (i in 1..n){
            if(n%i==0)c++
        }
    }
    return c==2
}

/** Сумма цифр числа. Отрицательные — по модулю: sumOfDigits(-123) == 6. */
fun sumOfDigits(n: Long): Int {
    var x = n.absoluteValue
    var sum = 0
    while (x > 0) {
        sum += (x % 10).toInt()
        x /= 10
    }
    return sum
}

/** n-е число Фибоначчи: fib(0)=0, fib(1)=1, fib(10)=55. Без рекурсии (цикл). 1 1 2 3 5 8 13 21*/
fun fibonacci(n: Int): Long{
    var prev = 1.0 // 2
    var c=1.0
    var ntemp : Double
    when{
        n==0 -> return 0
        n==1 -> return 1
        n==2 -> return 1
    }
    for (i in 3..n) {
        ntemp = c
        c += prev
        prev = ntemp
    }
    return c.toLong()
}

/**
 * Оценка по баллам через `when`:
 * 90..100 -> "A", 80..89 -> "B", 70..79 -> "C", 60..69 -> "D", 0..59 -> "F".
 * Вне 0..100 — бросить IllegalArgumentException.
 */
fun gradeFor(score: Int): String=
    when(score){
        in 90..100->return "A"
        in 80..89->return "B"
        in 70..79->return "C"
        in 60..69->return "D"
        in 0..59->return "F"
        else -> throw IllegalArgumentException("Балл вне 0..100: $score")
    }

/** Перевернуть строку. Без reversed() — руками, через цикл или StringBuilder. */
fun reverseManually(s: String): String {
    val sb = StringBuilder()
    for (i in s.lastIndex downTo 0) {
        sb.append(s[i])
    }
    return sb.toString()
}

/** Максимум в списке. Пустой список -> null. Без max()/maxOrNull() — руками. */
fun maxManually(numbers: List<Int>): Int? {
    if (numbers.isEmpty()) return null
    var max = numbers[0]          // тут уже Int, не Int?
    for (number in numbers) {
        if (number > max) max = number
    }
    return max
}
