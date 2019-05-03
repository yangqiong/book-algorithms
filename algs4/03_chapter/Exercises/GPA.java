/** 
 * 3.1.1
 * 编译：javac -cp :../../stdlib.jar:../.:../../01_chapter/ GPA.java
 * 运行：javac -cp :../../stdlib.jar:../. GPA.java
 * 输入：A- B+ B+ B-
 * 输出：GPA = 3.25
 */

public class GPA {

    public static void main(String[] args){
        BinarySearchST<String, Double> grades = new BinarySearchST(100);
        grades.put("B",  3.00);
        grades.put("C",  2.00);
        grades.put("D",  1.00);
        grades.put("F",  0.00);
        grades.put("A+", 4.33);
        grades.put("B+", 3.33);
        grades.put("C+", 2.33);
        grades.put("A-", 3.67);
        grades.put("B-", 2.67);

        int n = 0;
        double total = 0.0;
        for (n = 0; !StdIn.isEmpty(); n++){
            String grade = StdIn.readString();
            double value = grades.get(grade);
            total += value;
        }
        double gpa = total / n;
        StdOut.println("GPA = " + gpa);
    }
}