package br.edu.cba.ifmt.Controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import br.edu.cba.ifmt.DAO.UserDAO;
import br.edu.cba.ifmt.Model.User;

public class UserDeleteController extends Action{
	private UserDAO _userDAO;
	public UserDeleteController() throws Exception{
		_userDAO = new UserDAO();
	}
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		ActionMessages messages = new ActionMessages();
		
		User user = _userDAO.getById(id);
		if (user == null) {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("user.delete.fail_user"));
	        saveMessages(request.getSession(), messages);
			return mapping.findForward("index");
		}
		
		try {
			boolean result = _userDAO.delete(id);
			if (result == false) {
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("user.delete.fail"));
		        saveMessages(request.getSession(), messages);
				return mapping.findForward("index");
			}

			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("user.delete.success"));
	        saveMessages(request.getSession(), messages);
			return mapping.findForward("index");

		} catch (Exception e) {
			System.err.println("Erro UserController.delete(): " + e.getMessage());
			request.setAttribute("erros", "Ocorreu um erro inesperado ao processar o formulário.");
			return mapping.getInputForward();
		}
	}
}
