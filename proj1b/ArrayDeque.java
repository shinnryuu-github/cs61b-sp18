public class ArrayDeque<T> {
    private int size, front, end;
    private T[] array;

    private int getIndex(int i, int l){
        while (i < 0)
            i += l;
        return i % l;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private boolean isFull(){
        return size == array.length;
    }

    public ArrayDeque(){
        size = 0;
        end = 0;
        array = (T[]) new Object[8];
        front = array.length - 1;
    }

    private void resize(int capacity){
        T[] A = (T[]) new Object[capacity];
        if (capacity > array.length){
            int ptr1 = getIndex(front + 1, array.length), ptr2 = array.length, real_end = getIndex(end - 1, array.length);
            while (ptr1 != real_end) {
                A[ptr2] = array[ptr1];
                ptr1 = getIndex(ptr1 + 1, array.length);
                ptr2 = getIndex(ptr2 + 1, A.length);
            }
            A[ptr2] = array[ptr1];
            front = array.length - 1;
            end = getIndex(ptr2 + 1, A.length);
        }
        else {
            int ptr1 = getIndex(front + 1, array.length), ptr2 = 1, real_end = getIndex(end - 1, array.length);
            while (ptr1 != real_end){
                A[ptr2] = array[ptr1];
                ptr1 = getIndex(ptr1 + 1, array.length);
                ptr2 = getIndex(ptr2 + 1, A.length);
            }
            A[ptr2] = array[ptr1];
            front = 0;
            end = getIndex(ptr2 + 1, A.length);
        }
        array = A;
    }

    public void addFirst(T x){
        if (isFull())
            resize(size * 2);
        array[front] = x;
        front = getIndex(front - 1, array.length);
        size++;
    }

    public void addLast(T x){
        if (isFull())
            resize(size * 2);
        array[end] = x;
        end = getIndex(end + 1, array.length);
        size++;
    }
    public int size(){
        return size;
    }

    public T get(int index){
        index = getIndex(front + 1 + index, array.length);
        return array[index];
    }

    public T removeFirst(){
        if (isEmpty()){
            return null;
        }
        front = getIndex(front + 1, array.length);
        T res = array[front];
        array[front] = null;
        size--;
        if (array.length >= 16 && size < 0.25 * array.length){
            resize(4 * size);
        }
        return res;
    }

    public T removeLast(){
        if (isEmpty()){
            return null;
        }
        end = getIndex(end - 1, array.length);
        T res = array[end];
        array[end] = null;
        size--;
        if (array.length >= 16 && size < 0.25 * array.length){
            resize(4 * size);
        }
        return res;
    }

    public void printDeque(){
        for (int i = 0, j = front; i < size; i++){
            j = getIndex(j + 1, array.length);
            System.out.print(array[j] + " ");
        }
    }

}
