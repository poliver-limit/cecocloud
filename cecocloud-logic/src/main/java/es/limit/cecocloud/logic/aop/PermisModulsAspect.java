/**
 * 
 */
package es.limit.cecocloud.logic.aop;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.service.AbstractAuthServiceImpl.BaseBootAuthenticationToken;
import es.limit.cecocloud.logic.api.dto.Companyia;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.exception.ModuleDeniedException;
import es.limit.cecocloud.logic.api.service.CompanyiaService;

/**
 * Aspecte per a controlar l'accés als diferents mòduls de l'aplicació.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
//@Aspect
public class PermisModulsAspect {

	@Autowired
	private CompanyiaService companyiaService;

	@Before("@within(org.springframework.stereotype.Service) && execution(public * *(..))")
	public void before(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		// Obtenim el mòdul a partir del nom del servei
		String modul = signature.getDeclaringTypeName().split("\\.")[3];
		// El mòdul comú és accessible a tothom
		if ("comu".equals(modul) || "boot".equals(modul)) {
			return;
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		// Si no estam autenticats no podem accedir a cap mòdul
		if (authentication == null) {
			throw new ModuleDeniedException(modul);
		}
		// Obtenim informació de l'usuari autenticat
		BaseBootAuthenticationToken auth = (BaseBootAuthenticationToken)authentication;
		String usuari = auth.getName();
		UserSession session = (UserSession)auth.getSession();
		Companyia companyia = null;
		Long companyiaId = session.getCompanyia();
		if (companyiaId != null) {
			try {
				companyia = companyiaService.getOne(companyiaId);
			} catch (EntityNotFoundException e) { }
		}
		if (companyia == null) {
			throw new ModuleDeniedException(usuari, modul);
		}
		List<String> modulsDisponibles = companyia.getLlicencia().getModulsDisponibles();
		// Comprovam l'accés de l'usuari al mòdul
		if (modulsDisponibles.lastIndexOf(modul) == -1) {
			throw new ModuleDeniedException(usuari, companyia.getCodi(), modul);
		}
	}

}
