package kr.co.hucloud.batch.visit;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class TrafficDaoImpl extends SqlSessionDaoSupport implements TrafficDao {

	@Override
	public int insertTraffic(TrafficVO trafficVO) {
		return getSqlSession().insert("TrafficDao.insertTraffic", trafficVO);
	}

	@Override
	public int deleteTraffic() {
		return getSqlSession().delete("TrafficDao.deleteTraffic");
	}

}
