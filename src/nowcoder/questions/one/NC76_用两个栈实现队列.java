package nowcoder.questions.one;

import java.util.Stack;

/**
 * NC76_用两个栈实现队列
 *
 * @author lujun
 * @date 2021/12/17
 */
public class NC76_用两个栈实现队列 {
    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        final int pop = pop();
        final int pop1 = pop();
        final int pop2 = pop();
        System.out.println(1);
    }

    public static void push(int node) {
       stack1.push(node);
    }

    public static int pop() {
        if(stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }


}