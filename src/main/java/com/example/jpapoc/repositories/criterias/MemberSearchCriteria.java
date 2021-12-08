package com.example.jpapoc.repositories.criterias;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MemberSearchCriteria {
    private List<String> names;
}
