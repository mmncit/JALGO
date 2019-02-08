import datastructure.*;
public class Main{

    public static void main(String[] args) {
        
        System.out.println(Math.max(1, 3, 4, 5, 6, 2));

        int[] arrTest = { 10, 5, 17, 12, 20, 2 };
        ArrayList<Integer> myArray = new ArrayList<Integer>();

        for (int i = 0; i < arrTest.length; i++) {
            myArray.add(arrTest[i]);
        }

        System.out.print(myArray.toString());

    }

}