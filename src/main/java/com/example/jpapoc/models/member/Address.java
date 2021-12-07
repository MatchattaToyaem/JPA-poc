package com.example.jpapoc.models.member;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Address {
    private String name;
    private String road;
    private String postcode;
}
