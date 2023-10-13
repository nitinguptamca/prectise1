package consistency.is.the.to.success.ds.generalTree;

import java.util.ArrayList;
import java.util.List;


public class GeneraliseTree<T extends Comparable<T>> {

    Node<T> root;

    public void add(T data) {
        if (root == null) {
            root = new Node<>(data);
        } else {
            add(data, root);
        }
    }

    public void add(T data, Node<T> node) {
       /* Node<T> newNode = new Node<>(data, null);
        if (node.haveChild) {
            node.neighBour.add(newNode);
        } else {
            newNode.parent = node;
        }*/
    }


    static class Node<T extends Comparable<T>> {
        private final T data;
        private final List<Node<T>> neighBour;
        private boolean haveChild;

        Node(T data) {
            this.data = data;
            neighBour = new ArrayList<>();
            haveChild = false;
        }

        public boolean isHaveChild() {
            return haveChild;
        }

        public void setHaveChild(boolean haveChild) {
            this.haveChild = haveChild;
        }

        public List<Node<T>> getNeighBour() {
            return neighBour;
        }

        public void setNeighBour(Node<T> child) {
            if (this.haveChild) this.neighBour.add(child);
        }

        @Override
        public String toString() {
            return " key " + data + "child [" + neighBour + "]";
        }
    }

}

class TestingGeneralTree {
    public static void main(String[] args) {
        GeneraliseTree<Integer> gt = new GeneraliseTree<>();
        GeneraliseTree.Node<Integer> a = new GeneraliseTree.Node<>(10);
        GeneraliseTree.Node<Integer> b = new GeneraliseTree.Node<>(20);
        GeneraliseTree.Node<Integer> c = new GeneraliseTree.Node<>(30);
        GeneraliseTree.Node<Integer> e = new GeneraliseTree.Node<>(40);
        GeneraliseTree.Node<Integer> f = new GeneraliseTree.Node<>(50);
        GeneraliseTree.Node<Integer> g = new GeneraliseTree.Node<>(60);
        GeneraliseTree.Node<Integer> h = new GeneraliseTree.Node<>(70);
        GeneraliseTree.Node<Integer> a1 = new GeneraliseTree.Node<>(10);
        GeneraliseTree.Node<Integer> b1 = new GeneraliseTree.Node<>(20);
        GeneraliseTree.Node<Integer> c1 = new GeneraliseTree.Node<>(30);
        GeneraliseTree.Node<Integer> e1 = new GeneraliseTree.Node<>(40);
        GeneraliseTree.Node<Integer> f1 = new GeneraliseTree.Node<>(50);
        GeneraliseTree.Node<Integer> g1 = new GeneraliseTree.Node<>(60);
        GeneraliseTree.Node<Integer> h1 = new GeneraliseTree.Node<>(70);

        a.setHaveChild(true);
        a.setNeighBour(b1);
        a.setNeighBour(c1);
        a.setNeighBour(f1);
        b.setHaveChild(true);
        b.setNeighBour(h1);
        b.setNeighBour(g1);

    }


}
