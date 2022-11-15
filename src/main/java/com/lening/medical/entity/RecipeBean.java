package com.lening.medical.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_recipe")
public class RecipeBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer type;
    private String diagnose;
    private String remark;
    private Integer userid;

}
