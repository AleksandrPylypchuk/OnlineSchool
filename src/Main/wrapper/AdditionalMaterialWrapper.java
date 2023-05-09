package Main.wrapper;


import Main.Enum.ResurceType;
import Main.object.AdditionalMaterial;
import Main.object.Course;
import Main.repository.CourseRepository;

import java.util.Optional;

public class AdditionalMaterialWrapper {
    private AdditionalMaterial material;

    public AdditionalMaterialWrapper(AdditionalMaterial material) {
        this.material = material;
    }

    public Optional<Integer> getId() {
        return Optional.ofNullable(material).map(AdditionalMaterial::getId);
    }

    public Optional<String> getName() {
        return Optional.ofNullable(material).map(AdditionalMaterial::getName);
    }

    public Optional<Long> getLectureId() {
        return Optional.ofNullable(material).map(AdditionalMaterial::getLectureId);
    }

    public Optional<ResurceType> getResourceType() {
        return Optional.ofNullable(material).map(AdditionalMaterial::getResourceType);
    }

    public void setId(int id) {
        material.setId(id);
    }

    public void setName(String name) {
        material.setName(name);
    }

    public void setLectureId(long lectureId) {
        material.setLectureId(lectureId);
    }

    public void setResourceType(String resourceType) {
        if (material != null) {
            material.setResourceType(resourceType);
        }
    }

    public void setLectureById(long lectureId) {
        CourseRepository courseRepository = CourseRepository.getInstance();
        Course lecture = (Course) courseRepository.getByID((int)lectureId);
        if (lecture == null) {
            throw new IllegalArgumentException("Lecture with id " + lectureId + " does not exist");
        }
        material.setLectureId((long) lecture.getLectureID());
    }

    @Override
    public String toString() {
        return "AdditionalMaterialWrapper{" +
                "material=" + material +
                '}';
    }
}

