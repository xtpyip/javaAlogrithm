package src.chapter1_stackandqueue;

import java.util.Stack;

//使用递归逆序一个栈
public class Problem_03_ReverseStackUsingRecursive {
    /**
     *
     * 此函数每次返回并删除最底部的数字，保持上方相对顺序不变
     * @param stack
     * @return
     */
    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int result = stack.pop();
        if(stack.isEmpty()){
            return result;
        }else{
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    /**
     * 此函数逆转栈
     * @param stack
     */
    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int i = getAndRemoveLastElement(stack);
        // 从底部拿出数字，并从最后的递归函数依次压入栈中
        reverse(stack);
        stack.push(i);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverse(stack);


    }
}
