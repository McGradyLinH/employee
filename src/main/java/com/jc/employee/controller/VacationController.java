package com.jc.employee.controller;

import com.jc.employee.domain.VacationDetail;
import com.jc.employee.domain.VacationType;
import com.jc.employee.service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author LX
 * @date 2021/3/24
 */
@RestController
@RequestMapping("/vacation")
public class VacationController {
    @Autowired
    VacationService vacationService;

    public static final ThreadLocal<SimpleDateFormat> SIMPLEDATEFORMAT = ThreadLocal.withInitial(()-> new SimpleDateFormat("yyyy-MM-dd"));

    @PostMapping
    public String vacation(VacationDetail vacationDetail) {
        int i = vacationService.startVacation(vacationDetail);
        return i > 0 ? "success" : "fail";
    }

    @GetMapping("/{approveCode}/{code}")
    public List<VacationDetail> queryVacation(@PathVariable int approveCode, @PathVariable int code) {
        List<VacationDetail> vacationDetails = vacationService.queryVacation(approveCode, code);
        SimpleDateFormat dateFormat = SIMPLEDATEFORMAT.get();
        vacationDetails.forEach(vacationDetail -> {
            vacationDetail.setStartTimeStr(dateFormat.format(vacationDetail.getStartTime()));
            vacationDetail.setEndTimeStr(dateFormat.format(vacationDetail.getEndTime()));
        });
        SIMPLEDATEFORMAT.remove();
        return vacationDetails;
    }

    /**
     * 审批请假条
     *
     * @param detail
     * @return
     */
    @PutMapping
    public String approveVacation(VacationDetail detail) {
        int i = vacationService.approveVacation(detail);
        return i > 0 ? "success" : "fail";
    }

    @GetMapping("/types")
    public List<VacationType> types() {
        return vacationService.queryVacationType();
    }
}
