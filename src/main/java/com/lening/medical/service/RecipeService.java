package com.lening.medical.service;

import com.lening.medical.entity.RecipeBean;

import java.util.List;

public interface RecipeService {
    List<RecipeBean> findAll(RecipeBean recipeBean);
}
