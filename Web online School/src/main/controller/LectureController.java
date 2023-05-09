@Controller
public class LectureController {

    @Autowired
    private LectureRepository lectureRepository;

    @GetMapping("/lectures")
    public String getLectures(Model model) {
        List<Lecture> lectures = lectureRepository.findByDateBeforeOrderByDate(LocalDate.of(2023, 1, 1));
        model.addAttribute("lectures", lectures);
        return "lecture-list";
    }
}
