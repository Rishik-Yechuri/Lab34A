import java.util.*;

public class RemoveDups {
    public static void main(String[] args) {
        ListNode inputList = new ListNode("e");
        ListNode inputListRunner = inputList;
        inputListRunner.next = new ListNode("c");
        inputListRunner = inputListRunner.next;
        inputListRunner.next = new ListNode("b");
        inputListRunner = inputListRunner.next;
        inputListRunner.next = new ListNode("b");
        inputListRunner = inputListRunner.next;
        inputListRunner.next = new ListNode("r");
        inputListRunner = inputListRunner.next;
        inputListRunner.next = new ListNode("e");
        inputListRunner = inputListRunner.next;
        inputListRunner.next = new ListNode("q");
        inputListRunner = inputListRunner.next;
        inputListRunner.next = new ListNode("b");
        inputListRunner = inputListRunner.next;
        inputListRunner.next = new ListNode("c");
        inputListRunner = inputListRunner.next;
        inputListRunner.next = new ListNode("a");
        inputListRunner = inputListRunner.next;
        inputListRunner.next = new ListNode("b");
        inputListRunner = inputListRunner.next;
        inputListRunner.next = new ListNode("d");
        removeDuplicates(inputList);
        }

    public static ListNode removeDuplicates(ListNode originalList) {
        HashSet<String> holdVisitedLetter = new HashSet<>();
        ListNode runner = originalList;
        holdVisitedLetter.add(runner.val);
        while (runner.next != null) {
            while (holdVisitedLetter.contains(runner.next.val)) {
                runner.next = runner.next.next;
            }
            holdVisitedLetter.add(runner.next.val);
            runner = runner.next;
        }
        runner = originalList;
        while(runner != null){
            System.out.print(runner.val + " ");
            runner = runner.next;
        }
        return originalList;
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
