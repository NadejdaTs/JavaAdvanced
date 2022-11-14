package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = Integer.parseInt(sc.nextLine());

        Function<int[], int[]> remove = array -> Arrays.stream(array)
                .filter(w -> w % n != 0)
                .toArray();

        int[] result = remove.apply(numbers);

        for (int i = result.length - 1; i >= 0 ; i--) {
            System.out.print(result[i] + " ");
        }
    }
}
