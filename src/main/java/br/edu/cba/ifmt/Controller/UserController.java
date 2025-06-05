package br.edu.cba.ifmt.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import br.edu.cba.ifmt.DTO.UserDto;

public class UserController extends DispatchAction {
	public ActionForward inicio(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("index()");
		
		return mapping.findForward("index");
	}
	
	public ActionForward novo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("create()");
		
		return mapping.findForward("novo");
	}
	
	public ActionForward salvar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("store()");
		
		return mapping.findForward("index");
	}
	
	public ActionForward editar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("edit()");
		
		return mapping.findForward("editar");
	}
	
	public ActionForward atualizar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("update()");
		
		return mapping.findForward("index");
	}
}
