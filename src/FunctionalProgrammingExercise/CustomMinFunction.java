package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class CustomMinFunction {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        //otgovarq na e -> Integer.parseInt(e)
        Consumer<int[]> getMin = array -> System.out.println(Arrays.stream(array).min().orElse(0));
        getMin.accept(numbers);
    }
}
