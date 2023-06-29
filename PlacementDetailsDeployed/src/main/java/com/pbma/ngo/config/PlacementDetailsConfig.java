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
	public List<Object> getPlacementDetailsRequestJoltSpec() {
		return JsonUtils.classpathToList(applicationYaml.getJolt().getPlacementDetailsRequestJoltSpec());
	}
	
	@Bean
	public List<Object> getPlacementDetailsGetResponseJoltSpec() {
		return JsonUtils.classpathToList(applicationYaml.getJolt().getPlacementDetailsGetResponseJoltSpec());
	}
	
	@Bean
	public List<Object> getPlacementDetailsPostResponseJoltSpec() {
		return JsonUtils.classpathToList(applicationYaml.getJolt().getPlacementDetailsPostResponseJoltSpec());
	}
	
}
