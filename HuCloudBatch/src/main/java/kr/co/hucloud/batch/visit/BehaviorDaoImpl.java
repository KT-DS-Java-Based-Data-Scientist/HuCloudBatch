package kr.co.hucloud.batch.visit;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class BehaviorDaoImpl extends SqlSessionDaoSupport implements BehaviorDao {

	@Override
	public int insertBehavior(BehaviorVO behaviorVO) {
		return getSqlSession().insert("BehaviorDao.insertBehavior", behaviorVO);
	}

}
