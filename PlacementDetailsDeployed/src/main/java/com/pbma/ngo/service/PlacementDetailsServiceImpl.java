package com.pbma.ngo.service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pbma.ngo.config.PlacementDetailsConfig;
import com.pbma.ngo.entity.Placement;
import com.pbma.ngo.repository.PlacementRepository;
import com.pbma.ngo.util.Constants;
import com.pbma.ngo.util.PlacementDetailsUtils;

@Service
public class PlacementDetailsServiceImpl implements PlacementDetailsService {

	@Autowired
	private PlacementDetailsConfig placementDetailsConfig;

	@Autowired
	private PlacementRepository placementRepository;

	private static final Logger placementDetailsLogger = LoggerFactory
			.getLogger(PlacementDetailsServiceImpl.class);

	@Override
	public ResponseEntity<String> savePlacementDetails(String placementDetailsRequest) throws Exception {

		// jolt for request json - flatten to map to entity
		String transformedPlacementRequest = PlacementDetailsUtils.transformRequest(placementDetailsRequest,
				placementDetailsConfig.getPlacementDetailsRequestJoltSpec());
		placementDetailsLogger.debug("Save Placement Details transformed request : {}", transformedPlacementRequest);

		ObjectMapper objectMapper = new ObjectMapper();
		Placement requestPlacementObject = objectMapper.readValue(transformedPlacementRequest, Placement.class);
		System.out.println(requestPlacementObject);
		Placement placement = placementRepository.save(requestPlacementObject);
		placementDetailsLogger.info("Placement Details inserted in database successfully");

		// response jolt for placementId
		String placementResponse = new JSONObject(placement).toString(Constants.JSON_OBJECT_INDENTATION_FACTOR);

		String response = new JSONObject(PlacementDetailsUtils.transformRequest(placementResponse,
			placementDetailsConfig.getPlacementDetailsPostResponseJoltSpec()))
				.toString(Constants.JSON_OBJECT_INDENTATION_FACTOR);
				placementDetailsLogger.debug("Save Placement Details transformed response : {}", response);

		return new ResponseEntity<String>(response, HttpStatus.CREATED);

	}

	@Override
	public ResponseEntity<String> getPlacementDetails(long traineeId) throws Exception {

		// Placement placement = placementRepository.findByTraineeId(traineeId);
		// placementDetailsLogger.info("Placement Details retrieved from database successfully");

		// String placementResponse = new JSONObject(placement).toString(Constants.JSON_OBJECT_INDENTATION_FACTOR);

		// String response = new JSONObject(PlacementDetailsUtils.transformRequest(placementResponse,
		// placementDetailsConfig.getPlacementDetailsGetResponseJoltSpec()))
		// 		.toString(Constants.JSON_OBJECT_INDENTATION_FACTOR);
		// 		placementDetailsLogger.debug("Get Placement Details transformed response : {}", response);

		// return new ResponseEntity<String>(response, HttpStatus.OK);

		List<Placement> placements = placementRepository.findByTraineeId(traineeId);
		placementDetailsLogger.info("All Placement Details retrieved from database successfully");

		JSONArray transformedPlacements = new JSONArray();

		placements.forEach(placement -> {

			JSONObject responsePlacement = new JSONObject(PlacementDetailsUtils.transformRequest(
					new JSONObject(placement).toString(Constants.JSON_OBJECT_INDENTATION_FACTOR),
					placementDetailsConfig.getPlacementDetailsGetResponseJoltSpec()));
			transformedPlacements.put(responsePlacement);

		});

		String response = transformedPlacements.toString(Constants.JSON_OBJECT_INDENTATION_FACTOR);
		placementDetailsLogger.debug("Get All Placement Details transformed response : {}", response);

		return new ResponseEntity<String>(response, HttpStatus.OK);

		

	}

	@Override
	public ResponseEntity<String> getAllPlacementDetails() throws Exception {

		List<Placement> placements = placementRepository.findAll();
		placementDetailsLogger.info("All Placement Details retrieved from database successfully");

		JSONArray transformedPlacements = new JSONArray();

		placements.forEach(placement -> {

			JSONObject responsePlacement = new JSONObject(PlacementDetailsUtils.transformRequest(
					new JSONObject(placement).toString(Constants.JSON_OBJECT_INDENTATION_FACTOR),
					placementDetailsConfig.getPlacementDetailsGetResponseJoltSpec()));
			transformedPlacements.put(responsePlacement);

		});

		String response = transformedPlacements.toString(Constants.JSON_OBJECT_INDENTATION_FACTOR);
		placementDetailsLogger.debug("Get All Placement Details transformed response : {}", response);

		return new ResponseEntity<String>(response, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<String> deleteByPlacementId(Long placementId) throws Exception{
		

		placementRepository.deleteById(placementId);
		placementDetailsLogger.info("Placement Details retrieved from database successfully");

			return new ResponseEntity<String>("Deleted", HttpStatus.OK);
		

	
	}

	
}
