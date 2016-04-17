package interviewcoding;

import java.util.Scanner;

/**
 * Created by nirav_000 on 2/15/2016.
 */
public class BinarySearchTree {


    public static  Node root;
    public BinarySearchTree(){
        this.root = null;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int firstNode =  scanner.nextInt();

        int secondNode = scanner.nextInt();

        int totalNodes = scanner.nextInt();

        for(int i = 1 ; i <= totalNodes ; i++){
            int possibleNodes = scanner.nextInt();
            insert(possibleNodes);
        }

        display(root);

        System.out.print("The distance between the node with value " + firstNode + " and the node with value " + secondNode + " is " + findDistance(firstNode,secondNode));
    }

    public static void display(Node root) {

        if (root != null) {
            display(root.left);
            System.out.print(" " + root.data);
            display(root.right);
        }
    }


    public static void insert(int id){
        Node newNode = new Node(id);
        if(root==null){
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while(true){
            parent = current;
            if(id < current.data){
                current = current.left;
                if(current==null){
                    parent.left = newNode;
                    return;
                }
            }else{
                current = current.right;
                if(current==null){
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    public static int findDistance(int firstNode, int secondNode){

        int lenghtNode1 = findPathLength(root, firstNode) ;
        System.out.println("Node " + firstNode + " length " + " is " + lenghtNode1 );
        int lenghtNode2 = findPathLength(root, secondNode) ;
        System.out.println("Node " + secondNode + " length " + " is " + lenghtNode2 );
        int lcaData = findLCAData(root, firstNode, secondNode).data;
        int lcaLength = findPathLength(root, lcaData) ;

        System.out.println("LCA for Node " + firstNode + " and Node " + secondNode + " is " + lcaData );
        return lenghtNode1 + lenghtNode2 - 2*lcaLength ;

    }

    private static Node findLCAData(Node root, int firstNode, int secondNode) {

        if(root.data == firstNode || root.data == secondNode){
            return root;
        }
        else if(root.data > firstNode && root.data > secondNode){
            if(root.left != null){
                return findLCAData(root.left, firstNode, secondNode);
            }
            else{
                return root;
            }
        }
        else if(root.data < firstNode && root.data < secondNode) {
            if(root.right != null){
                return findLCAData(root.right, firstNode, secondNode);
            }
            else{
                return root;
            }

        }

        return root;
    }


    private static int findPathLength(Node root, int nodeData) {
        if(root != null){
            int x = 0;
            if(root.data == nodeData){
                return x ;
            }
            else if (nodeData > root.data ) {
               return  findPathLength(root.right, nodeData) + 1;
            }
            else if(nodeData < root.data){
                return  findPathLength(root.left, nodeData) + 1;
            }

        }
        return 0;
    }

}

class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
