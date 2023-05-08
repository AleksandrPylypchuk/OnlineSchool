package Main.object;

import Main.Enum.ResurceType;

public class AdditionalMaterial {

        private int id;
        private String name;
        private int lectureId;
        private ResurceType resourceType;

        public AdditionalMaterial(int id, String name, int lectureId, ResurceType resourceType) {
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

        public int getLectureId() {
            return lectureId;
        }



        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setLectureId(int lectureId) {
            this.lectureId = lectureId;
        }

    public void setResourceType(String resourceType) {
        if (resourceType.equals("URL") || resourceType.equals("VIDEO") || resourceType.equals("BOOK")) {
            this.resourceType = ResurceType.valueOf(resourceType);
        } else {
            throw new IllegalArgumentException("Invalid resource type: " + resourceType);
        }
    }


    @Override
    public String toString() {
        return "AdditionalMaterial{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lectureId=" + lectureId +
                ", resourceType='" + resourceType + '\'' +
                '}';
    }
}


