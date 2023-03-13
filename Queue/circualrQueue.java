public class circualrQueue {
    int Queue[] = new int[5];
    static int size = 0;
    static int front = 0;
    static int rear = 0;

    public void enQueue(int data) {

        if (!isFull()) {
            rear = (rear + 1) / 5;
            Queue[rear] = data;
            size = size + 1;
        } else {
            System.out.println("Queue is full ");
        }
    }

    public void deQueue() {
        if (!isEmpty()) {
            System.out.println(Queue[front] + " Deleted item");
            front = (front + 1) / 5;
            size = size - 1;
        } else {
            System.out.println("Queue is empty ");
        }
    }

    // size
    public int getsize() {
        return size;
    }

    // isFull and isEmpty
    public boolean isFull() {
        return getsize() == 5;
    }

    public boolean isEmpty() {
        return getsize() == 0;
    }

    public void show() {
        for (int i = (front + 1) % 5; i <= rear; i++) {
            System.out.print("[" + Queue[i] + "]->");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        queue q = new queue();
        q.enQueue(90);
        q.show();
        q.enQueue(78);
        q.show();
        
     
     

    }
}
