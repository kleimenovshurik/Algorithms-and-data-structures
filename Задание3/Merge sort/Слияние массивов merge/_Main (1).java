import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
public static int[] merge(int[] arr1, int[] arr2) {
        int l = 0;
        int r = 0;

        int lenA = arr1.length;
        int lenB = arr2.length;

        int result[] = new int[lenA + lenB];

        while (l < lenA && r < lenB) {
            if (arr1[l] >= arr2[r]) {
                result[l + r] = arr1[l];
                l = l + 1;
            } else {
                result[l + r] = arr2[r];
                r = r + 1;
            }
        }

        while (l < lenA) {
            result[l + r] = arr1[l];
            l = l + 1;
        }

        while (r < lenB) {
            result[l + r] = arr2[r];
            r = r + 1;
        }
        return result;
    }


    public static int[] mergeSort(int[] arrr) {
        if (arrr.length <= 1) {
            return arrr;
        }
        int length = arrr.length;
        int[] arr = new int[length];
        for (int i = 0; i < arrr.length; i++) {
            arr[i] = arrr[i];
        }

        int[] arr1 = Arrays.copyOfRange(arr, 0, arr.length / 2);
        int[] arr2 = Arrays.copyOfRange(arr, arr1.length, arr.length);

        return merge(mergeSort(arr1), mergeSort(arr2));
    }


    public static int[] testMergeSort() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String n = "";
        int number = 0;

        String elem = "";
        int element = 0;

        n = reader.readLine();
        number = Integer.parseInt(n);


        int[] arr = new int[number];
        int count = 0;

        while (count < number) {
            elem = reader.readLine();
            element = Integer.parseInt(elem);
            arr[count] = element;
            count++;
        }

        return mergeSort(arr);
    }


    public static void main(String[] args) throws IOException {
        int[] sortedArr = testMergeSort();

        for (int i = 0; i < sortedArr.length; i++) {
            System.out.println(sortedArr[i]);
        }
    }
}