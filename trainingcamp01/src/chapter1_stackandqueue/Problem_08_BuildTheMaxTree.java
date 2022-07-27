package src.chapter1_stackandqueue;

import java.util.HashMap;
import java.util.Stack;

public class Problem_08_BuildTheMaxTree {
    public static Node getMaxTree(int[] arr){
        Node[] nArr = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nArr[i] = new Node(arr[i]);
        }
        Stack<Node> stack = new Stack<>();
        HashMap<Node, Node> lBigMap = new HashMap<>();
        HashMap<Node, Node> rBigMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Node curNode = nArr[i];
            while(!stack.isEmpty() && stack.peek().value < curNode.value){
                popStackSetMap(stack,lBigMap);
            }
            stack.push(curNode);
        }
        while(!stack.isEmpty()){
            popStackSetMap(stack,lBigMap);
        }
        for (int i = arr.length - 1; i > -1 ; i--) {
            Node curNode = nArr[i];
            while(!stack.isEmpty() && stack.peek().value < curNode.value){
                popStackSetMap(stack,rBigMap);
            }
            stack.push(curNode);
        }
        while(!stack.isEmpty()){
            popStackSetMap(stack,rBigMap);
        }
        Node head = null;
        for (int i = 0; i < arr.length; i++) {
            Node curNode = nArr[i];
            Node left = lBigMap.get(curNode);
            Node right = rBigMap.get(curNode);
            if(left == null && right == null){
                head = curNode;
            }else if (left == null){
                if(right.left == null){
                    right.left = curNode;
                }else{
                    right.right = curNode;
                }
            }else if (right == null){
                if(left.left == null){
                    left.left = curNode;
                }else{
                    left.right = curNode;
                }
            }else{
                Node parent = left.value < right.value ? left : right;
                if (parent.left == null){
                    parent.left = curNode;
                }else{
                    parent.right = curNode;
                }
            }
        }
        return head;
    }
    public static void popStackSetMap(Stack<Node> stack,HashMap<Node,Node> map){
        Node curNode = stack.pop();
        if(stack.isEmpty()){
            map.put(curNode,null);
        }else{
            map.put(curNode,stack.peek());
        }
    }

    //前序遍历
    public static void printPreOrder(Node head){
        if(head == null){
            return;
        }
        System.out.print(head.value + " ");
        printPreOrder(head.left);
        printPreOrder(head.right);
    }
    // 中序遍历
    public static void printOrder(Node head){
        if(head == null){
            return;
        }
        printOrder(head.left);
        System.out.print(head.value + " ");
        printOrder(head.right);
    }
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        Node head = getMaxTree(arr);
        printPreOrder(head);
        System.out.println();
        printOrder(head);
    }
}
