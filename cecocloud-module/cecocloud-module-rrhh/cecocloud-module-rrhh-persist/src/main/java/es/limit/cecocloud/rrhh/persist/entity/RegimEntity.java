/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.entity;

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

import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableAmbIdentificador.AmbIdentificadorICodiPk;
import es.limit.cecocloud.rrhh.logic.api.dto.Regim;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un Regim.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "trhu_reg",
		indexes = {
				@Index(name = "irhu_reg_idf_fk", columnList = "reg_idf_cod"),
				@Index(name = "irrhu_reg_pk", columnList = "reg_idf_cod,reg_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "reg_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "reg_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "reg_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.presencia", column = @Column(name = "reg_prs", nullable = false)),
	@AttributeOverride(name = "embedded.contarHores", column = @Column(name = "reg_hor", nullable = false)),
	@AttributeOverride(name = "embedded.mantenirProximaEntrada", column = @Column(name = "reg_mntreg", nullable = false)),
	@AttributeOverride(name = "embedded.mostrarLlistatPlanificacio", column = @Column(name = "reg_pln", nullable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "reg_nom", length = 30)),
	@AttributeOverride(name = "embedded.numHoresLaborals", column = @Column(name = "reg_maxhorlab", length = 22)),
	@AttributeOverride(name = "embedded.numMinHoresLaborals", column = @Column(name = "reg_minhorlab", length = 22)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "reg_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "reg_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "reg_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "reg_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "reg_idf_cod", foreignKey = @ForeignKey(name = "rrhu_reg_idf_fk"), insertable = false, updatable = false)
			})
})
public class RegimEntity extends AbstractAmbIdentificadorEntity<Regim, AmbIdentificadorICodiPk<String>> {

	@Embedded
	protected Regim embedded;

	@Builder
	public RegimEntity(
			AmbIdentificadorICodiPk<String> pk,
			Regim embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;				
	}

	@Override
	public void update(Regim embedded) {
		this.embedded = embedded;
	}

}
