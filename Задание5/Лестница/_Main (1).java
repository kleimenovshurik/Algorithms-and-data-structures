import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;


public class Main {

        public static int ladder(int[] a) {
            int n = a.length;
            if (n == 1) {
                return a[0];
            }
            int[] dp = new int[n];
            dp[0] = a[0];
            dp[1] = Math.max(a[0] + a[1], a[1]);

            for (int i = 2; i < n; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2]) + a[i];
            }

            return dp[n - 1];
        }

        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(reader.readLine());
            int[] a = new int[n];

            String[] parts = reader.readLine().split(" "); // Читаем всю строку и разбиваем по пробелам
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(parts[i]);
            }

            System.out.println(ladder(a));
        }
    }