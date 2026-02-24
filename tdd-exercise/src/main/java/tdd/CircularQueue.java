package tdd;

/**
 *  Task 3 - TDD for Circular Queue
 *  A simple CircularQueue that stores integers with a **fixed** capacity.
 *  When full, new elements overwrite the oldest ones.
 *  <br>
 *  When removing elements, the oldest ones are removed first.
 *  Therefore, giving [4, 5, 3], the first element to be removed is 4, then 5, and finally 3.
 *  <br>
 *  For the exercise: 
 *   - Think about the test cases you need to write.
 *   - Introduce methods in the interface in order to make the tests pass.
 *   - Refactor
 */
public interface CircularQueue {

    /**
     * Remove the oldest element in the queue.
     *
     * @throws IllegalStateException if the queue is empty.
     * @return the oldest integers in the queue.
     */
    int remove();

    /**
     * Append an integer in the queue.
     * When full, new elements overwrite the oldest ones.
     *
     * @param elementToAppend in the queue.
     */
    void append(int elementToAppend);

    /**
     *
     * @return the fixed capacity of the queue.
     */
    int size();

    /**
     * Checks if the queue is empty.
     *
     * @return true if the stack is empty, false otherwise.
     */
    boolean isEmpty();
}