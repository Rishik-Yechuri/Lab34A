import java.util.*;

public class CTCIDeleteMiddleNode {
    public static void main(String[] args) {
        ListNode inputList = new ListNode("a");
        ListNode inputListRunner = inputList;
        ListNode middleNode = null;
        inputListRunner.next = new ListNode("b");
        inputListRunner = inputListRunner.next;
        inputListRunner.next = new ListNode("c");
        inputListRunner = inputListRunner.next;
        inputListRunner.next = new ListNode("d");
        inputListRunner = inputListRunner.next;
        inputListRunner.next = new ListNode("e");
        inputListRunner = inputListRunner.next;
        inputListRunner.next = new ListNode("f");
        inputListRunner = inputListRunner.next;
        inputListRunner.next = new ListNode("g");
        inputListRunner = inputListRunner.next;
        middleNode = inputListRunner;
        inputListRunner.next = new ListNode("h");
        inputListRunner = inputListRunner.next;
        inputListRunner.next = new ListNode("i");
        inputListRunner = inputListRunner.next;
        inputListRunner.next = new ListNode("j");
        inputListRunner = inputListRunner.next;
        inputListRunner.next = new ListNode("k");
        inputListRunner = inputListRunner.next;
        inputListRunner.next = new ListNode("l");
        deleteMiddleNode(middleNode);
        System.out.print("hi");
    }

    public static void deleteMiddleNode(ListNode middleNode) {
        ListNode current = middleNode;
        while(current!= null &&current.next != null){
            current.val = current.next.val;
            if(current.next.next == null){
                current.next = null;
            }
            current = current.next;
        }
    }

}

class ListNode {
    String val;
    ListNode next;

    ListNode() {
    }

    ListNode(String val) {
        this.val = val;
    }

    ListNode(String val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
