package com.example.identity.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

/**
 * @author Max.Jimenez
 */
@Entity
@Table(name = "phone")
@NoArgsConstructor
@Getter
@Setter
public class PhoneEntity {

    @Id
    @GeneratedValue
    @Type(type = "uuid-binary")
    private UUID id;

    private Integer number;

    private Integer citycode;

    private Integer contrycode;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

}
