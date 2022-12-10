package iotstar.vn.controller.Web;

import java.awt.desktop.UserSessionEvent;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iotstar.vn.Service.IUserService;
import iotstar.vn.Service.Impl.IUserServiceImpl;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@WebServlet(urlPatterns = { "/forgetpass/email" })
public class ForgetPassController extends HttpServlet {

	private static final String alpha = "abcdefghijklmnopqrstuvwxyz"; // a-z
	private static final String alphaUpperCase = alpha.toUpperCase(); // A-Z
	private static final String digits = "0123456789"; // 0-9
	private static final String specials = "~=+%^*/()[]{}/!@#$?|";
	private static final String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;
	private static final String ALL = alpha + alphaUpperCase + digits + specials;
	private static Random generator = new Random();
	IUserService userService = new IUserServiceImpl();

	public ForgetPassController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/emailforget.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String username = "andanhs1221@gmail.com";
		final String password = "xtlnykzoudxyhdts";
		String email = req.getParameter("email");
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
			message.setSubject("Quên mật khẩu tài khoản");
			message.setText("Mật khẩu mới của bạn là : " + code);

			Transport.send(message);

			System.out.println("Done");
			Cookie codeCookie = new Cookie("code",code);
			Cookie emailForget = new Cookie("emailForget",email);
			codeCookie.setMaxAge(60*5);
			emailForget.setMaxAge(60*5);
			resp.addCookie(emailForget);
			resp.addCookie(codeCookie);
			//Cập nhật mật khẩu mới cho email
			userService.updatePass(email, code);
			resp.sendRedirect(req.getContextPath()+ "/forgetpass/changepass");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = req.getRequestDispatcher("views/sendemail.jsp");
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
