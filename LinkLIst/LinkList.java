import java.util.Scanner;

public class LinkList {
    public class Node{
        int data;
        Node next;
    }
    Node head;

    // insert method is used to insert the element in the last

    public void insertAtEnd(int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    // insert the element at the start
    public void insertAtStart(int data) {
        Node n = new Node();
        n.data = data;
        n.next = null;
        if (head == null) {
            head = n;
        } else {
            n.next = head;
            head = n;
        }
    }
    // insert element at in between using the index number

    public void insertAtPostion(int index, int data) {
        // frist we have to creat the node
        Node node = new Node();
        node.data = data; // assigen the data to the inside the node
        node.next = null;
        if (index == 0) {
            insertAtStart(data);
        }
        // take the head node for go to the postion weher we have to insert
        else {
            Node h = head;
            for (int i = 0; i < index - 1; i++) {
                h = h.next;
            }
            node.next = h.next;
            h.next = node;
        }
    }

    // deleted the object at any postio in the list
    public void deletAt(int index) {
        if (index == 0) {
            Node n1 = head;
            head = head.next;
            System.out.println("Deleted item is " + n1.data);
        } else {
            Node n = head;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            Node n1 = n.next; // taking the delete node into n1 to get the address of next node
            n.next = n1.next;
            System.out.println("Deleted item is " + n1.data);

        }
    }

    public void show() {
        if (head == null) {
            System.out.println("Empty list");
        } else {
            Node pri = head;
            while (true) {
                System.out.print("[" + pri.data + "]->");
                if (pri.next == null) {
                    break;
                }
                pri = pri.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LinkList list = new LinkList();
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (choice != 6) {
            System.out.println(
                    "Please choose an option:\n1. Insert at Start \n2. Insert at Last \n3. Insert at any postion \n4. Deleted the element at postion \n5. Print the list \n6. Exit ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter data ");
                    int data = input.nextInt();
                    list.insertAtStart(data);
                    break;
                case 2:
                    System.out.println("Enter data ");
                    data = input.nextInt();
                    list.insertAtEnd(data);
                    break;
                case 3:
                    System.out.println("Enter index no");
                    int index = input.nextInt();
                    System.out.println("Enter data ");
                    data = input.nextInt();
                    list.insertAtPostion(index, data);
                    break;
                case 4:
                    System.out.println("Enter index no for deleting the object ");
                    index = input.nextInt();
                    list.deletAt(index);
                    break;

                case 5:
                    list.show();
                    break;
                case 6:
                    System.out.println("Thanks , Build By Rajan Shukla ");
                default:
                    System.out.println("Invalid choice Please try again ");

            }
        }

    }

}
