package com.pbma.ngo.service;

import org.springframework.http.ResponseEntity;

public interface PlacementDetailsService {

	public ResponseEntity<String> savePlacementDetails(final String placementDetails) throws Exception;
	public ResponseEntity<String> getPlacementDetails(final long traineeId) throws Exception;
	public ResponseEntity<String> getAllPlacementDetails() throws Exception;
	public ResponseEntity<String> deleteByPlacementId(Long placementId)throws Exception;
	public ResponseEntity<String> updatePlacementDetails(final long traineeId,final long placementId, final String placementDetails) throws Exception;
	public ResponseEntity<String> getPlacementDetailsByTraineeIdAndPlacementId(final long traineeId,final long placementId) throws Exception;

}
