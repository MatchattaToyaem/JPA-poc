package com.example.jpapoc.models.responses;

import com.example.jpapoc.models.member.Address;
import com.example.jpapoc.models.member.Point;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
public class MemberInformationResponse implements Serializable {
    private String name;
    private List<Point> points;
    private Address address;
}
