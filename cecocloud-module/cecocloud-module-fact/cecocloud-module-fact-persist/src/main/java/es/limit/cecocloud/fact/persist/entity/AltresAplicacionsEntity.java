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

import es.limit.cecocloud.fact.logic.api.dto.AltresAplicacions;
import es.limit.cecocloud.fact.logic.api.dto.AltresAplicacions.AltresAplicacionsPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació de altres aplicacions.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "factAltresAplicacionsEntity")
@Table(
		name = "tges_tpl",
		indexes = {
				@Index(name = "iges_tpl_idf_fk", columnList = "tpl_idf_cod"),
				@Index(name = "irges_tpl_pk", columnList = "tpl_idf_cod, tpl_tra_cod, tpl_apl, tpl_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "tpl_idf_cod", length = 4)),
	@AttributeOverride(name = "id.transportistaCodi", column = @Column(name = "tpl_tra_cod", length = 15)),
	@AttributeOverride(name = "id.aplicacio", column = @Column(name = "tpl_apl", length = 22, precision = 3, scale = 0)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "tpl_cod", length = 20)),
	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "tpl_cod", length = 20, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.aplicacio", column = @Column(name = "tpl_apl", length = 22, precision = 3, scale = 0, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "tpl_obs", length = 1000)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "tpl_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "tpl_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "tpl_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "tpl_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "tpl_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_tpl_idf_fk"))
})
public class AltresAplicacionsEntity extends AbstractWithIdentificadorAuditableEntity<AltresAplicacions, AltresAplicacionsPk> {

	@Embedded
	protected AltresAplicacions embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "tpl_idf_cod", referencedColumnName = "tra_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "tpl_tra_cod", referencedColumnName = "tra_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rges_tpl_tra_fk"))
	protected TransportistaEntity transportista;
	
	@Builder
	public AltresAplicacionsEntity(
			AltresAplicacionsPk pk,			
			IdentificadorEntity identificador,
			AltresAplicacions embedded,
			TransportistaEntity transportista) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.transportista = transportista;		
	}

	@Override
	public void update(AltresAplicacions embedded) {
		this.embedded = embedded;
	}

}
