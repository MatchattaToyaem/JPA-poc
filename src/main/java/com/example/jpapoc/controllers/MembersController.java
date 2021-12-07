package com.example.jpapoc.controllers;

import com.example.jpapoc.models.member.Point;
import com.example.jpapoc.models.responses.MemberInformationResponse;
import com.example.jpapoc.services.MembersInquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.ZonedDateTime;
import java.util.List;

@Controller
public class MembersController {
    @Autowired
    private MembersInquiryService membersInquiryService;
    @PostMapping("/member-information/inquiry")
    public ResponseEntity<MemberInformationResponse> getMemberInformationInquiry(
    ){
        return ResponseEntity.ok(membersInquiryService.inquiry());
    }
}
