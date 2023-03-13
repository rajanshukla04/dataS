import java.util.Scanner;

//Stack follow the concept of LIFO;
//last in first out 

public class Stack {
    int stack[] = new int[20];
    int top = -1;

    public void push(int data) {
        top++;
        stack[top] = data;
    }

    // Deleted the element in the pop
    public void pop() {
        if (top == -1) {
            System.out.println("Empty Stack");
        } else {
            System.out.println(stack[top--] + "Deleted from the stack");

        }
    }

    // get the acess of top element
    public void peek() {
        if (top == -1) {
            System.out.println("Empty Stack ");
        } else {
            System.out.println(stack[top] + ">- Top ");

        }
    }

    // isEmpty
    public void isEmpty() {
        if (top == -1) {
            System.out.println("Yes stack is Empty ");
        } else {
            System.out.println("Stack is not Empty ");
        }
    }

    // isfull Stack
    public void isFull() {
        if (top == 20) {
            System.out.println("Stack is full");
        } else {
            System.out.println("Stack is not full");
        }
    }

    // for print the object in stack
    public void show() {
        if (top == -1) {
            System.out.println("Stack is Empty ");
        } else {
            System.out.println("Stack Element : ");
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i] + " ");
            }

        }
    }

    public static void main(String[] args) {
        Stack nums = new Stack();
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (true) {
            System.out.println("1. Push \n2. Pop  \n3. Top \n4. Print Stack \n5. isEmpty \n6.isfull \n7. exit ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter your data");
                    int data = input.nextInt();
                    nums.push(data);
                    break;
                case 2:
                    nums.pop();
                    break;
                case 3:
                    nums.peek();
                    break;
                case 4:
                    nums.show();
                    break;
                case 5:
                    nums.isEmpty();
                    break;
                case 6:
                    nums.isFull();
                    break;
                case 7:
                    System.out.println("Thank you - Developed by Rajan Shukla ");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again !");
            }

        }

    }

}
