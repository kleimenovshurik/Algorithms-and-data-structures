import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void test4() throws IOException {

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
        
            for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    
    }

    public static void main(String[] args) {
        try {
            test4();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}