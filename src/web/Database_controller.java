package web;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Database_controller {
	private ResultSetMetaData rsmd;
	//private HashMap<String, ArrayList<String>> colMap = new HashMap<>();
	private ArrayList<ArrayList> colMap = new ArrayList<>();

	@Autowired DBDao dao;
	
	@RequestMapping("GetSQL.do")
	public ModelAndView GetSQL(@RequestParam("input") String input) throws SQLException{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		ResultSet rs = dao.getSQL(input);
		String colName = "";
		String colString = "";
		rsmd = rs.getMetaData();
		int numCol = rsmd.getColumnCount();
		ArrayList<String> headers = new ArrayList<>();
		for(int i = 1; i<= numCol; i++){
			headers.add(rsmd.getColumnLabel(i));
		}
		
		mv.addObject("headers", headers);
		ArrayList<String> smallList = new ArrayList<>();
				while(rs.next()){
					ArrayList<String> row = new ArrayList<>();
					for(int i = 1; i<=numCol; i++){
						colString = rs.getString(i);
						row.add(colString);
						//System.out.println(colString);	
					}
					colMap.add(row);
		}
		mv.addObject("colMap", colMap);
		//rs.close();
		return mv;
	}
}

