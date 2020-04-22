/**
 * 
 */
package es.limit.cecocloud.fact.persist.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

import es.limit.cecocloud.fact.logic.api.dto.RegimIva;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un regim d'iva.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_rgi",
		indexes = {
				@Index(name = "iges_rgi_idf_fk", columnList = "rgi_idf_cod"),
				@Index(name = "irges_rgi_pk", columnList = "rgi_idf_cod,rgi_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "rgi_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "rgi_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "rgi_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "rgi_des", nullable = false, length = 30)),
	@AttributeOverride(name = "embedded.codiComptabilitat", column = @Column(name = "rgi_codcmp", length = 30)),
	@AttributeOverride(name = "embedded.tip", column = @Column(name = "rgi_tip", nullable = false, length = 1)),
	@AttributeOverride(name = "embedded.codiFacturaElectronica", column = @Column(name = "rgi_codele", length = 2)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "rgi_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "rgi_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "rgi_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "rgi_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "rgi_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_rgi_idf_fk"))
})
public class RegimIvaEntity extends AbstractWithIdentificadorAuditableEntity<RegimIva, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected RegimIva embedded;

	@Formula(value="(SELECT CONCAT(CONCAT(rgi.rgi_des,' - '),rgi.rgi_cod) FROM tges_rgi rgi where rgi.rgi_cod = rgi_cod and rgi.rgi_idf_cod = rgi_idf_cod)")
	private String descripcioCodiTxt;
	
	@Builder
	public RegimIvaEntity(
			WithIdentificadorAndCodiPk<String> pk,
			RegimIva embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(RegimIva embedded) {
		this.embedded = embedded;
	}

}
