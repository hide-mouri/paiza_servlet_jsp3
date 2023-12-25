import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JobProfileServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		int jobId = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("message", "Hello Job " + jobId);

		String url = "jdbc:mysql://localhost/mydb?characterEncoding=UTF-8&serverTimezone=JST&useSSL=false";
		String user = "root";
		String password = "rootroot";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement statment = connection.prepareStatement("SELECT * FROM jobs WHERE jobs.id = ?")) {
			statment.setInt(1, jobId);
			ResultSet results = statment.executeQuery();

			while (results.next()) {

				String id = results.getString("id");
				request.setAttribute("id", id);

				String jobName = results.getString("jobName");
				request.setAttribute("jobName", jobName);

				String vitality = results.getString("vitality");
				request.setAttribute("vitality", vitality);

				String strength = results.getString("strength");
				request.setAttribute("strength", strength);

				String agility = results.getString("agility");
				request.setAttribute("agility", agility);

				String intelligence = results.getString("intelligence");
				request.setAttribute("intelligence", intelligence);

				String luck = results.getString("luck");
				request.setAttribute("luck", luck);
			}

		} catch (Exception e) {
			request.setAttribute("message", "Exception:" + e.getMessage());
		}

		String view = "/WEB-INF/views/jobProfile.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}
