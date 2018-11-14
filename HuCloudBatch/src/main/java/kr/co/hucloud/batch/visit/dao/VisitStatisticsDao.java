package kr.co.hucloud.batch.visit.dao;

import kr.co.hucloud.batch.visit.vo.Visit;

public interface VisitStatisticsDao {

	public int insertStatisticsByYears(Visit visit);
	
	public int insertStatisticsByMonths(Visit visit);

	public int insertStatisticsByDates(Visit visit);
	
	public int insertStatisticsBySeconds(Visit visit);
	
	public int insertStatisticsByMinutes(Visit visit);

	public int insertStatisticsByHours(Visit visit);
}
