package com.ohgiraffers.view;

import com.ohgiraffers.dto.JobDTO;

import java.util.List;

public class JobPrintResult {

    public void printJobList(List<JobDTO> jobList) {

        for (JobDTO jobDTO : jobList) {
            System.out.println(jobDTO);
        }
    }

    public void printErrorMessage(String errorCode) {
        String errorMessage = "";
        switch (errorCode) {
            case "selectList" : errorMessage = "직급 조회를 실패했습니다."; break;
            case "selectOne" : errorMessage = "직급 목록 조회를 실패했습니다."; break;
            case "insert" : errorMessage = "신규 직급 등록을 실패했습니다."; break;
            case "update" : errorMessage = "직급 수정을 실패했습니다."; break;
            case "delete" : errorMessage = "직급 삭제를 실패했습니다."; break;

        }
        System.out.println(errorMessage);

    }

    public void printJob(JobDTO job) {
        System.out.println(job);
    }

    public void printSuccessMessage(String successCode) {
        String successMessage = "";
        switch (successCode) {
            case "insert" : successMessage = "신규 직급 등록을 성공했습니다."; break;
            case "update" : successMessage = "직급 수정을 성공했습니다."; break;
            case "delete" : successMessage = "직급 삭제를 성공했습니다."; break;

        }
        System.out.println(successMessage);
    }

}
