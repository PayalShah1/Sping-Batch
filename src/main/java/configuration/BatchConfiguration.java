package main.java.configuration;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import main.java.model.EmployeeInfo;
import main.java.processor.ConsoleItemWriter;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	JobRepository jobrepository;

	@Autowired
	JobBuilderFactory jobBuilderFactory;

	@Autowired
	StepBuilderFactory stepBuilderFactory;


	@Bean
	public ItemReader<EmployeeInfo> reader(){
		FlatFileItemReader<EmployeeInfo> reader = new FlatFileItemReader<EmployeeInfo>();
		//reader.setLinesToSkip(1);//first line is title definition 
		reader.setResource(new FileSystemResource("input/sample.csv"));
		reader.setLineMapper(lineMapper());
		return reader; 
	}

	@Bean
	public LineMapper<EmployeeInfo> lineMapper() {
		DefaultLineMapper<EmployeeInfo> lineMapper = new DefaultLineMapper<EmployeeInfo>();

		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(';');
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(new String[]{"Employee Id", "Employee Name", "Email", "Phone Number", "Department"});

		BeanWrapperFieldSetMapper<EmployeeInfo> fieldSetMapper = new BeanWrapperFieldSetMapper<EmployeeInfo>();
		fieldSetMapper.setTargetType(EmployeeInfo.class);

		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(new EmployeeDataCSVMapper());

		return lineMapper;
	}

	@Bean
	public ConsoleItemWriter<EmployeeInfo> writer()
	{
		return new ConsoleItemWriter<EmployeeInfo>();
	}
}
