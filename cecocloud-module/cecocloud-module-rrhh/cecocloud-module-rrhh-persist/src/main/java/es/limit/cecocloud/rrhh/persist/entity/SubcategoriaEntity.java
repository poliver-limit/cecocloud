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
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableAmbIdentificador.AmbIdentificadorICodiPk;
import es.limit.cecocloud.rrhh.logic.api.dto.Subcategoria;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un Subcategoria.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "trhu_sct",
		indexes = {
				@Index(name = "irhu_sct_idf_fk", columnList = "sct_idf_cod"),
				@Index(name = "irrhu_sct_pk", columnList = "sct_idf_cod,sct_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "sct_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "sct_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "sct_cod", length = 4, insertable = false, updatable = false)),
//	@AttributeOverride(name = "embedded.categoriaCodi", column = @Column(name = "sct_cat_cod", length = 4)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "sct_nom", length = 30)),
	@AttributeOverride(name = "embedded.observacio", column = @Column(name = "sct_obs", length = 1000)),
	@AttributeOverride(name = "embedded.actiu", column = @Column(name = "sct_act")),
	@AttributeOverride(name = "createdBy", column = @Column(name = "sct_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "sct_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "sct_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "sct_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "sct_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rrhu_sct_idf_fk"))
})
public class SubcategoriaEntity extends AbstractAmbIdentificadorEntity<Subcategoria, AmbIdentificadorICodiPk<String>> {

	@Embedded
	protected Subcategoria embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = { 
					@JoinColumn(name = "sct_idf_cod", referencedColumnName = "cat_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "sct_cat_cod", referencedColumnName = "cat_cod", insertable = false, updatable = false)
					},
			foreignKey = @ForeignKey(name = "rrhu_sct_cat_fk"))
	@NotFound(action = NotFoundAction.IGNORE)
	protected CategoriaEntity categoria;
	@Column(name = "sct_cat_cod", length = 4)
	private String categoriaCodi;
	

	@Builder
	public SubcategoriaEntity(
			AmbIdentificadorICodiPk<String> pk,
			Subcategoria embedded,
			IdentificadorEntity identificador,
			CategoriaEntity categoria) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		
		this.categoriaCodi = categoria.getEmbedded().getCodi();		
	}

	@Override
	public void update(Subcategoria embedded) {
		this.embedded = embedded;
	}
	
	public void updateCategoria (CategoriaEntity categoria) {
		this.categoriaCodi = categoria.getEmbedded().getCodi();		
	}

}
