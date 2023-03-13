public class queue {
    int Queue[]=new int[5];
    int size=0;
    int front=0;
    int rear=-1;
public void enQueue(int data){
    rear++;
    Queue[rear]=data;
    size++;

}
public void deQueue(){
System.out.println(Queue[front]+" Deleted item");
front++;


}
public void show(){
    for(int i=front;i<=rear;i++){
        System.out.print("["+Queue[i]+"]->");
    }
    System.out.println();
}
public static void main(String[] args) {
    queue q=new queue();
    q.enQueue(90);
    q.show();
    q.enQueue(78);
    q.show();
    q.enQueue(23);
    q.show();
    q.enQueue(12);
    q.show();
    q.deQueue();
    q.deQueue();
    q.show();

}
public char[] isEmpty() {
    return null;
}

}
