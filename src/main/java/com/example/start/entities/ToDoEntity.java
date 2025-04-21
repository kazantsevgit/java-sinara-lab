package com.example.start.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "todo_lists")
public class ToDoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "list", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<EventEntity> events = new HashSet<>();

    public ToDoEntity(String name, Set<EventEntity> events) {
        this.name = name;
        this.events = events;
    }
}
