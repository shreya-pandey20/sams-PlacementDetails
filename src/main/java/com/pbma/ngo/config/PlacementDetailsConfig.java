package com.pbma.ngo.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bazaarvoice.jolt.JsonUtils;

@Configuration
public class PlacementDetailsConfig {

	@Autowired
	private ApplicationYaml applicationYaml;
	
	@Bean
	public List<Object> getPlacementDetailsPostRequestJoltSpec() {
		return JsonUtils.classpathToList(applicationYaml.getJolt().getPlacementDetailsPostRequestJoltSpec());
	}
	
	@Bean
	public List<Object> getPlacementDetailsGetResponseJoltSpec() {
		return JsonUtils.classpathToList(applicationYaml.getJolt().getPlacementDetailsGetResponseJoltSpec());
	}
	
	@Bean
	public List<Object> getPlacementDetailsPostResponseJoltSpec() {
		return JsonUtils.classpathToList(applicationYaml.getJolt().getPlacementDetailsPostResponseJoltSpec());
	}


	@Bean
	public List<Object> getPlacementDetailsPutRequestJoltSpec(){
		return JsonUtils.classpathToList(applicationYaml.getJolt().getPlacementDetailsPutRequestJoltSpec());
	}
 


	
}
