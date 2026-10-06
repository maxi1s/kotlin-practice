package day05_null_safety

import java.io.File
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertNull

class TasksTest {

    @Test
    fun `no double-bang operator in solution`() {
        val src = File("src/main/kotlin/day05_null_safety/Tasks.kt")
        if (!src.exists()) return // при проверке эталона файл может лежать в другом месте
        val code = src.readLines()
            .filterNot { it.trim().startsWith("*") || it.trim().startsWith("/*") || it.trim().startsWith("//") }
            .joinToString("\n")
        assertFalse(code.contains("!!"), "В решении дня 05 нельзя использовать !!")
    }

    @Test
    fun `lengthOrZero works`() {
        assertEquals(0, lengthOrZero(null))
        assertEquals(0, lengthOrZero(""))
        assertEquals(3, lengthOrZero("abc"))
    }

    @Test
    fun `firstNonNull works`() {
        assertNull(firstNonNull())
        assertNull(firstNonNull(null, null))
        assertEquals("b", firstNonNull(null, "b", "c"))
    }

    @Test
    fun `cityOf works`() {
        assertEquals("unknown", cityOf(null))
        assertEquals("unknown", cityOf(User("a", null, null)))
        assertEquals("unknown", cityOf(User("a", Address(null, "Lenina"), null)))
        assertEquals("Saratov", cityOf(User("a", Address("Saratov", null), null)))
    }

    @Test
    fun `parseIntOrNull works`() {
        assertNull(parseIntOrNull(null))
        assertNull(parseIntOrNull("abc"))
        assertNull(parseIntOrNull(" 42"))
        assertEquals(42, parseIntOrNull("42"))
        assertEquals(-7, parseIntOrNull("-7"))
    }

    @Test
    fun `sumNotNull works`() {
        assertEquals(0, sumNotNull(emptyList()))
        assertEquals(0, sumNotNull(listOf(null, null)))
        assertEquals(4, sumNotNull(listOf(1, null, 3)))
    }

    @Test
    fun `requireName works`() {
        assertEquals("Max", requireName("Max"))
        val e1 = assertFailsWith<IllegalArgumentException> { requireName(null) }
        assertEquals("name is required", e1.message)
        val e2 = assertFailsWith<IllegalArgumentException> { requireName("   ") }
        assertEquals("name is required", e2.message)
    }

    @Test
    fun `describe works`() {
        assertEquals("String of length 3", describe("abc"))
        assertEquals("Int: 5", describe(5))
        assertEquals("null", describe(null))
        assertEquals("unknown", describe(3.14))
        assertEquals("unknown", describe(listOf(1)))
    }

    @Test
    fun `averageAge works`() {
        assertNull(averageAge(emptyList()))
        assertNull(averageAge(listOf(User("a", null, null))))
        val avg = averageAge(listOf(User("a", null, 20), User("b", null, null), User("c", null, 30)))
        assertEquals(25.0, avg!!, 1e-9)
    }

    @Test
    fun `mapOrDefault works`() {
        assertEquals(3, mapOrDefault("abc", -1) { it.length })
        assertEquals(-1, mapOrDefault(null as String?, -1) { it.length })
        assertEquals("X", mapOrDefault(null as Int?, "X") { it.toString() })
    }
}
