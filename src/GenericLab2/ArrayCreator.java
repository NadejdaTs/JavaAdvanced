package GenericLab2;

import java.lang.reflect.Array;
import java.util.stream.IntStream;

public class ArrayCreator {

    public static <T> T[] create(int length, T value){
        return create(value.getClass(), length,value);
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] create(Class<?> clazz, int length, T value){
        T[] arr = (T[]) Array.newInstance(value.getClass(), length);

        /*for (int i = 0; i < length; i++) {
            arr[i] = value;
        }*/
        IntStream.range(0, length)
                .forEach(i -> arr[i] = value);

        return arr;
    }
}
