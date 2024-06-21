package com.ohgiraffers.controller;

import com.ohgiraffers.dto.JobDTO;
import com.ohgiraffers.service.JobService;
import com.ohgiraffers.view.JobPrintResult;

import java.util.List;
import java.util.Map;

public class JobController {
    private final JobPrintResult jobPrintResult;
    private final JobService jobService;

    // 생성자 주입
    public JobController() {
        jobPrintResult = new JobPrintResult();
        jobService = new JobService();
    }

    // 전체조회
    public void selectAllJob() {

        List<JobDTO> jobList = jobService.selectAllJob();

        if (jobList != null) {
            jobPrintResult.printJobList(jobList);
        } else {
            jobPrintResult.printErrorMessage("selectList");
        }

    }

    public void selectJobByCode(Map<String, String> parameter) {

        String code = parameter.get("code");

        JobDTO job = jobService.selectJobByCode(code);

        if (job != null) {
            jobPrintResult.printJob(job);
        } else {
            jobPrintResult.printErrorMessage("selectOne");
        }

    }
}
