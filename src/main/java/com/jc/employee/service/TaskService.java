package com.jc.employee.service;

import com.jc.employee.domain.Task;
import com.jc.employee.domain.TaskAllocation;

import java.util.List;

/**
 * @author LX
 * @date 2021/4/14
 */
public interface TaskService {
    /**
     * 发布任务
     * @param task
     * @return
     */
    int pubTask(Task task);

    /**
     * 查询某个人的任务
     * @param taskRecipient 人员编号
     * @return
     */
    List<Task> queryTask(String taskRecipient);

    /**
     * 查询某人发布的任务
     * @param pubCode
     * @return
     */
    List<Task> queryPubTask(String pubCode);

    int updateTaskAllocation(List<TaskAllocation> taskAllocations);
}
