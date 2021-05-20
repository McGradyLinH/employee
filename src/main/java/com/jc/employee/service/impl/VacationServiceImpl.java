package com.jc.employee.service.impl;

import com.jc.employee.domain.VacationDetail;
import com.jc.employee.domain.VacationType;
import com.jc.employee.mapper.VacationDao;
import com.jc.employee.service.VacationService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LX
 * @date 2021/3/24
 */
@Service
public class VacationServiceImpl implements VacationService {
    @Resource
    VacationDao vacationDao;

    /**
     * 开始请假
     *
     * @param detail
     * @return
     */
    @Override
    public int startVacation(VacationDetail detail) {
        return vacationDao.startVacation(detail);
    }

    @Override
    public int approveVacation(VacationDetail detail) {
        return vacationDao.approveVacation(detail);
    }

    @Override
    public List<VacationDetail> queryVacation(int approveCode, int code) {
        return vacationDao.queryVacation(approveCode, code);
    }

    @Cacheable(value = "types")
    @Override
    public List<VacationType> queryVacationType() {
        return vacationDao.queryVacationType();
    }
}
