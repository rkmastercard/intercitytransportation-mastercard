package org.mann.connectedcities.service;

import org.mann.connectedcities.util.InterCitiesTransportation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterCitiesTransportationService {

    @Autowired
    private InterCitiesTransportation cityLink;

    /**
     * @param source
     * @param destination
     * @return true if source city and destination city are connected else will return false
     */
    public boolean areCitiesConnected(String source, String destination){
        return cityLink.isCityConnected(source, destination);
    }
}
