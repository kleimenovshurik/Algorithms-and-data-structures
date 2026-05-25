import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {    
    public static int partitionXoar(int[] mas, int left, int right) {
        int l = left;
        int r = right;
        int pivot = mas[(left + right) / 2];
        while (true) {
            // Условия для убывающей сортировки
            while (mas[l] > pivot) {
                l++;
            }
            while (mas[r] < pivot) {
                r--;
            }
            if (l >= r) {
                return r;
            }
            int c = mas[l];
            mas[l] = mas[r];
            mas[r] = c;
            l++;
            r--;
        }
    }

    public static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partitionXoar(arr, left, right);
            quickSort(arr, left, pivotIndex);
            quickSort(arr, pivotIndex + 1, right);
        }
        return arr;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String n = reader.readLine();
            int number = Integer.parseInt(n);

            int[] arr = new int[number];
            for (int i = 0; i < number; i++) {
                arr[i] = Integer.parseInt(reader.readLine());
            }

            arr = quickSort(arr, 0, arr.length - 1);

            for (int num : arr) {
                System.out.println(num);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}