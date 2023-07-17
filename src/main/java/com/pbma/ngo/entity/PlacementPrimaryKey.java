package com.pbma.ngo.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class PlacementPrimaryKey implements Serializable {
     
    
    private Long placementId;
    private Long traineeId;


    public PlacementPrimaryKey() {
    }


    public PlacementPrimaryKey(Long placementId, Long traineeId) {
        this.placementId = placementId;
        this.traineeId = traineeId;
    }

    
}
