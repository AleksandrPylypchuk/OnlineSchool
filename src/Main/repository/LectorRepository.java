package Main.repository;

import Main.object.Lector;

public class LectorRepository {
    private RepositoryService<Lector> lectorRepositoryService;
    private void addLectors(Lector lectors){
        lectorRepositoryService.add(lectors);
    }
    private int CAPACITY = 1;
    private Lector[] lectorArrays = new Lector[CAPACITY];



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
