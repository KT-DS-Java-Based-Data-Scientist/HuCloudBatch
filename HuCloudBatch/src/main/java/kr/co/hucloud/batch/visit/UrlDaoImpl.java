package kr.co.hucloud.batch.visit;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class UrlDaoImpl extends SqlSessionDaoSupport implements UrlDao {

	@Override
	public int insertUrl(UrlVO urlVO) {
		return getSqlSession().insert("UrlDao.insertUrl", urlVO);
	}

}
