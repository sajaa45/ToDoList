@RestController
@RequestMapping(APP_ROOT + "/categories")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CategoryController implements CategoryApi {

    @Autowired
    private TodoService todoService;

    @Autowired
    private CategoryService categoryService;

    @Override
    @PostMapping("/create")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        return new ResponseEntity<>(categoryService.save(categoryDto), HttpStatus.CREATED);
    }

    @Override
    @PatchMapping("/update")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto) {
        return new ResponseEntity<>(categoryService.save(categoryDto), HttpStatus.OK);
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/todos/{id}")
    public ResponseEntity<List<TodoDto>> getAllTodoByCategoriesId(@PathVariable Long id) {
        return new ResponseEntity<>(todoService.findByCategory(id), HttpStatus.OK);
    }

    @Override
    @GetMapping("/todos/today/{userId}")
    public ResponseEntity<List<TodoDto>> getAllTodoByCategoriesForToday(@PathVariable Long userId) {
        return new ResponseEntity<>(categoryService.getAllTodoByCategoriesForToday(userId), HttpStatus.OK);
    }

    @Override
    @GetMapping("/users/{id}")
    public ResponseEntity<List<CategoryDto>> getAllCategoriesByUserId(@PathVariable Long id) {
        return new ResponseEntity<>(categoryService.findAllByUserId(id), HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Long id) {
        return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
