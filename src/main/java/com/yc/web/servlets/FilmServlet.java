package com.yc.web.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.bean.Filminfo;
import com.yc.bean.Filmtype;
import com.yc.dao.FilmDao;


@WebServlet("/film.action")
public class FilmServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;
	private FilmDao fd = new FilmDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if("findAlltype".equals(op)) {
				findAlltypeOp(request,response);
			}else if("selectFilminfo".equals(op)){
				selectFilminfoOp(request,response);
			}else if("insertFilminfo".equals(op)) {
				insertFilminfoOp(request,response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void insertFilminfoOp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Filminfo filminfo = (Filminfo) parseParameterToT(request, Filminfo.class);
		Filmtype filmtype = new Filmtype(filminfo.getTypeid());
		filminfo.setFilmtype(filmtype);
		int result = fd.insertFilminfo(filminfo);
		if(result > 0) {
			response.sendRedirect("index.jsp");
		}else {
			response.sendRedirect("insert.jsp");
		}
		
	}

	private void selectFilminfoOp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,Object> map = new HashMap<String, Object>();
		if(request.getParameter("filmname")!=null && !"".equals(request.getParameter("filmname"))){
			map.put("filmname", request.getParameter("filmname"));
		}
		if(request.getParameter("typeid")!=null && !"".equals(request.getParameter("typeid"))){
			Integer typeid = Integer.parseInt(request.getParameter("typeid"));
			map.put("typeid", typeid);		
		}
		if(request.getParameter("actor")!=null && !"".equals(request.getParameter("actor"))){
			map.put("actor", request.getParameter("actor"));
		}
		if(request.getParameter("director")!=null && !"".equals(request.getParameter("director"))){
			map.put("director", request.getParameter("director"));
		}
		if(request.getParameter("maxprice")!=null && !"".equals(request.getParameter("minprice"))){
			map.put("maxprice",Double.parseDouble(request.getParameter("minprice")));
		}
		if(request.getParameter("maxprice")!=null && !"".equals(request.getParameter("maxprice"))){
			map.put("maxprice", Double.parseDouble(request.getParameter("maxprice")));
		}
		List<Filminfo> list = fd.selectFilminfo(map);
		session.setAttribute("filminfo", list);
		request.getRequestDispatcher("select.jsp").forward(request, response);
	}

	private void findAlltypeOp(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Filmtype> filmtype = fd.findAlltype();
		jm.setCode(1);
		jm.setObj(filmtype);
		super.outJsonString(jm, response);
	}

}
