/**
 * 1.3.2.1 定容栈：一种表示定容字符串栈的抽象数据类型
 * 编译：javac -cp :../stdlib.jar FixedCapacityStackOfStrings.java
 * 运行：java -cp :../stdlib.jar FixedCapacityStackOfStrings.java < tobe.txt
 * 结果：to be not that or be (2 left on stack)
 */

public class FixedCapacityStackOfStrings {
    private String[] a;
    private int N;

    public FixedCapacityStackOfStrings(int cap){
        a = new String[cap];
        N = 0;
    }

    public boolean isEmpty() { return N == 0; }
    public int size() { return N; }
    public void push(String item){
        a[N++] = item;
    }
    public String pop(){
        return a[--N];
    }

    public static void main(String[] args){
        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(100);
        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if (!item.equals("-")){
                s.push(item);
            } else if (!s.isEmpty()) {
                StdOut.print(s.pop() + " ");
            }
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}