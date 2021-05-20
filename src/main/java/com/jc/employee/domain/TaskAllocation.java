package com.jc.employee.domain;

import lombok.Data;

/**
 * @author LX
 * @date 2021/4/14
 */
@Data
public class TaskAllocation {
    private int id;
    private int taskId;
    private int completeNum;
    private String taskRecipient;
    private String empName;
}
