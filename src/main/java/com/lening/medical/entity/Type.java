package com.lening.medical.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_type")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer t_did;
    private String t_dname;
    private Double t_price;
}
