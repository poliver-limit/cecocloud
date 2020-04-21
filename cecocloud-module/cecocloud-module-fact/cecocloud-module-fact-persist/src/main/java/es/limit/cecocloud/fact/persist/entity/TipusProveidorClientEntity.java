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

import es.limit.cecocloud.fact.logic.api.dto.TipusProveidorClient;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un tipus proveidorClient.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_tip",
		indexes = {
				@Index(name = "iges_tip_idf_fk", columnList = "tip_idf_cod"),
				@Index(name = "irges_tip_pk", columnList = "tip_idf_cod,tip_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "tip_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "tip_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "tip_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "tip_des", length = 30, nullable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "tip_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "tip_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "tip_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "tip_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "tip_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_tip_idf_fk"))
})
public class TipusProveidorClientEntity extends AbstractWithIdentificadorAuditableEntity<TipusProveidorClient, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected TipusProveidorClient embedded;
	
	@Formula(value="(SELECT CONCAT(CONCAT(tip.tip_des,' - '),tip.tip_cod) FROM tges_tip tip where tip.tip_cod = tip_cod and tip.tip_idf_cod = tip_idf_cod)")
	private String descripcioCodiTxt;

	@Builder
	public TipusProveidorClientEntity(
			WithIdentificadorAndCodiPk<String> pk,
			TipusProveidorClient embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(TipusProveidorClient embedded) {
		this.embedded = embedded;
	}

}
