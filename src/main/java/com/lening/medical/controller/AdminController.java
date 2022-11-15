package com.lening.medical.controller;

import com.github.pagehelper.PageInfo;
import com.lening.medical.entity.AdminBean;
import com.lening.medical.entity.PatientBean;
import com.lening.medical.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    @RequestMapping("/tologin")
    public String tologin(){
        return "admin_login";
    }

    @RequestMapping("/getLogin")
    public String getLogin(AdminBean adminBean){
        AdminBean rsuser = adminService.getlogin(adminBean);
        if (rsuser!=null){
            return "redirect:findAllConnAndPage";
        }else {
            return "/admin_login";
        }
    }

    @RequestMapping("/findAllConnAndPage")
    public String findAllConnAndPage(PatientBean patientBean,Model model,
                        @RequestParam(defaultValue = "1") Integer pageNum,
                        @RequestParam(defaultValue = "3") Integer pageSize) {
        PageInfo<PatientBean> pageInfo = adminService.findAllConnAndPage(patientBean, pageNum, pageSize);
        model.addAttribute("page", pageInfo);
        model.addAttribute("patient", patientBean);
        return "patient_list";
    }

}
