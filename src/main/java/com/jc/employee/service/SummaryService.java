package com.jc.employee.service;

import com.jc.employee.domain.EmpScore;
import com.jc.employee.domain.Summary;
import com.jc.employee.domain.SummaryScore;

import java.util.List;

/**
 * @author LX
 * @date 2021/3/30
 */
public interface SummaryService {
    /**
     * 写总结
     * @param summary
     * @return
     */
    int writeSummary(Summary summary);

    /**
     * 修改总结
     * @param summary
     * @return
     */
    int updateSummary(Summary summary);

    /**
     * 查询总结
     * @param empCode
     * @return
     */
    List<Summary> querySummaryByEmp(Summary summary);

    /**
     * 根据当前月份和当前登录用户剔除不需要的记录
     * @param summary
     * @return
     */
    List<Summary> querySummaryNoScoreByReviewer(Summary summary);

    /**
     * 打分
     * @param summaryScore
     * @return
     */
    int scoring(SummaryScore summaryScore);

    /**
     * 查询所有人的得分情况
     * @return
     */
    List<EmpScore> queryEmpScore(String yearMonth);
}
