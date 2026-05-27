import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void fractionalKnapsack(int backpackWeight, double[] itemsWeights, double[] itemsValues) {
        int n = itemsWeights.length;
        Item[] items = new Item[n];
        
        for (int i = 0; i < n; i++) {
            items[i] = new Item(itemsWeights[i], itemsValues[i]);
        }
        
        // Сортируем по убыванию удельной стоимости
        Arrays.sort(items, Comparator.comparingDouble(Item::getValuePerUnit).reversed());
        
        double totalValue = 0.0;
        int remainingWeight = backpackWeight;
        
        for (Item item : items) {
            if (remainingWeight <= 0) break;
            
            double takenWeight = Math.min(item.weight, remainingWeight);
            totalValue += takenWeight * item.getValuePerUnit();
            remainingWeight -= takenWeight;
        }
        
        System.out.printf("%.3f\n", totalValue);
    }
    
    static class Item {
        double weight;
        double value;
        
        public Item(double weight, double value) {
            this.weight = weight;
            this.value = value;
        }
        
        public double getValuePerUnit() {
            return value / weight;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = reader.readLine().split(" ");
        int count = Integer.parseInt(parts[0]);
        int bpw = Integer.parseInt(parts[1]);

        double[] itemsWeights = new double[count];
        double[] itemsPrices = new double[count];

        for (int i = 0; i < count; i++) {
            String[] parts2 = reader.readLine().split(" ");
            itemsPrices[i] = Double.parseDouble(parts2[0]);
            itemsWeights[i] = Double.parseDouble(parts2[1]);
        }

        fractionalKnapsack(bpw, itemsWeights, itemsPrices);
    }
}