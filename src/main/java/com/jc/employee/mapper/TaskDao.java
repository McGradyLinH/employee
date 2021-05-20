package com.jc.employee.mapper;

import com.jc.employee.domain.Task;
import com.jc.employee.domain.TaskAllocation;

import java.util.List;

/**
 * @author LX
 * @date 2021/4/14
 */
public interface TaskDao {
    /**
     * 发布任务
     * @param task
     * @return
     */
    int pubTask(Task task);

    /**
     * 批量分配任务
     * @param list
     * @return
     */
    void assignTasks(List<TaskAllocation> list);

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

    /**
     * 更新任务分配
     * @param taskAllocation
     */
    void updateTaskAllocation(TaskAllocation taskAllocation);

    /**
     * 根据任务id查询得分情况
     * @param taskId
     * @return
     */
    List<TaskAllocation> queryScoreByTaskId(Integer taskId);
}
