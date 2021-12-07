package com.example.jpapoc.repositories;

import com.example.jpapoc.models.member.MemberInformation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

@org.springframework.stereotype.Repository
public interface MembersRepository extends Repository<MemberInformation, UUID> {
    MemberInformation findByName(String name);
    @Query(value = "SELECT id, name, date_of_birth, address FROM member_information WHERE address ->> \'name\' = :information", nativeQuery = true)
    MemberInformation findByAddressInformation(@Param("information") String information);
}
