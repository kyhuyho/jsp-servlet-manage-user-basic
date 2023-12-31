package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.UserRepo;

@WebServlet(urlPatterns = "/user/delete")
public class UserDeleteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		UserRepo.deleteUser(Integer.parseInt(id));
		resp.sendRedirect(req.getContextPath() + "/user/search");
	}
}
