package tdd;

public class CircularQueueImpl implements CircularQueue {
    private int[] circularQueue;
    private int currentElementsInQueue;
    private int headOfTheQueue;
    private int tailOfTheQueue;

    public CircularQueueImpl(int capacity) {
        circularQueue = new int[capacity];
        currentElementsInQueue = 0;
        headOfTheQueue = 0;
        tailOfTheQueue = 0;
    }

    @Override
    public int remove() {
        if (isEmpty()) throw new IllegalStateException("Empty");
        int val = circularQueue[headOfTheQueue];
        headOfTheQueue = (headOfTheQueue + 1) % circularQueue.length;
        currentElementsInQueue -= 1;
        return val;
    }

    @Override
    public void append(int elementToAppend) {
        circularQueue[tailOfTheQueue] = elementToAppend;
        tailOfTheQueue = (tailOfTheQueue + 1) % circularQueue.length;
        if (currentElementsInQueue == size()) {
            headOfTheQueue = (headOfTheQueue + 1) % circularQueue.length;
        } else {
            currentElementsInQueue++;
        }
    }

    @Override
    public int size() {
        return circularQueue.length;
    }

    @Override
    public boolean isEmpty() {
        return currentElementsInQueue == 0;
    }
}
