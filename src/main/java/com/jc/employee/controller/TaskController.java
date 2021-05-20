package com.jc.employee.controller;

import com.jc.employee.domain.BaseResult;
import com.jc.employee.domain.Task;
import com.jc.employee.domain.TaskAllocation;
import com.jc.employee.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author LX
 * @date 2021/4/7
 */
@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public String pubTask(Task task) {
        System.out.println(task);
        task.setPubTime(new Date());
        int i = taskService.pubTask(task);
        return i > 0 ? "success" : "fail";
    }

    @GetMapping("/{taskRecipient}")
    public BaseResult selectTaskByEmpCode(@PathVariable String taskRecipient) {
        List<Task> tasks = taskService.queryTask(taskRecipient);
        return tasks.isEmpty() ? new BaseResult(200, "暂无任务") : new BaseResult(200, tasks);
    }

    @GetMapping("/pub/{pubCode}")
    public BaseResult selectTaskByPubCode(@PathVariable String pubCode){
        List<Task> tasks = taskService.queryPubTask(pubCode);
        return tasks.isEmpty() ? new BaseResult(200, "暂无任务") : new BaseResult(200, tasks);
    }

    @PutMapping
    public String updateTaskAllocation(String scores,String designees,Integer taskId){
        String[] empCodes = designees.split(",");
        String[] scoresArr = scores.split(",");
        if (empCodes.length == scores.length()){
            List<TaskAllocation> taskAllocations = new ArrayList<>(empCodes.length);
            for (int i = 0; i < empCodes.length; i++) {
                TaskAllocation taskAllocation = new TaskAllocation();
                taskAllocation.setTaskId(taskId);
                taskAllocation.setTaskRecipient(empCodes[i]);
                taskAllocation.setCompleteNum(Integer.parseInt(scoresArr[i]));
                taskAllocations.add(taskAllocation);
            }
            int i = taskService.updateTaskAllocation(taskAllocations);
            return i > 0 ? "success" : "fail";
        }
        return "fail";
    }
}
