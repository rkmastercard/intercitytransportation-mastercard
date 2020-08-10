package org.mann.connectedcities.controller;

import org.mann.connectedcities.service.InterCitiesTransportationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/connected")
public class InterConnectedCitiesController {

	@Autowired
	private InterCitiesTransportationService cityService;
	
    private final String NOT_MATCH = "no";
    private final String MATCH = "yes";

	private static final Logger LOGGER = LoggerFactory.getLogger(InterConnectedCitiesController.class);

	@GetMapping(path = "/cities")
	public String isConnected(@RequestParam("origin") String originCity,
			@RequestParam("destination") String destinationCity) {
		LOGGER.debug("isConnected is called with origin city = {} and destination city = {}", originCity,
				destinationCity);
		return cityService.areCitiesConnected(originCity, destinationCity) ? MATCH : NOT_MATCH;
	}
}