package main.java.processor;

import org.springframework.batch.item.ItemProcessor;

import main.java.model.EmployeeInfo;

public class EmployeeDataItemProcessor implements ItemProcessor<EmployeeInfo, EmployeeInfo> {

	@Override
	public EmployeeInfo process(EmployeeInfo item) throws Exception {
		// TODO Auto-generated method stub
		return null; //null means nothing to process further 
	}

}
