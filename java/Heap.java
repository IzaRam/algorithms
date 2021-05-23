/**
 * Min-Heap Implementation.
 */
class Heap {

	private int cap;
	private int size;
	private int[] nodes;

	public Heap() {
		this.cap = 4;
		this.nodes = new int[cap];
	}

	private int getLeftChildIndex(int index) {
		return (index * 2) + 1;
	}

	private int getRightChildIndex(int index) {
		return (index * 2) + 2;
	}

	private int getParentIndex(int index) {
		return (index - 1) / 2;
	}

	private void increaseCap() {
		this.cap = this.cap * 2;
		int temp[] = this.nodes;
		this.nodes = new int[this.cap];
		for (int i = 0; i < this.size; i++) {
			this.nodes[i] = temp[i];
		}
	}

	/**
	 * Inserts a new element in the heap
	 * @param node 
	 */
	public void push(int node) {
		if (size == cap) this.increaseCap();
		this.nodes[size] = node;
		this.size++;
		this.heapifyUp();
	}

	/**
	 * Returns the minimum element of the heap
	 * @return int
	 */
	public int peek() {
		if (this.isEmpty()) throw new IllegalStateException();
		return this.nodes[0];
	}

	/**
	 * Return and removes the minimum element of the heap
	 * @return int
	 */
	public int pop() {
		if (this.isEmpty()) throw new IllegalStateException();
		int node = this.nodes[0];
		this.size--;
		this.heapifyDown();
		return node;
	}

	private void swap(int p1, int p2) {
		int temp = this.nodes[p1];
		this.nodes[p1] = this.nodes[p2];
		this.nodes[p2] = temp;
	}

	private void heapifyDown() {
		this.swap(0, this.size);
		int index = 0;
		int leftIndex = this.getLeftChildIndex(index);
		while(leftIndex < this.size) {
			if (this.nodes[index] > this.nodes[leftIndex]) {
				this.swap(index, leftIndex);
				index = leftIndex;
				leftIndex = this.getLeftChildIndex(index);
			} else {
				int rightIndex = this.getRightChildIndex(index);
				if (rightIndex < this.size && this.nodes[index] > this.nodes[rightIndex]) {
					this.swap(index, rightIndex);
					index = rightIndex;
				} else {
					break;
				}
			}
		}
	}

	private void heapifyUp() {
		int index = size - 1;
		while (index > 0 && this.nodes[index] < this.nodes[this.getParentIndex(index)]) {
			this.swap(index, this.getParentIndex(index));
			index = this.getParentIndex(index);
		}
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void display() {
		for (int i = 0; i < size; i++) {
			System.out.print(this.nodes[i] + ", ");
		}
	}

}
