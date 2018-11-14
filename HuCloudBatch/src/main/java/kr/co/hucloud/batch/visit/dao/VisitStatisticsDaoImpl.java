package kr.co.hucloud.batch.visit.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import kr.co.hucloud.batch.visit.vo.Visit;

public class VisitStatisticsDaoImpl extends SqlSessionDaoSupport implements VisitStatisticsDao{

	@Override
	public int insertStatisticsBySeconds(Visit visit) {
		return getSqlSession().insert("VisitStatisticsDao.insertStatisticsBySeconds", visit);
	}

	@Override
	public int insertStatisticsByMinutes(Visit visit) {
		return getSqlSession().insert("VisitStatisticsDao.insertStatisticsByMinutes", visit);
	}

	@Override
	public int insertStatisticsByHours(Visit visit) {
		return getSqlSession().insert("VisitStatisticsDao.insertStatisticsByHours", visit);
	}

	@Override
	public int insertStatisticsByYears(Visit visit) {
		return getSqlSession().insert("VisitStatisticsDao.insertStatisticsByYears", visit);
	}

	@Override
	public int insertStatisticsByMonths(Visit visit) {
		return getSqlSession().insert("VisitStatisticsDao.insertStatisticsByMonths", visit);
	}

	@Override
	public int insertStatisticsByDates(Visit visit) {
		return getSqlSession().insert("VisitStatisticsDao.insertStatisticsByDates", visit);
	}

}
