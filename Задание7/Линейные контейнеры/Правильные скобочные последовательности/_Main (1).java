import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        int count1 = 0;
        int count2 = 0;

        int countOpenRound = 0;
        int countOpenSquare = 0;
        int countOpenClassic = 0;

        int countClosedRound = 0;
        int countClosedSquare = 0;
        int countClosedClassic = 0;


        ArrayList arrayList = new ArrayList();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String elemm = reader.readLine();

        for (int i = 0; i < elemm.length(); i++) {
            String element = elemm.substring(i, i + 1);
            //System.out.println(element);
            arrayList.add(element);
        }

        String elem = "";
        for (int i = 0; i < arrayList.size(); i++){
            elem = arrayList.get(i).toString();
            if (elem.equals("(")||elem.equals("[")||elem.equals("{")){
                LinkedList.pushFront(elem);
                count1++;
                if(elem.equals("(")){
                    countClosedRound++;
                }

                if(elem.equals("[")){
                    countClosedSquare++;
                }

                if(elem.equals("{")){
                    countOpenClassic++;
                }

            }
            else if(elem.equals(")")||elem.equals("]")||elem.equals("}")){
                LinkedList.pop();
                count2++;

                if(elem.equals(")")){
                    countOpenRound++;
                }

                if(elem.equals("]")){
                    countOpenSquare++;
                }

                if(elem.equals("}")){
                    countClosedClassic++;
                }
            }
            else{
                i=i;
            }
        }

        if((count1 == count2)&&(LinkedList.isEmpty())&&(countOpenRound == countClosedRound)&& (countOpenSquare == countClosedSquare) && (countOpenClassic == countClosedClassic) ) {
            System.out.println("CORRECT");
        }
        else{
            System.out.println("INCORRECT");
            }

    }
    public static class Node{
        public String value;
        public  Node next;


        public Node(String value) {
           this.value = value;
        }
    }

    public static class LinkedList{
        public static Node head = null;
        public static Node tail = null;


        public static void pushFront(String value){
            if((head == null)&&(tail == null)){
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

        public static String top(){
            if (head!=null){
                return head.value;
            }
            else {
                return null;
            }
        }

        public static void pop(){
            if(head!= null){
                head = head.next;
            }
            else{
                return;
                //System.out.println("INCORRECT");
            }
        }

        public static boolean isEmpty(){
            if((head == null)){
                return true;
            }
            else{
                return false;
            }
        }
    }
}