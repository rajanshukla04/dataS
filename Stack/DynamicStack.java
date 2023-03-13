import java.util.Scanner;

//Stack follow the concept of LIFO;
//last in first out 
// When the stack dynaic is avoid the concept of overflow  of stack 
// size of increse in the stack dynamically 
// when we pop stack the size is shrink the stack 

public class DynamicStack {
    int capcity = 2;
    int stack[] = new int[capcity];
    int top = 0;

    public int size() {
        return top;
    }

    public void push(int data) {
        if (size() == capcity) {
            expand();
        }

        stack[top] = data;
        top++;

    }

    private void expand() {
        int length = size();
        int newStack[] = new int[capcity * 2];
        // for(int i=0;i<length;i++){
        // newStack[i]=stack[i];
        // }
        System.arraycopy(stack, 0, newStack, 0, length);
        stack = newStack;
        capcity *= 2;

    }

    // Deleted the element in the pop
    public void pop() {
        if (top == 0) {
            System.out.println("Empty Stack");
        } else {
            top--;
            System.out.println(stack[top] + " Deleted from the stack");
            shrik();
        }
    }

    private void shrik() {
        int length = size();
        if (length <= (capcity / 2) / 2) {
            capcity = capcity / 2;
            int newStack[] = new int[capcity];
            System.arraycopy(newStack, 0, stack, 0, length);
            ;
            stack = newStack;
        }
    }

    // get the acess of top element
    public void peek() {
        if (top == -1) {
            System.out.println("Empty Stack ");
        } else {
            System.out.println(stack[top - 1] + ">- Top ");

        }
    }

    // for print the object in stack
    public void show() {
        if (top == -1) {
            System.out.println("Stack is Empty ");
        } else {
            System.out.println("Stack Element : ");
            for (int i = top - 1; i >= 0; i--) {
                System.out.println(stack[i] + " ");
            }

        }
    }

    public static void main(String[] args) {
        DynamicStack nums = new DynamicStack();
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (choice != 5) {
            System.out.println("1. Push \n2. Pop  \n3. Top \n4. Print Stack \n5. exit ");
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
                    System.out.println("Thank you - Developed by Rajan Shukla ");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again !");
            }

        }

    }

}
