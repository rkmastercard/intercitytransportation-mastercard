package org.mann.connectedcities.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mann.connectedcities.service.InterCitiesTransportationService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class InterConnectedCitiesControllerTests {

	@Mock
	private InterCitiesTransportationService cityService;

	@InjectMocks
	private InterConnectedCitiesController controller;

	@Test
	public void testCheckCitiesAreConnected() {
		Mockito.when(cityService.areCitiesConnected(Mockito.anyString(), Mockito.anyString())).thenReturn(true);

		String isConnected = controller.isConnected("Chicago", "New York");
		Assert.assertEquals("yes", isConnected);
	}

	@Test
	public void testCitiesNotConnected(){
		Mockito.when(cityService.areCitiesConnected(Mockito.anyString(), Mockito.anyString())).thenReturn(false);

		String isConnected = controller.isConnected("Chicago", "New York");
		Assert.assertEquals("no", isConnected);
	}

}
