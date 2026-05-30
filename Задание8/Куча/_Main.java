import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        int[] arr = new int[number];
        for (int i = 0; i < number; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        Heap.MakeHeap(arr);

        int amountRequestsToHeap = Integer.parseInt(reader.readLine());
        for (int i = 0; i < amountRequestsToHeap; i++) {
            String command = reader.readLine();
            String[] commandParts = command.split(" ");
            switch (commandParts[0]) {
                case "GetMax":
                    Integer max = Heap.GetMax();
                    System.out.println(max == null ? "None" : max);
                    break;
                case "PopMax":
                    Heap.PopMax();
                    break;
                case "Push":
                    int value = Integer.parseInt(commandParts[1]);
                    Heap.Push(value);
                    break;
                case "IsEmpty":
                    System.out.println(Heap.IsEmpty() ? "TRUE" : "FALSE");
                    break;
                default:
                    break;
            }
        }
    }

    public static class Heap {

        public static int[] heapElemnts;
        public static int countElemnts; // Кол-во элементов, актуальный размер кучи

        public static void MakeHeap(int[] arrElements) {
            heapElemnts = arrElements;
            countElemnts = heapElemnts.length;
            for (int i = countElemnts / 2 - 1; i >= 0; i--) {
                ShiftDown(i);
            }
        }

        public static void ShiftUp(int index) {
            while (index > 0) {
                int parentIndex = (index - 1) / 2;
                if (heapElemnts[index] > heapElemnts[parentIndex]) {
                    swap(index, parentIndex);
                    index = parentIndex;
                } else {
                    break;
                }
            }
        }

        public static void ShiftDown(int index) {
            while (true) {
                int leftChild = 2 * index + 1;
                int rightChild = 2 * index + 2;
                int largest = index;

                if (leftChild < countElemnts && heapElemnts[leftChild] > heapElemnts[largest]) {
                    largest = leftChild;
                }
                if (rightChild < countElemnts && heapElemnts[rightChild] > heapElemnts[largest]) {
                    largest = rightChild;
                }
                if (largest != index) {
                    swap(index, largest);
                    index = largest;
                } else {
                    break;
                }
            }
        }

        private static void swap(int i, int j) {
            int temp = heapElemnts[i];
            heapElemnts[i] = heapElemnts[j];
            heapElemnts[j] = temp;
        }

        public static Integer GetMax() {
            if (countElemnts == 0) {
                return null;
            }
            return heapElemnts[0];
        }

        public static void PopMax() {
            if (countElemnts == 0) return;

            swap(0, countElemnts - 1);
            countElemnts--;
            ShiftDown(0);
        }

        public static void Push(int value) {
            if (heapElemnts == null) {
                heapElemnts = new int[1];
                heapElemnts[0] = value;
                countElemnts = 1;
                return;
            }
            // Если массив заполнен, расширяем
            if (countElemnts == heapElemnts.length) {
                int[] newHeap = new int[heapElemnts.length * 2 + 1];
                System.arraycopy(heapElemnts, 0, newHeap, 0, heapElemnts.length);
                heapElemnts = newHeap;
            }
            heapElemnts[countElemnts] = value;
            countElemnts++;
            ShiftUp(countElemnts - 1);
        }

        public static boolean IsEmpty() {
            return countElemnts == 0;
        }
    }
}
