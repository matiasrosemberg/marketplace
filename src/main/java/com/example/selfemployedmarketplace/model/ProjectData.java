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
public class ProjectData {

    private String description;
    private Double maxBudget;
    private LocalDate bidEndingTime;

}
