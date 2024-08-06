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
import todo.todolist.dto.CategoryDto;
import todo.todolist.dto.TodoDto;

@Api(APP_ROOT + "/categories")
public interface CategoryApi {

        @PostMapping(value = APP_ROOT
                        + "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        @ApiOperation(value = "Create category", notes = "Creates a new category", response = CategoryDto.class)
        @ApiResponses(value = {
                        @ApiResponse(code = 201, message = "The newly created Category.")
        })
        ResponseEntity<CategoryDto> createCategory(
                        @ApiParam(value = "Category DTO", required = true) @RequestBody CategoryDto categoryDto);

        @PatchMapping(value = APP_ROOT
                        + "/categories/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        @ApiOperation(value = "Update Category", notes = "Updates an existing Category", response = CategoryDto.class)
        @ApiResponses(value = {
                        @ApiResponse(code = 200, message = "The updated Category.")
        })
        ResponseEntity<CategoryDto> updateCategory(
                        @ApiParam(value = "Category DTO", required = true) @RequestBody CategoryDto categoryDto);

        @GetMapping(value = APP_ROOT + "/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
        @ApiOperation(value = "Category Details", notes = "Returns the list of all categories", responseContainer = "List<CategoryDto>")
        @ApiResponses(value = {
                        @ApiResponse(code = 200, message = "List of all categories"),
        })
        ResponseEntity<List<CategoryDto>> getAllCategories();

        @GetMapping(value = APP_ROOT + "/categories/todos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        @ApiOperation(value = "Todo Details by Category ID", notes = "Returns the list of Todos for a selected category", responseContainer = "List<TodoDto>")
        @ApiResponses(value = {
                        @ApiResponse(code = 200, message = "List of Todos for the category"),
        })
        ResponseEntity<List<TodoDto>> getAllTodoByCategoriesId(
                        @ApiParam(value = "Category ID", required = true) @PathVariable("id") Long id);

        @GetMapping(value = APP_ROOT + "/categories/todos/today/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
        @ApiOperation(value = "List of Todos for Today by User ID", notes = "Returns the list of Todos for today for a selected user", responseContainer = "List<TodoDto>")
        @ApiResponses(value = {
                        @ApiResponse(code = 200, message = "List of Todos for today"),
        })
        ResponseEntity<List<TodoDto>> getAllTodoByCategoriesForToday(
                        @ApiParam(value = "User ID", required = true) @PathVariable("userId") Long userId);

        @GetMapping(value = APP_ROOT + "/categories/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        @ApiOperation(value = "Categories by User ID", notes = "Returns the list of categories for a selected user", responseContainer = "List<CategoryDto>")
        @ApiResponses(value = {
                        @ApiResponse(code = 200, message = "List of categories for the user"),
        })
        ResponseEntity<List<CategoryDto>> getAllCategoriesByUserId(
                        @ApiParam(value = "User ID", required = true) @PathVariable("id") Long id);

        @GetMapping(value = APP_ROOT + "/categories/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        @ApiOperation(value = "Category Details", notes = "Returns details of a specific category", response = CategoryDto.class)
        @ApiResponses(value = {
                        @ApiResponse(code = 200, message = "The requested Category"),
                        @ApiResponse(code = 404, message = "Category not found")
        })
        ResponseEntity<CategoryDto> getCategory(
                        @ApiParam(value = "Category ID", required = true) @PathVariable("id") Long id);

        @DeleteMapping(value = APP_ROOT + "/categories/delete/{id}")
        @ApiOperation(value = "Delete Category", notes = "Deletes a category by ID")
        @ApiResponses(value = {
                        @ApiResponse(code = 200, message = "Category successfully deleted"),
                        @ApiResponse(code = 404, message = "Category not found")
        })
        ResponseEntity<Void> deleteCategory(
                        @ApiParam(value = "Category ID", required = true) @PathVariable("id") Long id);
}
