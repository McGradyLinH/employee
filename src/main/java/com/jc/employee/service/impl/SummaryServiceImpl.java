package com.jc.employee.service.impl;

import com.jc.employee.domain.EmpScore;
import com.jc.employee.domain.Summary;
import com.jc.employee.domain.SummaryScore;
import com.jc.employee.mapper.SummaryDao;
import com.jc.employee.service.SummaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LX
 * @date 2021/3/30
 */
@Service
public class SummaryServiceImpl implements SummaryService {
    @Resource
    private SummaryDao dao;


    @Override
    public int writeSummary(Summary summary) {
        return dao.writeSummary(summary);
    }

    @Override
    public int updateSummary(Summary summary) {
        return dao.updateSummary(summary);
    }

    @Override
    public List<Summary> querySummaryByEmp(Summary summary) {
        return dao.querySummary(summary);
    }

    @Override
    public List<Summary> querySummaryNoScoreByReviewer(Summary summary) {
        return dao.querySummaryNoScoreByReviewer(summary);
    }

    @Override
    public int scoring(SummaryScore summaryScore) {
        return dao.scoring(summaryScore);
    }

    @Override
    public List<EmpScore> queryEmpScore(String yearMonth) {
        return dao.queryEmpScore(yearMonth);
    }
}
