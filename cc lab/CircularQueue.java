public class CircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;

    public CircularQueue(int k) {
        capacity = k;
        queue = new int[k];
        front = -1;
        rear = -1;
    }

    public boolean enqueue(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        if (front == -1) {
            front = rear;
        }
        return true;
    }

    public boolean dequeue() {
        if (isEmpty()) {
            return false;
        }
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : queue[front];
    }

    public int Rear() {
        return isEmpty() ? -1 : queue[rear];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return !isEmpty() && (rear + 1) % capacity == front;
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(3); // set the size to be 3
        System.out.println(circularQueue.enqueue(1));  // return true
        System.out.println(circularQueue.enqueue(2));  // return true
        System.out.println(circularQueue.enqueue(3));  // return true
        System.out.println(circularQueue.enqueue(4));  // return false, the queue is full
        System.out.println(circularQueue.Rear());  // return 3
        System.out.println(circularQueue.isFull());  // return true
        System.out.println(circularQueue.dequeue());  // return true
        System.out.println(circularQueue.enqueue(4));  // return true
        System.out.println(circularQueue.Rear());  // return 4
    }
}
