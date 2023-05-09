@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("")
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course", "id", id));
    }
    @GetMapping("/courses/{id}/details")
    public String getCourseDetails(@PathVariable("id") Long courseId, Model model) {

        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Курс не знайдено!"));
        model.addAttribute("course", course);
        return "course-details";
    }

    @GetMapping("/students")
    public String showStudents(Model model) {
        List<Student> students = studentRepository.findAllByOrderByLastNameAsc();
        model.addAttribute("students", students);
        return "students";
    }


}