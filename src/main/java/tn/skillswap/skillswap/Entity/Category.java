package tn.skillswap.skillswap.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Setter;

import java.util.List;

public class Category {
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Category;
    private String name_Category;

    @ManyToMany(mappedBy = "categories")
    @JsonIgnore
    private List<Course> courses;
}

