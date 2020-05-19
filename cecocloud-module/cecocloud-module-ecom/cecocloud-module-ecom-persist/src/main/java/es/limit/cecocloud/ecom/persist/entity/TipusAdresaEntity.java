/**
 * 
 */
package es.limit.cecocloud.ecom.persist.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Formula;

import es.limit.base.boot.persist.entity.AbstractEntity;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.logic.api.dto.TipusAdresa;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació sobre el TipusAdresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomTipusAdresaEntity")
@Table(
		name = "tcom_tad",
		uniqueConstraints = {
		@UniqueConstraint(name = "rcom_tad_pk", columnNames = "tad_cod")
		}				
)

@AttributeOverrides({
	@AttributeOverride(name = "id", column = @Column(name = "tad_cod")),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "tad_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "tad_des", length = 30, nullable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "tad_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "tad_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "tad_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "tad_datmod"))
})

public class TipusAdresaEntity extends AbstractEntity<TipusAdresa, String>{
	
	@Embedded
	protected TipusAdresa embedded;
	
	@Formula(value="(SELECT CONCAT(CONCAT(tad.tad_des,' - '),tad.tad_cod) FROM tcom_tad tad where tad.tad_cod = tad_cod)")
	private String descripcioCodiTxt;

	@Builder
	public TipusAdresaEntity(
			WithIdentificadorAndCodiPk<String> pk,
			TipusAdresa embedded,
			IdentificadorEntity identificador
			) {

		this.embedded = embedded;

	}

	@Override
	public void update(TipusAdresa embedded) {
		this.embedded = embedded;
	}

	
}

