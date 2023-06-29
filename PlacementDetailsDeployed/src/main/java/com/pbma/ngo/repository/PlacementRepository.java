package com.pbma.ngo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;
import com.pbma.ngo.entity.Placement;

public interface PlacementRepository extends JpaRepository<Placement,Long>
{
    
    //public Placement findByTraineeId(@Param("traineeId") final long traineeId);
    public List<Placement> findByTraineeId(@Param("traineeId") final long traineeId);
}
