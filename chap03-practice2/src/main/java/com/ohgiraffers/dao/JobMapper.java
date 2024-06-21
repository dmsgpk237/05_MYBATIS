package com.ohgiraffers.dao;

import com.ohgiraffers.dto.JobDTO;

import java.util.List;

public interface JobMapper {

    List<JobDTO> selectAllJob();


    JobDTO selectJobByCode(String code);

}
