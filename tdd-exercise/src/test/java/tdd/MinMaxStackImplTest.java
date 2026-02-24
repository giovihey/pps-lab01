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
        assertEquals(1, minMaxStack.size());
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

    @Test
    public void testGetTheMinimumValue() {
        final int minValue = 0;
        minMaxStack.push(VALUE);
        minMaxStack.push(minValue);
        assertEquals(minValue, minMaxStack.getMin());
    }

    @Test
    public void testGetTheMaximumValue() {
        final int maxValue = 10;
        minMaxStack.push(VALUE);
        minMaxStack.push(maxValue);
        assertEquals(maxValue, minMaxStack.getMax());
    }

    @Test
    public void testGetTheSizeOfTheStack() {
        final int numberOfItemsInTheStack = 3;
        minMaxStack.push(VALUE);
        minMaxStack.push(VALUE);
        minMaxStack.push(VALUE);
        assertEquals(numberOfItemsInTheStack, minMaxStack.size());
    }

    @Test
    public void testRetrieveButNotRemoveOfThePeek() {
        minMaxStack.push(VALUE);
        final int value = minMaxStack.peek();
        assertEquals(VALUE, value);
        assertFalse(minMaxStack.isEmpty());
    }
}