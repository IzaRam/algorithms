class MyArrayList<T> {
	
	private Object[] vals;
	private int size;
	private int cap;

	public MyArrayList() {
		cap = 4;
		size = 0;
		vals = new Object[cap];
	}

	public boolean add(T val) {
	
		if (this.size == this.cap) {
			Object[] temp = vals;
			this.cap = this.cap * 2;
			vals = new Object[cap];
			for (int i = 0; i < temp.length; i++) {
				vals[i] = temp[i];
			}
		}
		vals[size] = val;
		size++;
		return true;
	}

	public T get(int index) throws ArrayIndexOutOfBoundsException{

		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException("Index out of bounds!");
		}

		@SuppressWarnings("unchecked")
		T val = (T) vals[index];
		return val;

	}
	
	
	public int size() {
		return this.size;
	}

}
