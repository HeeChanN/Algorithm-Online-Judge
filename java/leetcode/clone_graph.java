import java.util.*;

class Solution {

    private HashMap<Node,Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        if(map.containsKey(node)){
            return map.get(node);
        }

        Node newnode = new Node(node.val);
        map.put(node, newnode);

        for(Node next : node.neighbors){
            Node newNextNode = cloneGraph(next);
            newnode.neighbors.add(newNextNode);
        }
        return newnode;
    }
}
