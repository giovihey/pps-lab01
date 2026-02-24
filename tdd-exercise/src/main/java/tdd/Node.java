package tdd;

/**
 * This class represent a triple of values.
 *
 * @param value that is pushed in the stack.
 * @param currentMinimum value in the stack.
 * @param currentMaximum value in the stack.
 */
public record Node(int value, int currentMinimum, int currentMaximum) { }
