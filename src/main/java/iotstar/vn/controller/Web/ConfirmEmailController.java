package iotstar.vn.controller.Web;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

/**
 * Servlet implementation class ConfirmEmailController
 */
@WebServlet(urlPatterns = { "/register/confirm-email", "/register/confirm-code" })
public class ConfirmEmailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String alpha = "abcdefghijklmnopqrstuvwxyz"; // a-z
	private static final String alphaUpperCase = alpha.toUpperCase(); // A-Z
	private static final String digits = "0123456789"; // 0-9
	private static final String specials = "~=+%^*/()[]{}/!@#$?|";
	private static final String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;
	private static Random generator = new Random();

	public ConfirmEmailController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		if (url.contains("register/confirm-email")) {
			ConfirmEmail(request, response);
		}
		if (url.contains("register/confirm-code")) {
			ConfirmCode(request, response);
		}
	}

	protected void ConfirmEmail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/confirmemail.jsp");
		dispatcher.forward(request, response);
	}

	protected void ConfirmCode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/confirmcode.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		if (url.contains("register/confirm-email")) {
			PostConfirmEmail(request, response);
		}
		if (url.contains("register/confirm-code")) {
			PostConfirmCode(request, response);
		}
	}
	protected void PostConfirmEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		final String username = "andanhs1221@gmail.com";
		final String password = "xtlnykzoudxyhdts";
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); // TLS

		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			String code = randomAlphaNumeric(6);
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(email));
			message.setSubject("Xac nhan email");
			message.setText("Ma xac nhan cua ban la : " + code);
			Transport.send(message);
			System.out.println("Done");
			request.setAttribute("confirmcode", code);
			request.setAttribute("emailRegister", email);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/confirmcode.jsp");
			dispatcher.forward(request, response);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	protected void PostConfirmCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailRegister = request.getParameter("emailRegister");
		String confirmCode = request.getParameter("confirmcode").trim();
		String confirmCodeEnter = request.getParameter("confirmCodeEnter").trim();
		if(confirmCode.compareTo(confirmCodeEnter)==0)
		{
			request.setAttribute("emailRegister", emailRegister);
			request.getRequestDispatcher("/views/register.jsp").forward(request, response);
		}
		else {
			request.setAttribute("mess", "Ma xac nhan sai");
			request.getRequestDispatcher("/views/confirmcode.jsp").forward(request, response);
		}
	}
	public String randomAlphaNumeric(int numberOfCharactor) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numberOfCharactor; i++) {
			int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
			char ch = ALPHA_NUMERIC.charAt(number);
			sb.append(ch);
		}
		return sb.toString();
	}

	public static int randomNumber(int min, int max) {
		return generator.nextInt((max - min) + 1) + min;
	}
}
