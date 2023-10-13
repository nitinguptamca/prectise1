package consistency.is.the.to.success.ds.sll;

import java.util.Objects;

public class DoublyLinkedList<T extends Comparable<T>>{

    Node<T> head,tail;

    public  void addAtFirst(T data) {
        Node<T> newNode= new Node<>(data);
        if(head==null){
            head=tail= newNode;
        }else {
            Node<T> ptr=head;
            newNode.next=ptr;
            ptr.previous=newNode;
            head=newNode;
        }
    }

    public void printAll() {
        Node<T> node = head;
        while (node!=null){
            System.out.print(node);
            node=node.next;
        }
        System.out.println();
    }

    public void delete1(T data) {
        if(head==null) return;
        Node<T> ptr = head;
        Node<T> prev=null;
        while (ptr!=null){
            Node<T> next =ptr.next;
            if(prev==null && ptr.data.compareTo(data)==0){
                Node<T> second= head.next;
                head=second;
                break;
            }
            if(next.data.compareTo(data)==0) {
                ptr.next= ptr.next.next;
                break;
            }
            prev=ptr;
            ptr=next;
        }
    }

    public void addAtLast(T data) {
        Node<T> newNode= new Node<>(data);
        if(head==null) {
            head=tail=newNode;
        }else {
            Node<T> last =tail;
            last.next=newNode;
            tail=newNode;
        }
    }

    public void addAtPosition(T data, int position) {
        Node<T> current = head;
        Node<T> newNode = new Node<>(data);
        int count=0;
        if(position==0) addAtFirst(data);
        else {
            for (int i = 1; i < position - 1; i++) {
                if (current != null) current = current.next;
            }
            if(current!=null && current.next!=null) {
                Node<T> ptr = current;
                Node<T> ptrNext = current.next;
                ptr.next = newNode;
                newNode.next = ptrNext;
            } else if (current!=null && current.next==null) {
                addAtFirst(data);
            } else{
                throw new IndexOutOfBoundsException("exceed limit");
            }
        }
    }

    public void kThAddFromLast(T data, int k) {
        Node<T> s =head;
        Node<T> p =head;
        Node<T> newNode= new Node<>(data);
        int count=0;
        while (s!=null){
            if(count<k){
                s=s.next;
            }else{
                s=s.next;
                p=p.next;
            }
            count++;
        }
        if(count<k){
            throw new IndexOutOfBoundsException();
        }else {
            Node<T> ptr = p;
            Node<T> ptrNext = p.next;
            p.next = newNode;
            newNode.next = ptrNext;
        }
    }

    public void addAfterThisNode(Node<T> integerNode, T data) {
        Node<T> current =head;
        Node<T> newNode = new Node<>(data);
        Node<T>previous=null;
        while (current!=null){
            Node<T> nextNode= current.next;
            if(current.data.compareTo(integerNode.data)==0){
                current.next=newNode;
                newNode.next=nextNode;
                break;
            }
            previous=current;
            current=nextNode;
        }
    }

    public void deleteAtFirst() {
        Objects.requireNonNull(head);
        Node<T> current = head.next;
        head=current;
    }

    public void deleteLast() {
        Objects.requireNonNull(head);
        Node<T> current =head;
        while(current!=null && current.next!=null&& current.next.next!=null) current=current.next;
        current.next=current.next.next;
    }

    public void deleteMiddle() {
        Objects.requireNonNull(head);
        Node<T> beforeMiddle = getBeforeMiddle(head);
        beforeMiddle.next=beforeMiddle.next.next;
    }

    private Node<T> getBeforeMiddle(Node<T> head) {
        Node<T> slowPointer = head;
        Node<T> fastPointer=head.next.next;
        while (fastPointer!=null){
            fastPointer=fastPointer.next;
            if(fastPointer!=null){
                fastPointer=fastPointer.next;
                slowPointer=slowPointer.next;
            }
        }
        return slowPointer;
    }

    private Node<T> getMiddle(Node<T> head) {
        Node<T> slowPointer = head;
        Node<T> fastPointer=head;
        while (fastPointer!=null){
            fastPointer=fastPointer.next;
            if(fastPointer!=null){
                fastPointer=fastPointer.next;
                slowPointer=slowPointer.next;
            }
        }
        return slowPointer;
    }

    public void removeDuplicate() {
        Objects.requireNonNull(head);
        Node<T> current =head;
        while (current!=null){
            Node<T> ptr =current.next;
            while (ptr!=null &&ptr.next!=null){
             if(current.data.compareTo(ptr.next.data)==0){
                 ptr.next=ptr.next.next;
             } else if(ptr.data.compareTo(ptr.next.data)==0){
                 ptr.next=ptr.next.next;
             }
             ptr=ptr.next;
            }
            current=current.next;
        }
    }

    public void reverseOrder() {
        Objects.requireNonNull(head);
        Node<T> current =head;
        Node<T> previous =null ,nextNode=null;
        while (current!=null){
            nextNode=current.next;
            current.next=previous;
            previous=current;
            current=nextNode;
        }
        head=previous;
    }

    public Node<T> sortedMerge(Node<T> h) {
        Objects.requireNonNull(h);
        if(h==null || h.next==null) return h;
        Node<T> middle =getMiddle(h);
        Node<T> nextToMiddle =middle.next;
        middle.next=null;
        Node<T> left = sortedMerge(h);
        Node<T> right = sortedMerge(nextToMiddle);
        Node<T> sortedList= sortedMerge(left ,right);
        return sortedList;
    }

    private Node<T> sortedMerge(Node<T> left, Node<T> right) {
        Node<T> result =null;
        if(left==null) return right;
        if(right==null) return left;
        if(left.data.compareTo(right.data)>0){
            result=left;
            result.next=sortedMerge(left.next ,right);
        }else {
            result =right;
            result.next=sortedMerge(left ,right.next);
        }
        return result;
    }

    public void delete(T i) {
    }

    static final class Node<T extends Comparable<T>>{
        T data;
        Node<T> next ,previous;
        public Node(T data){
            this.data=data;
        }
        @Override
        public String toString(){
            return " "+data;
        }
    }

}

