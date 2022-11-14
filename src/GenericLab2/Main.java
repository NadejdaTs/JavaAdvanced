package GenericLab2;

public class Main {
    public static void main(String[] args) {
        String[] javas = ArrayCreator.<String>create(13, "Java");

        String[] javas2 = ArrayCreator.<String>create(String.class, 13, "Java create method 2");

        Integer[] inArr = ArrayCreator.<Integer>create(Integer.class, 5, 4);
        System.out.println();
    }
}
