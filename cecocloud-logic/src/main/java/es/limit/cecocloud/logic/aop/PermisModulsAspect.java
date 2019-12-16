/**
 * 
 */
package es.limit.cecocloud.logic.aop;

import javax.persistence.EntityNotFoundException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.api.permission.BaseBootAuthenticationToken;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.exception.ModuleDeniedException;
import es.limit.cecocloud.logic.api.service.IdentificadorService;

/**
 * Aspecte per a controlar l'accés als diferents mòduls de l'aplicació.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
//@Aspect
public class PermisModulsAspect {

	@Autowired
	private IdentificadorService identificadorService;

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
		Identificador identificador = null;
		Long identificadorId = session.getI();
		if (identificadorId != null) {
			try {
				identificador = identificadorService.getOne(identificadorId);
			} catch (EntityNotFoundException e) { }
		}
		if (identificador == null) {
			throw new ModuleDeniedException(usuari, modul);
		}
		 
//		List<String> modulsDisponibles = identificador.getLlicencia().getModulsDisponibles();
//		// Comprovam l'accés de l'usuari al mòdul
//		if (modulsDisponibles.lastIndexOf(modul) == -1) {
//			throw new ModuleDeniedException(usuari, companyia.getCodi(), modul);
//		}
	}

}
