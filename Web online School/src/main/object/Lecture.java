@Entity
@Table(name = "lectures")
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate date;
    private int additionalMaterialsCount;

    // constructors, getters and setters
}

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {
    List<Lecture> findByDateBeforeOrderByDate(LocalDate date);
}

@Controller
public class LectureController {
    @Autowired
    private LectureRepository lectureRepository;

    @GetMapping("/lectures")
    public String getAllLectures(Model model) {
        List<Lecture> lectures = lectureRepository.findByDateBeforeOrderByDate(LocalDate.of(2023, 1, 1));

        model.addAttribute("lectures", lectures);
        return "lectures";
    }
}
