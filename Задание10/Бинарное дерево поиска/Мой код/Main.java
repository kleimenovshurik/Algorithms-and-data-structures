package ru.kleimenov.main;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key){
            this.key = key;
        }
    }


    public static class BST{
        private Node root;


        public BST(){
        }

        public BST(Node node){
            root = node;
        }

        public boolean find(int elem){
            boolean flag = false;
            flag = findRoot(root, elem);

            if(flag == true){
                System.out.println("TRUE");
            }
            else{
                System.out.println("FALSE");
            }
            return flag;
        }


        public boolean findRoot(Node node, int elem){

            boolean flag = false;
            if (node == null){
                return flag;
            }
            if (node.key == elem){
                flag = true;
                return flag;
            }
            if((node.key < elem) && (node.right != null)){
                node = node.right;
                if(node.key != elem){
                    return findRoot(node, elem);
                }
                else{
                    flag = true;
                    return flag;
                }
            }
            if((node.key < elem) && (node.right == null )){
                flag = false;
                return flag;
            }


            if((node.key > elem) && (node.left != null)){
                node = node.left;
                if(node.key != elem){
                    return findRoot(node, elem);
                }
                else{
                    flag = true;
                    return flag;
                }
            }

            if((node.key > elem) && (node.left == null)){
                flag = false;
                return flag;
            }

            return flag;
        }

        //поиск крайнего левого элемента
        public Node find_min(){
            Node minNode = root;

            if(minNode == null){
                return null;
            }

            while(minNode.left != null){
                minNode = minNode.left;
            }
            System.out.println(minNode.key);
            return minNode;
        }

        public Node find_min2(Node node){
            Node minNode = node;

            if(minNode == null){
                return null;
            }

            while(minNode.left != null){
                minNode = minNode.left;
            }
            //System.out.println(minNode.key);

            return minNode;
        }

        //поиск крайнего правого элемента
        public Node get_max(){
            Node maxNode = root;

            if(maxNode == null){
                return null;
            }

            while (maxNode.right != null) {
                maxNode = maxNode.right;
            }
            System.out.println(maxNode.key);
            return maxNode;
        }

        //добавить элемент
        public void push(int value){
            pushElem(root, value);
        }




        public Node pushElem(Node node, int value){
            if(node == null && this.root == null){
                Node nodeAdd = new Node(value);
                //BST newBst = new BST(nodeAdd);
                this.root = nodeAdd;
                return nodeAdd;
            }

            if(node == null && this.root != null){
                Node nodeAdd = new Node(value);
                //BST newBst = new BST(nodeAdd);
                return nodeAdd;
            }

            if(node.key == value){
                return node;
            }
            if (node.key < value && node.right != null ){
                node.right = pushElem(node.right, value);
            }

            if (node.key < value && node.right == null) {
                node.right = new Node(value);
            }

            if(node.key > value && node.left!= null){
                node.left = pushElem(node.left, value);
            }

            if(node.key > value && node.left == null){
                node.left = new Node(value);
            }
            return node;
        }

        /*public Node pushElem2(int value){

            if(this.root == null){
                Node node = new Node(value);
                this.root = node;
                return node;
            }
            Node current = this.root;

            if( current.key == value){
                return current;
            }
            while (current.left != null || current.right != null){
                if(current.key < value && current.right !=null ) {
                        current = current.right;
                }
                if (current.key > value && current.left != null){
                        current = current.left;
                }

                if(current.key > value && current.left == null){
                    Node nodeAdded = new Node(value);
                    current.left = nodeAdded;
                    return current;
                }

                if(current.key < value && current.right == null){
                    Node nodeAdded = new Node(value);
                    current.right = nodeAdded;
                    return current;
                }


            }

            while (current.left == null || current.right == null){
                if (current.right == null && current.key < value){
                    Node nodeAdded = new Node(value);
                    current.right = nodeAdded;
                    return current;
                }

                if (current.left == null && current.key > value){
                    Node nodeAdded = new Node(value);
                    current.left = nodeAdded;
                    return current;
                }
            }
            return current;
        }*/

        /*public Node pushElem2(Node node,int value){
            if(this.root == null){
                Node addNode =  new Node(value);
                this.root = addNode;
                return addNode;
            }

            if (node.key == value){
                return node;
            }

            Node current = this.root;

            while (current.left != null && current.right == null){
                if(current.key < value){
                    current.right = new Node(value);
                }
                if (current.key > value){
                    current = current.left;
                }
            }

            while (current.left == null && current.right != null){
                if(current.key < value){
                    current = current.right;
                }
                if (current.key > value){
                    current.left = new Node(value);
                }
            }


            while (current.left == null && current.right == null){
                if (current.key < value){
                    current.right = new Node(value);
                    break;
                }
                if (current.key > value){
                    current.left = new Node(value);
                    break;
                }
            }

            while (current.left != null && current.right != null){
                if(current.key < value){
                    current = current.right;
                }
                if (current.key > value){
                    current = current.left;
                }
                if (current.key < value && current.right == null){
                    Node nodeAdd = new Node(value);
                    current.right = nodeAdd;
                    return nodeAdd;
                }
                if(current.key > value && current.left == null){
                    Node nodeAdd = new Node(value);
                    current.left = nodeAdd;
                    return nodeAdd;
                }
            }
            return node;
        }*/

        public Node pushElem2(Node node, int value) {
            // Если дерево вообще пустое, создаем корень
            if (this.root == null) {
                this.root = new Node(value);
                return this.root;
            }

            Node current = this.root;

            // Всего один бесконечный цикл для спуска по дереву
            while (true) {
                // Если такой элемент уже есть в дереве, ничего не добавляем
                if (value == current.key) {
                    return current;
                }

                // Если новое число меньше текущего, нам нужно идти НАЛЕВО
                if (value < current.key) {
                    if (current.left != null) {
                        current = current.left; // Место занято, спускаемся глубже
                    } else {
                        current.left = new Node(value); // Свободно! Создаем узел
                        return current.left; // Выходим из метода
                    }
                }
                // Если новое число больше текущего, нам нужно идти НАПРАВО
                else {
                    if (current.right != null) {
                        current = current.right; // Место занято, спускаемся глубже
                    } else {
                        current.right = new Node(value); // Свободно! Создаем узел
                        return current.right; // Выходим из метода
                    }
                }
            }
        }

        /*public void pushElem3(int value){
            Node current = this.root;
            if(current.key == value){
                return;
            }
            while (true){
                if(current.key < value && current.right !=null ) {
                    current = current.right;
                }
                if (current.key > value && current.left != null){
                    current = current.left;
                }

                if(current.key > value && current.left == null){
                    Node nodeAdded = new Node(value);
                    current.left = nodeAdded;
                    return;
                }

                if(current.key < value && current.right == null){
                    Node nodeAdded = new Node(value);
                    current.right = nodeAdded;
                    return;
                }
                if (current.right == null && current.key < value){
                    Node nodeAdded = new Node(value);
                    current.right = nodeAdded;
                    return;
                }

                if (current.left == null && current.key > value){
                    Node nodeAdded = new Node(value);
                    current.left = nodeAdded;
                    return;
                }
            }
        }*/

        public void pop(int value){
            this.root = popElem(root, value);
        }

        public Node popElem(Node node, int value){
            if (node == null){
                return null;
            }

            if (node.key < value){
                node.right = popElem(node.right, value);
            }

            if (node.key > value){
                node.left = popElem(node.left, value);
            }

            if (node.key == value){
                if ((node.left == null) && (node.right == null)){
                    return null;
                }

                if((node.left != null)&&(node.right == null)){
                    return node.left;
                }
                if((node.left == null)&&(node.right != null)){
                    return node.right;
                }
                if((node.left != null)&&(node.right != null)){
                    Node current = node;
                    current.key = this.find_min2(current.right).key;
                    // Добавляем удаление скопированного ключа из правого поддерева
                    current.right = popElem(current.right, current.key);
                }
            }
            return node;
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        int count = 0;
        BST bst = new BST();
        while(count < number){
            boolean flag = false;
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
            String command = reader.readLine();
            char[] CharrArray = command.toCharArray();
            for (int i = 0; i < CharrArray.length; i++){
                if(CharrArray[i] == ' '){
                    flag = true;
                    break;
                }
            }
            if(flag == true){
                String[] commandParts = command.split(" ");
                String str = commandParts[1];
                switch (commandParts[0]){
                    case "push":
                        bst.push(Integer.parseInt(str));
                        break;
                    case "pop":
                        bst.pop(Integer.parseInt(str));
                        break;
                    case "find":
                        bst.find(Integer.parseInt(str));
                        break;
                }
            }
            if (flag == false)
                 {
                    switch (command){
                        case "get_min":
                            bst.find_min();
                            break;
                        case  "get_max":
                            bst.get_max();
                            break;
                        default:
                            break;
                    }
                }
            count++;
        }
            System.out.println();
    }
}