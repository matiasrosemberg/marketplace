package com.example.selfemployedmarketplace.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
public class Bid {

    private Integer projectId;
    private Double actualBid;
    private Integer devId;
    private LocalDate createdAt;

    public Bid(Integer projectId, Double actualBid, Integer devId) {
        this.projectId = projectId;
        this.actualBid = actualBid;
        this.devId = devId;
        this.createdAt = LocalDate.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bid bid = (Bid) o;
        return Objects.equals(projectId, bid.projectId) && Objects.equals(actualBid, bid.actualBid) && Objects.equals(devId, bid.devId) && Objects.equals(createdAt, bid.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, actualBid, devId, createdAt);
    }
}
