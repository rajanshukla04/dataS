package BinaryTree;

import java.util.LinkedList;
import java.util.PropertyResourceBundle;
import java.util.Queue;

// this class we used to crate the node of each tree 

public class BinaryTreeeYT {
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

    // this is another class used to create the tree
    static class BinaryTree {
        static int idx = -1;   // 

        public static Node BulidTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newnode = new Node(nodes[idx]);
            newnode.left = BulidTree(nodes);
            newnode.right = BulidTree(nodes);
            return newnode;
        }

    }

    // preorder Travesal in tree
    /*
     * first we have to start form the root then travel the left subtree of root the
     * after that right subTree
     */
    /*
     * Root
     * LeftSubtree
     * Right Subtree
     * 
     */
    public static void preorder(Node root) {
        if (root == null) {
            // System.out.print(-1+" "); // we can print the -1 as null then it give same
            // output as input is given
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);

    }

    // Inorder Traversal
    /*
     * 1-Left Subtree
     * 2-Root
     * 3- Right subtree
     * 
     */
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // PostOrder Traversal
    /*
     * 1-left Subtree
     * 2-right subtree
     * 3- root
     */
    public static void PostOrder(Node root) {
        if (root == null) {
            return;
        }
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.print(root.data + " ");
    }


    // Level Order Traversal 
    /*
     * 1
     * 2 3
     * 4 5 6
     */
    // we use queue to this type of traversal 
    // FIFO poprtie  of queue is -- 1 2 3 4 5 6 
    // we null as next line output 
    
    // BFS - Breath First Search - Level order 
    // DFS- Depath First Search -- pre, in ,post order 

    public static void levelOrder(Node root){
        if(root==null){
         return;
        }
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currNode=q.remove();
            if(currNode==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(currNode.data+" ");
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
        }


    }


    //Counter of nodes 

/*
 * this work as he count the  left sub count and right subtree count and with the increment 
 */
    public static int CountOFNodes(Node root){
        if(root==null){
            return 0;
        }
        int leftCount=CountOFNodes(root.left);
        int rightCount=CountOFNodes(root.right);

        return leftCount+rightCount+1;

    }

//  Sum of nodes 
/*Frist we add leftsub tree and then right subtree and add the root value to the subtree 
 // 
 */
public static int SumOfNodes(Node root){
    if(root==null){
        return 0;
    }
    int leftsum=SumOfNodes(root.left);
    int rightsum=SumOfNodes(root.right);
    return leftsum+rightsum+root.data;

}


// Height of  tree 
/*
 root
  |
  |   // distan betweeen root and depeast leaf(leaf which is last leaf or below that leaf )  is kown as height of tree 
  |
Depeast leaf 
  */

  public static int  HeightOfNode(Node root){
    if(root==null){
        return 0;
    }
    int leftHeight=HeightOfNode(root.left);
    int rightHeight=HeightOfNode(root.right);
    return Math.max(leftHeight,rightHeight)+1;

  }


  //Dimeter of a tree 
  /*
Number of nodes in the longest path 
betweeen any two node  
   

Case1- when we are going throug the root one node to another node 
Case2- when not passing through the root  one node to another node 
----- in case2 there  is chance that only left or only right side the longest path 
   */

   // solving the apporach 
/* for finding the dimeter we first calculate the left tree dimeter 
    then we calculate the right sub tree dimeter 
    for the dimeter passing throgh the root we have to  take the sum of leftdimeter+ rightdimeter+1

 * 
 */

 // write the code which has time complexity square of n 
 public static int DiameterOfTree(Node root){
    if(root==null){
        return 0;
    }
    int DiamLeft=DiameterOfTree(root.left);
    int DiamRight=DiameterOfTree(root.right);
    int DiamRoot=HeightOfNode(root.left)+HeightOfNode(root.right)+1;

    return Math.max(DiamRoot,Math.max(DiamRight, DiamLeft));

 }

 // when we have to return the two thigns in the function we hvae to crate the class we can not return the 
 // two things in one function 

 static class treeInfo{
    int hit;
    int diam;
    treeInfo(int hit,int diam){    // this is constract where we crate the object 
        this.hit=hit;
        this.diam=diam;   
    }
 }
 public static treeInfo Diameter2(Node root){
    
    if(root==null){
        return  new treeInfo(0, 0);
    }
treeInfo left=Diameter2(root.left);
treeInfo right=Diameter2(root.right);

int myheight=Math.max(left.hit,right.hit)+1;

int diamleft=left.diam;
int diamRight=right.diam;
int diamRoot=left.hit+right.hit+1;

int mydima=Math.max(diamRight,Math.max(diamleft,diamRoot));


treeInfo MyInfo=new treeInfo(myheight,mydima);
return MyInfo;

 }

// Subtee of another Tree 


    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.BulidTree(nodes);
        
        System.out.println(root.data);
        System.out.println("Priorder travesal tree ");
        preorder(root);
        System.out.println();

        System.out.println("Inorderr Travesa ");
        inOrder(root);
        System.out.println();

        System.out.println("Post Order tree");
        PostOrder(root);
        System.out.println();

        System.out.println("Level Order Travesal ");
        levelOrder(root);


        System.out.println("Count the nodes in the tree ");
        System.out.println(CountOFNodes(root));

        System.out.println("The sum of nodes is ");
        System.out.println(SumOfNodes(root));

        System.out.println("Height of subtree");
        System.out.println(HeightOfNode(root));

        System.out.println("left root height is "+HeightOfNode(root.left));


        System.out.println("Diameter of a tree");
        System.out.println(DiameterOfTree(root));
        

        System.out.println("Diametere using time complexity of n ");
        System.out.println(Diameter2(root).diam);  // this we  give the dimeter inforatio 
        System.out.println("Height of tree " +Diameter2(root).hit);  // this will return the height of tree 
        


    }
}
