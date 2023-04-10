package Main.repository;


public class RepositoryService<E> {
    private int CAPACITY = 10;
    private E[] elementArray;

    int size() {
        return elementArray.length + 1;
    }

    boolean isEmpty() {
        if (elementArray.length == 0) {
            return true;
        }
        return false;
    }

    E get(int index) {
        return elementArray[index];
    }

    void add(E element) {
        for (int i = 0; i < elementArray.length; i++) {
            if (elementArray[i] == null) {
                elementArray[i] = element;
                break;
            } else if (i == elementArray.length - 1) {
                increasingArray();
            }

        }
    }


    void add(int index, E element) {
        elementArray[index] = element;
    }

    void remove(int index) {
        elementArray[index] = null;

    }

    private void increasingArray() {
        int tempCapacity = CAPACITY;
        CAPACITY = (CAPACITY * 3) / 2 + 1;
        E[] tempArrayElement = (E[]) elementArray[CAPACITY];
        System.arraycopy(elementArray, 0, tempArrayElement, 0, tempCapacity);
        elementArray = tempArrayElement;
    }
}
