package com.example.jpapoc.models.converters;

import com.example.jpapoc.models.member.Address;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;

@Converter(autoApply = true)
public class AddressConverter implements AttributeConverter<Address, String> {
    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Address address) {
        try{
            return objectMapper.writeValueAsString(address);
        }catch (JsonProcessingException e){
            System.out.println("Json error");
            return null;
        }
    }

    @Override
    public Address convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, new TypeReference<Address>() {
            });
        } catch (IOException ex) {
            // logger.error("Unexpected IOEx decoding json from database: " + dbData);
            return null;
        }
    }
}
