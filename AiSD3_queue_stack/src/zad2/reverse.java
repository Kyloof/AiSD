package zad2;

import java.util.Stack;

public class reverse<T> extends Stack<T> {
    Stack<T> reversedStack;

    public void reverseStack(){
        Stack<T> reversedStack = new Stack<>();

        while (size()!=0){
            reversedStack.push(pop());
        }
        while (!reversedStack.isEmpty()) {
            push(reversedStack.pop());
        }
    }
    public static void main(String[] args){
        reverse<Integer> st1 = new reverse<>();
        st1.push(1);
        st1.push(2);
        st1.push(3);
        st1.reverseStack();
        while (!st1.isEmpty()){
            System.out.println(st1.pop());
        }


    }
}
