package BinaryTree;


// frist wee have to travel form root 
/*
 1- root
 2- left subtree
 3-right subtree 
 image.png


 
 */
public class priorder {
    static class BulidTree{
        static class Node{
            int data;
            Node left;
            Node right;
            Node(int data){
                this.data=data;
                this.left=null;
                this.right=null;
            }
        }
    }
    public static void preorder(Node root){
    if(root==null){
         // System.out.print(-1+" "); // we can print the -1 as null  then it give same output as input is given
        return;
    }
    System.out.print(root.data+" ");
    preorder(root.left);
    preorder(root.right);
    

}
}
