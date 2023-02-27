package Main.Repository;

import Main.Lector;

public class LectorRepository {
    private int CAPACITY = 1;
    private Lector[] lectorArrays = new Lector[CAPACITY];

    public void addLectors(Lector lectors) {

        for (int i = 0; i < lectorArrays.length; i++) {
            if (lectorArrays[i] == null) {
                lectorArrays[i] = lectors;
                break;
            } else if (i == lectorArrays.length-1) {
                increasingArray();
            }

        }

    }

    private void increasingArray() {
        int tempCapacity = CAPACITY;
        CAPACITY = (CAPACITY * 3) / 2 + 1;
        Lector[] tempArrayLector = new Lector[CAPACITY];
        System.arraycopy(lectorArrays, 0, tempArrayLector, 0, tempCapacity);
        lectorArrays = tempArrayLector;

    }


    public Lector[] getLectorArrays() {
        return lectorArrays;
    }

}
