import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static int [] backpack(int maxWeight, int [] arr){
        int count = arr.length;
        int amount = 0;
        int sum = 0;
        int [] arrS = new int[count];
        int [] res = new int[2];
        Arrays.sort(arr);
        arrS = arr;
        int j = 0;
        while (sum < maxWeight){
            sum = sum + arrS[j];
            j++;
            amount++;
        }

        if(sum > maxWeight){
            sum = sum - arr[j - 1];
            amount--;
        }
        res[0] = amount;
        res[1] = sum;
        return res;
    }

public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //максимальный вес, который может утащить школьник.
        int maxWeight = Integer.parseInt(reader.readLine());

        //
        List<Integer> a = new ArrayList<>();

        String[] parts = reader.readLine().split(" "); // Читаем всю строку и разбиваем по пробелам
        for (int i = 0;i < parts.length; i++){
                a.add(Integer.parseInt(parts[i]));
        }

        int listCount = a.size();
        int [] finalArr = new int[listCount];

        for(int i = 0; i < a.size(); i++){
            finalArr[i] = a.get(i);
        }

        int [] res = new int[listCount];
        res = backpack(maxWeight, finalArr);
        System.out.print(res[0] + " " + res[1]);
    }
}