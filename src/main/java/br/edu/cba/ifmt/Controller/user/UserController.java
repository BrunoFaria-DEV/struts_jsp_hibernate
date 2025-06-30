package br.edu.cba.ifmt.Controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.edu.cba.ifmt.DAO.CityDAO;
import br.edu.cba.ifmt.DAO.UserDAO;
import br.edu.cba.ifmt.Model.User;

public class UserController extends Action{
	private UserDAO _userDAO;
	public UserController() throws Exception{
		_userDAO = new UserDAO();
		new CityDAO();
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<User> users = _userDAO.getAll();

		System.out.println("UserController(): ");
		request.setAttribute("users", users);
		return mapping.findForward("index");
	}

}
