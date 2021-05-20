package com.jc.employee.service.impl;

import com.jc.employee.controller.VacationController;
import com.jc.employee.domain.Task;
import com.jc.employee.domain.TaskAllocation;
import com.jc.employee.mapper.TaskDao;
import com.jc.employee.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @author LX
 * @date 2021/4/14
 */

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskDao taskDao;

    @Autowired
    public TaskServiceImpl(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Transactional
    @Override
    public int pubTask(Task task) {
        try {
            int i = taskDao.pubTask(task);
            if (i > 0) {
                String designees = task.getDesignees();
                String[] empsCode = designees.split(",");
                List<TaskAllocation> list = new ArrayList<>(empsCode.length);
                int id = task.getId();
                for (String empCode : empsCode) {
                    TaskAllocation taskAllocation = new TaskAllocation();
                    taskAllocation.setTaskId(id);
                    taskAllocation.setTaskRecipient(empCode);
                    list.add(taskAllocation);
                }
                taskDao.assignTasks(list);
                return 1;
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Task> queryTask(String taskRecipient) {
        SimpleDateFormat simpleDateFormat = VacationController.SIMPLEDATEFORMAT.get();
        List<Task> tasks = taskDao.queryTask(taskRecipient);
        Date date = new Date();
        tasks.forEach(task -> {
            task.setOverdue(task.getEndTime().compareTo(date) <= 0);
            task.setEndTimeStr(simpleDateFormat.format(task.getEndTime()));
            task.setPubTimeStr(simpleDateFormat.format(task.getPubTime()));
        });
        return tasks;
    }

    @Override
    public List<Task> queryPubTask(String pubCode) {
        List<Task> tasks = taskDao.queryPubTask(pubCode);
        Date date = new Date();
        tasks.forEach(task -> {
            task.setOverdue(task.getEndTime().compareTo(date) <= 0);
            List<TaskAllocation> taskAllocations = taskDao.queryScoreByTaskId(task.getId());
            String designees = task.getDesignees();
            String designeesName = task.getDesigneesName();
            String[] strings = designees.split(",");
            String[] names = designeesName.split(",");
            for (int i = 0; i < taskAllocations.size(); i++) {
                String empCode = strings[i];
                TaskAllocation taskAllocation1 = taskAllocations.get(i);
                taskAllocation1.setEmpName(names[i]);
                int index = i;
                while (!empCode.equals(taskAllocation1.getTaskRecipient()) && (index + 1) < taskAllocations.size()) {
                    index++;
                    taskAllocation1 = taskAllocations.get(index);
                    taskAllocation1.setEmpName(names[i]);
                }
                if (index != i) {
                    TaskAllocation taskAllocation = taskAllocations.get(i);
                    taskAllocations.set(i, taskAllocation1);
                    taskAllocations.set(index, taskAllocation);
                }
            }
            task.setTaskAllocations(taskAllocations);
        });
        return tasks;
    }

    @Transactional
    @Override
    public int updateTaskAllocation(List<TaskAllocation> taskAllocations) {
        taskAllocations.forEach(taskDao::updateTaskAllocation);
        return 1;
    }

}
