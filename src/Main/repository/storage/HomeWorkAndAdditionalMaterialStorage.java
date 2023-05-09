package Main.repository.storage;

import Main.object.HomeWork;
import Main.object.AdditionalMaterial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeWorkAndAdditionalMaterialStorage {

    private Map<Integer, List<HomeWork>> homeworkMap = new HashMap<>();
    private Map<Integer, List<AdditionalMaterial>> additionalMaterialMap = new HashMap<>();

    public void addHomework(HomeWork homework) {
        int lectureId = (int) homework.getLectureID();

        List<HomeWork> homeworkList = homeworkMap.getOrDefault(lectureId, new ArrayList<>());

        homeworkList.add(homework);

        homeworkMap.put(lectureId, homeworkList);
    }

    public void addAdditionalMaterial(AdditionalMaterial additionalMaterial) {
        int lectureId = (int) additionalMaterial.getLectureId();

        List<AdditionalMaterial> additionalMaterialList = additionalMaterialMap.getOrDefault(lectureId, new ArrayList<>());

        additionalMaterialList.add(additionalMaterial);

        additionalMaterialMap.put(lectureId, additionalMaterialList);
    }

    public List<HomeWork> getHomeworkList() {
        List<HomeWork> homeWorks = new ArrayList<>();
        for (List<HomeWork> hwList : homeworkMap.values()) {
            homeWorks.addAll(hwList);
        }
        return homeWorks;
    }

    public List<HomeWork> getHomeworkList(int lectureId) {
        return homeworkMap.getOrDefault(lectureId, new ArrayList<>());
    }

    public List<AdditionalMaterial> getAdditionalMaterialList(int lectureId) {
        return additionalMaterialMap.getOrDefault(lectureId, new ArrayList<>());
    }
}
