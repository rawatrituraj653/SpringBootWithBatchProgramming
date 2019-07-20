package com.nt.batchConfig;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nt.listener.JobExListener;
import com.nt.process.Processor;
import com.nt.reader.Reader;
import com.nt.writer.Writer;

@Configuration
public class BatchConfig {
	@Autowired
	private StepBuilderFactory factory;
	
	@Autowired
	private JobBuilderFactory  jf;
	
	@Bean
	public Job j1() {
		
		return jf.get("job")
				.incrementer(new RunIdIncrementer())
				.listener(listener())
				.start(s1())
				/*.next(sf1()).next(sf2())*/
				.build();
	}				
	
	
	@Bean
	public  Step s1() {
		return factory.get("step")
				.<String,String>chunk(2)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
	}
	
	@Bean
	public JobExListener listener() {
		
		return new JobExListener();
	}
	
	@Bean
	public Reader reader() {
		
		return new Reader();
	}
	
	@Bean
	public Processor processor() {
		return new Processor();
	}
	@Bean
	public Writer  writer() {
		return  new  Writer();
	}
}
