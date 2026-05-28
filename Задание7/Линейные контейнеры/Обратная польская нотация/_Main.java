import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        LinkedList linkedList = new LinkedList();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine().trim());

        for (int i = 0; i < count; i++) {
            String element = reader.readLine().trim();

            if (!element.equals("+") && !element.equals("-") && !element.equals("*") && !element.equals(":")) {
                // Это число, кладем в стек
                linkedList.push(element);
            } else {
                // Это оператор, извлекаем 2 числа из стека
                if (linkedList.isEmpty()) continue;
                String bStr = linkedList.top(); // Верхний элемент
                linkedList.pop();

                if (linkedList.isEmpty()) continue;
                String aStr = linkedList.top();
                linkedList.pop();

                int a = Integer.parseInt(aStr);
                int b = Integer.parseInt(bStr);
                int result = 0;

                switch (element) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case ":":
                        result = a / b; // Целочисленное деление
                        break;
                }
                // Помещаем результат обратно в стек
                linkedList.push(String.valueOf(result));
            }
        }

        // После обработки всей последовательности в стеке остается один результат
        System.out.println(linkedList.head.value);
    }

    public static class Node {
        public String value;
        public Node next;

        public Node(String value) {
            this.value = value;
        }
    }

    public static class LinkedList {
        public Node head = null;

        public void push(String value) {
            Node node = new Node(value);
            node.next = head;
            head = node;
        }

        public void pop() {
            if (head != null) {
                head = head.next;
            }
        }

        public String top() {
            if (head != null) {
                return head.value;
            }
            return null;
        }

        public boolean isEmpty() {
            return head == null;
        }
    }
}