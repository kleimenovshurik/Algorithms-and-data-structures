import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static int[] countSort(int[] arr) throws IOException {

        //int[] arr = {-18, -15, -15, -3, 6, 6, 15};
        int[] arrModif = new int[arr.length];

        // Определяем минимальный элемент
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        //случай если присутствуют отрицательные элементы
        if (min < 0){
            int minReverse = min * (-1);
            for (int i = 0; i < arr.length; i++ ){
                arrModif[i] = arr[i] + minReverse;
            }
        }

        int maxModif = arrModif[0];
        for (int i = 1; i < arrModif.length; i++) {
            if (arrModif[i] > maxModif) {
                maxModif = arrModif[i];
            }
        }

        // Подсчёт количества каждого из элементов
        int[] arrCount = new int[maxModif + 1];
        for (int i = 0; i < arrModif.length; i++) {
            arrCount[arrModif[i]]++;
        }

        // Преобразуем массив arrCount в массив с границами
        int[] arrBouders = new int[arrCount.length];


        //преобразуем массив arrCount в массив с границами, для этого используем массив arrBouders
        for(int i = 0; i < arrCount.length; i++){
            arrBouders[i] = arrCount[i];
        }

        for(int i = 1; i < arrBouders.length; i++){
            arrBouders[i] = arrBouders[i] + arrBouders[i-1];
        }


        int[] result = new int[arr.length];
        for (int i = arrModif.length - 1; i >= 0; i--) {
            int value = arrModif[i];
            int index = arrBouders[value] - 1;
            result[index] = value+min; // Сохраняем оригинальное значение
            arrBouders[value]--;
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

        int [] arr = new int[number];
        int count = 0;

        while (count<number){
            elem = reader.readLine();
            element = Integer.parseInt(elem);
            arr[count] = element;
            count++;
        }

        int [] result = countSort(arr);
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}