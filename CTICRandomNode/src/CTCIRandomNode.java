import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class CTCIRandomNode {
    public static void main(String[] args) {
        try{
            CTCIRandomNode obj = new CTCIRandomNode();
            obj.run(args);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void run(String[] args){
        //Creates data(Binary Tree)
        Node topNode = new Node(5);
        BinaryTree binaryTree = new BinaryTree(topNode);
        binaryTree.insert(new Node(2));
        binaryTree.insert(new Node(6));
        binaryTree.insert(new Node(3));
        binaryTree.insert(new Node(17));
        binaryTree.insert(new Node(4));
        binaryTree.insert(new Node(8));
        binaryTree.insert(new Node(11));
        binaryTree.insert(new Node(0));
        //Prints if a node exists
        System.out.println("Node with value 11 exists:" + binaryTree.find(11));
        //Prints out a random node
        System.out.println("First Random Node:" + binaryTree.getRandomNode().num);
        //Deletes two nodes
        System.out.println("First Node Deleted:" + binaryTree.delete());
        System.out.println("Second Node Deleted:" + binaryTree.delete());
        //Prints out another random node
        System.out.println("Second Random Node:" + binaryTree.getRandomNode().num);
        //Prints if a node exists
        System.out.println("Node with value 11 exists:" + binaryTree.find(11));
    }
}
class Node {
    public int num;
    public Node leftNode;
    public Node rightNode;
    public Node(){}
    public Node(int num){
        this.num = num;
    }
    public Node(int num,Node leftNode,Node rightNode){
        this.num = num;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
}
class BinaryTree{
    public ArrayList<Node> holdNodes;
    public Node nodeToAddTo;
    public int indexOfNodeToAddTo;
    public BinaryTree(Node start){
        nodeToAddTo = start;
        holdNodes = new ArrayList<Node>();
        holdNodes.add(start);
        indexOfNodeToAddTo = 0;
    }
    public void insert(Node node){
        holdNodes.add(node);
        if(nodeToAddTo.leftNode == null){
            nodeToAddTo.leftNode = node;
        }else{
            nodeToAddTo.rightNode = node;
            indexOfNodeToAddTo++;
            nodeToAddTo = holdNodes.get(indexOfNodeToAddTo);
        }
    }
    public int delete(){
        int nodeDeleted = holdNodes.remove(holdNodes.size() -1).num;
        if(nodeToAddTo.rightNode != null){
            nodeToAddTo.rightNode = null;
        }else{
            nodeToAddTo.leftNode = null;
            indexOfNodeToAddTo--;
            nodeToAddTo = holdNodes.get(indexOfNodeToAddTo);
        }
        return nodeDeleted;
    }
    public boolean find(int num){
        Queue<Node> nodeQueue = new LinkedList<Node>();
        if(holdNodes.size() < 1){
            return false;
        }
        for(int x=0;x<holdNodes.size();x++){
            if(holdNodes.get(x).num == num){
                return true;
            }
        }
        return false;
    }
    public Node getRandomNode(){
        Random random = new Random();
        int randomIndex = random.nextInt(holdNodes.size());
        return holdNodes.get(randomIndex);
    }
}