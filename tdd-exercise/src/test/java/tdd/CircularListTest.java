package tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    public static final int CAPACITY_OF_QUEUE = 3;
    public static final int ELEMENT_TO_APPEND = 10;
    private CircularQueueImpl circularQueueImpl;

    @BeforeEach
    public void initializeCircularQueue() {
        circularQueueImpl = new CircularQueueImpl(CAPACITY_OF_QUEUE);
    }

    @Test
    public void testInitialQueue() {
        assertEquals(CAPACITY_OF_QUEUE, circularQueueImpl.size());
    }

    @Test
    public void testEmptyInitialQueue() {
        assertTrue(circularQueueImpl.isEmpty());
    }

    @Test
    public void testAddElementInQueue() {
        circularQueueImpl.append(ELEMENT_TO_APPEND);
        assertFalse(circularQueueImpl.isEmpty());
    }

    @Test
    public void testRemoveElementFromQueue() {
        final int elementToRemove = 2;
        circularQueueImpl.append(elementToRemove);
        circularQueueImpl.append(ELEMENT_TO_APPEND);
        circularQueueImpl.append(ELEMENT_TO_APPEND);
        assertEquals(elementToRemove, circularQueueImpl.remove());
    }

    @Test
    public void testRemoveElementFromEmptyQueue() {
        assertThrows(IllegalStateException.class, () -> circularQueueImpl.remove());
    }

    @Test
    public void testAddElementToFullQueue() {
        final int firstElementInQueue = 5;
        circularQueueImpl.append(ELEMENT_TO_APPEND);
        circularQueueImpl.append(firstElementInQueue);
        circularQueueImpl.append(ELEMENT_TO_APPEND);
        circularQueueImpl.append(ELEMENT_TO_APPEND);
        assertEquals(firstElementInQueue, circularQueueImpl.remove());
    }
}
