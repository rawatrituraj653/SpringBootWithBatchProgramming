package com.nt.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class Reader implements ItemReader<String>{

	private String arr[]= {"Rituraj","Rawat","Amit","Sumit"};
	private int count =0;
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		System.out.println("From Item Reader");
		if(count<arr.length) {
			return arr[count++];
		}
		else {
			count=0;
		}
		return null;
	}
}
