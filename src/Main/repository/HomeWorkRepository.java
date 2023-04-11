package Main.repository;

import Main.object.HomeWork;

public class HomeWorkRepository {
    private RepositoryService<HomeWork> repository;

    public HomeWorkRepository() {
        repository = new RepositoryService<>();
    }

    public void addHomeWork(HomeWork homeWork) {
        repository.add(homeWork);
    }

    public HomeWork[] getHomeWorkArrays() {
        HomeWork[] homeWorks = new HomeWork[repository.size()];
        for (int i = 0; i < repository.size(); i++) {
            homeWorks[i] = repository.get(i);
        }
        return homeWorks;
    }
}
