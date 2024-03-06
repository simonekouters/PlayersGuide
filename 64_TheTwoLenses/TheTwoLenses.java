import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TheTwoLenses {
    public static void main(String[] args) {
        int[] array = new int[] {1, 9, 2, 8, 3, 7, 4, 6, 5};
        
        System.out.println(sortArray(array));
        System.out.println(sortArrayWithLambda(array));
    }
    
    private static List<Integer> sortArray(int[] array) {
        Arrays.sort(array);
        List<Integer> list = new ArrayList<>();
        
        for (int number : array) {
            if (number % 2 == 0) {
                list.add(number * 2);
            }
        }
        return list;
  }

    private static List<Integer> sortArrayWithLambda(int[] array) {
        return Arrays.stream(array)
            .sorted()
            .filter(number -> number % 2 == 0)
            .mapToObj(number -> number * 2)
            .collect(Collectors.toList());
    }
}

