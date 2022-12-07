package iotstar.vn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// super.service(response, response);
				response.setContentType("text/html");
				try (PrintWriter out = response.getWriter()) {
					out.println("service:Hello Service");
				}

	}
	@Override

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("test/html");
		try (PrintWriter out = response.getWriter()) {
			out.println("doGet:Hello doGet");
		}

	}

	@Override

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("test/html");
		try (PrintWriter out = response.getWriter()) {
			out.println("doPost:Hello doPost");
		}

	}

}
