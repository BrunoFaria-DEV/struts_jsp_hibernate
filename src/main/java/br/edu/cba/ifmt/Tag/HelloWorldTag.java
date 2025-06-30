package br.edu.cba.ifmt.Tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloWorldTag extends TagSupport{
	private String name;
	private String style;

	public void setName(String name) {
		this.name = name;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter jspWriter = pageContext.getOut();
			jspWriter.write("<div class=\"" + style + "\">");
			jspWriter.write("<label class=\"" + style + "\">Taglib HelloWord</label><br>");
			jspWriter.write("<select name=\"top\" class=\"" + style + "\">");
			jspWriter.write("<option value=\"\">escolha uma opção</option>");
			jspWriter.write("<option value=\"1\">Olá mundo. Seja bem vindo a tela: " + name + "!</option>");
			jspWriter.write("</select>");
			jspWriter.write("</div>");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return SKIP_BODY;
	}
}
