package com.lening.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lening.medical.entity.AdminBean;
import com.lening.medical.entity.PatientBean;
import com.lening.medical.mapper.AdminMapper;
import com.lening.medical.mapper.PatientMapper;
import com.lening.medical.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Resource
    private PatientMapper patientMapper;

    @Override
    public AdminBean getlogin(AdminBean adminBean) {
        Example example = new Example(AdminBean.class);
        Example.Criteria criteria = example.createCriteria();
        if(adminBean!=null){
            if(!StringUtils.isEmpty(adminBean.getAccount())){
                criteria.andEqualTo("account", adminBean.getAccount());
            }
            List<AdminBean> list = adminMapper.selectByExample(example);
            if (list != null && list.size() == 1) {
                //判断密码
                AdminBean rsuser = list.get(0);
                if (rsuser.getApassword().equals(adminBean.getApassword())) {
                    return rsuser;
                }
            }
        }
        return null;
    }

    @Override
    public PageInfo<PatientBean> findAllConnAndPage(PatientBean patientBean, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(PatientBean.class);
        Example.Criteria criteria = example.createCriteria();
        if (patientBean!=null){
            if (!StringUtils.isEmpty(patientBean.getUser_name())){
                criteria.andLike("user_name", "%"+patientBean.getUser_name()+"%");
            }
            if (patientBean.getCreate_time()!=null){
                criteria.andEqualTo(patientBean.getCreate_time());
            }
        }
        List<PatientBean> list = patientMapper.selectByExample(example);
        PageInfo<PatientBean> pageInfo = new PageInfo<PatientBean>(list);
        return pageInfo;
    }


}
