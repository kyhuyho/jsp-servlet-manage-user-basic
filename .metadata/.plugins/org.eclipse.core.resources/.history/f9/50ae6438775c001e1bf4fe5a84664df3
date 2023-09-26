package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import repository.UserRepo;

@WebServlet(urlPatterns = "/user/search")
public class UserListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> list = UserRepo.getAllUser();
		req.setAttribute("listUser", list);
		req.getRequestDispatcher("/views/user.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		List<User> listUser = UserRepo.search(name);
		req.setAttribute("listUser", listUser);
		req.getRequestDispatcher("/views/user.jsp").forward(req, resp);

	}
}
