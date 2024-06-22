package com.ohgiraffers.service;

import com.ohgiraffers.dao.JobMapper;
import com.ohgiraffers.dto.JobDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.common.Template.getSqlSession;

public class JobService {

    private JobMapper jobMapper;

    public List<JobDTO> selectAllJob() {
        SqlSession sqlSession = getSqlSession();

        jobMapper = sqlSession.getMapper(JobMapper.class);

        List<JobDTO> jobList = jobMapper.selectAllJob();

        sqlSession.close();

        return jobList;
    }

    public JobDTO selectJobByCode(String code) {

        SqlSession sqlSession = getSqlSession();

        jobMapper = sqlSession.getMapper(JobMapper.class);

        JobDTO job = jobMapper.selectJobByCode(code);

        sqlSession.close();

        return job;
    }

    public JobDTO selectJobByName(String name) {

        SqlSession sqlSession = getSqlSession();

        jobMapper = sqlSession.getMapper(JobMapper.class);

        JobDTO job = jobMapper.selectJobByName(name);

        sqlSession.close();

        return job;

    }
}
