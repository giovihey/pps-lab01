package tdd;

import java.util.ArrayList;
import java.util.List;

public class MinMaxStackImpl implements MinMaxStack {

    private final List<Node> stack;

    public MinMaxStackImpl() {
        stack = new ArrayList<>();
    }

    @Override
    public void push(int value) {
        if (isEmpty()) {
            stack.add(new Node(value, value, value));
        } else {
            Node top = stack.get(stack.size() - 1);
            int newMin = Math.min(value, top.currentMaximum());
            int newMax = Math.max(value, top.currentMinimum());
            stack.add(new Node(value, newMin, newMax));
        }
    }

    @Override
    public int pop() {
        if  (stack.isEmpty()) throw new IllegalStateException();
        Node removed = stack.remove(stack.size() - 1);
        return removed.value();
    }

    @Override
    public int peek() {
        if  (stack.isEmpty()) throw new IllegalStateException();
        return stack.get(stack.size() - 1).value();
    }

    @Override
    public int getMin() {
        if (stack.isEmpty()) throw new IllegalStateException("Stack is empty");
        return stack.get(stack.size() - 1).currentMinimum();
    }

    @Override
    public int getMax() {
        if (stack.isEmpty()) throw new IllegalStateException("Stack is empty");
        return stack.get(stack.size() - 1).currentMaximum();
    }

    @Override
    public boolean isEmpty() {
        return (stack.isEmpty());
    }

    @Override
    public int size() {
        return stack.size();
    }
}
