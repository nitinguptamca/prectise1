package consistency.is.the.to.success.ds.sll;

class TestingDLL {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.addAtFirst(10);
        dll.addAtFirst(20);
        dll.addAtFirst(30);
        dll.addAtFirst(40);
        dll.addAtFirst(50);
        dll.addAtFirst(60);
        dll.addAtFirst(170);
       // dll.printAll();
      //  dll.delete1(10);
     ///   dll.printAll();
     ///   dll.delete1(170);
     //   dll.printAll();

        dll.addAtFirst(108);
        dll.addAtLast(109);
        dll.addAtLast(10);
        dll.addAtLast(20);
        dll.addAtLast(100);
      //  dll.printAll();

        dll.addAtLast(30);
        dll.addAtLast(40);
        dll.addAtLast(50);
        dll.addAtLast(60);
        dll.addAtLast(170);
        dll.addAtLast(108);
        dll.addAtLast(109);
       // dll.printAll();
        ///  dll.addAtPosition(100,1);
       //   dll.printAll();
        // dll.addAtPosition(90,9);
       // dll.printAll();
       // dll.kThAddFromLast(77,7);
       // dll.printAll();
       //   dll.kThAddFromLast(77,77);

        // dll.addAfterThisNode(new SingleLinkedList.Node<>(40) , 200);
        //dll.printAll();
       // dll.addAfterThisNode(new SingleLinkedList.Node<>(1000) , 200);
       // dll.printAll();
      //   dll.deleteAtFirst();
     /*   dll.printAll();
          dll.deleteLast();
        dll.printAll();
         dll.deleteMiddle();
         dll.printAll();
        dll.deleteMiddle();
        dll.printAll();
          dll.deleteAtFirst();
         dll.deleteLast();
        dll.deleteMiddle();*/
        ///dll.printAll();
        ///dll.removeDuplicate();
        //dll.printAll();
        ///dll.removeDuplicate();
        dll.printAll();
      //  dll.removeDuplicate();
      //   dll.reverseOrder();
        ///  dll.sortedMerge(dll.head);
         dll.printAll();
         dll.deleteAtFirst();
        dll.delete(170);
        dll.printAll();
        dll.delete(109);
        dll.printAll();
        dll.delete(10);
        dll.printAll();
        dll.delete(30);
        dll.printAll();
    }
}
