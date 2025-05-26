package project_Eden_Michaela;

import java.util.Arrays;

public class Utils {
    public static Object[] resizeArr(Object[] arr) {
        return Arrays.copyOf(arr, arr.length == 0 ? 2 : arr.length * 2);
    }


    public static boolean isExist(Object[] arr, int size, Object obj) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(obj)) {
                return true;
            }
        }
        return false;
    }


}
