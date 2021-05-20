package com.jc.employee.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author LX
 * @date 2021/3/18
 */
@Data
public class VacationDetail {
    private int id;
    private String leavePeople;
    private int vacationTypeId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;
    private String startTimeStr;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;
    private String endTimeStr;
    private float totalTime;
    private String vacationReason;
    private String approverCode;
    private String approvalRemarks;
    private int processNumber;
    private String empName;
}
