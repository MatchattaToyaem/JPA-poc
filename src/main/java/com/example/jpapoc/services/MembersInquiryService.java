package com.example.jpapoc.services;

import com.example.jpapoc.models.member.Address;
import com.example.jpapoc.models.member.MemberInformation;
import com.example.jpapoc.models.member.Point;
import com.example.jpapoc.models.responses.MemberInformationResponse;
import com.example.jpapoc.repositories.MembersRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembersInquiryService {
    @Autowired
    private MembersRepository membersRepository;
    public MemberInformationResponse inquiry(){
        MemberInformation memberInformation = membersRepository.findByAddressInformation("Accenture");
        Address address = new Address();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            address = objectMapper.readValue(memberInformation.getAddress(), Address.class);
        }catch (Exception e){
            System.out.println("ERROR");
        }
        return new MemberInformationResponse().setName(memberInformation.getName()).setPoints(List.of(new Point())).setAddress(address);
    }
}
