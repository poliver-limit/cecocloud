/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.entity;

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

import es.limit.cecocloud.rrhh.logic.api.dto.Categoria;
import es.limit.cecocloud.rrhh.logic.api.dto.Categoria.CategoriaPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un Categoria.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "trhu_cat",
		indexes = {
				@Index(name = "irhu_cat_idf_fk", columnList = "cat_idf_cod"),
				@Index(name = "irrhu_cat_pk", columnList = "cat_idf_cod,cat_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "cat_idf_cod", length = 4)),	
	@AttributeOverride(name = "id.codi", column = @Column(name = "cat_cod", length = 4)),
	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "cat_cod", length = 4, insertable = false, updatable = false)),	
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "cat_nom", nullable = false)),			
	@AttributeOverride(name = "embedded.observacio", column = @Column(name = "cat_obs", length = 1000)),			
	@AttributeOverride(name = "embedded.souBase", column = @Column(name = "cat_soubas", length = 22)),			
	@AttributeOverride(name = "embedded.actiu", column = @Column(name = "cat_act")),
			
	@AttributeOverride(name = "createdBy", column = @Column(name = "cat_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "cat_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "cat_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "cat_datmod"))
})
public class CategoriaEntity extends AbstractAuditableCompositePkEntity<Categoria, CategoriaPk> {

	@Embedded
	protected Categoria embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "cat_idf_cod",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "rrhu_cat_idf_fk"))
	protected IdentificadorRrhhEntity identificador;
	
	@Builder
	public CategoriaEntity(
			CategoriaPk pk,
			Categoria embedded,
			IdentificadorRrhhEntity identificador			
			) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;		
	}

	@Override
	public void update(Categoria embedded) {
		this.embedded = embedded;
	}

}
