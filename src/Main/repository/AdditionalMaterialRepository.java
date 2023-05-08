package Main.repository;

import Main.object.AdditionalMaterial;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdditionalMaterialRepository {
    private List<AdditionalMaterial> additionalMaterials = new ArrayList<>();

    public void add(AdditionalMaterial additionalMaterial) {
        additionalMaterials.add(additionalMaterial);
    }

    public void remove(AdditionalMaterial additionalMaterial) {
        additionalMaterials.remove(additionalMaterial);
    }

    public void update(AdditionalMaterial additionalMaterial) {
        for (int i = 0; i < additionalMaterials.size(); i++) {
            if (additionalMaterials.get(i).getId() == additionalMaterial.getId()) {
                additionalMaterials.set(i, additionalMaterial);
                break;
            }
        }
    }
    public AdditionalMaterial getAdditionalMaterialById(int id) {
        for (AdditionalMaterial additionalMaterial : additionalMaterials) {
            if (additionalMaterial.getId() == id) {
                return additionalMaterial;
            }
        }
        return null;
    }

    public AdditionalMaterial get(int id) {
        for (AdditionalMaterial additionalMaterial : additionalMaterials) {
            if (additionalMaterial.getId() == id) {
                return additionalMaterial;
            }
        }
        return null;
    }

    public List<AdditionalMaterial> getAllAdditionalMaterials() {
        return additionalMaterials;
    }

    public List<AdditionalMaterial> sortById() {
        List<AdditionalMaterial> sortedList = new ArrayList<>(additionalMaterials);
        Collections.sort(sortedList, Comparator.comparing(AdditionalMaterial::getId));
        return sortedList;
    }


    public List<AdditionalMaterial> sortByLectureID() {
        List<AdditionalMaterial> sortedList = new ArrayList<>(additionalMaterials);
        Collections.sort(sortedList, Comparator.comparing(AdditionalMaterial::getLectureId));
        return sortedList;
    }


    public List<AdditionalMaterial> sortByType() {
        List<AdditionalMaterial> sortedList = new ArrayList<>(additionalMaterials);
        Collections.sort(sortedList, Comparator.comparing(AdditionalMaterial::getResourceType));
        return sortedList;
    }

}
