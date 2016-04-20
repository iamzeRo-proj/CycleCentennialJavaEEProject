package com.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Size;

import com.dao.LoginDAO;
import com.util.UserUtil;

@ManagedBean
@SessionScoped
public class Login implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;

	@Size(min = 4, message = "**please enter a valid password")
	private String pwd;
	
	private String msg;
	
	@Size(min = 8, max = 10, message = "**Username must be 9 characters")
	private String user;

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	// validate login
	public String validateUsernamePassword() {
		if (validateCheckCode()) {
			UserBean userBean = LoginDAO.validate(user, UserUtil.conver2MD5(pwd));
			if (userBean.getFirstName()!=null) {
				HttpSession session = SessionBean.getSession();
				session.setAttribute("username", userBean.getFirstName()+" "+userBean.getLastName());
				session.setAttribute("userId", userBean.getId());
				session.setAttribute("user", userBean);
				return "admin";
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Incorrect Username and Passowrd", "Please enter correct username and Password"));
				return "login";
			}			
		}
		return "login";
	}

	// logout event, invalidate session
	public String logout() {
		HttpSession session = SessionBean.getSession();
		session.invalidate();
		return "login";
	}

	public boolean validateCheckCode() {
		HttpSession session = SessionBean.getSession();
		String clientCheckCode = msg;
		String serverCheckCode = (String) session.getAttribute("checkCode");
		System.out.println(clientCheckCode + "   " + serverCheckCode);
		if (clientCheckCode.toUpperCase().equals(serverCheckCode.toUpperCase())) {
			return true;
		}
		return false;
	}
}