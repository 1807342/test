package com.yc.test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.yc.bean.Filmtype;

public class TestFilmtype {
	
	static SqlSessionFactory factory = null;
	
	@Before
	public void initSetUp() {
		String resoures = "mybatis-config.xml";
		try {
			Reader reader = Resources.getResourceAsReader(resoures);
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	@Test
	public void testInsertSome() {
		SqlSession session = factory.openSession();
		List<Filmtype> list = new ArrayList<Filmtype>();
		list.add(new Filmtype("喜剧"));
		list.add(new Filmtype("动作"));
		list.add(new Filmtype("科幻"));
		try {
			session.insert("com.yc.model.FilmtypeMapper.insertSome", list);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	@Test
	public void testSelectBytypename() {
		SqlSession session = factory.openSession();
		String typename = "喜剧";
		try {
			Filmtype filmtype = session.selectOne("com.yc.model.FilmtypeMapper.selectBytypename", typename);
			System.out.println(filmtype);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	@Test
	public void testSelectAll() {
		SqlSession session = factory.openSession();
		try {
			List<Filmtype> list = session.selectList("com.yc.model.FilmtypeMapper.selectAll");
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	@Test
	public void testselectBytype() {
		SqlSession session = factory.openSession();
		try {
			Filmtype filmtype = new Filmtype("喜剧");
			List<Object> list = session.selectList("com.yc.model.FilmtypeMapper.selectBytype",filmtype);
			List<Object> list2 = session.selectList("com.yc.model.FilmtypeMapper.selectBytype");
			System.out.println(list2);
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

}
