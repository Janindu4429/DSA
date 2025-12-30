/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ArrayCircularQueue;

/**
 *
 * @author janindu
 */
public class ArrayCircularQueue {

    int[] queue;       // Array to store queue elements
    int front, rear;   // Pointers for front and rear
    int size;          // Current number of elements
    int capacity;      // Maximum size of queue

    // Constructor to initialize circular queue
    public ArrayCircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        size = 0;
        rear = capacity - 1;
    }

    // Check if queue is full
    boolean isFull() {
        return size == capacity;
    }

    // Check if queue is empty
    boolean isEmpty() {
        return size == 0;
    }

    // Insert element into queue
    void enqueue(int data) {

        // If queue is full, insertion not possible
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }

        // Circular increment of rear index
        rear = (rear + 1) % capacity;

        // Insert data
        queue[rear] = data;
        size++;
    }

    // Remove element from queue
    int dequeue() {

        // If queue is empty, deletion not possible
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        // Get front element
        int data = queue[front];

        // Circular increment of front index
        front = (front + 1) % capacity;
        size--;

        return data;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        // Create circular queue of size 5
        ArrayCircularQueue q = new ArrayCircularQueue(5);

        // Insert elements
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        // Remove elements
        System.out.println("Dequeued: " + q.dequeue());
        System.out.println("Dequeued: " + q.dequeue());
    }
    
}
