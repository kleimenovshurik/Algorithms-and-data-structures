import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {



    //Создаем статически вложенный класс, независящий от main
    public static class Node{
        public String value;
        Node next;

        public  Node(String value){
            this.value = value;
        }

        public boolean searchNode(String value){
            Node temp = this;
            Node current = this;

            boolean flag = false;
            while (current != null && current.value != null){
                if(current.value.equals(value)){
                    flag = true;
                    return flag;
                }
                current = current.next;
            }
            current = temp;
            return flag;
        }

        public Node removeNode(String value){
            Node current = this;

            //удаляем первый элемент
            if (current.value.equals(value)){
                current = current.next;
                return current;
            }

            // Ищем элемент по всей цепочке
            while (current.next != null){
                if(current.next.value.equals(value)){
                    current.next = current.next.next;
                    return this;
                }
                if( !current.next.value.equals(value)){
                    current = current.next;
                    int a = 0;
                }
            }
            return this;
        }
    }

    public static class HashTable{
        public Node [] mas;
        int size;
        int capasity;
        int countCollision;

        public HashTable(int size, int capasity){
            this.size = size;
            this.capasity = capasity;
            this.mas = new Node[capasity];
            this.countCollision = 0;
        }

        public int hash(String value){
            int hash = 0;
            int size = value.length();
            int x = 0;
            if (size == 0){
                return 0;
            }
            if (size > 1){
                x = size - 1;
            }
            else{
                x = 1;
            }

            char temp = '.';
            int temp2 = 0;
            String [] arrValue = new String[size];
            arrValue = value.split("");
            for(int i = 0; i < arrValue.length; i++){
                temp = arrValue[i].charAt(0);
                temp2 = (int)temp;
                hash = (hash * x + temp2) % size;
            }
            return hash;
        }

        /*public boolean search(String value){
            boolean flag = false;
            int hash = hash(value);
            Node current = this.mas[hash];
            while (current != null){
                if(mas[hash] == null || mas[hash].value == null){
                    flag = false;
                }
                else{
                    if(current.value.equals(value)){
                        flag = true;
                    }
                    current = current.next;
                }

                if(flag == true){
                    System.out.println("TRUE");
                }
                else {
                    System.out.println("FALSE");
                }
            }
            return flag;
        }*/


            public boolean search(String value){
            boolean flag = false;
            int hash = hash(value);
            Node current = this.mas[hash];
            while (current != null){
                    if(current.value.equals(value)){
                        flag = true;
                        break;
                    }
                    current = current.next;


            }
                if(flag == true){
                    System.out.println("TRUE");
                }
                else {
                    System.out.println("FALSE");
                }

            return flag;
        }


        /*public Node [] push(String value){
            int hash = hash(value);
            if(mas[hash] != null) {
                if (mas[hash].value.equals(value)) {
                    return this.mas;
                } else {
                    if (!mas[hash].value.equals(value)) {
                        Node current = mas[hash];
                        while (current.next != null) {
                            // идем до конца цепочки
                            current = current.next;
                        }
                        Node node = new Node(value);
                        current.next = node;
                        countCollision += 1;
                    }
                }
            }
            else{
                mas[hash] = new Node(value);
                size = size + 1;
            }
            return mas;
        }*/

        public Node [] push(String value){
            int hash = hash(value);
            Node current = mas[hash];
            if(mas[hash] == null){
                mas[hash] = new Node(value);
                size++;
                return mas;
            }

            if(current.value.equals(value)){
                return this.mas;
            }

            while (current.next != null){
                if(current.next.value.equals(value)){
                    return this.mas;
                }
                current = current.next;
            }
            current.next = new Node(value);
            size++;
            countCollision++;
            return mas;
        }

        public Node [] pop(String value){
            int hash = hash(value);
            if((mas[hash] == null) || (mas[hash].searchNode(value)== false)){
                System.out.println("FALSE");
            }
            else {
                mas[hash] =  mas[hash].removeNode(value);
                countCollision = countCollision - 1;
                System.out.println("TRUE");
            }
            return mas;
        }



    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        HashTable hashTable = new HashTable(0, number);
        int count = 0;
        while(count < number){
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
            String command = reader.readLine();
            String[] commandParts = command.split(" ");
            String str = commandParts[1];
            switch (commandParts[0]) {
                case "push":
                    hashTable.push(str);
                    break;
                case "pop":
                    hashTable.pop(str);
                    break;
                case "search":
                    hashTable.search(str);
                    break;
                default:
                    break;
            }
            count++;
        }

        /*Node n1 = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        Node n4 = new Node("4");
        Node n5 = new Node("5");
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;*/

        /*Node n1 = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        Node n4 = new Node("4");
        Node n5 = new Node("5");*/


        /*HashTable hashTable = new HashTable(0, 8);

        hashTable.push("1");
        hashTable.push("278");
        hashTable.push("qwerty");
        hashTable.pop("278");*/



    }
}