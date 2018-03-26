package tinder.comidas.ec.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import tinder.comidas.ec.enums.TipoUsuario;
import tinder.comidas.ec.model.Usuario;
import tinder.comidas.ec.service.UsuarioService;
import tinder.comidas.ec.util.SessionUtils;


@ManagedBean(name = "loginManager")
@SessionScoped
public class LoginController {

	private String usuario;
	private String password;
	private String msg;
	
	@Inject
	UsuarioService usuarioService;
	
	public String validateUsuarioPassword(){
		
		Usuario user = usuarioService.validate(usuario, password);
		
		if(user != null){
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", user.getNombre());
			session.setAttribute("userid", user.getId());
			
			if(user.getTipoUsuario().equals(TipoUsuario.ADMIN)){
				return "admin";
			}else{
				return "normal";
			}
			
			
		}else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrecto Usuario o Password",
							"Por favor ingrese nuevamente!"));
			return "login";
		}
	}
	
	public String logout(){
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "/login.xhtml";
	}
	
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
