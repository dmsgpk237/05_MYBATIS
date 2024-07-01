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

    public boolean registJob(JobDTO job) {

        SqlSession sqlSession = getSqlSession();
        jobMapper = sqlSession.getMapper(JobMapper.class);

        int result = jobMapper.insertJob(job);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean modifyJob(JobDTO job) {
        SqlSession sqlSession = getSqlSession();
        jobMapper = sqlSession.getMapper(JobMapper.class);

        int result = jobMapper.modifyJob(job);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }


    public boolean deleteJob(String jobCode) {

        SqlSession sqlSession = getSqlSession();

        jobMapper = sqlSession.getMapper(JobMapper.class);

        int result = jobMapper.deleteJob(jobCode);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }
}
