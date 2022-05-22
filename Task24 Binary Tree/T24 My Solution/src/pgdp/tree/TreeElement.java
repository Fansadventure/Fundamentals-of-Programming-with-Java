package pgdp.tree;

public class TreeElement {
	private long info;
	private TreeElement left;
	private TreeElement right;

	public TreeElement(long info) {
		this.info = info;
	}

	public void insert(long value) {
	if(value>=info)
		if(right == null)
			right = new TreeElement(value);
		else
			right.insert(value);
	else
		if(left==null)
			left = new TreeElement(value);
		else
			left.insert(value);
	}

	public void toString(StringBuilder sb) {
		if(left!=null)
			left.toString(sb);
		if(sb.length()!=0)
			sb.append(",");
		sb.append(info);
		if(right!=null)
			right.toString(sb);
	}
	// help method:
	public long getMin(){
		return left != null ? left.getMin() : info;
	}
	public TreeElement remove(long value) {
		if(value<info && left!=null)
			left = left.remove(value);
		else if(value>info && right!=null)
			right = right.remove(value);
		else if(value == info){
			if(right == null && left !=null)
				return left;
			else if(right != null && left ==null)
				return right;
			else if (right != null && left !=null) {
				info = right.getMin();
				right = right.remove(info);
			}
			else
				return null;
		}
		return this;
	}

	public int size() {
		return 1 + (left != null ? left.size() : 0) + (right != null ? right.size() : 0);
	}

	public boolean contains(long value) {
		if(value == info)
			return true;
		if(value<info && left!=null)
			return left.contains(value);
		if(value>info && right!=null)
			return right.contains(value);
		return false;
	}
}
