package ru.kleimenov.main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }

    public static class BST {
        private Node root;

        public BST() {
        }

        public void find(int elem) {
            Node current = root;
            while (current != null) {
                if (elem == current.key) {
                    System.out.println("TRUE");
                    return;
                }
                if (elem < current.key) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
            System.out.println("FALSE");
        }

        public void find_min() {
            if (root == null) {
                return;
            }
            Node current = root;
            while (current.left != null) {
                current = current.left;
            }
            System.out.println(current.key);
        }

        public void get_max() {
            if (root == null) {
                return;
            }
            Node current = root;
            while (current.right != null) {
                current = current.right;
            }
            System.out.println(current.key);
        }

        public void push(int value) {
            if (root == null) {
                root = new Node(value);
                return;
            }

            Node current = root;
            while (true) {
                if (value < current.key) {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = new Node(value);
                        return;
                    }
                } else {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = new Node(value);
                        return;
                    }
                }
            }
        }

        public void pop(int value) {
            Node parent = null;
            Node current = root;

            while (current != null && current.key != value) {
                parent = current;
                if (value < current.key) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }

            if (current == null) {
                return;
            }

            //current - это удаляемый узел
            if (current.left == null || current.right == null) {
                // ИСПРАВЛЕНО: Заменили тернарный оператор на обычный if-else
                Node newChild;
                if (current.left != null) {
                    newChild = current.left;
                } else {
                    newChild = current.right;
                }

                if (parent == null) {
                    root = newChild;
                } else if (current == parent.left) {
                    parent.left = newChild;
                    //Если удаляемый узел был правым ребенком, родитель теперь указывает на newChild
                } else {
                    parent.right = newChild;
                }
            }
            //У удаляемого узла два потомка. Если узел current имеет и левого, и правого потомка, его нельзя просто удалить. Вместо этого его нужно заменить преемником (successor) —
            // узлом с минимальным ключом в его правом поддереве
            else {
                Node successorParent = current;
                Node successor = current.right;

                //начинаем поиск левого узла в правом поддереве
                // Узел, у которого больше нет левого потомка, и есть преемник
                while (successor.left != null) {
                    successorParent = successor;
                    successor = successor.left;
                }
                //на этом этапе переписываем значение крайнего левого узла из правой ветки в удалямые узел
                current.key = successor.key;

                // successor - преемник
                // successorParent - родитель преемника
                if (successorParent.left == successor) {
                    //все дети, которые находятся справа у удаляемого узла становятся левыми детьми у родителя
                    successorParent.left = successor.right;
                }
                // Случай когда у правого ребенка удаляемого узла вообще нет своих левых детей
                else {
                    successorParent.right = successor.right;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstLine = reader.readLine();
        if (firstLine == null) return;

        int number = Integer.parseInt(firstLine.trim());
        BST bst = new BST();

        String line;
        int count = 0;
        while (count < number) {
            line = reader.readLine();
            String commandLine = line.trim();
            if (commandLine.isEmpty()) {
                continue;
            }

            String[] parts = commandLine.split("\\s+");
            String command = parts[0];

            if (parts.length > 1) {
                int value = Integer.parseInt(parts[1]);
                switch (command) {
                    case "push":
                        bst.push(value);
                        break;
                    case "pop":
                        bst.pop(value);
                        break;
                    case "find":
                        bst.find(value);
                        break;
                }
            } else {
                switch (command) {
                    case "get_min":
                        bst.find_min();
                        break;
                    case "get_max":
                        bst.get_max();
                        break;
                }
            }
            count++;
        }
    }
}
