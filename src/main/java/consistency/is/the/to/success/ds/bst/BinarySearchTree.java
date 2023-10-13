package consistency.is.the.to.success.ds.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree<T extends Comparable<T>> {

    Node<T> root;

    public void add(T data) {
        if (root == null) {
            root = new Node<>(data, null);
        } else {
            add(data, root);
        }
    }

    private void add(T data, Node<T> node) {
        if (node.data.compareTo(data) > 0) {
            if (node.leftChild == null) {
                node.leftChild = new Node<>(data, node);
            } else {
                add(data, node.leftChild);
            }
        } else {
            if (node.rightChild == null) {
                node.rightChild = new Node<>(data, node);
            } else {
                add(data, node.rightChild);
            }
        }
    }

    public void inOrderTraversal() {
        System.out.println();
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node<T> node) {
        if (node.leftChild != null) inOrderTraversal(node.leftChild);
        System.out.print(node);
        if (node.rightChild != null) inOrderTraversal(node.rightChild);
    }

    //left-right-root
    public void postOrderTraversal() {
        System.out.println();
        postOrderTraversal(root);
    }

    private void postOrderTraversal(Node<T> node) {
        if (node.leftChild != null) postOrderTraversal(node.leftChild);
        if (node.rightChild != null) postOrderTraversal(node.rightChild);
        System.out.print(node);
    }

    //root-left-right
    public void preOrderTraversal() {
        System.out.println();
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node<T> node) {
        System.out.print(node);
        if (node.leftChild != null) preOrderTraversal(node.leftChild);
        if (node.rightChild != null) preOrderTraversal(node.rightChild);
    }

    public void inOrderTraversalIterative(Node<T> node) {
        Stack<Node<T>> stack = new Stack<>();
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.leftChild;
            } else {
                Node<T> ptr = stack.pop();
                System.out.print(ptr);
                node = ptr.rightChild;
            }
        }
    }

    //Root-Left-Right
    public void preOrderTraversalIterative(Node<T> node) {
        Stack<Node<T>> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node<T> ptr = stack.pop();
            System.out.print(ptr);
            if (ptr.rightChild != null) stack.push(ptr.rightChild);
            if (ptr.leftChild != null) stack.push(ptr.leftChild);
        }
    }

    //Left-right-root
    public void postOrderTraversalIterative(Node<T> node) {
        Stack<Node<T>> stack = new Stack<>();
        Stack<Node<T>> out = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node<T> ptr = stack.pop();
            out.push(ptr);
            if (ptr.leftChild != null) stack.push(ptr.leftChild);
            if (ptr.rightChild != null) stack.push(ptr.rightChild);
        }
        while (!out.isEmpty()) System.out.print(out.pop());
    }

    public int getHeight(Node<T> node) {
        if (node == null) return -1;
        return 1 + Math.max(getHeight(node.leftChild), getHeight(node.rightChild));
    }

    public int getHeightIterative(Node<T> node) {
        if (node == null) return -1;
        Node<T> ptr = node;
        int left = 1 + getHeightIterative(node.leftChild);
        int right = 1 + getHeightIterative(node.rightChild);
        return Math.max(left, right);
    }

    int countLeft = 0;

    public Node<T> kSmallestNode(int k, Node<T> node) {
        if (node == null) return null;
        Node<T> left = kSmallestNode(k, node.leftChild);
        if (left != null) return left;
        countLeft++;
        if (k == countLeft) return node;
        return kSmallestNode(k, node.rightChild);
    }

    public Node<T> kthSmallestNodePr23(Node<T> node ,int k){
        if(node==null) return null;
        int count =0;
        Node<T> current = node;
        while(current!=null){
            if(current.leftChild==null){
                count++;
                if(count==k) return current;
                current=current.rightChild;
            }else{
                Node<T> left = current.leftChild;
                while (left.rightChild!=null | left.rightChild!=current) left=left.rightChild;
                if(left.rightChild==null){
                    left.rightChild=current;
                    current=current.leftChild;
                }else {
                    left.rightChild=null;
                    count++;
                    if(count==k) return current;
                    current=current.rightChild;
                }
            }
        }
        return current;
    }

    public int countNode(Node<T> node) {
        if(node==null) return 0;
        return 1+countNode(node.leftChild)+countNode(node.rightChild);

    }

    public int countNodeIterative(Node<T> node) {
        if(node==null) return 0;
        Stack<Node<T>> stack = new Stack<>();
        int count=0;
        stack.push(node);
        while (!stack.isEmpty()){
            Node<T> ptr=stack.pop();
            count++;
            if(ptr.leftChild!=null) stack.push(ptr.leftChild);
            if(ptr.rightChild!=null) stack.push(ptr.rightChild);
        }
       return count;
    }

    public void printLeafNode(Node<T> node) {
        if(node.leftChild==null && node.rightChild==null)
            System.out.print(node);
        if(node.leftChild!=null)printLeafNode(node.leftChild);
        if(node.rightChild!=null) printLeafNode(node.rightChild);
    }

    public boolean searchData(T data, Node<T> node) {
        if(node==null) return false;
        if(node.data.compareTo(data)>0){
           return searchData(data, node.leftChild);
        }else if(node.data.compareTo(data)<0){
          return   searchData(data,node.rightChild);
        } else if (node.data.compareTo(data)==0) {
            System.out.println(" data found" +node.data);
            return true;
        }else {
            return false;
        }
    }

    public Node<T> min(Node<T> node) {
        if(node==null) return null;
        return node.leftChild==null? node:min(node.leftChild);
    }

    public Node<T> max(Node<T> node) {
        if(node==null) return null;
        return node.rightChild==null? node: max(node.rightChild);
    }

    static final class Node<T extends Comparable<T>> {
        T data;
        Node<T> leftChild, rightChild, parentNode;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> parentNode) {
            this.data = data;
            this.parentNode = parentNode;
        }

        @Override
        public String toString() {
            return " " + data;
        }

    }
}


class TestingBST {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(25);
        bst.add(30);
        bst.add(35);
        bst.add(20);
        bst.add(15);
        bst.add(10);
        bst.add(33);
        bst.add(34);
        bst.add(27);
        bst.add(13);
        bst.add(16);
        bst.add(19);
        bst.add(26);
        bst.add(1);
        bst.add(17);
        bst.add(39);
       // bst.inOrderTraversal();
      //  bst.inOrderTraversalIterative(bst.root);
      //  bst.preOrderTraversal();
      ///  System.out.println("\n ********");
      ///  bst.preOrderTraversalIterative(bst.root);
        //System.out.println("\n ********");
        //bst.postOrderTraversal();
        //System.out.println("\n ********");
        //bst.postOrderTraversalIterative(bst.root);
        //System.out.println("\n height"+ bst.getHeight(bst.root));
        //System.out.println("\n height "+bst.getHeightIterative(bst.root));
        //System.out.println("k smallest element ::" + bst.kSmallestNode(4 ,bst.root));
      //  System.out.println("k smallest element ::" + bst.kthSmallestNodePr23(bst.root ,4 ));
      //  System.out.println("\n countNode  "+ bst.countNode(bst.root));
      //  System.out.println("\n countNode  "+ bst.countNodeIterative(bst.root));
       // bst.printLeafNode(bst.root);
       // System.out.println(bst.searchData(13 ,bst.root));
      //  System.out.println("\n  min element "+ bst.min(bst.root));
        System.out.println("\n  max element "+ bst.max(bst.root));
    }




}