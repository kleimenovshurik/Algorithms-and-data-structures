import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {    

		public static void main(String[] args) throws IOException {
        DynamicArrayTest dynamicArrayTest = new DynamicArrayTest(0, 0, new int[]{});

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //количество операций
        int count = 0;
        int number = Integer.parseInt(reader.readLine());

        while (count < number) {
            String elem = reader.readLine();
            if(elem.equals("push_back") || elem.equals("pop_back")  || elem.equals("size")  || elem.equals("index")){
                count++;
            }
            if (elem.equals("push_back")){
                String element = reader.readLine();
                dynamicArrayTest.push_back(Integer.parseInt(element));
            }

            if (elem.equals("pop_back")){
                dynamicArrayTest.pop_back();
            }

            if(elem.equals("size")){
                int size = dynamicArrayTest.size;
                System.out.println(size);
            }
            if (elem.equals("index")){
                String element = reader.readLine();
                dynamicArrayTest.index(Integer.parseInt(element));
            }

        }

        DynamicArrayTest dynamicArrayTest1 = new DynamicArrayTest(0,0, new int[]{});

    }

    public static class DynamicArrayTest {
        int size;
        int capacity;
        int[] buffer = new int[capacity];

        public DynamicArrayTest(int size, int capacity, int[] buffer) {
            this.size = size;
            this.capacity = capacity;
            this.buffer = buffer;
        }

        public void pop_back(){
            size = size - 1;
            System.out.println(buffer[size]);
            buffer[size] = 0;
        }

        public void push_back(int elem){
            if(size + 1 >= capacity){
                resize();
            }
            buffer[size] = elem;
            size = size + 1;
        }

        public int[] resize(){
            int [] new_buffer = new int[capacity + 1];
            for(int i = 0; i < buffer.length; i++){
                new_buffer[i] = buffer[i];
            }
            capacity = capacity + 1;
            buffer = new_buffer;
            return buffer;
        }

        public int size(){
            System.out.println(size);
            return size;
        }

        public void index(int ind){
            System.out.println(buffer[ind]);
        }
    }
}