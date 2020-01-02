package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.sqlUntil;

/**
 * Servlet implementation class Ajax_let1
 */
@WebServlet("/Ajax_let1")
public class Ajax_let1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajax_let1() {
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
		String act=request.getParameter("key1");
		String pwd=request.getParameter("key2");
		System.out.println(act+" "+pwd);
		String massge="zhuche";
		
		try {
			Connection con=sqlUntil.getConnection();
			Statement stat=con.createStatement();
			String sql="select id from web1 where account='"+act+"'and password='"+pwd+"'";
			System.out.println(sql);
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()) {
				String id=rs.getString("id");
				
				if(id!=null) {
					System.out.println("√‹¬Î’˝»∑");
					massge="1";
					break;
				}
			}
			con.close();
			PrintWriter out=response.getWriter();
			System.out.println(massge);
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
