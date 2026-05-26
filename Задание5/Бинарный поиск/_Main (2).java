import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;


public class Main {
public static boolean binSearch2(int key, int[] arr, int indexMin, int indexMax) {

        boolean flag = false;

        int seredina = (indexMin + indexMax) / 2;

        if (indexMin > indexMax) {
            flag = false;
            return flag;
        }

        if (arr[seredina] == key) {
            flag = true;
            return flag;
        }

        if (key > arr[seredina]) {
            flag = binSearch2(key, arr, seredina + 1, indexMax);
        } else if (key < arr[seredina]) {
            flag = binSearch2(key, arr, indexMin, seredina - 1);
        }


        return flag;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
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

            //число наличие которого необходимо проверить в массиве
            String k = "";
            int key = 0;

            k = reader.readLine();
            key = Integer.parseInt(k);


            boolean flag = binSearch2(key, arr, 0, arr.length);
            if (flag == true) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}