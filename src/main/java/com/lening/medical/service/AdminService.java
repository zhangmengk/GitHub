package com.lening.medical.service;

import com.github.pagehelper.PageInfo;
import com.lening.medical.entity.AdminBean;
import com.lening.medical.entity.PatientBean;

public interface AdminService {

    PageInfo<PatientBean> findAllConnAndPage(PatientBean patientBean, Integer pageNum, Integer pageSize);

    AdminBean getlogin(AdminBean adminBean);
}
