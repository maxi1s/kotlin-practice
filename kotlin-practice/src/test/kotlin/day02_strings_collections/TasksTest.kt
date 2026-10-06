package day02_strings_collections

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

class TasksTest {

    @Test
    fun `isPalindrome works`() {
        assertTrue(isPalindrome(""))
        assertTrue(isPalindrome("a"))
        assertTrue(isPalindrome("A man, a plan, a canal: Panama"))
        assertTrue(isPalindrome("Шалаш"))
        assertFalse(isPalindrome("Kotlin"))
        assertFalse(isPalindrome("ab"))
    }

    @Test
    fun `countWords works`() {
        assertEquals(emptyMap(), countWords(""))
        assertEquals(mapOf("the" to 2, "cat" to 1, "and" to 1, "dog" to 1), countWords("the cat and The dog"))
        assertEquals(mapOf("a" to 3), countWords("  a   a a "))
    }

    @Test
    fun `secondLargest works`() {
        assertNull(secondLargest(emptyList()))
        assertNull(secondLargest(listOf(7)))
        assertNull(secondLargest(listOf(7, 7, 7)))
        assertEquals(3, secondLargest(listOf(5, 5, 3)))
        assertEquals(8, secondLargest(listOf(1, 9, 8, 9, 2)))
    }

    @Test
    fun `capitalizeWords works`() {
        assertEquals("", capitalizeWords(""))
        assertEquals("Hello World", capitalizeWords("hello world"))
        assertEquals("Hello  Big World", capitalizeWords("hello  big world"))
        assertEquals("Already Upper", capitalizeWords("Already Upper"))
    }

    @Test
    fun `mergeSorted works`() {
        assertEquals(emptyList(), mergeSorted(emptyList(), emptyList()))
        assertEquals(listOf(1, 2, 3), mergeSorted(listOf(1, 2, 3), emptyList()))
        assertEquals(listOf(1, 2, 3, 4, 5, 6), mergeSorted(listOf(1, 3, 5), listOf(2, 4, 6)))
        assertEquals(listOf(1, 1, 2, 2), mergeSorted(listOf(1, 2), listOf(1, 2)))
        assertEquals(listOf(1, 2, 3, 10, 20), mergeSorted(listOf(10, 20), listOf(1, 2, 3)))
    }

    @Test
    fun `compress works`() {
        assertEquals("", compress(""))
        assertEquals("a1", compress("a"))
        assertEquals("a3b2c1", compress("aaabbc"))
        assertEquals("a1b1a1", compress("aba"))
    }

    @Test
    fun `distinctPreservingOrder does not mutate input`() {
        val input = listOf("b", "a", "b", "c", "a")
        val result = distinctPreservingOrder(input)
        assertEquals(listOf("b", "a", "c"), result)
        assertEquals(listOf("b", "a", "b", "c", "a"), input)
        assertEquals(emptyList(), distinctPreservingOrder(emptyList()))
    }

    @Test
    fun `pairEnds works`() {
        assertEquals(emptyList(), pairEnds(emptyList()))
        assertEquals(emptyList(), pairEnds(listOf(1)))
        assertEquals(listOf(1 to 4, 2 to 3), pairEnds(listOf(1, 2, 3, 4)))
        assertEquals(listOf(1 to 3), pairEnds(listOf(1, 2, 3)))
        assertEquals(listOf(1 to 5, 2 to 4), pairEnds(listOf(1, 2, 3, 4, 5)))
    }
}
