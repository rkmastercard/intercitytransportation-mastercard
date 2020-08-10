package org.mann.connectedcities.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mann.connectedcities.util.InterCitiesTransportation;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class InterCitiesTransportationTest {

    @InjectMocks
    private InterCitiesTransportation connectedCities;

    @Test
    public void testCitiesAreConnected() {
        connectedCities.addCities("Chicago", "New York");
        boolean cityConnected = connectedCities.isCityConnected("Chicago", "New York");
        Assert.assertTrue(cityConnected);
    }

    @Test
    public void testCitiesnotConnected() {
        connectedCities.addCities("Chicago", "New York");
        boolean cityConnected = connectedCities.isCityConnected("Chicago", "Los Angels");
        Assert.assertFalse(cityConnected);
        cityConnected = connectedCities.isCityConnected("Los Angels", "New York");
        Assert.assertFalse(cityConnected);
    }

    @Test
    public void testSingleCityNullCheck(){
        connectedCities.addCities("Chicago", "New York");
        boolean cityConnected = connectedCities.isCityConnected(null, "Chicago");
        Assert.assertFalse(cityConnected);
        cityConnected = connectedCities.isCityConnected("Chicago", null);
        Assert.assertFalse(cityConnected);
    }

    @Test
    public void testBothCityNullCheck(){
        connectedCities.addCities("Chicago", "New York");
        boolean cityConnected = connectedCities.isCityConnected(null, null);
        Assert.assertTrue(cityConnected);
    }

    @Test
    public void testConnectedCitiesAreCaseSensitive(){
        connectedCities.addCities("Chicago", "New York");
        boolean cityConnected = connectedCities.isCityConnected("chicago", "new York");
        Assert.assertTrue(cityConnected);
        cityConnected = connectedCities.isCityConnected("chicago", "New York");
        Assert.assertTrue(cityConnected);
        cityConnected = connectedCities.isCityConnected("Chicago", "los Angels");
        Assert.assertFalse(cityConnected);
    }

    @Test
    public void testsameSourceAndDestination(){
        connectedCities.addCities("Chicago", "New York");
        boolean cityConnected = connectedCities.isCityConnected("Los Angels", "Los Angels");
        Assert.assertTrue(cityConnected);
    }

    @Test
    public void testsameSourceAndDestinationCaseSensitive(){
        connectedCities.addCities("Chicago", "New York");
        boolean cityConnected = connectedCities.isCityConnected("New York", "new york");
        Assert.assertTrue(cityConnected);
    }

    @Test
    public void testsingleSourceDestination(){
        connectedCities.addCities("Chicago", "New York");
        boolean cityConnected = connectedCities.isCityConnected("Chicago", "New York");
        Assert.assertTrue(cityConnected);
    }

    @Test
    public void testMultipleSourceDestinationLinked(){
        connectedCities.addCities("Chicago", "New York");
        connectedCities.addCities("New York", "Los Angels");
        boolean cityConnected = connectedCities.isCityConnected("Chicago", "New York");
        Assert.assertTrue(cityConnected);
    }

    @Test
    public void testMultipleSourceDestinationUnlinked(){
        connectedCities.addCities("Chicago", "New York");
        connectedCities.addCities("Los Angels", "Washington");
        boolean cityConnected = connectedCities.isCityConnected("Chicago", "New York");
        Assert.assertTrue(cityConnected);
    }

}