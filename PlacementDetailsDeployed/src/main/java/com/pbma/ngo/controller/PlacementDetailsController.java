package com.pbma.ngo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pbma.ngo.service.PlacementDetailsService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PlacementDetailsController {

	@Autowired
	private PlacementDetailsService placementDetailsService;

	private static final Logger placementDetailsLogger = LoggerFactory.getLogger(PlacementDetailsController.class);

	@PostMapping(value = "/placements", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addPlacementDetails(@RequestBody String placementDetailsRequest) throws Exception {
		placementDetailsLogger.info("Received request to Add Placement Details");
		ResponseEntity<String> responseEntity = placementDetailsService.savePlacementDetails(placementDetailsRequest);
		placementDetailsLogger.info("Completed request to Add Placement Details");
		return responseEntity;
	}

	@GetMapping(value = "/placements/{traineeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> viewPlacementDetails(@PathVariable("traineeId") Long traineeId) throws Exception {
		placementDetailsLogger.info("Received request to View Placement Details");
		ResponseEntity<String> responseEntity = placementDetailsService.getPlacementDetails(traineeId);
		placementDetailsLogger.info("Completed request to View Placement Details");
		return responseEntity;
	}

	@GetMapping(value = "/placements", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> viewAllPacementDetails() throws Exception {
		placementDetailsLogger.info("Received request to View All Placement Details");
		ResponseEntity<String> responseEntity = placementDetailsService.getAllPlacementDetails();
		placementDetailsLogger.info("Completed request to View All Placement Details");
		return responseEntity;
	}

	@DeleteMapping(value="/placements/{placementId}")
	public ResponseEntity<String> deletePlacementDetails(@PathVariable("placementId") Long placementId) throws Exception {
		placementDetailsLogger.info("Received request to Delete  Placement Details");
		ResponseEntity<String> responseEntity = placementDetailsService.deleteByPlacementId(placementId);
		placementDetailsLogger.info("Completed request to delete  Placement Details");
		return responseEntity;
	}
}
