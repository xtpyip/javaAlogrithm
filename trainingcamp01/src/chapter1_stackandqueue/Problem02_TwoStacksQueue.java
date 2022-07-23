package src.chapter1_stackandqueue;

import java.util.Stack;

public class Problem02_TwoStacksQueue {
    public static class TwoStacksQueue {
        public Stack<Integer> stackIn ;
        public Stack<Integer> stackOut ;
        public TwoStacksQueue(){
            this.stackIn = new Stack<Integer>();
            this.stackOut = new Stack<Integer>();
        }
        public void add(int newValue){
            stackIn.push(newValue);
        }
        public int poll(){
            if (stackIn.empty() && stackOut.isEmpty()){
                throw new RuntimeException("Your stack is empty");
            }else if(stackOut.isEmpty()){
                while (!stackIn.isEmpty()){
                    stackOut.push(stackIn.pop());
                }
            }
            return stackOut.pop();
        }
        public int peek(){
            if(stackIn.isEmpty() && stackOut.isEmpty()){
                throw new RuntimeException("Your stack is empty");
            }else if(stackOut.isEmpty()){
                while(!stackIn.empty()){
                    stackOut.push(stackIn.pop());
                }
            }
            return stackOut.peek();
        }

    }

    public static void main(String[] args) {
        TwoStacksQueue test = new TwoStacksQueue();
        test.add(1);
        test.add(2);
        test.add(3);
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());

    }
}
