package tdd;

import java.util.ArrayList;
import java.util.List;

public class MinMaxStackImpl implements MinMaxStack {

    private final List<Integer> stack;

    public MinMaxStackImpl() {
        stack = new ArrayList<>();
    }

    @Override
    public void push(int value) {
        stack.add(value);
    }

    @Override
    public int pop() {
        if  (stack.isEmpty()) {
            throw new IllegalStateException();
        }
        return stack.remove(stack.size()-1);
    }

    @Override
    public int peek() {
        if  (stack.isEmpty()) {
            throw new IllegalStateException();
        }
        return stack.get(stack.size()-1);
    }

    @Override
    public int getMin() {
        return 0;
    }

    @Override
    public int getMax() {
        return 0;
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
