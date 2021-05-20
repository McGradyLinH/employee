package com.jc.employee.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author LX
 * @date 2021/3/30
 */
@Data
public class Summary {
    private int id;
    private Date subTime;
    private String belongToEmp;
    private Employee employee;
    private String summaryContent;
    private String belongToMonth;
    private String reviewer;
}
