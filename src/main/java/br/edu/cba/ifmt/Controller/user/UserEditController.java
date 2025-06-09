package br.edu.cba.ifmt.Controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
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

public class UserEditController extends Action{
	private UserDAO _userDAO;
	private CityDAO _cityDAO;
	
	public UserEditController() throws Exception{
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
		ActionMessages messages = new ActionMessages();
		UserDto userDto = (UserDto) form;
		
		User user = _userDAO.getById(id);
		if (user == null) {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("user.not_found"));
	        saveMessages(request.getSession(), messages);
			return mapping.findForward("index");
		}
		
        userDto.setId(user.getId());
        userDto.setNome(user.getNome());
        userDto.setEmail(user.getEmail());
        userDto.setCpf(user.getCpf());
        if (user.getCity() != null) {
            userDto.getCity().setId(user.getCity().getId());
        }
		
		loadFormData(request);
		
		System.out.println("Usuario encontrado id: " + user.getId());
		return mapping.findForward("edit");
	}
}
