package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    private MinMaxStackImpl minMaxStack;

    @BeforeEach
    void initializeStack() {
        minMaxStack = new MinMaxStackImpl();
    }

    @Test
    public void testInitialStack() {
        assertTrue(minMaxStack.isEmpty());
    }
}