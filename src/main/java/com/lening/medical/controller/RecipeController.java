package com.lening.medical.controller;

import com.lening.medical.entity.RecipeBean;
import com.lening.medical.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    @Resource
    private RecipeService recipeService;

    @RequestMapping("/recipeController")
    public String recipeController(RecipeBean recipeBean, Model model){
        List<RecipeBean> list = recipeService.findAll(recipeBean);
        model.addAttribute("list", list);
        return "recipe_list";
    }
}
