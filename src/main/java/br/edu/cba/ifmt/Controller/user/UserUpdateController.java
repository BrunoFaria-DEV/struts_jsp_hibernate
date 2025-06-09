package br.edu.cba.ifmt.Controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import br.edu.cba.ifmt.DAO.CityDAO;
import br.edu.cba.ifmt.DAO.UserDAO;
import br.edu.cba.ifmt.DTO.UserDto;
import br.edu.cba.ifmt.Model.City;
import br.edu.cba.ifmt.Model.User;

public class UserUpdateController extends Action{
	private UserDAO _userDAO;
	private CityDAO _cityDAO;
	
	public UserUpdateController() throws Exception{
		_userDAO = new UserDAO();
		_cityDAO = new CityDAO();
	}
	
	private void loadFormData(HttpServletRequest request) {
		List<City> cities = _cityDAO.getAll();
		request.setAttribute("cities", cities);
	}
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		UserDto userDto = (UserDto) form;
		ActionErrors errors = new ActionErrors();
		ActionMessages messages = new ActionMessages();
		
		User user = _userDAO.getById(id);
		if (user == null) {
			errors.add("errors", new ActionMessage("O usuario não foi encontrado na base de dados!"));
			saveErrors(request, errors);
			
			loadFormData(request);
			return mapping.getInputForward();
		}
		
		City city = _cityDAO.getById(userDto.getCity().getId());
		if (city == null) {
			errors.add("city", new ActionMessage("O município não foi encontrado na base de dados!"));
			saveErrors(request, errors);
			
			loadFormData(request);
			return mapping.getInputForward();
		}
		
		try {
			user.setNome(userDto.getNome());
			user.setEmail(userDto.getEmail());
			user.setCpf(userDto.getCpf());
			user.setCity(city);
			
			boolean result = _userDAO.update(id, user);
			if (result == false) {
				System.out.println("erro na persistencia");

				errors.add("city", new ActionMessage("Erro ao editar o usuário."));
				saveErrors(request, errors);
				
				loadFormData(request);
				return mapping.getInputForward();
			}

			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("user.update.success"));
	        saveMessages(request.getSession(), messages);
			return mapping.findForward("index");

		} catch (Exception e) {
			System.err.println("Erro UserController.update(): " + e.getMessage());
			request.setAttribute("erros", "Ocorreu um erro inesperado ao processar o formulário.");
			return mapping.getInputForward();
		}
	}
}
