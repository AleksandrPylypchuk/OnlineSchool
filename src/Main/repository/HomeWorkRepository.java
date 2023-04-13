package Main.repository;

import Main.object.HomeWork;

public class HomeWorkRepository implements HomeWorkInt {
    private RepositoryService<HomeWork> repository;

    public HomeWorkRepository() {
        repository = new RepositoryService<>();
    }

    @Override
    public HomeWork[] get() {
        HomeWork[] homeWorks = new HomeWork[repository.size()];
        for (int i = 0; i < repository.size(); i++) {
            homeWorks[i] = repository.get(i);
        }
        return homeWorks;
    }

    @Override
    public void add(HomeWork homeWork) {
         repository.add(homeWork);
    }

    @Override
    public void update(HomeWork homeWork) {

    }

    @Override
    public void remove(int index) {
        repository.remove(index);
    }
}
