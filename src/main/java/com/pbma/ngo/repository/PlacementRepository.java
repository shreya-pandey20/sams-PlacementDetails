package com.pbma.ngo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.pbma.ngo.entity.Placement;

@Repository
public interface PlacementRepository extends JpaRepository<Placement,Long>
{
    
    //public Placement findByTraineeId(@Param("traineeId") final long traineeId);
    public List<Placement> findByTraineeId(@Param("traineeId") final long traineeId);

    public Placement findByTraineeIdAndPlacementId(@Param("traineeId")long traineeId,@Param("placementId") long placementId);

    public List<Placement> findAllByTraineeIdOrderByPlacementIdDesc(@Param("traineeId") final long traineeId);
    
}