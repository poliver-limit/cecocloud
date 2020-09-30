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
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.limit.cecocloud.fact.logic.api.dto.PreuPerGamma;
import es.limit.cecocloud.fact.logic.api.dto.PreuPerGamma.PreuPerGammaPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació de preu per gamma.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "factPreuPerGammaEntity")
@Table(
		name = "tges_pbu",
		indexes = {
				@Index(name = "iges_pbu_idf_fk", columnList = "pbu_idf_cod"),
				@Index(name = "irges_pbu_pk", columnList = "pbu_idf_cod, pbu_gma_cod, pbu_tra_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "pbu_idf_cod", length = 4)),
	@AttributeOverride(name = "id.gammaCodi", column = @Column(name = "pbu_gma_cod", length = 4)),
	@AttributeOverride(name = "id.transportistaCodi", column = @Column(name = "pbu_tra_cod", length = 15)),
	
	@AttributeOverride(name = "embedded.preu1", column = @Column(name = "pbu_pru001", length = 22, precision = 17, scale = 5)),
	@AttributeOverride(name = "embedded.preu2", column = @Column(name = "pbu_pru002", length = 22, precision = 17, scale = 5)),
	@AttributeOverride(name = "embedded.preu3", column = @Column(name = "pbu_pru003", length = 22, precision = 17, scale = 5)),
	@AttributeOverride(name = "embedded.preu4", column = @Column(name = "pbu_pru004", length = 22, precision = 17, scale = 5)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "pbu_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "pbu_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "pbu_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "pbu_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "pbu_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_pbu_idf_fk"))
})
public class PreuPerGammaEntity extends AbstractWithIdentificadorAuditableEntity<PreuPerGamma, PreuPerGammaPk> {

	@Embedded
	protected PreuPerGamma embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "pbu_idf_cod", referencedColumnName = "gma_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "pbu_gma_cod", referencedColumnName = "gma_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_pbu_gma_fk"))			
	protected ArticleGammaEntity gamma;	
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "pbu_idf_cod", referencedColumnName = "tra_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pbu_tra_cod", referencedColumnName = "tra_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rges_pbu_tra_fk"))
	protected TransportistaEntity transportista;
	
	@Builder
	public PreuPerGammaEntity(
			PreuPerGammaPk pk,			
			IdentificadorEntity identificador,
			PreuPerGamma embedded,
			ArticleGammaEntity gamma,
			TransportistaEntity transportista,
			DivisaEntity divisa) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.gamma = gamma;
		this.transportista = transportista;		
	}

	@Override
	public void update(PreuPerGamma embedded) {
		this.embedded = embedded;
	}

}
