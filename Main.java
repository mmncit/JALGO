import datastructure.Queue;

public class Main{

    public static void main(String[] args) {
        
        System.out.println(Math.max(1, 3, 4, 5, 6, 2));

        int[] arrTest = { 10, 5, 17, 12, 20, 2 };
        Queue<Integer> testQueue = new Queue<>();

        for (int i = 0; i < arrTest.length; i++) {
            testQueue.enqueue(arrTest[i]);
        }

        System.out.print(testQueue.toString());

    }

}