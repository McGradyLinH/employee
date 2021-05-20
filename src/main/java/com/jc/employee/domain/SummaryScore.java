package com.jc.employee.domain;

import lombok.Data;

/**
 * @author LX
 * @date 2021/3/30
 */
@Data
public class SummaryScore {
    private int id;
    private int summaryId;
    private double score;
    private String reviewer;
}
