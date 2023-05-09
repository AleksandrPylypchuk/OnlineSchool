package Main.object;

import Main.Enum.ResurceType;
import Main.repository.CourseRepository;

public class AdditionalMaterial {

    private Integer id;
    private String name;
    private Long lectureId;
    private ResurceType resourceType;

    public AdditionalMaterial(Integer id, String name, int lectureId, ResurceType resourceType) {
        this.id = id;
        this.name = name;
        this.lectureId = (long) lectureId;
        this.resourceType = resourceType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLectureId() {
        return lectureId;
    }

    public void setLectureId(Long lectureId) {
        this.lectureId = lectureId;
    }

    public ResurceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        if (resourceType.equals("URL") || resourceType.equals("VIDEO") || resourceType.equals("BOOK")) {
            this.resourceType = ResurceType.valueOf(resourceType);
        } else {
            throw new IllegalArgumentException("Invalid resource type: " + resourceType);
        }
    }

    public void setLectureById(Long lectureId) {
        CourseRepository courseRepository = CourseRepository.getInstance();
        Course lecture = (Course) courseRepository.getByID((int) lectureId.longValue());
        if (lecture == null) {
            throw new IllegalArgumentException("Lecture with id " + lectureId + " does not exist");
        }
        this.lectureId = (long) lecture.getLectureID();
    }

    @Override
    public String toString() {
        return "AdditionalMaterial{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lectureId=" + lectureId +
                ", resourceType=" + resourceType +
                '}';
    }
}
