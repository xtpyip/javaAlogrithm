package src.chapter1_stackandqueue;

import java.util.Stack;

public class Problem01_GetMinStack {
    public static class MyStack1 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack1() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        public void push(int newNum) {
            if (stackMin.isEmpty()) {
                stackMin.push(newNum);
            } else if (newNum <= this.getMin()) {
                stackMin.push(newNum);
            }
            stackData.push(newNum);
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("your stack is empty");
            }
            int value = this.stackData.pop();
            if (value == this.getMin()) {
                this.stackMin.pop();
            }
            return value;
        }

        public int getMin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("your stack is empty");
            }
            return this.stackMin.peek();
        }

        public void print() {
            while (!this.stackMin.isEmpty()) {
                System.out.print(this.stackMin.pop() + " \t");
            }
        }

    }

    public static class MyStack2 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack2() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        public void push(int newNum) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
            } else if (newNum <= getMin()) {
                this.stackMin.push(newNum);
            } else {
                this.stackMin.push(getMin());
            }
            this.stackData.push(newNum);
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("your stack is empty");
            }
            this.stackMin.pop();
            return this.stackData.pop();
        }

        public int getMin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("your stack is empty");
            }
            return this.stackMin.peek();
        }

        public void print() {
            while (!this.stackMin.isEmpty()) {
                System.out.print(this.stackMin.pop() + " \t");
            }
        }

    }


    public static void main(String[] args) {
        MyStack1 myStack1 = new MyStack1();
        myStack1.push(3);
        System.out.println(myStack1.getMin());
        myStack1.push(4);
        System.out.println(myStack1.getMin());
        myStack1.push(1);
        System.out.println(myStack1.getMin());
        myStack1.push(3);
        System.out.println(myStack1.getMin());
        System.out.println(myStack1.pop());
        System.out.println(myStack1.getMin());


        System.out.println("=====================");
        myStack1.print();
        System.out.println();
        System.out.println("=====================");

        MyStack2 stack2 = new MyStack2();
        stack2.push(3);
        System.out.println(stack2.getMin());
        stack2.push(4);
        System.out.println(stack2.getMin());
        stack2.push(1);
        System.out.println(stack2.getMin());
        stack2.push(3);
        System.out.println(stack2.getMin());
        System.out.println(stack2.pop());
        System.out.println(stack2.getMin());

        System.out.println("==================");
        stack2.print();

    }


}
