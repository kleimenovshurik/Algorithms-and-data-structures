import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    boolean flag = true;
    while (flag == true){
        String elem = reader.readLine();
        if(elem.equals("новичок:")){
            String name = reader.readLine();
            LinkedListIn.pushFront(name);
        }

        if(elem.equals("следующий")&&(!LinkedListOut.isEmpty())){
            if (LinkedListOut.head != null) {
                System.out.println(LinkedListOut.head.value);
                LinkedListOut.popFront();
                //elem="";
                }
            }

        if(elem.equals("следующий")&&(LinkedListOut.isEmpty())) {

            while (!LinkedListIn.isEmpty()) {
                LinkedListOut.pushFront(LinkedListIn.top());
                LinkedListIn.popFront();
            }
            if (LinkedListOut.head != null) {
                System.out.println(LinkedListOut.head.value);
                LinkedListOut.popFront();
            }
        }

        if(elem.equals("Смена закончилась!")){
            flag = false;
        }
        if(LinkedListOut.isEmpty()&&elem.equals("следующий")){
            System.out.println("Все вылечены!");
            flag = false;
        }
    }
}

    public static class Node{
        public String value;
        public Node next;

        public Node(String value) {
            this.value = value;
        }
    }

    public static class LinkedListIn{
        public static Node head = null;
        public static Node tail = null;


        public static void pushFront(String value){
            if(head == tail && tail == null){
                Node node = new Node(value);
                head = node;
                tail =  node;
            }
            else{
                Node node = new Node(value);
                node.next = head;
                head = node;
            }
        }

        public static boolean isEmpty(){
            if (head == null){
                return true;
            }
            else {
                return false;
            }
        }

        public static void popFront(){
            if (head!= null){
                head = head.next;
            }
        }

        public static String top() {
            if (head != null) {
                return head.value;
            } else {
                return null;
            }
        }
    }

    public static class LinkedListOut{
        public static Node head = null;
        public static Node tail = null;


        public static void pushFront(String value){
            if(head == tail && tail == null){
                Node node = new Node(value);
                head = node;
                tail = node;
            }
            else{
                Node node = new Node(value);
                node.next = head;
                head = node;
            }
        }

        public static boolean isEmpty(){
            if (head == null){
                return true;
            }
            else {
                return false;
            }
        }

        public static void popFront(){
            head = head.next;
        }

        public static String top() {
            if (head != null) {
                return head.value;
            } else {
                return null;
            }
        }
    }
}