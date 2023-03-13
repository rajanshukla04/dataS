package  BinaryST;
import java.util.ArrayList;
import java.util.Scanner;
public class BST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // insert the data into as BST
    // value we compare to root
    // if tha value is less than the root then it goes into the left sub tree
    // if value is more than the root then value insert into right sub tree
    // for every value we compare hence the time complexity is big(H) height of tree
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            // left sub tree insert
            root.left = insert(root.left, val);

        } else {
            root.right = insert(root.right, val);

        }
        return root;
    }
    // search in Binary Search Tree {BST}
    // if the key is less than the root then we go to the right place
    // root>key --- Left Sub tree
    // we compare the root with key (as we do in Binary search compare with
    // middle of array) and here we do in same if it is equal we return true
    // warset case we search form root to leaf of tree

    public static boolean SearchBST(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data > key) {
            return SearchBST(root.left, key);

        } else if (root.data == key) {
            return true;
        } else {
            return SearchBST(root.right, key);
        }
    }
    // Delete a Node -- imporata
    /*
     * cases-
     * 1.No Child(leaf Node )
     * --delete the node just return the value null to the root
     * 2. One child
     * -- Delete Node &
     * replace with child node
     * -- link the other node as child node to the root
     * //-- Object delte as Garbage collection there is not need to wirte the
     * code for delted just change the adress assign 
     * 3.Two Children
     * --Replace value with inorder successor
     * -- DElete the node for inorder successor
     * 
     * -- inorder successor always has 0 or 1 child
     * -- in BST inorder successor alway left most in right subtree
     * --f
     * 
     * -- we do this because maintain the properity of BST
     * 
     */

    public static Node delete(Node root, int val) {
        if (root.data > val) {
            root.left = delete(root.left, val);
        } else if (root.data < val) {
            root.right = delete(root.right, val);
        } else {// root.data==val

            // case 1 when root is leaf
            if (root.left == null && root.right == null) {
                return null;
            }
            // case 2 when the root is only one childp

            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            Node Is = inorderSuccesoor(root.right);
            root.data = Is.data;
            root.right = delete(root.right, Is.data);

        }
        return root;
    }


    // this function is used to give the right ka left most root for  help in deleted case 3 
    public static Node inorderSuccesoor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // print in range the 
// if the root data lies in the range then we have search in both left subtree as well as 
// right sub tree 
// Case-1 X<root<Y-- both side left right and equal 
// X>root --- right 
// Y<root -- left 
//

    public static void inrangPrint(Node root, int start, int end ){
       if(root==null){
        return;
       }
        if(root.data>=start && root.data<=end ){
            inrangPrint(root.left, start, end);
            System.out.print(root.data +" ");
            inrangPrint(root.right, start, end);
        }
        else if(root.data>=end){
            inrangPrint(root.left, start, end);

        }
        else{
            inrangPrint(root.right, start, end);
        }   
        
       
    }
     
// Root to Leaf Paths 
// -- number of path we can reach at the leaf 
public static void PrintRootToleafPath(Node root ,ArrayList<Integer> path){
    if(root==null){
        return;
    }
    path.add(root.data);

    if(root.left==null && root.right==null){
        Print(path);
    }
    else{
        PrintRootToleafPath(root.left, path);
        PrintRootToleafPath(root.right,path);
    }
    path.remove(path.size()-1);

}
    private static void Print(ArrayList<Integer> path) {
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println();
}

    // inorder traversal in the binary search tree
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        
        int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        inorder(root);
        System.out.println("print in range");

        inrangPrint(root, 11, 11);
        System.out.println();

        System.out.println("print the path");
        PrintRootToleaf(root,new ArrayList<>());

        
        delete(root, 5);
        inorder(root);



        // if(SearchBST(root,11)){
        // System.out.println("Found");
        // }
        // else{
        // System.out.println("not Found ");
        // }
    }

    private static void PrintRootToleaf(Node root, ArrayList arrayList) {
    }
}
