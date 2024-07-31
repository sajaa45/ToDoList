package Controllers;

import Controllers.api.CategoryApi;
import dto.CategoryDto;
import dto.TodoDto;
import services.CategoryService;
import services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static utils.Constants.APP_ROOT;

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
    public ResponseEntity<CategoryDto> createCategory(CategoryDto categoryDto) {
        return new ResponseEntity<>(categoryService.save(categoryDto), HttpStatus.CREATED);
    }

    @Override
    @PatchMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(CategoryDto categoryDto) {
        return new ResponseEntity<>(categoryService.save(categoryDto), HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<List<TodoDto>> getAllTodoByCategoriesId(Long id) {
        return new ResponseEntity<>(todoService.findByCategory(id), HttpStatus.OK);
    }

    @Override
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CategoryDto>> getAllCategoriesByUserId(Long id) {
        return new ResponseEntity<>(categoryService.findAllByUserId(id), HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategory(Long id) {
        return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCategory(Long id) {
        categoryService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    @GetMapping("/todos/today/{userId}")
    public ResponseEntity<List<TodoDto>> getAllTodoByCategoriesForToday(Long userId) {
        return new ResponseEntity(categoryService.getAllTodoByCategoriesForToday(userId), HttpStatus.OK);
    }
}
