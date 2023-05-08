package Main.object;

import Main.Enum.ResurceType;
import Main.repository.CourseRepository;


public class AdditionalMaterial {

    private int id;
    private String name;
    private long lectureId;
    private ResurceType resourceType;

    public AdditionalMaterial(int id, String name, long lectureId, ResurceType resourceType) {
        this.id = id;
        this.name = name;
        this.lectureId = lectureId;
        this.resourceType = resourceType;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getLectureId() {
        return lectureId;
    }

    public ResurceType getResourceType() {
        return resourceType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLectureId(long lectureId) {
        this.lectureId = lectureId;
    }

    public void setResourceType(String resourceType) {
        if (resourceType.equals("URL") || resourceType.equals("VIDEO") || resourceType.equals("BOOK")) {
            this.resourceType = ResurceType.valueOf(resourceType);
        } else {
            throw new IllegalArgumentException("Invalid resource type: " + resourceType);
        }
    }

    public void setLectureById(long lectureId) {
        CourseRepository courseRepository = CourseRepository.getInstance();
        Course lecture = (Course) courseRepository.getByID((int)lectureId);
        if (lecture == null) {
            throw new IllegalArgumentException("Lecture with id " + lectureId + " does not exist");
        }
        this.lectureId = lecture.getLectureID();
    }


    @Override
    public String toString() {
        return "AdditionalMaterial " +
                "id=" + id +
                ", name='" + name +
                ", lectureId=" + lectureId +
                ", resourceType='" + resourceType;
    }
}
