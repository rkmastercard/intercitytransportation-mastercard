package org.mann.connectedcities.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mann.connectedcities.util.InterCitiesTransportation;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class InterCitiesTransportationServiceTest {

    @Mock
    private InterCitiesTransportation cityLink;

    @InjectMocks
    private InterCitiesTransportationService citiesService;

    @Test
    public void testCheckCitiesAreConnected() {
        Mockito.when(cityLink.isCityConnected(Mockito.anyString(), Mockito.anyString())).thenReturn(true);

        boolean isConnected = citiesService.areCitiesConnected("Chicago", "New York");
        Assert.assertTrue(isConnected);
    }

    @Test
    public void testCitiesNotConnected(){
        Mockito.when(cityLink.isCityConnected(Mockito.anyString(), Mockito.anyString())).thenReturn(false);

        boolean isConnected = citiesService.areCitiesConnected("Chicago", "Los Angels");
        Assert.assertFalse(isConnected);
    }
}
