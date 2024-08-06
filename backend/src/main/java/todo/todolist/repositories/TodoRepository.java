package todo.todolist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import todo.todolist.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findTodoByCategoryId(Long categoryId);
}
