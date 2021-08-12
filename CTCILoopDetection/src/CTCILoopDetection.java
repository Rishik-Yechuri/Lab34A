import java.util.*;

public class CTCILoopDetection {
    public static void main(String[] args) {
        ListNode repeatNode = null;
        ListNode input = new ListNode("a");
        ListNode inputRunner= input;
        inputRunner.next = new ListNode("b");
        inputRunner = inputRunner.next;
        inputRunner.next = new ListNode("c");
        inputRunner = inputRunner.next;
        repeatNode = inputRunner;
        inputRunner.next = new ListNode("d");
        inputRunner = inputRunner.next;
        inputRunner.next = new ListNode("e");
        inputRunner = inputRunner.next;
        inputRunner.next = repeatNode;
        ListNode startOfLoop = returnLoopStart(input);
        if(startOfLoop != null){
            System.out.println(startOfLoop.val);
        }else{
            System.out.println(startOfLoop);
        }
    }

    public static ListNode returnLoopStart(ListNode list) {
        HashSet<ListNode> visitedNodes = new HashSet<>();
        ListNode list1Runner = list;
        while(list1Runner!=null){
            if(visitedNodes.contains(list1Runner))return list1Runner;
            visitedNodes.add(list1Runner);
            list1Runner = list1Runner.next;
        }
        return null;
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
