import java.time.Instant;

public class ArrayDeque<T> {
    private int size, front, end;
    private T[] Array;

    private int get_index(int i, int l){
        while (i < 0)
            i += l;
        return i % l;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private boolean isFull(){
        return size == Array.length;
    }

    public ArrayDeque(){
        size = 0;
        end = 0;
        Array = (T[]) new Object[8];
        front = Array.length - 1;
    }

    private void resize(int capacity){
        T[] A = (T[]) new Object[capacity];
        if (capacity > Array.length){
            int ptr1 = get_index(front + 1, Array.length), ptr2 = Array.length, real_end = get_index(end - 1, Array.length);
            while (ptr1 != real_end) {
                A[ptr2] = Array[ptr1];
                ptr1 = get_index(ptr1 + 1, Array.length);
                ptr2 = get_index(ptr2 + 1, A.length);
            }
            A[ptr2] = Array[ptr1];
            front = Array.length - 1;
            end = get_index(ptr2 + 1, A.length);
        }
        else {
            int ptr1 = get_index(front + 1, Array.length), ptr2 = 1, real_end = get_index(end - 1, Array.length);
            while (ptr1 != real_end){
                A[ptr2] = Array[ptr1];
                ptr1 = get_index(ptr1 + 1, Array.length);
                ptr2 = get_index(ptr2 + 1, A.length);
            }
            A[ptr2] = Array[ptr1];
            front = 0;
            end = get_index(ptr2 + 1, A.length);
        }
        Array = A;
    }

    public void addFirst(T x){
        if (isFull())
            resize(size * 2);
        Array[front] = x;
        front = get_index(front - 1, Array.length);
        size++;
    }

    public void addLast(T x){
        if (isFull())
            resize(size * 2);
        Array[end] = x;
        end = get_index(end + 1, Array.length);
        size++;
    }
    public int size(){
        return size;
    }

    public T get(int index){
        index = get_index(front + 1 + index, Array.length);
        return Array[index];
    }

    public T removeFirst(){
        if (isEmpty()){
            return null;
        }
        front = get_index(front + 1, Array.length);
        T res = Array[front];
        Array[front] = null;
        size--;
        if (Array.length >= 16 && size < 0.25 * Array.length){
            resize(4 * size);
        }
        return res;
    }

    public T removeLast(){
        if (isEmpty()){
            return null;
        }
        end = get_index(end - 1, Array.length);
        T res = Array[end];
        Array[end] = null;
        size--;
        if (Array.length >= 16 && size < 0.25 * Array.length){
            resize(4 * size);
        }
        return res;
    }

    public void printDeque(){
        for (int i = 0, j = front; i < size; i++){
            j = get_index(j + 1, Array.length);
            System.out.print(Array[j] + " ");
        }
    }

    private static void main(String[] args){
        ArrayDeque<Integer> A = new ArrayDeque<>();
        A.addFirst(0);
        A.addFirst(1);
        A.addFirst(2);
        A.addFirst(3);
        A.addFirst(4);
        A.addFirst(5);
        A.isEmpty();
        A.addFirst(7);
        A.addFirst(8);
        A.addFirst(9);
        int res = A.removeLast();
        System.out.println(res);
        A.printDeque();
        A.removeLast();
        A.removeLast();
        A.removeLast();
        A.removeLast();
        res = A.removeLast();
        System.out.println("");
        System.out.println(res);
        A.printDeque();
    }
}
