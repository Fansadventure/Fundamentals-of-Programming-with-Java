package pgdp.tree;

public class Tree {
	private TreeElement root;

	public void insert(long value) {
		if(root == null)
			root = new TreeElement(value);
		else
			root.insert(value);
	}

	public String toString() {
		StringBuilder sb= new StringBuilder();
		if(root !=null)
			root.toString(sb);
		return sb.toString();
	}

	public void remove(long value) {
		if(contains(value))
			root = root.remove(value);
	}

	public int size() {
		return root == null ? 0 : root.size();
	}

	public boolean contains(long value) {
		return root != null && root.contains(value);
	}
}
