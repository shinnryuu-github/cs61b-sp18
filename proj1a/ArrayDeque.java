import java.time.Instant;

public class ArrayDeque<T> {
    private int size, front, end;
    private T[] Array;

    private int get_index(int i){
        while (i < 0)
            i += Array.length;
        return i % Array.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private boolean isFull(){
        return size == Array.length;
    }

    public ArrayDeque(){
        size = front = end = 0;
        Array = (T[]) new Object[8];
    }

    private void resize(int capacity){
        T[] A = (T[]) new Object[capacity];
        System.arraycopy(Array, 0, A, 0, end + 1);
        int lenth = Array.length - front;
        System.arraycopy(Array, front, A, A.length - lenth, lenth);
        Array = A;
        front = A.length - lenth;
    }

    public void addFirst(T x){
        if (isFull())
            resize(size * 2);
        front = get_index(front - 1);
        Array[front] = x;
        size++;
    }

    public void addLast(T x){
        if (isFull())
            resize(size * 2);
        end = get_index(end + 1);
        Array[end] = x;
        size++;
    }
    public int size(){
        return size;
    }

    public T get(int index){
        return Array[index];
    }

    private float usage_ratio(){
        return (float) size / (float) Array.length;
    }

    public T removeFirst(){
        T res = Array[front];
        Array[front] = null;
        front = get_index(front + 1);
        size--;
        if (Array.length >= 16 && this.usage_ratio() < 0.25){
            resize(4 * size);
        }
        return res;
    }

    public T removeLast(){
        T res = Array[end];
        Array[end] = null;
        end = get_index(end - 1);
        size--;
        if (Array.length >= 16 && this.usage_ratio() < 0.25){
            resize(4 * size);
        }
        return res;
    }

    public void printDeque(){
        for (int i = 0, j = front; i < size; i++){
            j = get_index(j + 1);
            System.out.print(Array[j] + " ");
        }
    }

    public static void main(String[] args){
        ArrayDeque<Integer> L = new ArrayDeque<>();
        for (int i = 0; i < 100; i++){
            L.addFirst(i);
        }
        L.printDeque();
    }
}
