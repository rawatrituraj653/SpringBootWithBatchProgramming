package com.nt.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class JobExListener  implements JobExecutionListener{

	
	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("Before Job Started");
	}
	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("After Job: "+jobExecution.getStatus().toString());
	}
}
