package datastructure;


import java.util.LinkedList;
import java.util.List;

public class MyLinkedList {

    public static void main(String[] args) {



    }

    Node InsertNth(Node head, int data, int position) {
        // This is a "method-only" submission.
        // You only need to complete this method.
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        if(head == null){
            return newNode;
        }
        int i = 0 ;
        Node orgNode = head;
        while(head != null){
            if(position == 0){
                newNode.next = head;
                return newNode;
            }
            if(i == position - 1){
                newNode.next = head.next;
                head.next = newNode;
            }
            i++;
            head = head.next;
        }
        return orgNode;
    }

    Node Delete(Node head, int position) {
        // Complete this method
        Node orgHead = head;

        int i = 0;

        while(head != null){
            if(position == 0){
                return head.next ;
            }
            if(i == position-1){

                Node tmpNode = head.next;
                head.next = tmpNode.next;
            }
            i++;
            head = head.next;
        }

        return orgHead ;

    }

}

class Node{
    int data;
    Node next;
}
