package project_Eden_Michaela;

import java.util.Arrays;

public class Utils {
    public static Object[] resizeArr(Object[] arr) {
        return Arrays.copyOf(arr, arr.length == 0 ? 2 : arr.length * 2);
    }


    public static boolean isExist(Object[] arr, int size, String name) {
        for (int i = 0; i < size; i++) {
            if (arr[i] instanceof StudyDepartment studyDepartment) {
                if (studyDepartment.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
            if (arr[i] instanceof Lecturer lecturer) {
                if (lecturer.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
            if (arr[i] instanceof Committee committee) {
                if (committee.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;

    }
}
