package todo.todolist.model;

import java.io.Serializable;/*let classes be connected */
import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity /* class is an entity and should be put in a database */
@AllArgsConstructor /* writes constructors for you without getters setters */
@NoArgsConstructor /* writes the constructors without args */
@Data
public class Todo implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private ZonedDateTime startDate;
    private boolean done;
    private boolean favorite;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnore
    private Category category;
}
