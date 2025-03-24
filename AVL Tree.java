class Node {  
    int val, height;  
    Node left, right;  

    Node(int val) {  
        this.val = val;  
        this.left = null;  
        this.right = null;  
        this.height = 1;  
    }  
}  

class AVL {  
    Node root;  

    int get_height(Node node) {  
        return node == null ? 0 : node.height;  
    }  

    int getBalance(Node node) {  
        return node == null ? 0 : get_height(node.left) - get_height(node.right);  
    }  

    Node right(Node y) {  
        Node x = y.left;  
        y.left = x.right;  
        x.right = y;  
        y.height = Math.max(get_height(y.left), get_height(y.right)) + 1; 
        x.height = Math.max(get_height(x.left), get_height(x.right)) + 1;  
        return x;  
    }  

    Node left(Node y) {  
        Node x = y.right;  
        y.right = x.left; 
        x.left = y;  
        y.height = Math.max(get_height(y.left), get_height(y.right)) + 1;
        x.height = Math.max(get_height(x.left), get_height(x.right)) + 1;
        return x;  
    }  

    Node leftRight(Node y) {  
        y.left = left(y.left);  
        return right(y);  
    }  

    Node rightLeft(Node y) {  
        y.right = right(y.right);  
        return left(y);  
    }  

    Node insert(Node node, int val) {  
        if (node == null) {  
            return new Node(val);  
        }  
        if (val < node.val) {  
            node.left = insert(node.left, val);  
        } else if (val > node.val) {  
            node.right = insert(node.right, val);  
        } else {  
            return node;   
        }  

        node.height = Math.max(get_height(node.left), get_height(node.right)) + 1;  

        int balance = getBalance(node);  

        if (balance > 1 && val < node.left.val) {  
            return right(node);  
        }  
        
        if (balance < -1 && val > node.right.val) {  
            return left(node);  
        } 
        if (balance > 1 && val > node.left.val) {  
            return leftRight(node);  
        }  
        if (balance < -1 && val < node.right.val) {  
            return rightLeft(node);  
        }  

        return node;  
    } 

    void inorder(Node node) {  
        if (node != null) {  
            inorder(node.left);  
            System.out.print(node.val + " ");  
            inorder(node.right);  
        }  
    }  

    void preorder(Node node) {  
        if (node != null) {  
            System.out.print(node.val + " ");  
            preorder(node.left);  
            preorder(node.right);  
        }  
    }  

    void postorder(Node node) {  
        if (node != null) {  
            postorder(node.left);  
            postorder(node.right);  
            System.out.print(node.val + " ");  
        }  
    }  
}  

public class Main {  
    public static void main(String[] args) {  
        AVL t = new AVL();  
        int[] arr = {10, 12, 7, 80, 90, 35, 66, 77, 88};  
        for (int i : arr) {  
            t.root = t.insert(t.root, i);  
        }  
        System.out.print("Inorder: ");  
        t.inorder(t.root);  
        System.out.println();  

        System.out.print("Preorder: ");  
        t.preorder(t.root);  
        System.out.println();  

        System.out.print("Postorder: ");  
        t.postorder(t.root);  
        System.out.println();  
    }  
}