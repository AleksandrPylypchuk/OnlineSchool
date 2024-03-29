package Main.repository;


public class RepositoryService<E> {

    private int size;
    private int id;
    private E[] array;

    public E[] getArray() {
        return array;
    }

    public void setArray(E[] array) {
        this.array = array;
    }

    public RepositoryService() {
        size = 0;
        array = (E[]) new Object[10];
        id=0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int index) {
        return array[index];
    }

    public void add(E element) {

        if (size == array.length) {
            resizeArray(array.length * 2);
        }
        array[size] = element;
        size++;
    }



    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
        if (size > 0 && size == array.length / 4) {
            resizeArray(array.length / 2);
        }
    }

    private void resizeArray(int newSize) {
        E[] newArray = (E[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
}


