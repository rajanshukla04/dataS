package BinaryST;

import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;

import BinaryTree.priorder;

public class BST1 {
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

    // insert data into the tree 
    public static Node insert(Node root,int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(root.data>val){
            root.left=insert(root.left, val);
        }
        else{
            root.right=insert(root.right, val);
        }
return root;
    }
    // search in bst 
    public static boolean search(Node root,int key){
        if(root==null){
            return false;
        }
        if(root.data>key){
            return search(root.left, key);
        }
        else if(root.data==key){
            return true;
        }
        else{
            return search(root.right, key);
        } 
    }
    // inorder travesal in bst
   public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }


    // Post order travsal in the tree
    public static void Postorder(Node root){
        if(root==null){
            return;
        }
        Postorder(root.left);
        Postorder(root.right);
        System.out.print(root.data+" ");
    }
 // preorder travsal in the tree
 public static void Preorder(Node root){
    if(root==null){
        return;
    }
    System.out.print(root.data+" ");
    Preorder(root.left);
    Preorder(root.right); 
 }
public static void main(String[] args) {
    int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
    Node root=null;
    for(int i=0;i<values.length;i++){
        root=insert(root,values[i]);
    }
    System.out.println("item list is ");
    inorder(root);
    System.out.println("post order ");
    Postorder(root);
    System.out.println("PreOrder tree ");
    Preorder(root);

    System.err.println("search the element- ");
       System.out.println(search(root, 9));

}
}
