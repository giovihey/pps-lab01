package tdd;

public class MySmartDoorLock implements SmartDoorLock{

    private static final int MAX_ATTEMPTS_FOR_UNLOCK = 3;
    private static final int PIN_LENGTH = 4;
    private Integer pin;
    private boolean locked;
    private boolean blocked;
    private int failedAttempts;

    public MySmartDoorLock() {
        this.reset();
    }

    @Override
    public void setPin(int pin) {
        if (isLocked() || isBlocked()) {
            throw new IllegalStateException("Cannot set PIN: device is locked or blocked");
        }
        if (!isValidPinLength(pin)) {
            throw new IllegalArgumentException("PIN must be exactly 4 digits");
        }
        this.pin = pin;
    }

    @Override
    public void unlock(int pin) {
       if (pin == this.pin) {
           this.locked = false;
        } else  {
            this.failedAttempts += 1;
        }
       if (getFailedAttempts() >= getMaxAttempts()) {
           this.blocked = true;
       }
    }

    @Override
    public void lock() {
        if (pin == null) {
            throw new NullPointerException();
        }
        this.locked = true;
    }

    @Override
    public boolean isLocked() {
        return this.locked;
    }

    @Override
    public boolean isBlocked() {
        return this.blocked;
    }

    @Override
    public int getMaxAttempts() {
        return MAX_ATTEMPTS_FOR_UNLOCK;
    }

    @Override
    public int getFailedAttempts() {
        return this.failedAttempts;
    }

    @Override
    public void reset() {
        this.pin = null;
        this.locked = false;
        this.blocked = false;
        this.failedAttempts = 0;
    }

    /**
     * Check the length of the PIN.
     * @param pin The PIN entered by the user.
     * @return true if the length of the PIN is correct, false otherwise.
     */
    private boolean isValidPinLength(int pin) {
        return String.valueOf(pin).length() == PIN_LENGTH;
    }
}
