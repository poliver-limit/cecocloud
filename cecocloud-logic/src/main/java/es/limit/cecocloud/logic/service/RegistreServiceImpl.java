/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.limit.cecocloud.logic.api.dto.RegistreUsuari;
import es.limit.cecocloud.logic.api.dto.RegistreValidate;
import es.limit.cecocloud.logic.api.dto.Rol;
import es.limit.cecocloud.logic.api.dto.Usuari;
import es.limit.cecocloud.logic.api.service.RegistreService;
import es.limit.cecocloud.logic.helper.TokenHelper;
import es.limit.cecocloud.persist.entity.UsuariEntity;
import es.limit.cecocloud.persist.repository.UsuariRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

/**
 * Implementació del servei encarregat de gestionar usuaris.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class RegistreServiceImpl implements RegistreService {

	private static final String CECOCLOUD_BASE_URL = "http://oficina.limit.es/cecocloud";

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private TokenHelper tokenHelper;
	@Autowired
	private UsuariRepository usuariRepository;
	@Autowired
	private JavaMailSender javaMailSender;
	@Value("${spring.mail.properties.mail.smtp.from}")
	private String mailSmtpFrom;

	@Override
	@Transactional
	public void create(RegistreUsuari dto) {
		Usuari usuari = new Usuari();
		usuari.setCodi(dto.getCodi());
		usuari.setNom(dto.getNom());
		usuari.setEmail(dto.getEmail());
		usuari.setActiu(true);
		usuari.setRols(new HashSet<Rol>(Arrays.asList(Rol.MARCA)));
		UsuariEntity entity = UsuariEntity.builder().embedded(usuari).build();
		usuariRepository.save(entity);
		enviarEmailValidacio(usuari);
	}

	@Override
	@Transactional(readOnly = true)
	public void contrasenyaRecover(String email) {
		Optional<UsuariEntity> usuari = usuariRepository.findByEmbeddedEmail(email);
		enviarEmailRecuperacio(usuari.get().getEmbedded());
	}

	@Override
	@Transactional
	public void validate(RegistreValidate dto) {
		String token = dto.getToken();
		Jws<Claims> parsedToken = tokenHelper.validate(token, false);
		String codi = parsedToken.getBody().getSubject();
		Optional<UsuariEntity> usuari = usuariRepository.findByEmbeddedCodi(codi);
		usuari.get().updateContrasenya(passwordEncoder.encode(dto.getContrasenya()));
	}

	private void enviarEmailValidacio(
			Usuari usuari) {
		String token = tokenHelper.buildValidate(usuari);
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom(mailSmtpFrom);
        msg.setTo(usuari.getEmail());
        msg.setSubject("CECOCLOUD: registre d'usuari");
        msg.setText("Per a completar el registre haurà d'accedir a la pàgina de validació utilitzant el següent enllaç: " + CECOCLOUD_BASE_URL + "/registre/validate/" + token);
        javaMailSender.send(msg);
	}

	private void enviarEmailRecuperacio(
			Usuari usuari) {
		String token = tokenHelper.buildRecover(usuari);
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom(mailSmtpFrom);
        msg.setTo(usuari.getEmail());
        msg.setSubject("CECOCLOUD: recuperació de contrasenya");
        msg.setText("Per a canviar la contrasenya d'usuari haurà d'accedir a la pàgina de validació utilitzant el següent enllaç: " + CECOCLOUD_BASE_URL + "/registre/validate/" + token);
        javaMailSender.send(msg);
	}

}
