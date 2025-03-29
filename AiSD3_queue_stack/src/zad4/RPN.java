package zad4;

import java.util.Stack;

public class RPN  {
    public int analyzeResult(String[] tab){
        Stack<String> stack = new Stack<>();
        for(int i=0;i<tab.length;i++){
            if (tab[i] == "+"){
                int x = Integer.valueOf(stack.pop());
                int y = Integer.valueOf(stack.pop());
                stack.push(Integer.toString( x+y));
            }
            if (tab[i] == "/"){
                int x = Integer.valueOf(stack.pop());
                int y = Integer.valueOf(stack.pop());
                stack.push(Integer.toString( x/y));
            }
            if (tab[i] == "-"){
                int x = Integer.valueOf(stack.pop());
                int y = Integer.valueOf(stack.pop());
                stack.push(Integer.toString( x-y));
            }
            if (tab[i] == "*"){
                int x = Integer.valueOf(stack.pop());
                int y = Integer.valueOf(stack.pop());
                stack.push(Integer.toString( x*y));
            }
            else{
                stack.push(tab[i]);
            }
        }
        return Integer.valueOf(stack.peek());
    }

    public static void main(String[] args){
        RPN rpn = new RPN();
        String[] tab = {"12", "2", "3" ,"4" ,"*" ,"10" ,"5" ,"/", "+", "*", "+"};
        rpn.analyzeResult(tab);

    }
}
