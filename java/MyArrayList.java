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
			for (int i = 0; i < size; i++) {
				vals[i] = temp[i];
			}
		}
		vals[size] = val;
		size++;
		return true;
	}

	public void add(int index, T val) throws ArrayIndexOutOfBoundsException {
		
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException("Index out of bounds!");
		}

		if (this.size == this.cap) {
			Object[] temp = vals;
			this.cap = this.cap * 2;
			vals = new Object[cap];
			for (int i = 0; i < size; i++) {
				vals[i] = temp[i];
			}
		}

		Object[] temp = vals;
		vals = new Object[cap];
		for (int i = 0; i < index; i++) {
			vals[i] = temp[i];
		}
		vals[index] = val;
		for (int i = index; i < size; i++) {
			vals[i+1] = temp[i];
		}
		size++;

	}

	public void clear() {
		cap = 4;
		size = 0;
		vals = new Object[cap];
	}

	public boolean contains(Object o) {
	
		for (int i = 0; i < this.size; i++) {
			if (vals[i].equals(o))
				return true;
		}
		return false;
	}

	public T get(int index) throws ArrayIndexOutOfBoundsException{

		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException("Index out of bounds!");
		}

		@SuppressWarnings("unchecked")
		T val = (T) vals[index];
		return val;

	}

	public int indexOf(Object o) {
		for (int i = 0; i < this.size; i++) {
			if (vals[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}

	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		}
		return false;
	}

	public T remove(int index) throws ArrayIndexOutOfBoundsException {
		
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException("Index out of bounds!");
		}
	
		Object[] temp = vals;
		vals = new Object[cap];
		for(int i = 0, j = 0; i < this.size; i++, j++) {
			if (i == index) {
				i++;
			}
			vals[j] = temp[i];
		}

		size--;
		@SuppressWarnings("unchecked")
		T val = (T)temp[index];
		return val;
	}

	public boolean remove(Object o) {

		int index = this.indexOf(o);

		if (index == -1)
			return false;
	 	
		this.remove(index);
		return true;
		
	}

	public T set(int index, T elem) throws ArrayIndexOutOfBoundsException{

		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException("Index out of bounds!");
		}


		@SuppressWarnings("unchecked")
		T val = (T) vals[index];
		vals[index] = elem;
		return val;
	}
	
	public int size() {
		return this.size;
	}

}
