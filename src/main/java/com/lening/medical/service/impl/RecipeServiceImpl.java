package com.lening.medical.service.impl;

import com.lening.medical.entity.PatientBean;
import com.lening.medical.entity.RecipeBean;
import com.lening.medical.mapper.PatientMapper;
import com.lening.medical.mapper.RecipeMapper;
import com.lening.medical.service.RecipeService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Resource
    private RecipeMapper recipeMapper;
    @Resource
    private PatientMapper patientMapper;

    @Override
    public List<RecipeBean> findAll(RecipeBean recipeBean) {
        Example example = new Example(RecipeBean.class);
        Example.Criteria criteria = example.createCriteria();
        if (recipeBean.getId()!=null){
            PatientBean patient = patientMapper.selectByPrimaryKey(recipeBean.getId());
            criteria.andEqualTo("userid", patient.getUser_id());
        }
        List<RecipeBean> list = recipeMapper.selectByExample(example);
        return list;
    }
}
