package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import util.Pair;

public class BT_VerticalTraversal {
	
	public static void main(String[] args) {
		BaseTree baseTree = new BaseTree();

		Node<Integer> root = baseTree.createTree();
		 List<List<Integer>> list = verticalOrderTraversal(root);
		 System.out.println(list);
	}
	
	public static List<List<Integer>> verticalOrderTraversal(Node<Integer> root) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        
        TreeMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
        Queue<Pair<Integer, Node<Integer>>> queue = new LinkedList<>();
       
        queue.add(new Pair<Integer, Node<Integer>>(0, root));
        
        while(!queue.isEmpty()){
            int size = queue.size();
           
            for(int i = 0; i< size; i++){
            	 Pair<Integer, Node<Integer>> pair  = queue.poll();
                 
                 int level = pair.key;
                 Node<Integer> node = pair.value;
                if(node.left != null){
                    queue.add(new Pair<Integer, Node<Integer>>(level - 1, node.left));
                }
                
                if(node.right != null){
                    queue.add(new Pair<Integer, Node<Integer>>(level + 1, node.right));
                }
                
                List<Integer> tempList = map.get(level);
                if(tempList == null){
                    tempList = new ArrayList<>();           
                }
                tempList.add(node.value);
                map.put(level, tempList);
            }           
        }
                
        for(List<Integer> list : map.values()){
        	result.add(list);
        }
        
        return result;
    }

	public static List<List<Integer>> verticalTraversal(Node<Integer> root) {

		List<List<Integer>> list = new ArrayList<>();
		if (root == null) {
			return list;
		}

		Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
		verticalOrderTraversal(root, 0, map);

		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			list.add(entry.getValue());
		}

		return list;
	}

	private static void verticalOrderTraversal(Node<Integer> node, int level, Map<Integer, List<Integer>> map) {
		if (node == null) {
			return;
		}

		List<Integer> list = map.get(level);
		if (list == null) {
			list = new ArrayList<Integer>();
		}
		list.add(node.value);
		map.put(level, list);

		verticalOrderTraversal(node.left, level - 1, map);
		verticalOrderTraversal(node.right, level + 1, map);
	}

}
