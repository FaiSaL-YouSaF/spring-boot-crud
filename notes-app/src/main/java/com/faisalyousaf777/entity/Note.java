package com.faisalyousaf777.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notes_table")
public class Note {

    @Id
    @GeneratedValue(
            strategy = jakarta.persistence.GenerationType.IDENTITY
    )
    @Column(name = "id", updatable = false)
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    public Note(String title, String description) {
        this.title = title.trim();
        this.description = description.trim();
    }
}
