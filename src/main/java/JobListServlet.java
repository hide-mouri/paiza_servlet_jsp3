import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JobListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		request.setAttribute("message", "Jobリスト");

		String url = "jdbc:mysql://localhost/mydb?characterEncoding=UTF-8&serverTimezone=JST&useSSL=false";
		String user = "root";
		String password = "rootroot";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement statment = connection.prepareStatement("SELECT * FROM jobs");
				ResultSet results = statment.executeQuery()) {

			ArrayList<HashMap<String, String>> rows = new ArrayList<HashMap<String, String>>();

			while (results.next()) {
				HashMap<String, String> columns = new HashMap<String, String>();

				String id = results.getString("id");
				columns.put("id", id);

				String jobName = results.getString("jobName");
				columns.put("jobName", jobName);

				String vitality = results.getString("vitality");
				columns.put("vitality", vitality);

				String strength = results.getString("strength");
				columns.put("strength", strength);

				String agility = results.getString("agility");
				columns.put("agility", agility);

				String intelligence = results.getString("intelligence");
				columns.put("intelligence", intelligence);

				String luck = results.getString("luck");
				columns.put("luck", luck);

				rows.add(columns);
			}

			request.setAttribute("rows", rows);

		} catch (Exception e) {
			request.setAttribute("message", "Exception:" + e.getMessage());
		}

		String view = "/WEB-INF/views/jobList.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}
