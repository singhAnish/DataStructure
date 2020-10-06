package binarytree;


public class BT_MaximumSum_Leaf {
	
	public static void main(String[] args) {
		BaseTree baseTree = new BaseTree();
		Node<Integer> root = baseTree.createTree();
		
		System.out.println("Max pathSum  " + maxPathSum(root, root)); 
	}

    private static int maxPathSum(Node<Integer> root, Node<Integer> node)  { 
        Res res = new Res(); 
        res.val = Integer.MIN_VALUE; 
        maxPathSumUtil(root, res); 
        return res.val; 
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
    
    
    static class Res { 
        int val; 
    } 
}
