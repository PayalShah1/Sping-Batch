package main.java.processor;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import main.java.model.EmployeeInfo;

public class EmployeeDataCSVReader implements ItemReader<EmployeeInfo>{

	@Override
	public EmployeeInfo read() throws Exception, UnexpectedInputException, ParseException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
