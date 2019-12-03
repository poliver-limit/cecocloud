package es.limit.cecocloud.logic.helper;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.api.dto.util.AuthenticationFacade;
import es.limit.base.boot.logic.api.exception.InvalidAuthenticationTokenException;
import es.limit.base.boot.logic.api.exception.InvalidUserSessionException;
import es.limit.base.boot.logic.api.permission.BaseBootAuthenticationToken;
import es.limit.cecocloud.logic.api.dto.UserSession;

@Component
public class AuthenticationTokenHelper {

	@Autowired
	AuthenticationFacade authenticationFacade;
	
	public BaseBootAuthenticationToken getAuthentication() {
		BaseBootAuthenticationToken baseBootAuthenticationToken = null;
		Authentication authentication = authenticationFacade.getAuthentication();
		if (authentication != null) {
			if (authentication instanceof BaseBootAuthenticationToken) {
				baseBootAuthenticationToken = (BaseBootAuthenticationToken)authentication;
			} else {
				throw new InvalidAuthenticationTokenException(authentication, "Tipus d'autenticació no vàlida.");
			}
		}
		return baseBootAuthenticationToken;
	}
	
	public String getAuthenticationUserName() {
		return getAuthentication().getName();
	}
	
	public Collection<GrantedAuthority> getAuthenticationAuthorities() {
		return getAuthentication().getAuthorities();
	}
	
	public Object getDetails() {
		return getAuthentication().getDetails();
	}
	
	public UserSession getAuthenticationUserSession() {
		UserSession userSession = null;
		Object session = getAuthentication().getSession();
		if (session != null) {
			if (session instanceof UserSession) {
				userSession = (UserSession)session;
			} else {
				throw new InvalidUserSessionException(session, "Tipus de sessió no vàlida.");
			}
		}
		return userSession;
	}
	
	public Long getAuthenticationCompanyiaId() {
		return getAuthenticationUserSession().getC();
	}
	
	public Long getAuthenticationEmpresaId() {
		return getAuthenticationUserSession().getE();
	}
}
