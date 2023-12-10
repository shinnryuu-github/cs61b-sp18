public class LinkedListDeque<T> {
    private class Node{
        private Node prev, next;
        private T data;

        public Node(T d, Node p, Node n){
            data = d;
            prev = p;
            next = n;
        }

        public Node(){
            prev = null;
            next = null;
        }

        public T getRecursize(int index){
            if (this == null)
                return null;
            if (index == 0)
                return data;
            return next.getRecursize(index - 1);
        }
    }
    private int size;
    private Node sentinel;

    public LinkedListDeque(){
        size = 0;
        sentinel = new Node();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }
    
    public void addFirst(T item){
        if (this.isEmpty()){
            sentinel.next = new Node(item, sentinel, sentinel);
            sentinel.prev = sentinel.next;
        }
        else{
            sentinel.next = new Node(item, sentinel, sentinel.next);
            sentinel.next.next.prev = sentinel.next;
        }
        size++;
    }

    public void addLast(T item){
        if (this.isEmpty()){
            sentinel.prev = new Node(item, sentinel, sentinel);
            sentinel.next = sentinel.prev;
        }
        else {
            sentinel.prev = new Node(item, sentinel.prev, sentinel);
            sentinel.prev.prev.next = sentinel.prev;
        }
        size++;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        Node ptr = sentinel.next;
        if (ptr != null)
            while (ptr != sentinel){
                System.out.print(ptr.data + " ");
                ptr = ptr.next;
            }
    }

    public T removeFirst(){
        if (!this.isEmpty()) {
            T res = sentinel.next.data;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size--;
            return res;
        }
        return null;
    }

    public T removeLast(){
        if (!this.isEmpty()) {
            T res = sentinel.prev.data;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size--;
            return res;
        }
        return null;
    }

    public T get(int index){
        if (index >= size)
            return null;
        int cnt = 0;
        Node ptr = sentinel.next;
        while (cnt < index){
            cnt++;
            ptr = ptr.next;
        }
        return ptr.data;
    }

    public T getRecursive(int index) {
        return sentinel.next.getRecursize(index);
    }
}
