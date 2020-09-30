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

import es.limit.cecocloud.fact.logic.api.dto.EmpresaGrup;
import es.limit.cecocloud.fact.logic.api.dto.UsuariGrup;
import es.limit.cecocloud.fact.logic.api.dto.UsuariGrup.UsuariGrupPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació de usuaris del grup.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "factUsuariGrupEntity")
@Table(
		name = "tges_usg",
		indexes = {
				@Index(name = "iges_usg_idf_fk", columnList = "usg_idf_cod"),
				@Index(name = "irges_usg_pk", columnList = "usg_idf_cod, usg_gru_cod, usg_usu_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "usg_idf_cod", length = 4)),
	@AttributeOverride(name = "id.grupCodi", column = @Column(name = "usg_gru_cod", length = 4)),
	@AttributeOverride(name = "id.usuariCodi", column = @Column(name = "usg_usu_cod", length = 30)),
	
	@AttributeOverride(name = "embedded.usuari", column = @Column(name = "usg_usu_cod", length = 30, insertable = false, updatable = false)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "usg_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "usg_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "usg_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "usg_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "usg_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_usg_idf_fk"))
})
public class UsuariGrupEntity extends AbstractWithIdentificadorAuditableEntity<UsuariGrup, UsuariGrupPk> {

	@Embedded
	protected UsuariGrup embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "usg_idf_cod", referencedColumnName = "gru_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "usg_gru_cod", referencedColumnName = "gru_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_usg_gru_fk"))			
	protected GroupEntity grup;	
	
	@Builder
	public UsuariGrupEntity(
			UsuariGrupPk pk,			
			IdentificadorEntity identificador,
			UsuariGrup embedded,
			GroupEntity grup) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.grup = grup;		

	}

	@Override
	public void update(UsuariGrup embedded) {
		this.embedded = embedded;
	}

}
