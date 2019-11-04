/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.limit.base.boot.logic.api.exception.InvalidLicenseException;
import es.limit.base.boot.logic.service.AbstractGenericServiceWithPermissionsImpl;
import es.limit.cecocloud.logic.api.dto.Companyia;
import es.limit.cecocloud.logic.api.dto.Llicencia;
import es.limit.cecocloud.logic.api.service.CompanyiaService;
import es.limit.cecocloud.logic.helper.AsymmetricCryptographyHelper;
import es.limit.cecocloud.persist.entity.CompanyiaEntity;

/**
 * Implementació del servei encarregat de gestionar companyies.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class CompanyiaServiceImpl extends AbstractGenericServiceWithPermissionsImpl<Companyia, CompanyiaEntity, Long> implements CompanyiaService {

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	@Transactional
	@Cacheable(value="companyia", key="#id")
	public Companyia getOne(Long id) {
		Companyia companyia = super.getOne(id);
		if (companyia.getLlicenciaKey() != null & !companyia.getLlicenciaKey().isEmpty()) {
			try {
				companyia.setLlicencia(objectMapper.readValue(
						AsymmetricCryptographyHelper.decryptText(companyia.getLlicenciaKey()), 
						Llicencia.class));
			} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException
					| InvalidKeySpecException | NoSuchPaddingException | IOException ex) {
				throw new InvalidLicenseException("No s'ha pogut desencriptar la llicència", ex);
			}
		}
		return companyia;
	}

	@Override
	@Transactional
	@CacheEvict(value="companyia", key="#id")
	public Companyia update(Long id, Companyia dto) {
		return super.update(id, dto);
	}

	@Override
	@Transactional
	@CacheEvict(value="companyia", key="#id")
	public void delete(Long id) {
		super.delete(id);
	}

}
