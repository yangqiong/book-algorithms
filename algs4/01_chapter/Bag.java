/**
 * 1.3 背包
 * 编译：javac -cp :../stdlib.jar Bag.java
 * 运行：java -cp :../stdlib.jar Bag.java < tobe.txt
 * 结果：to be not that or be (2 left on bag)
 */

import java.util.NoSuchElementException;
import java.util.Iterator;

public class Bag<Item> implements Iterable<Item>{
    private Node first;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() { return first == null; }
    public int size() { return N; }

    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
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
        Bag<String> s = new Bag<String>();
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if (!item.equals("-")){
                s.add(item);
            }
        } 
        StdOut.println("(" + s.size() + " left on bag)");
    }
}