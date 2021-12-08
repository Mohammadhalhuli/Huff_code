package application;



public class TreeNode implements Comparable<TreeNode> {
	int count;
	char ch;
	TreeNode left;
	TreeNode right;

	public TreeNode() {
		ch = 0;
	}

	public TreeNode(int count) {
		this.count = count;
		ch = 0;
		left = null;
		right = null;
	}

	public TreeNode(int count, char ch) {
		this.count = count;
		this.ch = ch;
		left = null;
		right = null;
	}

	public int getCount() {
		return count;
	}

	public char getCh() {
		return ch;
	}

	public TreeNode getLeft() {
		return left;
	}

	public TreeNode getRight() {
		return right;
	}

	@Override
	public int compareTo(TreeNode t) {
		return count - t.count;
	}
	

}

