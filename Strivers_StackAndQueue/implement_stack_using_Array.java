package Strivers_StackAndQueue;
import  java.util.*;
class myStack{
    int[] arr = new int[100];
    int pos = 0;

    public void push(int data){
        if(pos<arr.length)arr[pos++] = data;
    }

    public int pop(){
        if(pos<0) throw new EmptyStackException();
        int x = arr[--pos];
        return x;
    }

    public int peek(){
        if(pos<0) throw new EmptyStackException();
        return arr[pos-1];
    }

    public void print(){
        for(int i=0;i<pos;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
public class implement_stack_using_Array {
    public static void main(String[] args) {
        myStack st = new myStack();
        st.push(2);
        st.push(3);
        st.push(4);
        st.print();
        st.pop();
        st.print();
        System.out.println(st.peek());
        st.pop();
        st.pop();
        st.pop();

    }
}
