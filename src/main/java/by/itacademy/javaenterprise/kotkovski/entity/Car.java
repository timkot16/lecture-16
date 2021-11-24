package by.itacademy.javaenterprise.kotkovski.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String model;
    @Column(name = "vin_code")
    private String vinCode;
    @Column
    private int year;
    @Column
    private String number;
}