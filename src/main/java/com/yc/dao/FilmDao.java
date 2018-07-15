package com.yc.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yc.bean.Filminfo;
import com.yc.bean.Filmtype;

public class FilmDao {
	
	private MyBatisUtil mu = new MyBatisUtil();
	public List<Filmtype> findAlltype() {
		SqlSession session = mu.getSession();
		List<Filmtype> list = session.selectList("com.yc.model.FilmtypeMapper.selectAll");
		session.close();
		return list;
	}
	public List<Filminfo> selectFilminfo(Map<String, Object> map) {
		SqlSession session = mu.getSession();
		List<Filminfo> list = null;
		try {
			list = session.selectList("com.yc.model.FilminfoMapper.select",map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
	public int insertFilminfo(Filminfo filminfo) {
		SqlSession session = mu.getSession();
		int result = 0;
		try {
			result = session.insert("com.yc.model.FilminfoMapper.insertFilmInfo", filminfo);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return result;
	}
	
}
