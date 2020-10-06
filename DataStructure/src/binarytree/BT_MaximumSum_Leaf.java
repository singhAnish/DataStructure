package binarytree;

import java.util.Scanner;

public class BT_MaximumSum_Leaf {
	
	private static int maxSum = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BaseTree baseTree = new BaseTree(scanner);
		Node<Integer> root = baseTree.createTree();
		
		System.out.println("Max pathSum  " + maxPathSum(root, root)); 
	}

	
	
	private static int maxPathSumUtil(Node<Integer> node, Res res) { 
		  
        if (node == null) 
            return 0; 
        if (node.left == null && node.right == null) 
            return node.value; 
  
        int ls = maxPathSumUtil(node.left, res); 
        int rs = maxPathSumUtil(node.right, res); 
  
        if (node.left != null && node.right != null) { 
  
            res.val = Math.max(res.val, ls + rs + node.value); 
            return Math.max(ls, rs) + node.value; 
        } 
  
        return (node.left == null) ? rs + node.value  : ls + node.value; 
    } 
  
    private static int maxPathSum(Node<Integer> root, Node<Integer> node)  { 
        Res res = new Res(); 
        res.val = Integer.MIN_VALUE; 
        maxPathSumUtil(root, res); 
        return res.val; 
    } 
    
    
    static class Res { 
        int val; 
    } 
	

}
