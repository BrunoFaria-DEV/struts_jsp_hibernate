package br.edu.cba.ifmt.Controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.edu.cba.ifmt.DAO.CityDAO;
import br.edu.cba.ifmt.Model.City;

public class UserCreateController extends Action{
	private CityDAO _cityDAO;

	public UserCreateController() {
		_cityDAO = new CityDAO();
	}

	private void loadFormData(HttpServletRequest request) {
		List<City> cities = _cityDAO.getAll();
		request.setAttribute("cities", cities);
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		loadFormData(request);
		return mapping.findForward("create");
	}
}
