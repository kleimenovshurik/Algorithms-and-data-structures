import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
public static void test7() throws IOException {
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


        int temp;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length-1;  j++){
                if(arr[j] <= arr[j + 1]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

public static void main(String[] args) {

        try {
            test7();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}