package model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

import java.io.Serializable;/*let classes be connected */
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity/*class is an entity and should be put in a database */
@AllArgsConstructor/*writes constructors for you without getters setters */
@NoArgsConstructor/*writes the constructors without args */
@Data/*uses many annotations in once such as @Getters and @Setters */
public class User implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    /*user has a one to many rp with categories */
    /*mappedBy: user owns the rp */
    private List<Todo> category;
}

