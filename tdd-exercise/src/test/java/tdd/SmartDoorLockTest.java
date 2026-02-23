package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartDoorLockTest {

    public static final int PIN = 1234;
    public static final int WRONG_PIN = 2345;
    private MySmartDoorLock smartDoorLock;

    @BeforeEach
    void initializeSmartDoorLock() {
        smartDoorLock = new MySmartDoorLock();
    }

    @Test
    public void testInitializeSmartDoorLock() {
        assertFalse(smartDoorLock.isLocked());
    }

    @Test
    public void testSetPin() {
        smartDoorLock.setPin(PIN);
        smartDoorLock.lock();
        assertTrue(smartDoorLock.isLocked());
    }

    @Test
    public void testPinIsNotSet() {
        assertThrows(NullPointerException.class, () -> {smartDoorLock.lock();});
    }

    @Test
    public void testUnlockTheDoor() {
        smartDoorLock.setPin(PIN);
        smartDoorLock.lock();
        smartDoorLock.unlock(PIN);
        assertFalse(smartDoorLock.isLocked());
    }

    @Test
    public void testFailedUnlockTheDoor() {
        smartDoorLock.setPin(PIN);
        smartDoorLock.lock();
        smartDoorLock.unlock(WRONG_PIN);
        smartDoorLock.unlock(WRONG_PIN);
        smartDoorLock.unlock(WRONG_PIN);
        assertTrue(smartDoorLock.isBlocked());
    }
}
