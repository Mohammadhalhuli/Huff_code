package application;


public class Heap {

	TreeNode[] elt;
	int size;
	int capacity;

	public Heap() {
		this(1);
	}

	public Heap(int capacity) {
		this.capacity = capacity;
		elt = new TreeNode[capacity];
		size = 0;
	}

	public TreeNode[] getElt() {
		TreeNode[] ret = new TreeNode[size + 1];
		for (int i = 0; i < size + 1; i++)
			ret[i] = elt[i];
		return ret;
	}

	public int getSize() {
		return size;
	}

	public int getCapacity() {
		return capacity;
	}

	public boolean isEmpty() {
		if(size ==0)
			return true;
		else
			return false;
	}

	public void addElt(TreeNode element) {
		int i = ++size;
		while ((i > 1) && elt[i / 2].getCount() > element.getCount()) {
			elt[i] = elt[i / 2];
			i /= 2;
		}
		elt[i] = element;
	}

	public TreeNode deleteElt() {
		int child, i;
		TreeNode last, min = null;
		if (size != 0) {
			min = elt[1];
			last = elt[size--];
			for (i = 1; i * 2 <= size; i = child) {
				child = i * 2;
				if (child < size
						&& elt[child].getCount() > elt[child + 1].getCount())
					child++;
				if (last.getCount() > elt[child].getCount())
					elt[i] = elt[child];
				else
					break;
			}
			elt[i] = last;
		}
		return min;
	}

}