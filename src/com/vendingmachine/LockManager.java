package com.vendingmachine;

public class LockManager {
    private boolean isLocked;

    public synchronized void lock() {
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
    }

    public synchronized boolean isLocked() {
        return isLocked;
    }
}
