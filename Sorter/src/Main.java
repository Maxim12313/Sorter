//Andrew Merrill
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int i=0;
        while (i<1){
            testSort(1000);
            i++;
        }
    }

    public static void testSort(int length) {
        Random random = new Random();
        List<Integer> nums = new ArrayList<Integer>();
        int maxSize = 1000;
        for (int i = 0; i < length; i++) {
            nums.add(random.nextInt(maxSize));
        }
        List<Integer> copyNums = new ArrayList<Integer>(nums);
        java.util.Collections.sort(copyNums);
        long startTime = System.currentTimeMillis();

        //System.out.println("Before: " + nums);

        //Sorting.selectionSort(nums);
        //Sorting.insertionSort(nums);
        //Sorting.bubbleSort(nums);
        nums = Sorting.mergeSort(nums);
        //Sorting.quickSort(nums);


        // Use your sort function to sort the list called nums
        //  Sorting.yourSortFunction(nums);   // if your sort function sorts the list in-place
        //   or
        //  nums = Sorting.yourSortFunction(nums);  // if your sort function returns a new list

        long stopTime = System.currentTimeMillis();
        double duration = (double) ((stopTime - startTime) / 1000.0);
        if (copyNums.size() != nums.size()) {
            System.out.print("sorting " + length + " integers produced a list with length " + nums.size() + " :-( ");
        } else {
            boolean foundBadNum = false;
            for (int i = 0; i < copyNums.size(); i++) {
                if (!(nums.get(i).equals(copyNums.get(i)))) {
                    foundBadNum = true;
                }
            }
            if (foundBadNum) {
                System.out.print("sorting " + length + " integers failed :-( ");
            } else {
                System.out.print("sorting " + length + " integers succeeded :-) ");
            }
        }
        System.out.println("in " + duration + " seconds");


        //System.out.println("After: "+ nums);
    }
}
