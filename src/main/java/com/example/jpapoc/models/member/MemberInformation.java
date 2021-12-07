package com.example.jpapoc.models.member;

import com.example.jpapoc.configs.JpaConvertJson;
import com.example.jpapoc.models.member.Point;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
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
    private String address;

}
