package kr.co.hucloud.batch.visit;

import java.util.Arrays;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import kr.co.hucloud.batch.tool.HuCloudContext;
import kr.co.hucloud.batch.tool.Receiver;

public class PersonalJob extends QuartzJobBean {
	
	private UrlDao trafficDao;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		
		trafficDao = HuCloudContext.getBean("trafficDao");

		Receiver receiver = HuCloudContext.getBean("kafkaConsumer");
	    ConsumerRecords<String, String> logs = receiver.receive("BatchTopic");
		
	    //logs.forEach(record -> System.out.println(record.value()));
	    logs.forEach(record -> {
	    	Arrays.asList(record.value())
	    		  .stream()
	    		  .map(line -> line.split("ł"))
	    		  .map(arr -> new UrlVO(arr))
	    		  .forEach(log -> {
	    			  trafficDao.insertUrl(log);
	    		  });
	    		  
	    });
	}

}
