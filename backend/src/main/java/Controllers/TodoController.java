package  Controllers;


import Controllers.api.TodoApi;
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
@RequestMapping(APP_ROOT + "/todos")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TodoController implements TodoApi {

    @Autowired
    private TodoService todoService;

    @Autowired
    private CategoryService categoryService;

    @Override
    @PostMapping("/create")
    public ResponseEntity<TodoDto> createTodo(TodoDto userDto) {
        return new ResponseEntity<>(todoService.save(userDto), HttpStatus.CREATED);
    }

    @Override
    @PatchMapping("/update")
    public ResponseEntity<TodoDto> updateTodo(TodoDto todoDto) {
        return new ResponseEntity<>(todoService.save(todoDto), HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<TodoDto>> getAllTodos() {
        return new ResponseEntity<>(todoService.findAll(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/{todoId:.+}")
    public ResponseEntity<TodoDto> getTodo(Long todoId) {
        return  new ResponseEntity<>(todoService.findById(todoId), HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/delete/{id:.+}")
    public ResponseEntity deleteTodo(Long id) {
        return null;
    }
}
