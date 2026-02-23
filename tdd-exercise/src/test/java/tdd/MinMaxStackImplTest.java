package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    public static final int VALUE = 1;
    private MinMaxStackImpl minMaxStack;

    @BeforeEach
    void initializeStack() {
        minMaxStack = new MinMaxStackImpl();
    }

    @Test
    public void testInitialStack() {
        assertTrue(minMaxStack.isEmpty());
    }

    @Test
    public void testPushAnItem() {
        minMaxStack.push(VALUE);
        assertEquals(VALUE, minMaxStack.size());
    }

    @Test
    public void testPopAnItem() {
        minMaxStack.push(VALUE);
        assertEquals(VALUE, minMaxStack.pop());
    }

    @Test
    public void testPopEmptyTheStack() {
        minMaxStack.push(VALUE);
        minMaxStack.pop();
        assertTrue(minMaxStack.isEmpty());
    }

    @Test
    public void testSizeOfStackAfterPeek() {
        minMaxStack.push(VALUE);
        minMaxStack.peek();
        assertEquals(VALUE, minMaxStack.size());
    }

    @Test
    public void testPopWhenTheStackIsEmpty() {
        assertThrows(IllegalStateException.class, () -> minMaxStack.pop());
    }

    @Test
    public void testPeekWhenTheStackIsEmpty() {
        assertThrows(IllegalStateException.class, () -> minMaxStack.peek());
    }
}