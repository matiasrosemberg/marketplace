package com.example.selfemployedmarketplace.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class ProjectAndBid {

    private Project project;
    private Bid maxBid;

}
