import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static int[] merge(int [] arr1, int [] arr2) throws IOException {

        int l = 0;
        int r = 0;

        int lenA = arr1.length;
        int lenB = arr2.length;

        int result[] = new int[lenA + lenB];

        while (l < lenA && r < lenB){
            if(arr1[l] <= arr2[r]){
                result[l + r] = arr1[l];
                l = l + 1;
            }
            else{
                result[l + r] = arr2[r];
                r = r + 1;
            }
        }

        while( l < lenA){
            result[l + r] = arr1[l];
            l = l + 1;
        }

        while (r < lenB){
            result[l + r] = arr2[r];
            r = r + 1;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {

        try {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String n = "";
        int number = 0;

        String elem = "";
        int element = 0;

        n = reader.readLine();
        number = Integer.parseInt(n);


        int [] arr1 = new int[number];
        int count = 0;

        while (count < number){
            elem = reader.readLine();
            element = Integer.parseInt(elem);
            arr1[count] = element;
            count++;
        }

        String n2 = "";
        int number2 = 0;

        String elem2 = "";
        int element2 = 0;

        n2 = reader.readLine();
        number2 = Integer.parseInt(n2);


        int [] arr2 = new int[number2];
        int count2 = 0;

        while (count2 < number2){
            elem2 = reader.readLine();
            element2 = Integer.parseInt(elem2);
            arr2[count2] = element2;
            count2++;
        }
            int [] result =  merge(arr1,arr2);
            for(int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}