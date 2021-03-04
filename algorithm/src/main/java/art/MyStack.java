package art;


/**
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2021/3/4 7:46
 */
public class MyStack<E> {

    private static final int DEFAULT_SIZE = 15;
    private Object[] values;
    private int index = 0;
    private int size;

    public MyStack() {
        this(DEFAULT_SIZE);
    }

    public MyStack(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Parameter 'size' must not be negative");
        }
        this.values = new Object[size];
        this.size = size;
    }

    public void push(E e) {
        if (index == size - 1) {
            expand();
        }
        values[index++] = e;
    }

    public E pop() throws IllegalAccessException {
        if (index == 0) {
            throw new IllegalAccessException("Can not pop element from a empty stack");
        }
        return (E)values[--index];
    }

    private void expand() {
        int newSize = size << 1;
        Object[] newValues = new Object[newSize];
        System.arraycopy(values, 0, newValues, 0, size);
        values = newValues;
        size = newSize;
    }

}
