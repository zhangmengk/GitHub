package com.lening.medical.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "t_patient")
public class PatientBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    private String user_name;
    private Integer user_phone;
    private Integer user_sex;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date create_time;
    private Integer user_age;
    private Integer admin_id;
}
