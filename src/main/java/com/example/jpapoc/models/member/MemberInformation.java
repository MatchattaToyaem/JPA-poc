package com.example.jpapoc.models.member;

import com.example.jpapoc.models.converters.AddressConverter;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@Accessors(chain = true)
@Table(name = "member_information")
@NoArgsConstructor
public class MemberInformation implements Serializable {
    @Id
    private UUID id;
    private String name;
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    @Convert(converter = AddressConverter.class)
    @Column(columnDefinition = "json")
    private Address address;

}
