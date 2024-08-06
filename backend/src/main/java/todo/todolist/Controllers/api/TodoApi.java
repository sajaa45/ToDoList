package todo.todolist.Controllers.api;

import static todo.todolist.utils.Constants.*;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import todo.todolist.dto.TodoDto;

@Api(APP_ROOT + "/todos")
public interface TodoApi {

        @PostMapping(value = APP_ROOT
                        + "/todos/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        @ApiOperation(value = "Create Todo", notes = "Creates a new Todo", response = TodoDto.class)
        @ApiResponses(value = {
                        @ApiResponse(code = 201, message = "The newly created Todo.")
        })
        ResponseEntity<TodoDto> createTodo(
                        @ApiParam(value = "Todo DTO", required = true) @RequestBody TodoDto todoDto);

        @PatchMapping(value = APP_ROOT
                        + "/todos/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        @ApiOperation(value = "Update Todo", notes = "Updates an existing Todo", response = TodoDto.class)
        @ApiResponses(value = {
                        @ApiResponse(code = 200, message = "The updated Todo.")
        })
        ResponseEntity<TodoDto> updateTodo(
                        @ApiParam(value = "Todo DTO", required = true) @RequestBody TodoDto todoDto);

        @GetMapping(value = APP_ROOT + "/todos/all", produces = MediaType.APPLICATION_JSON_VALUE)
        @ApiOperation(value = "Get All Todos", notes = "Returns the list of all Todos", responseContainer = "List<TodoDto>")
        @ApiResponses(value = {
                        @ApiResponse(code = 200, message = "List of Todos")
        })
        ResponseEntity<List<TodoDto>> getAllTodos();

        @GetMapping(value = APP_ROOT + "/todos/{todoId}", produces = MediaType.APPLICATION_JSON_VALUE)
        @ApiOperation(value = "Get Todo by ID", notes = "Returns the Todo for the given ID", response = TodoDto.class)
        @ApiResponses(value = {
                        @ApiResponse(code = 200, message = "The requested Todo"),
                        @ApiResponse(code = 404, message = "Todo not found")
        })
        ResponseEntity<TodoDto> getTodo(
                        @ApiParam(value = "Todo ID", required = true) @PathVariable Long todoId);

        @DeleteMapping(value = APP_ROOT + "/todos/delete/{todoId}")
        @ApiOperation(value = "Delete Todo", notes = "Deletes a Todo by ID")
        @ApiResponses(value = {
                        @ApiResponse(code = 200, message = "The Todo was deleted"),
                        @ApiResponse(code = 404, message = "Todo not found")
        })
        ResponseEntity<Void> deleteTodo(
                        @ApiParam(value = "Todo ID", required = true) @PathVariable Long todoId);
}
