package com.example.jpapoc.repositories;

import com.example.jpapoc.models.member.MemberInformation;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.UUID;

@org.springframework.stereotype.Repository
public interface MembersRepository extends Repository<MemberInformation, UUID> {
    MemberInformation findByName(String name);
    @Query()
    MemberInformation findByAddressInformation(String information);
}
