package algorithm.solution.smileDK.baejoon.stack;

public interface StackInterface<T> {

    T push(T data);

    T pop();

    T peek();

    boolean empty();

    int search(Object o);
    // TODO: Object vs Generic?

    // etc
    int size();

    void clear();



}
