package com.lening.medical.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "t_admin")
public class AdminBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aid;
    private String aname;
    private Integer account;
    private Integer apassword;
}
