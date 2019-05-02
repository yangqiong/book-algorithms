/**
 * 1.3.2.5 下压（LIFO）栈（能够动态调整数组大小的实现） 
 * 编译：javac -Xlint:unchecked -cp :../stdlib.jar ResizingArrayStack.java
 * 运行：java -cp :../stdlib.jar ResizingArrayStack.java < tobe.txt
 * 结果：to be not that or be (2 left on stack)
 */

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1];
    private int N = 0;
    private void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++){
            temp[i] = a[i];
            a = temp;
        }
    }

    public boolean isEmpty() { return N == 0; }
    public int size() { return N; }
    
    public void push(Item item){
        if (N == a.length) resize(2 * a.length);
        a[N++] = item;
    }

    public Item pop(){
        Item item = a[--N];
        if ( N > 0 && N == a.length / 4){
            resize((a.length / 2));
        }
        return item;
    }

    

    public Iterator<Item> iterator(){
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;
        public boolean hasNext()    { return i > 0;     }
        public Item next()          { return a[--i];    }
        public void remove()        {                   }
    }
    
    public static void main(String[] args){
        FixedCapacityStack<String> s = new FixedCapacityStack<String>(100);
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if (!item.equals("-")){
                s.push(item);
            } else if (!s.isEmpty()){
                StdOut.printf(s.pop() + " ");
            }
        }
        StdOut.print("(" + s.size() + " left on stack)");
    }
}