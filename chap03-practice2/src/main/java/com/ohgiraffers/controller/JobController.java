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

    public void selectJobByName(Map<String, String> parameter) {

        String name = parameter.get("name");

        JobDTO job = jobService.selectJobByName(name);

        if (job != null) {
            jobPrintResult.printJob(job);
        } else {
            jobPrintResult.printErrorMessage("selectOne");
        }

    }

    public void registJob(Map<String, String> parameter) {

        String jobCode = parameter.get("jobCode");
        String jobName = parameter.get("jobName");

        JobDTO job = new JobDTO();
        job.setJobCode(jobCode);
        job.setJobName(jobName);

        if (jobService.registJob(job)) {
            jobPrintResult.printSuccessMessage("insert");

        } else {
            jobPrintResult.printErrorMessage("insert");
        }

    }
}
