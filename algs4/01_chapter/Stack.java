/**
 * 1.3.3.8 下压堆栈（链表实现） 
 * 编译：javac -cp :../stdlib.jar Stack.java
 * 运行：java -cp :../stdlib.jar Stack.java < tobe.txt
 * 结果：to be not that or be (2 left on stack)
 */

import java.util.NoSuchElementException;
import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>{
    private Node first;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() { return first == null; }
    public int size() { return N; }

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Item pop(){
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Iterator<Item> iterator(){
        return new ListIterator(first);
    }

    private class ListIterator implements Iterator<Item> {
        private Node current;

        public ListIterator(Node first){
            current = first;
        }
        public boolean hasNext(){
            return current != null;
        }

        public Item next()          { 
            // if (!hasNext()) throw NoSuchElementException;
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args){
        Stack<String> s = new Stack<String>();
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if (!item.equals("-")){
                s.push(item);
            } else if (!s.isEmpty()) {
                StdOut.printf(s.pop() + " ");
            }
        } 
        StdOut.println("(" + s.size() + " left on stack)");
    }
}