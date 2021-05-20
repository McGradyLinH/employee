package com.jc.employee.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author LX
 * @date 2021/4/14
 */
@Data
public class Task {
    private int id;
    private String taskName;
    private String taskContent;
    private Date pubTime;
    private String pubTimeStr;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;
    private String endTimeStr;
    private String publisherCode;
    private int taskNum;
    private String taskUnit;
    /**
     * 被指定人集合
     */
    private String designees;
    private TaskAllocation taskAllocation;
    private boolean overdue;
    private String designeesName;
    private List<TaskAllocation> taskAllocations;
}
