/**
 * 
 */
package es.limit.cecocloud.marc.logic.api.validation;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import es.limit.cecocloud.logic.api.dto.OperariEmpresa;
import es.limit.cecocloud.logic.api.service.OperariEmpresaService;
import es.limit.cecocloud.marc.logic.api.dto.AdressaIp;
import es.limit.cecocloud.marc.logic.api.dto.Marcatge;
import es.limit.cecocloud.marc.logic.api.service.AdressaIpService;

/**
 * Validador de l'adreça IP des de la qual es fa el marcatge. Si
 * existeix alguna adreça donada d'alta a dins la taula d'IPs vàlides
 * aleshores es valida que l'adreça es de la qual s'ha fet la petició
 * sigui una d'aquestes.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class MarcatgeAdressaIpAutoritzadaValidator implements ConstraintValidator<MarcatgeAdressaIpAutoritzada, Marcatge> {

	@Autowired
	private OperariEmpresaService operariEmpresaService;
	@Autowired
	private AdressaIpService adressaIpService;

	@Override
	public void initialize(MarcatgeAdressaIpAutoritzada constraintAnnotation) {
	}

	@Override
	public boolean isValid(
			Marcatge marcatge,
			ConstraintValidatorContext context) {
		if (marcatge.getOperariEmpresa() != null) {
			OperariEmpresa operariEmpresa = operariEmpresaService.getOne(marcatge.getOperariEmpresa().getId());
			List<AdressaIp> adreces = adressaIpService.findByQuickFilterAndRsqlQuery(
					null,
					"empresa.id==" + operariEmpresa.getId(),
					Sort.unsorted());
			if (adreces != null && !adreces.isEmpty()) {
				String marcatgeAdresaIp = marcatge.getAdressaIp();
				Optional<AdressaIp> adressaTrobada = adreces.stream().filter(adressa -> marcatgeAdresaIp.equals(adressa.getAdressa())).findFirst();
				return adressaTrobada.isPresent();
			}
		}
		return true;
	}

}
