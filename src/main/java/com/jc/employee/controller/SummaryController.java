package com.jc.employee.controller;

import com.jc.employee.domain.BaseResult;
import com.jc.employee.domain.EmpScore;
import com.jc.employee.domain.Summary;
import com.jc.employee.domain.SummaryScore;
import com.jc.employee.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * @author LX
 * @date 2021/3/30
 */
@RestController
@RequestMapping("/summary")
public class SummaryController {
    @Autowired
    SummaryService service;


    @PostMapping
    public String writeSummary(Summary summary) {
        summary.setSubTime(new Date());
        List<Summary> summaries = service.querySummaryByEmp(summary);
        if (summaries.isEmpty()) {
            return service.writeSummary(summary) == 1 ? "success" : "fail";
        } else {
            return service.updateSummary(summary) == 1 ? "success" : "fail";
        }
    }

    @GetMapping
    public BaseResult getSummary(Summary summary) {
        List<Summary> summaries = service.querySummaryByEmp(summary);
        return summaries.isEmpty() ? new BaseResult(200, "暂无记录") : new BaseResult(200, summaries);
    }

    @GetMapping("/noScore")
    public BaseResult getSummaryNoScore(Summary summary) {
        summary.setBelongToMonth(getMonthStr());
        List<Summary> summaries = service.querySummaryNoScoreByReviewer(summary);
        return summaries.isEmpty() ? new BaseResult(200, "暂无记录") : new BaseResult(200, summaries);
    }

    /**
     * 打分
     * @return
     */
    @PostMapping("/score")
    public String score(SummaryScore summaryScore) {
        return service.scoring(summaryScore) == 1 ? "success" : "fail";
    }

    @GetMapping("/score")
    public BaseResult getScore(){
        String monthStr = getMonthStr();
        List<EmpScore> empScores = service.queryEmpScore(monthStr);
        empScores.forEach(empScore -> empScore.setMonth(monthStr));
        return empScores.isEmpty() ? new BaseResult(200, "暂无记录") : new BaseResult(200, empScores);
    }

    private static String getMonthStr() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        String s = formatter.format(localDate);
        return s.charAt(5) == '0' ? s.replace("-0", "-") : s;
    }
}
