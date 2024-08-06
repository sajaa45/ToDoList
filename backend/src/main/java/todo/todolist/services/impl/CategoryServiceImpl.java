package todo.todolist.services.impl;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todo.todolist.dto.CategoryDto;
import todo.todolist.exception.EntityNotFoundException;
import todo.todolist.exception.ErrorCodes;
import todo.todolist.exception.InvalidEntityException;
import todo.todolist.repositories.CategoryRepository;
import todo.todolist.services.CategoryService;
import todo.todolist.validators.CategoryValidator;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDto save(CategoryDto category) {
        List<String> errors = CategoryValidator.validateCategory(category);
        if (!errors.isEmpty()) {
            log.error("Category is not valid: {}", category);
            throw new InvalidEntityException("Category is not valid", ErrorCodes.CATEGORY_NOT_VALID, errors);
        }
        return CategoryDto.fromEntity(categoryRepository.save(CategoryDto.toEntity(category)));
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto findById(Long id) {
        if (id == null) {
            log.error("Category id is null");
            throw new IllegalArgumentException("Category id cannot be null");
        }
        return categoryRepository.findById(id)
                .map(CategoryDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No Category found with ID = " + id, ErrorCodes.CATEGORY_NOT_FOUND));
    }

    @Override
    public List<CategoryDto> findAllByUserId(Long userId) {
        if (userId == null) {
            log.error("User id is null");
            throw new IllegalArgumentException("User id cannot be null");
        }
        return categoryRepository.findCategoryByUserId(userId).stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            log.error("Category id is null");
            throw new IllegalArgumentException("Category id cannot be null");
        }
        if (!categoryRepository.existsById(id)) {
            log.error("No Category found with ID = {}", id);
            throw new EntityNotFoundException("No Category found with ID = " + id, ErrorCodes.CATEGORY_NOT_FOUND);
        }
        categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryDto> getAllTodoByCategoriesForToday(Long userId) {
        if (userId == null) {
            log.error("User id is null");
            throw new IllegalArgumentException("User id cannot be null");
        }
        ZonedDateTime startOfDay = ZonedDateTime.now().withHour(0).withMinute(0);
        ZonedDateTime endOfDay = ZonedDateTime.now().withHour(23).withMinute(59);
        return categoryRepository.getAllTodoByCategoriesForToday(startOfDay, endOfDay, userId).stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }
}
