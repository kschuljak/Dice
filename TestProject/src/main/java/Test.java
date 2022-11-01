import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test
{
    public static void main(String[] args) {

        System.out.println("TEST ONE");
        List<Integer> testOneListOne = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> testOneListTwo = new ArrayList<>(Arrays.asList(4, 5, 6));
        List<Integer> resultOne = interleaveLists(testOneListOne, testOneListTwo);
        System.out.println(resultOne);

        System.out.println("TEST TWO");
        List<Integer> testTwoListOne = new ArrayList<>(Arrays.asList(7, 1, 3));
        List<Integer> testTwoListTwo = new ArrayList<>(Arrays.asList(2, 5, 7, 9));
        List<Integer> resultTwo = interleaveLists(testTwoListOne, testTwoListTwo);
        System.out.println(resultTwo);

        System.out.println("TEST THREE");
        List<Integer> testThreeListOne = new ArrayList<>(Arrays.asList(1, 2, 5, 8));
        List<Integer> testThreeListTwo = new ArrayList<>(Arrays.asList(4, 5, 6));
        List<Integer> resultThree = interleaveLists(testThreeListOne, testThreeListTwo);
        System.out.println(resultThree);

    }

    public static List<Integer> interleaveLists(List<Integer> listOne, List<Integer> listTwo) {
        int sizeOne = listOne.size();
        int sizeTwo = listTwo.size();
        int newSize = sizeOne + sizeTwo;
        int incrementOne = 0;
        int incrementTwo = 0;
        List<Integer> interleavedList = new ArrayList<>(newSize);
        for (int i = 0; i < newSize; i++) {
            if (incrementOne < sizeOne && incrementTwo < sizeTwo) {
                interleavedList.add(i, listOne.get(incrementOne));
                incrementOne++;
                i++;
                interleavedList.add(i, listTwo.get(incrementTwo));
                incrementTwo++;
            } else if (incrementOne < sizeOne) {
                interleavedList.add(i, listOne.get(incrementOne));
                incrementOne++;
            } else if (incrementTwo < sizeTwo) {
                interleavedList.add(i, listTwo.get(incrementTwo));
                incrementTwo++;
            } else {
                return interleavedList;
            }
        }
        return interleavedList;
    }
}
