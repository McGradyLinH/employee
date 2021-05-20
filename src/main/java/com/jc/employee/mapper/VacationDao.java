package com.jc.employee.mapper;

import com.jc.employee.domain.VacationDetail;
import com.jc.employee.domain.VacationType;

import java.util.List;

/**
 * @author LX
 * @date 2021/3/24
 */
public interface VacationDao {
    int startVacation(VacationDetail detail);

    /**
     * 审核请假
     * @param detail
     * @return
     */
    int approveVacation(VacationDetail detail);

    /**
     * 查询未被审核的请假
     * @param approveCode
     * @param code
     * @return
     */
    List<VacationDetail> queryVacation(int approveCode, int code);

    /**
     * 查询所有的请假类型
     * @return
     */
    List<VacationType> queryVacationType();
}
