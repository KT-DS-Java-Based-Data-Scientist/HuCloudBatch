package kr.co.hucloud.batch.visit;

import java.util.Arrays;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import kr.co.hucloud.batch.tool.HuCloudContext;
import kr.co.hucloud.batch.tool.Receiver;

public class BehaviorAnalysisJob extends QuartzJobBean {
	
	private BehaviorDao behaviorDao;
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		
		behaviorDao = HuCloudContext.getBean("behaviorDao");
		
		Receiver receiver = HuCloudContext.getBean("kafkaConsumer");
	    ConsumerRecords<String, String> logs = receiver.receive("IDTopic");
		
	    logs.forEach(record -> {
	    	Arrays.asList(record.value())
	    		  .stream()
	    		  .map(line -> line.split("ł"))
	    		  .map(arr -> new BehaviorVO(arr))
	    		  .forEach(log -> {
	    			  behaviorDao.insertBehavior(log);
	    		  });
	    		  
	    });
	}

}
