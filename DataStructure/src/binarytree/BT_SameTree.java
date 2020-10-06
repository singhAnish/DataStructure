package binarytree;

public class BT_SameTree {

	public static void main(String[] args) {
		BaseTree baseTree = new BaseTree();

		Node<Integer> p = baseTree.createTree();
		Node<Integer> q = baseTree.createTree();

		System.out.print("Both tree are same" + isSameTree(p, q));
	}

	private static boolean isSameTree(Node<Integer> p, Node<Integer> q) {
		if (p == null && q == null) {
			return true;
		} else if (p == null || q == null) {
			return false;
		} else if (p.value != q.value) {
			return false;
		} else {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
	}

}
