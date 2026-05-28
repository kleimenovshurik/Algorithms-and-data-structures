import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //количество операций
        int count = 0;
        int number = Integer.parseInt(reader.readLine());
        while(count < number){
            String elem = reader.readLine();
            if(elem.equals("push")){
                int chislo = Integer.parseInt(reader.readLine());
                Stack.pushFront(chislo);
            }
            if(elem.equals("top")){
                Stack.top();
            }
            if(elem.equals("pop")){
                Stack.popFront();
            }
            if (elem.equals("is_empty")){
                Stack.isEmpty();
            }
        count++;
        }
		            
    }
    public static class Node {
        public int value;
        public Node next;


        public Node(int value) {
            this.value = value;
        }
    }


    public static class Stack{
        static Node head = null;
        static Node tail = null;

        //добавление вначало
        public static void pushFront(int value){
            if(head == tail && head == null){
                Node node = new Node(value);
                head = node;
                tail = node;
            }
            else {
                Node node = new Node(value);
                node.next = head;
                head = node;
            }
        }

        //удалить из начала
        public static void popFront(){
            head = head.next;
        }

        public static int top(){
            System.out.println(head.value);
            return head.value;
        }

        public static boolean isEmpty(){
            if (head == null){
                System.out.println("Пуст");
                return true;
            }
            else {
                System.out.println("Не пуст");
                return false;
            }
        }
    }
}
