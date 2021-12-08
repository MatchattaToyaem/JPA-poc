package com.example.jpapoc.repositories;

import com.example.jpapoc.models.member.MemberInformation;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import com.example.jpapoc.repositories.specifications.MemberSpecification;

import java.util.List;
import java.util.UUID;

@org.springframework.stereotype.Repository
public interface MembersRepository extends Repository<MemberInformation, UUID>, JpaSpecificationExecutor<MemberInformation>{
    MemberInformation findByName(String name);
//    @Query(value = "SELECT id, name, date_of_birth, address FROM member_information WHERE address ->> \'name\' like %:information% limit 1", nativeQuery = true)
    List<MemberInformation> findAll(Specification<MemberInformation> specification);
}
