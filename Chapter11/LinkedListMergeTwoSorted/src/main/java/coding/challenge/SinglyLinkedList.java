package coding.challenge;

public final class SinglyLinkedList {

    private final class Node {

        private int data;
        private Node next;

        @Override
        public String toString() {
            return " " + data + " ";
        }
    }

    private Node head;

    public void insertFirst(int data) {

        Node newNode = new Node();

        newNode.data = data;
        newNode.next = head;
        head = newNode;
    }

    public void merge(SinglyLinkedList sll) {

        // these are the two lists
        Node list1 = head;      // this is the merged linked list (the final result)
        Node list2 = sll.head;  // from this list we add nodes at appropriate place in list1

        // if the merged list head bigger then we need to swap the heads
        if (list1.data < list2.data) {
            head = list1;
        } else {
            head = list2;
            list2 = list1;
            list1 = head;
        }

        // compare the nodes from list1 with the nodes from list2
        while (list1.next != null) {
            if (list1.next.data > list2.data) {

                Node auxNode = list1.next;
                list1.next = list2;
                list2 = auxNode;
            }
                        
            list1 = list1.next;
        }

        if (list1.next == null) {
            list1.next = list2;
        }
    }

    public void print() {      
        Node currentNode = head;
        while (currentNode != null) {

            System.out.print(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
    }
}
