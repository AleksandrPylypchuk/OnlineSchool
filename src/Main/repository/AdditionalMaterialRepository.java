package Main.repository;

import Main.object.AdditionalMaterial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdditionalMaterialRepository {
    private Map<Integer, AdditionalMaterial> additionalMaterials = new HashMap<>();

    public void add(AdditionalMaterial additionalMaterial) {
        additionalMaterials.put(additionalMaterial.getId(), additionalMaterial);
    }

    public void remove(AdditionalMaterial additionalMaterial) {
        additionalMaterials.remove(additionalMaterial.getId());
    }

    public int getNextID() {
        int maxID = 0;
        for (AdditionalMaterial additionalMaterial : additionalMaterials.values()) {
            if (additionalMaterial.getId() > maxID) {
                maxID = additionalMaterial.getId();
            }
        }
        return maxID + 1;
    }
    public void update(AdditionalMaterial additionalMaterial) {
        additionalMaterials.put(additionalMaterial.getId(), additionalMaterial);
    }

    public AdditionalMaterial getAdditionalMaterialById(int id) {
        return additionalMaterials.get(id);
    }

    public List<AdditionalMaterial> getAllAdditionalMaterials() {
        return new ArrayList<>(additionalMaterials.values());
    }

    public List<AdditionalMaterial> sortById() {
        List<AdditionalMaterial> sortedList = new ArrayList<>(additionalMaterials.values());
        Collections.sort(sortedList, Comparator.comparing(AdditionalMaterial::getId));
        return sortedList;
    }

    public List<AdditionalMaterial> sortByLectureID() {
        List<AdditionalMaterial> sortedList = new ArrayList<>(additionalMaterials.values());
        Collections.sort(sortedList, Comparator.comparing(AdditionalMaterial::getLectureId));
        return sortedList;
    }

    public List<AdditionalMaterial> sortByType() {
        List<AdditionalMaterial> sortedList = new ArrayList<>(additionalMaterials.values());
        Collections.sort(sortedList, Comparator.comparing(AdditionalMaterial::getResourceType));
        return sortedList;
    }
}
