public class LinkedList {
    Node head;
    int length = 0;

    // Node class to represent elements in the linked list
    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    // Recursively reverses the linked list
    public Node reverseRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    // Finds the middle node of the linked list
    public Node middle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Checks if the linked list is a palindrome
    public boolean isPalindrome() {
        boolean pal = true;
        if (head == null || head.next == null) {
            return pal;
        }

        Node midNode = middle(head);
        Node revHead = reverseRecursive(midNode);

        Node currFirstHalfNode = head;
        Node currSecHalfNode = revHead;

        while (currSecHalfNode != null) {
            if (!currFirstHalfNode.data.equals(currSecHalfNode.data)) {
                pal = false;
                Node fixingRevHead = reverseRecursive(revHead);
                midNode.next = fixingRevHead.next;
                return pal;
            }
            currFirstHalfNode = currFirstHalfNode.next;
            currSecHalfNode = currSecHalfNode.next;
        }

        Node fixingRevHead = reverseRecursive(revHead);
        midNode.next = fixingRevHead.next;
        return pal;
    }

    // Detects if the linked list has a cycle
    public Node detectCycle() {
        if (head == null || head.next == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }

    // Finds the first node of the cycle in the linked list
    public Node cycleFirstNode() {
        if (head == null || head.next == null) {
            return null;
        }

        Node fastSlowMeet = detectCycle();
        if (fastSlowMeet == null) {
            return null;
        }

        Node currFastSlowForward = fastSlowMeet;
        Node currNode = head;

        while (currFastSlowForward != currNode) {
            currFastSlowForward = currFastSlowForward.next;
            currNode = currNode.next;
        }

        return currNode;
    }

    // Removes the cycle in the linked list
    public void deleteCycle() {
        Node cycleStarts = cycleFirstNode();
        if (cycleStarts == null) {
            return;
        }

        Node currNode = cycleStarts;
        do {
            currNode = currNode.next;
        } while (currNode.next != cycleStarts);

        currNode.next = null;
    }

    // Inserts a new node at a specific index
    public void insertAtInd(String data, int index) {
        if (index == 0) {
            Node temp = head;
            head = new Node(data);
            head.next = temp;
            length++;
            return;
        }

        if (index < 0) {
            return;
        }

        Node currNode = head;
        int i = 0;
        while (i < index - 1) {
            if (currNode != null) {
                currNode = currNode.next;
                i++;
            } else {
                return;
            }
        }

        Node temp = currNode.next;
        currNode.next = new Node(data);
        currNode.next.next = temp;
        length++;
    }

    // Deletes the nth node from the end of the list
    public void deleteNthFromLast(int n) {
        if (head == null || n > length) {
            return;
        }

        if (n == length) {
            head = head.next;
            length--;
            return;
        }

        int i = 1;
        Node currNode = head;
        while (i < length - n) {
            currNode = currNode.next;
            i++;
        }

        if (currNode == null || currNode.next == null) {
            return;
        }

        currNode.next = currNode.next.next;
        length--;
    }

    // Deletes a node at a specific index
    public void deleteAtIndex(int index) {
        if (head == null || index < 0) {
            return;
        }

        if (index == 0) {
            head = head.next;
            length--;
            return;
        }

        Node currNode = head;
        int i = 0;
        while (i < index - 1) {
            if (currNode != null) {
                currNode = currNode.next;
                i++;
            } else {
                return;
            }
        }

        if (currNode == null || currNode.next == null) {
            return;
        }

        currNode.next = currNode.next.next;
        length--;
    }

    // Iteratively reverses the linked list
    public void reverseIterate() {
        if (head == null || head.next == null) {
            return;
        }

        Node currNode = head;
        Node prev = null;

        while (currNode != null) {
            Node temp = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = temp;
        }
        head = prev;
    }

    // Adds a new node at the beginning of the list
    public void addFirst(String tbAdded) {
        Node newNode = new Node(tbAdded);

        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    // Adds a new node at the end of the list
    public void addLast(String tbAdded) {
        Node newNode = new Node(tbAdded);

        if (head == null) {
            head = newNode;
        } else {
            Node currNode = head;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = newNode;
        }
        length++;
    }

    // Deletes the first node of the list
    public void deleteFirst() {
        if (head != null) {
            head = head.next;
            length--;
        }
    }

    // Deletes the last node of the list
    public void deleteLast() {
        if (head == null || head.next == null) {
            head = null;
            length--;
            return;
        }

        Node currNode = head;
        while (currNode.next.next != null) {
            currNode = currNode.next;
        }
        currNode.next = null;
        length--;
    }

    // Prints the linked list
    public void printLL() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node currNode = head;
            System.out.print("Linked List: [ ");

            while (currNode != null) {
                System.out.print(currNode.data);
                currNode = currNode.next;

                if (currNode != null) {
                    System.out.print(", ");
                }
            }
            System.out.println(" ]");
        }
    }

    public static void main(String[] args) {
        // Palindrome Linked List
        LinkedList palindromeList = new LinkedList();
        palindromeList.addLast("M");
        palindromeList.addLast("A");
        palindromeList.addLast("D");
        palindromeList.addLast("A");
        palindromeList.addLast("M");

        System.out.println("Palindrome Linked List - Before checking:");
        palindromeList.printLL();
        System.out.println("Is the first list a palindrome? " + palindromeList.isPalindrome());
        System.out.println("Palindrome Linked List - After checking:");
        palindromeList.printLL();

        // Non-Palindrome Linked List
        LinkedList nonPalindromeList = new LinkedList();
        nonPalindromeList.addLast("H");
        nonPalindromeList.addLast("E");
        nonPalindromeList.addLast("L");
        nonPalindromeList.addLast("L");
        nonPalindromeList.addLast("O");

        System.out.println("\nNon-Palindrome Linked List - Before checking:");
        nonPalindromeList.printLL();
        System.out.println("Is the second list a palindrome? " + nonPalindromeList.isPalindrome());
        System.out.println("Non-Palindrome Linked List - After checking:");
        nonPalindromeList.printLL();
    }
}
