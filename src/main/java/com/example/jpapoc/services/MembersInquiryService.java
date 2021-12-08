package com.example.jpapoc.services;

import com.example.jpapoc.models.member.Address;
import com.example.jpapoc.models.member.MemberInformation;
import com.example.jpapoc.models.member.Point;
import com.example.jpapoc.models.responses.MemberInformationResponse;
import com.example.jpapoc.repositories.MembersRepository;
import com.example.jpapoc.repositories.criterias.MemberSearchCriteria;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.jpapoc.repositories.specifications.MemberSpecification.addressInformation;

@Service
public class MembersInquiryService {
    @Autowired
    private MembersRepository membersRepository;
    public MemberInformationResponse inquiry(){
        MemberSearchCriteria searchCriteria = new MemberSearchCriteria();
        searchCriteria.setNames(List.of("re"));
        List<MemberInformation> memberInformation = membersRepository.findAll(addressInformation(searchCriteria));
        Address address = memberInformation.get(0).getAddress();
        return new MemberInformationResponse().setName(memberInformation.get(0).getName()).setPoints(List.of(new Point())).setAddress(address);
    }
}
