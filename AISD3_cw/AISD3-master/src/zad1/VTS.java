package zad1;

import java.util.EmptyStackException;
import java.util.Stack;

public class VTS<T> extends Stack<T> {
    int cursor = 0;

    @Override
    public T push(T item){
        this.cursor = 0;
        super.push(item);
        return item;
    }
    @Override
    public synchronized T pop(){
        this.cursor = 0;
        return super.pop();

    }

    public void top(){
        this.cursor = 0;
    }

    public void down(){
        this.cursor = 0;
        int len = size();
        if (this.cursor+1 > len-1){
            throw new StackOverflowError();
        }
        else{
            this.cursor++;
        }


    }
    @Override
    public synchronized T peek() {

        if (cursor < 0)
            throw new EmptyStackException();
        return elementAt(size() - 1 - cursor);
    }

    public static void main(String[] args){
        VTS<Integer> vts = new VTS<>();
        vts.push(1);
        vts.push(2);
        vts.push(3);

        System.out.println(vts.peek());

        vts.pop();

        vts.push(1);

        vts.top();
        vts.down();

        System.out.println(vts.peek());


    }
}
