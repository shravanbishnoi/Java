/*
 * Implementation of Binary Search Tree
 * 
 * Author: Shravan
 * Date: 12-03-2024
*/

public class BST {

    // Node class
    public static class Node{
        int data;
        Node left, right;

        // Constructor
        Node(int data){
            this.data = data;
        }
    }

    public static Node insert(Node root, int data){

        if (root==null){
            root = new Node(data);
        }
        else{
            if (data<=root.data){
                root.left = insert(root.left, data);
            }
            else{
                root.right = insert(root.right, data);
            }
        }
        return root;
    }

    // In-Order Traversal
    public static void inorderTraversal(Node root){
        if (root==null){
            return;
        }
        else{
            inorderTraversal(root.left);
            System.out.println(root.data);
            inorderTraversal(root.right);
        }
    }

    // Post-Order Traversal
    public static void postorderTraversal(Node root){
        if (root==null){
            return;
        }
        else{
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.println(root.data);
        }
    }

    // Pre-Order Traversal
    public static void preorderTraversal(Node root){
        if (root==null){
            return;
        }
        else{
            System.out.println(root.data);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    // Search for an element
    public static boolean searchTree(Node root, int key){
        if (root==null){
            return false;
        }
        else{
            // Recursive search in left subtree
            if (key<root.data){
                return searchTree(root.left, key);
            }
            else if (key==root.data){
                return true;  // found
            }
            // Recursive search in right subtree
            else{
                return searchTree(root.right, key);
            }
        }
    }

    public static Node delete(Node root, int key){
        if (root==null){
            return root;
        }
        else if (key<root.data){
            root.left = delete(root.left, key);
        }
        else if (key>root.data){
            root.right = delete(root.right, key);
        }
        else{
            if (root.right==null && root.left==null){
                return null;
            }
            if (root.left==null){
                return root.right;
            }
            else if (root.right==null){
                return root.left;
            }
            Node inSc = inorderSuccessor(root.right);
            root.data = inSc.data;
            root.right = delete(root.right, inSc.data);
        }
        return root;
    }

    public static Node inorderSuccessor(Node root){
        while (root.left!=null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int arr[] = {20, 15, 38, 7, 7, 92, 69, -3};
        Node root = null;

        for (int n:arr){
            root = insert(root, n);
        }
        System.out.println("Inorder Traversal: ");
        inorderTraversal(root);

        System.out.println("Postorder Traversal: ");
        postorderTraversal(root);

        System.out.println("Preorder Traversal: ");
        preorderTraversal(root);

        System.out.println("Searching: "+ searchTree(root, 7));

        System.out.println("deleting: ");
        delete(root, 69);
    }
}