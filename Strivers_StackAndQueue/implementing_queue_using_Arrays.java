package Strivers_StackAndQueue;
class myQueue{
    int[] arr = new int[100];
    int pos = 0;
    int temp = 0;

    public void push(int data){
        if (pos == arr.length) { // no more space
            throw new IllegalStateException("Queue Overflow: cannot add more elements");
        }
        arr[pos++] = data;
    }

    public int pop(){
        if (temp == pos) { // empty queue
            throw new IllegalStateException("Queue Underflow: cannot remove from empty queue");
        }
        int x = arr[temp++];
        return x;
    }

    public int peek(){
        if (temp == pos) { // empty queue
            throw new IllegalStateException("Queue is empty: nothing to peek");
        }
        return arr[temp];
    }

    public void print(){
        for(int i=temp;i<pos;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
public class implementing_queue_using_Arrays {
    public static void main(String[] args) {
        myQueue q = new myQueue();
        q.push(2);
        q.push(3);
        q.push(4);
        q.print();
        q.pop();
        System.out.println(q.peek());
        q.print();
        q.pop();
        q.print();
        q.pop();
        q.print();
        q.pop();

    }
}
