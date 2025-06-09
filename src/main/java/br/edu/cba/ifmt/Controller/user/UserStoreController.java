package br.edu.cba.ifmt.Controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

public class UserStoreController extends Action{
	private UserDAO _userDAO;
	private CityDAO _cityDAO;
	
	public UserStoreController() throws Exception{
		_userDAO = new UserDAO();
		_cityDAO = new CityDAO();
	}
	
	private void loadFormData(HttpServletRequest request) {
		List<City> cities = _cityDAO.getAll();
		request.setAttribute("cities", cities);
	}
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			UserDto userDto = (UserDto) form;
			ActionErrors errors = new ActionErrors();
			ActionMessages messages = new ActionMessages();
			
			City city = _cityDAO.getById(userDto.getCity().getId());
			if (city == null) {
				errors.add("city", new ActionMessage("O município não foi encontrado na base de dados!"));
				saveErrors(request, errors);
				
				loadFormData(request);
				return mapping.getInputForward();
			}

			User user = new User(
					userDto.getNome(), 
					userDto.getEmail(), 
					userDto.getCpf(), 
					new City(
							userDto.getCity().getId(), 
							userDto.getCity().getNome()
							)
					);
			
			boolean result = _userDAO.add(user);
			if (result == false) {
				System.out.println("erro na persistencia");

				errors.add("city", new ActionMessage("Erro ao criar o usuário."));
				saveErrors(request, errors);
				
				loadFormData(request);
				return mapping.getInputForward();
			}

			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("user.create.success"));
	        saveMessages(request.getSession(), messages);
			return mapping.findForward("index");

		} catch (Exception e) {
			System.err.println("Erro UserController.store(): " + e.getMessage());
			request.setAttribute("erros", "Ocorreu um erro inesperado ao processar o formulário.");
			return mapping.getInputForward();
		}
	}
}
