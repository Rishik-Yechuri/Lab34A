import java.util.ArrayList;
import java.util.HashMap;

public class CTCIPathsWithSum {
    public static void main(String[] args) {
        try{
            CTCIPathsWithSum obj = new CTCIPathsWithSum();
            obj.run(args);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void run(String[] args){
        //Creating data(Binary Tree)
        Node node = new Node(5);
        node.leftNode = new Node(2);
        node.rightNode = new Node(6);
        node.leftNode.leftNode = new Node(3);
        node.leftNode.rightNode = new Node(17);
        node.rightNode.leftNode = new Node(4);
        node.rightNode.rightNode = new Node(8);
        node.leftNode.leftNode.leftNode = new Node(11);
        node.leftNode.rightNode.rightNode = new Node(0);
        node.rightNode.leftNode.leftNode = new Node(5);
        node.rightNode.leftNode.rightNode = new Node(2);
        node.rightNode.rightNode.leftNode = new Node(8);
        node.rightNode.rightNode.rightNode = new Node(9);
        //Prints out number of paths that result in the specified sum
        System.out.println(findNumOfPaths(10,node));
    }
    public int findNumOfPaths(int target,Node topNode){
        int numOfPathsFound = 0;
        Object[] holdLayers = returnLayers(topNode,new Object[]{new ArrayList<ArrayList<Node>>(),new HashMap<Node,Node>()},null,1);
        for(int x = 0; x<((ArrayList<ArrayList<Node>>)holdLayers[0]).size(); x++){

            for(int y=0;y<((ArrayList<ArrayList<Node>>)holdLayers[0]).get(x).size();y++){
                boolean hasParent = true;
                int currentSum = 0;
                Node currNode = ((ArrayList<ArrayList<Node>>)holdLayers[0]).get(x).get(y);
                while(hasParent){
                    Node parentNode = ((HashMap<Node,Node>)holdLayers[1]).get(currNode);
                    currentSum+=currNode.num;
                    if(parentNode==null){
                        hasParent = false;
                    }else{
                        currNode = parentNode;
                    }
                    if(currentSum == target){
                        numOfPathsFound++;
                    }
                    //currentSum+=((ArrayList<ArrayList<Node>>)holdLayers[0]).get(x).get(y)
                }
            }
        }
        return numOfPathsFound;
    }
    public Object[]/*ArrayList<ArrayList<Integer>>*/ returnLayers(Node currNode,Object[] holdObjects/*ArrayList<ArrayList<Integer>> holdLayers,HashMap<Node,Node> holdParents*/,Node parent,int currentLayer){
        if(currentLayer > ((ArrayList<ArrayList<Node>>)holdObjects[0]).size()){
            ((ArrayList<ArrayList<Node>>)holdObjects[0]).add(new ArrayList<Node>());
        }
        ((HashMap<Node,Node>)holdObjects[1]).put(currNode,parent);
        ((ArrayList<ArrayList<Node>>)holdObjects[0]).get(currentLayer-1).add(currNode);
        if(currNode.leftNode != null){
            holdObjects[0] = returnLayers(currNode.leftNode,holdObjects,currNode,currentLayer+1)[0];
        }
        if(currNode.rightNode != null){
            holdObjects[0] = returnLayers(currNode.rightNode,holdObjects,currNode,currentLayer+1)[0];
        }

        return holdObjects;
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