import java.util.Arrays;

public class Stack<T> {

    private T[] array;
    private int topIndex;
    private int size;

    public Stack(int size) {
        this.size = size;
        this.array = (T[])new Object[size];
        topIndex = -1;
    }

    public void push(T item) {
        topIndex += 1;
        if (topIndex < size) {
            array[topIndex] = item;
        } else {
            throw new StackOverflow("Full");
        }
    }

    public T pop() {
        if (topIndex >= 0 ) {
            T top = array[topIndex];
            array[topIndex] = null;
            topIndex -= 1;
            return top;
        }
        throw new StackUnderflow("Empty");
    }

    //top item without removing it
    public T peek() {
        if (topIndex >= 0 ) {
            return array[topIndex];
        }
        throw new StackUnderflow("Empty");
    }

    public int freeSpaces() {
        int result = 0;
        for (T item:array) {
            if (item == null) {
                result += 1;
            }
        }
        return result;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

}
