package com.example.selfemployedmarketplace.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Project {

    private Integer id;
    private LocalDate createdAt;
    private ProjectData projectData;

    public Project(Integer newId, LocalDate newLocalDate, ProjectData newProjectData) {
        this.id = newId;
        this.createdAt = newLocalDate;
        this.projectData = newProjectData;
    }
}
