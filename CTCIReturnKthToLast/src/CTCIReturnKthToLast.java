import java.util.*;

public class CTCIReturnKthToLast {
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
        System.out.println(findKthToLast(inputList,6).val);
    }

    public static ListNode findKthToLast(ListNode originalList,int k) {
        ListNode runner = originalList;
        int listLength = 0;
        while(runner != null){
            listLength++;
            runner = runner.next;
        }
        runner = originalList;
        for(int x=0;x<listLength-k;x++){
            runner = runner.next;
            if(x==listLength-k){
                return runner;
            }
        }
        return runner;
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
