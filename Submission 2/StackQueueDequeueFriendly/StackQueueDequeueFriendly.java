/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package StackQueueDequeueFriendly;
import java.util.Stack;
/**
 *
 * @author janindu
 */


public class StackQueueDequeueFriendly {


    // First stack to store queue elements
    Stack<Integer> stack1 = new Stack<>();

    // Second stack used for rearranging elements during enqueue
    Stack<Integer> stack2 = new Stack<>();

    // Enqueue operation (costly operation)
    void enqueue(int data) {

        // Move all elements from stack1 to stack2
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        // Push new element into empty stack1
        stack1.push(data);

        // Move all elements back to stack1
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    // Dequeue operation (efficient operation)
    int dequeue() {

        // Check if queue is empty
        if (stack1.isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        // Pop element from stack1 (front of queue)
        return stack1.pop();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
                // Create queue object
        StackQueueDequeueFriendly q = new StackQueueDequeueFriendly();

        // Insert elements into queue
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        // Remove elements from queue
        System.out.println("Dequeued: " + q.dequeue());
        System.out.println("Dequeued: " + q.dequeue());
    }
    
}
