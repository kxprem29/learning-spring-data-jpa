package com.kxprem.hospitalManagement.entity;

import com.kxprem.hospitalManagement.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@Table(
        name = "patient",
        uniqueConstraints = {
//                @UniqueConstraint(name = "unique_patient_email",columnNames = {"email"}),
                @UniqueConstraint(name = "unique_patient_name_birthdate", columnNames = {"name","birthDate"})
        },
        indexes = {
                @Index(name="idx_patient_birth_date", columnList = "birthDate")
        }
)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "column_name")
    private String name;

//    @ToString.Exclude
    private LocalDate birthDate;

    @Column(unique = true, nullable = false)
    private String email;

    private String gender;

//    @Override
//    public String toString() {
//        return "Patient{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", birthDate=" + birthDate +
//                ", email='" + email + '\'' +
//                ", gender='" + gender + '\'' +
//                '}';
//    }

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    @OneToOne  //owning side
//    @JoinColumn(name = "patient_insurance_id")
    private Insurance insurance;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointment;
}
