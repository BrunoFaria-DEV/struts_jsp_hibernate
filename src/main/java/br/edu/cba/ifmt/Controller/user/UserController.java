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

	
	/*
	 * public ActionForward inicio(ActionMapping mapping, ActionForm form,
	 * HttpServletRequest request, HttpServletResponse response) throws Exception {
	 * List<User> users = _userDAO.getAll();
	 * 
	 * System.out.println("inicio(): "); request.setAttribute("users", users);
	 * return mapping.findForward("inicio"); }
	 * 
	 * public ActionForward novo(ActionMapping mapping, ActionForm form,
	 * HttpServletRequest request, HttpServletResponse response) throws Exception {
	 * List<City> cities = _cityDAO.getAll();
	 * 
	 * System.out.println("novo(): "); request.setAttribute("cities", cities);
	 * return mapping.findForward("novo"); }
	 * 
	 * public ActionForward salvar(ActionMapping mapping, ActionForm form,
	 * HttpServletRequest request, HttpServletResponse response) throws Exception {
	 * try { UserDto userDto = (UserDto) form;
	 * 
	 * //Informações sobre o mapeamento System.out.println("salvar(): ");
	 * 
	 * ActionErrors errors = new ActionErrors();
	 * 
	 * City city = _cityDAO.getById(userDto.getCity().getId()); if (city == null) {
	 * errors.add("city", new
	 * ActionMessage("O município não foi encontrado na base de dados!"));
	 * saveErrors(request, errors); return mapping.getInputForward(); }
	 * 
	 * User user = new User( userDto.getNome(), userDto.getEmail(),
	 * userDto.getCpf(), new City( userDto.getCity().getId(),
	 * userDto.getCity().getNome() ) );
	 * 
	 * boolean result = _userDAO.add(user); if (result == false) {
	 * System.out.println("erro na persistencia");
	 * 
	 * errors.add("city", new ActionMessage("Erro ao criar o usuário."));
	 * saveErrors(request, errors); return mapping.getInputForward(); }
	 * 
	 * request.getSession().setAttribute("success", "Usuário criado com sucesso!");
	 * return mapping.findForward("inicio");
	 * 
	 * } catch (Exception e) { System.err.println("Erro UserController.store(): " +
	 * e.getMessage()); request.setAttribute("erros",
	 * "Ocorreu um erro inesperado ao processar o formulário."); return
	 * mapping.findForward("novo"); } }
	 * 
	 * public ActionForward editar(ActionMapping mapping, ActionForm form,
	 * HttpServletRequest request, HttpServletResponse response) throws Exception {
	 * int id = Integer.parseInt(request.getParameter("id"));
	 * 
	 * User user = _userDAO.getById(id); if (user == null) {
	 * request.getSession().setAttribute("erros", "Usuário não encontrado."); return
	 * mapping.findForward("index"); }
	 * 
	 * List<City> cities = _cityDAO.getAll();
	 * 
	 * request.setAttribute("cities", cities); request.setAttribute("user", user);
	 * 
	 * System.out.println("editar(): "); return mapping.findForward("editar"); }
	 * 
	 * public ActionForward atualizar(ActionMapping mapping, ActionForm form,
	 * HttpServletRequest request, HttpServletResponse response) throws Exception {
	 * int id = Integer.parseInt(request.getPathInfo().substring(1));
	 * 
	 * User user = _userDAO.getById(id); if (user == null) {
	 * request.getSession().setAttribute("erros",
	 * "O usuário não foi encontrado na base de dados!");
	 * response.sendRedirect(request.getContextPath() + "/usuarios"); return
	 * mapping.findForward("editar"); }
	 * 
	 * String nome = request.getParameter("nome"); String email =
	 * request.getParameter("email"); String cpf = request.getParameter("cpf"); int
	 * municipio_id = Integer.parseInt(request.getParameter("municipio_id"));
	 * 
	 * City city = _cityDAO.getById(municipio_id);
	 * 
	 * if (city == null) { request.getSession().setAttribute("erros",
	 * "O município não foi encontrado na base de dados!");
	 * response.sendRedirect(request.getContextPath() + "/usuarios/novo"); return; }
	 * 
	 * try {
	 * 
	 * user.setNome(nome); user.setEmail(email); user.setCPF(cpf);
	 * user.setCity(city);
	 * 
	 * boolean result = _userDAO.update(id, user); if (result == false) {
	 * System.out.println("erro na persistencia");
	 * request.getSession().setAttribute("erros", "Erro ao editar o usuário.");
	 * response.sendRedirect(request.getContextPath() + "/usuarios/novo"); return; }
	 * 
	 * request.getSession().setAttribute("success", "Usuário editado com sucesso!");
	 * response.sendRedirect(request.getContextPath() + "/usuarios");
	 * 
	 * } catch (Exception e) { System.err.println("Erro UserController.update(): " +
	 * e.getMessage()); request.getSession().setAttribute("erros",
	 * "Ocorreu um erro inesperado ao processar o formulário.");
	 * response.sendRedirect(request.getContextPath() + "/usuarios"); }
	 * 
	 * return mapping.findForward("index"); }
	 * 
	 * public ActionForward excluir(ActionMapping mapping, ActionForm form,
	 * HttpServletRequest request, HttpServletResponse response) throws Exception {
	 * 
	 * System.out.println("update()");
	 * 
	 * return mapping.findForward("index"); }
	 */
}
