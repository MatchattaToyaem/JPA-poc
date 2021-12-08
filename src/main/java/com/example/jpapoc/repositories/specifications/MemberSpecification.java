package com.example.jpapoc.repositories.specifications;

import com.example.jpapoc.models.member.MemberInformation;
import com.example.jpapoc.repositories.criterias.MemberSearchCriteria;
import org.springframework.data.jpa.domain.Specification;

public class MemberSpecification{
    public static Specification<MemberInformation> addressInformation(MemberSearchCriteria searchCriteria){
        return (root, query, criteriaBuilder) -> {
            if (searchCriteria.getNames().size() == 1) {

                return criteriaBuilder.like(criteriaBuilder.lower(criteriaBuilder.function("jsonb_extract_path_text", String.class, root.<String>get("address"), criteriaBuilder.literal("name"))), "%" + searchCriteria.getNames().get(0) + "%");

            }
            return null;
        };
    }

}
