package day01_basics

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

class TasksTest {

    @Test
    fun `fizzBuzz basic`() {
        assertEquals("1", fizzBuzz(1))
        assertEquals("Fizz", fizzBuzz(3))
        assertEquals("Buzz", fizzBuzz(5))
        assertEquals("FizzBuzz", fizzBuzz(15))
        assertEquals("Fizz", fizzBuzz(9))
        assertEquals("FizzBuzz", fizzBuzz(30))
    }

    @Test
    fun `isPrime works`() {
        assertFalse(isPrime(0))
        assertFalse(isPrime(1))
        assertTrue(isPrime(2))
        assertTrue(isPrime(3))
        assertFalse(isPrime(4))
        assertTrue(isPrime(97))
        assertFalse(isPrime(100))
        assertTrue(isPrime(7919))
    }

    @Test
    fun `sumOfDigits works`() {
        assertEquals(0, sumOfDigits(0))
        assertEquals(6, sumOfDigits(123))
        assertEquals(6, sumOfDigits(-123))
        assertEquals(45, sumOfDigits(123456789L))
    }

    @Test
    fun `fibonacci works`() {
        assertEquals(0L, fibonacci(0))
        assertEquals(1L, fibonacci(1))
        assertEquals(1L, fibonacci(2))
        assertEquals(55L, fibonacci(10))
        assertEquals(12586269025L, fibonacci(50))
    }

    @Test
    fun `gradeFor works`() {
        assertEquals("A", gradeFor(100))
        assertEquals("A", gradeFor(90))
        assertEquals("B", gradeFor(89))
        assertEquals("C", gradeFor(75))
        assertEquals("D", gradeFor(60))
        assertEquals("F", gradeFor(0))
        assertEquals("F", gradeFor(59))
        assertFailsWith<IllegalArgumentException> { gradeFor(101) }
        assertFailsWith<IllegalArgumentException> { gradeFor(-1) }
    }

    @Test
    fun `reverseManually works`() {
        assertEquals("", reverseManually(""))
        assertEquals("a", reverseManually("a"))
        assertEquals("niltoK", reverseManually("Kotlin"))
        assertEquals("тевирп", reverseManually("привет"))
    }

    @Test
    fun `maxManually works`() {
        assertNull(maxManually(emptyList()))
        assertEquals(5, maxManually(listOf(5)))
        assertEquals(9, maxManually(listOf(3, 9, -1, 7)))
        assertEquals(-1, maxManually(listOf(-5, -1, -7)))
    }
}
