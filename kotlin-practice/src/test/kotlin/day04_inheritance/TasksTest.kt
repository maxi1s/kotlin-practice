package day04_inheritance

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class TasksTest {

    @Test
    fun `shapes area`() {
        assertEquals(Math.PI, Circle(1.0).area(), 1e-9)
        assertEquals(6.0, Rect(2.0, 3.0).area(), 1e-9)
        assertEquals(6.0, Triangle(3.0, 4.0, 5.0).area(), 1e-9)
    }

    @Test
    fun `invalid triangle`() {
        assertFailsWith<IllegalArgumentException> { Triangle(1.0, 2.0, 10.0) }
        assertFailsWith<IllegalArgumentException> { Triangle(0.0, 1.0, 1.0) }
    }

    @Test
    fun `describe uses polymorphic name and area`() {
        assertEquals("Circle with area 3.14", Circle(1.0).describe())
        assertEquals("Rect with area 6.00", Rect(2.0, 3.0).describe())
        assertEquals("Triangle with area 6.00", Triangle(3.0, 4.0, 5.0).describe())
    }

    @Test
    fun `totalArea`() {
        val shapes: List<Shape> = listOf(Rect(1.0, 1.0), Rect(2.0, 2.0), Triangle(3.0, 4.0, 5.0))
        assertEquals(11.0, totalArea(shapes), 1e-9)
        assertEquals(0.0, totalArea(emptyList()), 1e-9)
    }

    @Test
    fun `salary and payroll`() {
        val e = Employee("Ann", 1000.0)
        val m = Manager("Bob", 2000.0, 500.0)
        assertEquals(1000.0, e.monthlySalary(), 1e-9)
        assertEquals(2500.0, m.monthlySalary(), 1e-9)
        assertTrue(m is Employee)
        assertEquals(3500.0, payroll(listOf(e, m)), 1e-9)
    }

    @Test
    fun `logger default method`() {
        val logger = ConsoleLogger()
        logger.log("start")
        logger.logError("boom")
        assertEquals(listOf("start", "ERROR: boom"), logger.lines)
    }

    @Test
    fun `diamond default methods resolved explicitly`() {
        assertEquals("A+B", AB().hello())
    }
}
