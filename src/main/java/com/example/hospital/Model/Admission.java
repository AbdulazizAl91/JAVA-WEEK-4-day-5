package com.example.hospital.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Admission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Positive
    @Max(4)
    @Column(columnDefinition = "int check(number_of_beds_capacity<=4)")
    private Integer numberOfBedsCapacity ;
    @NotEmpty
    @Column(columnDefinition = "varchar(20) not null")
    private String patientName;
    @Positive
    @Max(4)
    @Column(columnDefinition = "int unique check(patient_bed_number>0 and patient_bed_number<=4)")
    private Integer patientBedNumber;
    @NotEmpty
    @Column(columnDefinition = "varchar(20) not null ")
    private String doctorName;

}
