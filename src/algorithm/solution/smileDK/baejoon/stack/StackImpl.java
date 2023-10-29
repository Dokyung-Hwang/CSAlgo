package algorithm.solution.smileDK.baejoon.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class StackImpl<T> extends ArrayList<T> implements StackInterface<T> {

    // 초기 크기 설정 x
    public StackImpl() {
        super();
    }


    // 초기 크기 설정 o
    public StackImpl(int capacity) {
        super(capacity);
    }

    @Override
    public T push(T data) {
        add(data);
        return data;
    }

    @Override
    public T pop() {
        int length = size();

        if (length == 0) throw new EmptyStackException();

        return remove(length - 1);
    }

    @Override
    public T peek() {
        int length = size();

        if (length == 0) throw new EmptyStackException();

        return get(length - 1);
    }

    @Override
    public boolean empty() {
        return size() == 0;
    }

    @Override
    public int search(Object o) {
        int index = lastIndexOf(o);

        if (index >= 0) return size() - index;

        return -1;
    }
}
