package Main.repository;

import Main.object.HomeWork;
import Main.repository.storage.HomeWorkAndAdditionalMaterialStorage;

import java.util.List;

public class HomeWorkRepository implements HomeWorkInt {

    private HomeWorkAndAdditionalMaterialStorage storage;

    public HomeWorkRepository() {
        this.storage = new HomeWorkAndAdditionalMaterialStorage();
    }

    @Override
    public HomeWork[] get() {
        List<HomeWork> homeWorks = storage.getHomeworkList();
        return homeWorks.toArray(new HomeWork[0]);
    }


    @Override
    public void add(HomeWork homeWork) {
        storage.addHomework(homeWork);
    }

    @Override
    public void update(HomeWork homeWork) {
        List<HomeWork> homeWorks = storage.getHomeworkList((int) homeWork.getLectureID());
        for (int i = 0; i < homeWorks.size(); i++) {
            HomeWork hw = homeWorks.get(i);
            if (hw.getId() == homeWork.getId()) {
                homeWorks.set(i, homeWork);
                break;
            }
        }
    }

    @Override
    public void remove(int id) {
        List<HomeWork> homeWorks = storage.getHomeworkList();
        for (int i = 0; i < homeWorks.size(); i++) {
            HomeWork hw = homeWorks.get(i);
            if (hw.getId() == id) {
                homeWorks.remove(i);
                break;
            }
        }
    }
}
