/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.limit.base.boot.persist.entity.AbstractAuditableCompositePkEntity;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableAmbIdentificadorICodi.AmbIdentificadorICodiPk;
import es.limit.cecocloud.facturacio.logic.api.dto.Tarifa;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una tarifa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_tar",
		indexes = {
				@Index(name = "iges_tar_idf_fk", columnList = "tar_idf_cod"),
				@Index(name = "irges_tar_pk", columnList = "tar_idf_cod,tar_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "tar_idf_cod", length = 4)),	
	@AttributeOverride(name = "id.codi", column = @Column(name = "tar_cod", length = 4)),
	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "tar_cod", length = 4, insertable = false, updatable = false)),	
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "tar_des", length = 30, nullable = false)),			
	@AttributeOverride(name = "embedded.percentatgeMaterial", column = @Column(name = "tar_ptemat", nullable = false)),			
	@AttributeOverride(name = "embedded.percentatgeMaObra", column = @Column(name = "tar_ptemanobr", nullable = false)),			
	@AttributeOverride(name = "embedded.tarifaTipus", column = @Column(name = "tar_tip", length = 1)),			
	@AttributeOverride(name = "embedded.formaCalcul", column = @Column(name = "tar_calpvp", length = 1)),			
	@AttributeOverride(name = "embedded.actualitzarPreu", column = @Column(name = "tar_canpru", length = 1)),			
	@AttributeOverride(name = "embedded.tarifaOferta", column = @Column(name = "tar_ofr", length = 1)),			
	@AttributeOverride(name = "embedded.descomptesGenerals", column = @Column(name = "tar_dtegen", length = 1)),			
	@AttributeOverride(name = "embedded.dataInici", column = @Column(name = "tar_diaini")),			
	@AttributeOverride(name = "embedded.dataFi", column = @Column(name = "tar_diafin")),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "tar_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "tar_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "tar_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "tar_datmod"))
})
public class TarifaEntity extends AbstractAuditableCompositePkEntity<Tarifa, AmbIdentificadorICodiPk<String>> {

	@Embedded
	protected Tarifa embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "tar_idf_cod",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "rges_tar_idf_fk"))
	protected IdentificadorEntity identificador;	

	@Builder
	public TarifaEntity(
			AmbIdentificadorICodiPk<String> pk,
			Tarifa embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;	
	}

	@Override
	public void update(Tarifa embedded) {
		this.embedded = embedded;
	}

}
