public class ArrayDeque<item> {
    private int size, front, end;
    private item[] Array;

    public int get_index(int i){
        while (i < 0)
            i += Array.length;
        return i % Array.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == Array.length;
    }

    public ArrayDeque(){
        size = front = end = 0;
        Array = (item[]) new Object[8];
    }

    public ArrayDeque(item x){
        size = 1;
        Array = (item[]) new Object[8];
        Array[front] = x;
        front = get_index(front - 1);
        end = 0;
    }

    public void resize(int capacity){
        item[] A = (item[]) new Object[capacity];
        System.arraycopy(Array, 0, A, 0, end);
        int lenth = Array.length - front;
        System.arraycopy(Array, front + 1, A, A.length - lenth, lenth - 1);
        Array = A;
        front = A.length - lenth;
    }

    public void addFirst(item x){
        if (isFull())
            resize(size * 2);
        Array[front] = x;
        front = get_index(front - 1);
        size++;
    }

    public void addLast(item x){
        if (isFull())
            resize(size * 2);
        end = get_index(end + 1);
        Array[end] = x;
        size++;
    }
    public int size(){
        return size;
    }

    public item get(int index){
        return Array[index];
    }

    public float usage_ratio(){
        return (float) size / (float) Array.length;
    }

    public item removeFirst(){
        front = get_index(front + 1);
        item res = Array[front];
        Array[front] = null;
        size--;
        if (Array.length >= 16 && this.usage_ratio() < 0.25){
            resize(4 * size);
        }
        return res;
    }

    public item removeLast(){
        item res = Array[end];
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

}
