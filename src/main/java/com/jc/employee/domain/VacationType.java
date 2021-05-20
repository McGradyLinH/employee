package com.jc.employee.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author LX
 * @date 2021/3/24
 */
@Data
public class VacationType implements Serializable {
    private int id;
    private String vacationTypeName;
}
