package kr.co.hucloud.batch.visit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import kr.co.hucloud.batch.tool.HuCloudContext;
import kr.co.hucloud.batch.tool.Receiver;

public class TrafficAnalysisJob extends QuartzJobBean {
	
	private TrafficDao trafficDao;
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		
		trafficDao = HuCloudContext.getBean("trafficDao");
		
		Receiver receiver = HuCloudContext.getBean("kafkaConsumer");
		
		// RealTimeLog Table Data 삭제
		trafficDao.deleteTraffic();
		
	    ConsumerRecords<String, String> logs = receiver.receive("RealTimeTopic");
	    
	    List<String> logList = new ArrayList<>();
	    
	    logs.forEach( (log) -> {
	    	logList.add(log.value());
	    });
	      
	    logList.stream()
	    		.map(line -> line.split("ł"))
	    		.map(arr -> {
	    			String[] newArr = new String[2];
	    			newArr[0] = arr[1];
	    			newArr[1] = arr[2];
	    			
	    			return newArr;
	    		})
	    		.collect(Collectors.groupingBy(dataArr -> dataArr[0], Collectors.summingInt(dataArr -> Integer.parseInt(dataArr[1]))))
	    		.entrySet()
	    		.stream()
	    		.map(data -> new TrafficVO(data.getKey(), data.getValue()))
	    		.forEach(data -> {
	    			// Data Insert
	    			trafficDao.insertTraffic(data);
	    		});
		
	}

}
