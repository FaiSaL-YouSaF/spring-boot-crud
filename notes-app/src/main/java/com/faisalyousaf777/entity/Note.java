package com.faisalyousaf777.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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

    @NotBlank(message = "Note Title may not be Blank")
    @Column(name = "title", nullable = false)
    private String title;

    @NotBlank(message = "Note Description may not be Blank")
    @Column(name = "description", nullable = false)
    private String description;

//    @NotBlank(message = "Note Created At may not be Blank")
    @Column(name = "created_at", nullable = true, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = true)
    private LocalDateTime updatedAt;

    public Note(String title, String description) {
        this.title = title.trim();
        this.description = description.trim();
    }
}
