package com.yc.test;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.yc.bean.Filminfo;
import com.yc.bean.Filmtype;

public class testFilminfo {
	
	static SqlSessionFactory factory = null;
	@Before
	public void initSetUp() {
		String resource = "mybatis-config.xml";
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	public void testInsertFilmInfo() {
		SqlSession session = factory.openSession();
		Filminfo filminfo = new Filminfo();
		filminfo.setFilmtype(new Filmtype(1,"喜剧"));
		filminfo.setFilmname("喜剧之王");
		filminfo.setActor("王晶");
		filminfo.setDirector("周星驰，吴孟达");
		filminfo.setTicketprice(20);
		try {
			session.insert("com.yc.model.FilminfoMapper.insertFilmInfo", filminfo);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
	}
	
	@Test
	public void testSelect() {
		SqlSession session = factory.openSession();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("filmname", "喜剧");
		map.put("typename", "喜剧");
		map.put("minprice", 10);
		map.put("maxprice", 20);
		try {
			List<Map> list = session.selectList("com.yc.model.FilminfoMapper.select",map);
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
	}

}
