package com.test.spring.di.ex03;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DB {
	
	public ArrayList<String> getList() {
		
		//DB로부터 회원 명단 가져오기
		
		try {

			Connection conn = null;
			Statement stat = null;
			ResultSet rs = null;
			
			String sql = "select name from tblUser order by name asc";
			
			conn = DBUtil.open();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			ArrayList<String> list = new ArrayList<String>();
			
			while (rs.next()) {
				list.add(rs.getString("name"));
			}
			
			return list;			

		} catch (Exception e) {
			System.out.println("DB.getList()");
			e.printStackTrace();
		}
		
		return null;
	}

}





