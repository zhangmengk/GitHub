package com.lening.medical.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_drug")
public class DrugBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer did;
    private String dname;
    private Double price;
}
