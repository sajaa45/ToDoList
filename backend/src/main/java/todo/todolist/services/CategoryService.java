package todo.todolist.services;

import java.util.List;

import todo.todolist.dto.CategoryDto;

public interface CategoryService {

    CategoryDto save(CategoryDto category);

    List<CategoryDto> findAll();

    CategoryDto findById(Long id);

    List<CategoryDto> getAllTodoByCategoriesForToday(Long userId);

    List<CategoryDto> findAllByUserId(Long userId);

    void delete(Long id);
    
}