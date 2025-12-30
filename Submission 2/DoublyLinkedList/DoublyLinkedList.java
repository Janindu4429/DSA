/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DoublyLinkedList;

/**
 *
 * @author janindu
 */
public class DoublyLinkedList {


    // Node class
    class Node {
        int data;     // Data of node
        Node prev;    // Reference to previous node
        Node next;    // Reference to next node

        Node(int data) {
            this.data = data;
        }
    }

    Node head;   // Head of doubly linked list

    // Insert node at the end
    void insert(int data) {

        Node newNode = new Node(data);

        // If list is empty
        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        // Traverse till last node
        while (temp.next != null) {
            temp = temp.next;
        }

        // Link new node
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Delete node by value
    void delete(int key) {

        Node temp = head;

        // Search for the node
        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        // If node not found
        if (temp == null)
            return;

        // If node is not head
        if (temp.prev != null)
            temp.prev.next = temp.next;
        else
            head = temp.next;

        // If node is not last
        if (temp.next != null)
            temp.next.prev = temp.prev;
    }

    // Display doubly linked list
    void display() {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }

        System.out.println("null");
    }
    public static void main(String[] args) {
        // TODO code application logic here
        DoublyLinkedList list = new DoublyLinkedList();

        // Insert elements
        list.insert(5);
        list.insert(10);
        list.insert(15);

        // Display list
        list.display();

        // Delete element
        list.delete(10);
        list.display();
    }
    
}
