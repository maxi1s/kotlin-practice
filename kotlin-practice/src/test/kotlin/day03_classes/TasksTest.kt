package day03_classes

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TasksTest {

    @Test
    fun `Rectangle area perimeter square`() {
        val r = Rectangle(3.0, 4.0)
        assertEquals(12.0, r.area(), 1e-9)
        assertEquals(14.0, r.perimeter(), 1e-9)
        assertFalse(r.isSquare)
        assertTrue(Rectangle(2.0, 2.0).isSquare)
    }

    @Test
    fun `Rectangle rejects non-positive sides`() {
        assertFailsWith<IllegalArgumentException> { Rectangle(0.0, 1.0) }
        assertFailsWith<IllegalArgumentException> { Rectangle(1.0, -2.0) }
    }

    @Test
    fun `Counter behaviour`() {
        val c = Counter()
        assertEquals(0, c.value)
        c.increment(); c.increment(); c.increment()
        assertEquals(3, c.value)
        c.decrement()
        assertEquals(2, c.value)
        c.reset()
        assertEquals(0, c.value)
        assertEquals(10, Counter(10).value)
    }

    @Test
    fun `BankAccount deposit and withdraw`() {
        val acc = BankAccount("Max", 100.0)
        acc.deposit(50.0)
        acc.withdraw(30.0)
        assertEquals(120.0, acc.balance, 1e-9)
        assertEquals(listOf("deposit 50.0", "withdraw 30.0"), acc.history)
    }

    @Test
    fun `BankAccount validation`() {
        val acc = BankAccount("Max", 10.0)
        assertFailsWith<IllegalArgumentException> { acc.deposit(0.0) }
        assertFailsWith<IllegalArgumentException> { acc.withdraw(-1.0) }
        assertFailsWith<IllegalStateException> { acc.withdraw(10.01) }
        assertEquals(10.0, acc.balance, 1e-9)
        assertTrue(acc.history.isEmpty())
    }

    @Test
    fun `IntStack behaviour`() {
        val s = IntStack()
        assertTrue(s.isEmpty())
        assertEquals(0, s.size)
        s.push(1); s.push(2); s.push(3)
        assertEquals(3, s.size)
        assertEquals(3, s.peek())
        assertEquals(3, s.pop())
        assertEquals(2, s.pop())
        assertEquals(1, s.size)
        assertFalse(s.isEmpty())
        s.pop()
        assertFailsWith<NoSuchElementException> { s.pop() }
        assertFailsWith<NoSuchElementException> { s.peek() }
    }

    @Test
    fun `Point behaviour`() {
        val origin = Point()
        assertEquals(0.0, origin.x)
        assertEquals(0.0, origin.y)
        assertEquals(5.0, origin.distanceTo(Point(3.0, 4.0)), 1e-9)
        assertEquals("(1.0, 2.0)", Point(1.0, 2.0).toString())
    }
}
