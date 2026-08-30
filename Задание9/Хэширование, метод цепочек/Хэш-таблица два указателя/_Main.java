import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    //создаем статически вложенныый класс, независящий от main
    public static class Buket {
        String value;
        String state;
    }


    public static class HashTable {
        public Buket[] mas;
        public int numberValue;
        public int stepValue;
        public int capacity;
        public int size;
        public int countDeleted;
        public int countFull;

        public HashTable(int capacity, int size) {
            this.capacity = capacity;
            this.size = size;
            this.mas = new Buket[capacity];
        }


        public int hashStart(String value, int nV) {
            this.numberValue = nV;
            int hash = 0;

            int len = value.length();
            char[] arr = new char[len];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = value.charAt(i);
                hash = (hash * this.numberValue + (int) arr[i]) % capacity;
            }
            return hash;
        }

        public int hashStep(String value) {
            int hash = 0;
            int sV = this.numberValue + 1;
            int len = value.length();
            char[] arr = new char[len];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = value.charAt(i);
                hash = (hash * sV + (int) arr[i]) % capacity;
            }
            if (hash == 0){
                hash = 1;
            }
            return hash;
        }

        public boolean search(String value) {
            int randomNum = 5;
            int k = hashStart(value, randomNum);
            int s = hashStep(value);
            int id;
            boolean flag = false;

            for (int i = 0; i < capacity; i++) {
                id = (k + i * s) % this.capacity;
                if ( (this.mas[id] != null) && (this.mas[id].value.equals(value)) && (this.mas[id].state.equals("full")) ) {
                    flag = true;
                    break;
                }
                if (this.mas[id] == null){
                    break;
                }

            }
            if(flag == true){
                System.out.println("TRUE");
            }
            else {
                System.out.println("FALSE");
            }
            return flag;
        }




        public boolean remove(String value) {
            int randomNum = 5;
            int k = hashStart(value, randomNum);
            int s = hashStep(value);
            int id;
            boolean flag = false;
            int count = 0;

            for (int i = 0; i < capacity; i++) {
                id = (k + i * s) % this.capacity;
                if(this.mas[id] != null){
                    if ((this.mas[id].value.equals(value)) && (this.mas[id].state.equals("full"))) {
                        this.mas[id].state = "deleted";
                        this.countDeleted = this.countDeleted + 1;
                        this.mas[id].value = "";
                        flag = true;
                        count = count + 1;
                        //return flag;
                        break;
                    }
                    else{
                        flag = false;
                    }
                }

                else{
                    flag = false;
                    //return flag;
                    break;
                }
            }
            if(count > 0){
                System.out.println("TRUE");
                flag = true;
            }
            else{
                System.out.println("FALSE");
            }
            return flag;
        }



        public boolean insert(String value){
            int randomNum =  5;
            int k = hashStart(value, randomNum);
            int s = hashStep(value);
            int firstDeleted = -1;
            int i = 0;
            int id = 0;
            boolean flag = false;


            while( i < this.capacity) {
                id = (k + s * i) % this.capacity;
                if(this.mas[id] == null){
                    if(firstDeleted != -1){
                        this.mas[firstDeleted].value = value;
                        this.mas[firstDeleted].state = "full";
                        countDeleted = countDeleted - 1;
                        flag = true;
                        return flag;
                    }
                    else {
                        this.mas[id] = new Buket();
                        this.mas[id].value = value;
                        this.mas[id].state = "full";
                        flag = true;
                        countFull++;
                        return flag;
                    }
                }
                else{
                    if( (this.mas[id].value.equals(value)) && (this.mas[id].state.equals("full"))) {
                        flag = false;
                        return flag;
                    }

                    if ( (this.mas[id].state.equals("deleted")) && firstDeleted == -1){
                        firstDeleted = (k + s * i) % this.capacity;
                    }
                }

                i = i + 1;

            }
            return flag;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        int count = 0;
        HashTable hashTable1 = new HashTable(number, 0);
        while(count < number){
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
            String command = reader.readLine();


            String[] commandParts = command.split(" ");
            String str = commandParts[1];
            switch (commandParts[0]) {
                case "push":
                    hashTable1.insert(str);
                    break;
                case "pop":
                    hashTable1.remove(str);
                    break;
                case "search":
                    hashTable1.search(str);
                    break;
                default:
                    break;
            }
            count++;
        }
    }
}