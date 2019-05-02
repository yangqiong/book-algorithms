/**
 * 1.3.2.2 一种表示范型定容栈的抽象数据类型 FixedCapacityStack
 * 编译：javac -cp :../stdlib.jar FixedCapacityStack.java
 * 运行：java -cp :../stdlib.jar FixedCapacityStack.java < tobe.txt
 * 结果：to be not that or be (2 left on stack)
 */

public class FixedCapacityStack<Item> {
    private Item[] a;
    private int N;
    
    public FixedCapacityStack(int cap){
        a = (Item[]) new Object[cap];
        N = 0;
    }

    public boolean isEmpty() { return N == 0; }
    public int size() { return N; }
    public void push(Item item){
        a[N++] = item;
    }
    public Item pop(){
        return a[--N];
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