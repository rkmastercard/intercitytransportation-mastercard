package org.mann.connectedcities.service;

import org.mann.connectedcities.exception.InterCityMappingFileException;
import org.mann.connectedcities.util.InterCitiesTransportation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class InterCityResourceFileReaderService {

    @Autowired
    private InterCitiesTransportation cityLink;

    @Value("classpath:data/city-information.txt")
    private Resource cityInfoResource;

    /**
     * Load cities mapping (connectivity) from resource file.
     * @throws IOException
     */
    @PostConstruct
    public void initialize() throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(cityInfoResource.getInputStream()))){
            reader.lines().forEach(this::addCities);
        }
    }

    private void addCities(String line) {
        String [] str = line.trim().split("-");
        if(str.length != 2){
            throw new InterCityMappingFileException("City mapping issue detected. Input Data :: " + line);
        }
        cityLink.addCities(str[0].trim(), str[1].trim());
    }
}
