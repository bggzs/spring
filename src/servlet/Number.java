package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.sqlUntil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class Number
 */
@WebServlet("/Number")
public class Number extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Number() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String number=request.getParameter("key1");
		System.out.println(number);
		try {
			Connection con=sqlUntil.getConnection();
			Statement stat=con.createStatement();
			String sql="select * from xinxi1 where number="+number+"";
			ResultSet rs=stat.executeQuery(sql);
			ResultSetMetaData metaData=rs.getMetaData();
			int columnCount=metaData.getColumnCount();
            JSONArray array = new JSONArray();
            while(rs.next()) {
           	 JSONObject jsonobj=new JSONObject();
            	for(int i=1;i<=columnCount;i++) {
            		String coulmnName=metaData.getColumnName(i);
            		String value=rs.getString(coulmnName);
            		jsonobj.put(coulmnName, value);
            	}
            	array.add(jsonobj);
            }
        	String massge=array.toString();
        	System.out.println(massge);
            con.close();
            PrintWriter out=response.getWriter();
            out.print(massge);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
