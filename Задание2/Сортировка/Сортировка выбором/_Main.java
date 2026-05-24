import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
public static void test6() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String n;
        int number;

        String elem;
        int element;

        n = reader.readLine();
        number = Integer.parseInt(n);


        int [] arr = new int[number];
        int count=0;

        while (count<number){
            elem = reader.readLine();
            element = Integer.parseInt(elem);
            arr[count] = element;
            count++;
        }

        for(int i = 1; i < arr.length; i++){
            int j = i;
            int x = arr[j];
            while (j > 0 && arr[j-1] > x){
                arr[j] = arr[j-1];
                j = j-1;
            }
            arr[j] = x;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int indexMin = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[indexMin]) {
                    indexMin = j;  // Здесь каждый раз обновляем индекс минимума
                }
            }
            // Обмен происходит после поиска минимума, а не на каждой итерации!!!
            int temp = arr[i];
            arr[i] = arr[indexMin];
            arr[indexMin] = temp;

      }
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }

    }






    public static void main(String[] args) {
        try {
            test6();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}