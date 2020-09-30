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

import es.limit.cecocloud.fact.logic.api.dto.LiniaFullFeina;
import es.limit.cecocloud.fact.logic.api.dto.LiniaFullFeina.LiniaFullFeinaPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació de una linia full feina.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "factLiniaFullFeinaEntity")
@Table(
		name = "tges_lff",
		indexes = {
				@Index(name = "iges_lff_idf_fk", columnList = "lff_idf_cod"),
				@Index(name = "irges_lff_pk", columnList = "lff_idf_cod, lff_ffa_cod, lff_ord", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "lff_idf_cod", length = 4)),
	@AttributeOverride(name = "id.finalFacturaCodi", column = @Column(name = "lff_ffa_cod", length = 4)),
	@AttributeOverride(name = "id.ordre", column = @Column(name = "lff_ord", length = 22)),
	
	@AttributeOverride(name = "embedded.ordre", column = @Column(name = "lff_ord", length = 22, precision = 17, scale = 5, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "lff_nom", length = 60, nullable = false)),
	@AttributeOverride(name = "embedded.imprimir", column = @Column(name = "lff_prn", length = 1, nullable = false)),
	@AttributeOverride(name = "embedded.cncFactura", column = @Column(name = "lff_cncfac", length = 1)),
	@AttributeOverride(name = "embedded.formula", column = @Column(name = "lff_fml", length = 255)),
	@AttributeOverride(name = "embedded.aplicaTotal", column = @Column(name = "lff_apltot", length = 1, nullable = false)),
	@AttributeOverride(name = "embedded.importFacturat", column = @Column(name = "lff_impfac", length = 1)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "lff_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "lff_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "lff_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "lff_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "lff_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_lff_idf_fk"))
})
public class LiniaFullFeinaEntity extends AbstractWithIdentificadorAuditableEntity<LiniaFullFeina, LiniaFullFeinaPk> {

	@Embedded
	protected LiniaFullFeina embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "lff_idf_cod", referencedColumnName = "ffa_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "lff_ffa_cod", referencedColumnName = "ffa_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_lff_ffa_fk"))			
	protected FinalFacturaEntity finalFactura;	
	
	@Builder
	public LiniaFullFeinaEntity(
			LiniaFullFeinaPk pk,			
			IdentificadorEntity identificador,
			LiniaFullFeina embedded,
			FinalFacturaEntity finalFactura) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.finalFactura = finalFactura;

	}

	@Override
	public void update(LiniaFullFeina embedded) {
		this.embedded = embedded;
	}

}
