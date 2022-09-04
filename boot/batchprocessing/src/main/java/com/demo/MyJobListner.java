package com.demo;

import java.util.Date;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class MyJobListner implements JobExecutionListener {

	@Override
	public void beforeJob(JobExecution je) {
		System.out.println("job started..." + new Date());
	}

	@Override
	public void afterJob(JobExecution je) {
		System.out.println("job done..." + new Date());
	}

}
