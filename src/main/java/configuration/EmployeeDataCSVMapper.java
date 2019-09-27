package main.java.configuration;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import main.java.model.EmployeeInfo;

public class EmployeeDataCSVMapper implements FieldSetMapper<EmployeeInfo>{

	
	@Override
	public EmployeeInfo mapFieldSet(FieldSet fieldSet) throws BindException {

		EmployeeInfo employeeInfo = new EmployeeInfo();
		
		//populate employee data
		employeeInfo.setEmployeeID(fieldSet.readInt(0));
		employeeInfo.setEmployeeName(fieldSet.readString(1));
		employeeInfo.setEmail(fieldSet.readString(2));
		employeeInfo.setPhoneNumber(fieldSet.readInt(3));
		employeeInfo.setDepartment(fieldSet.readString(4));
		
		return employeeInfo;
	}

}
