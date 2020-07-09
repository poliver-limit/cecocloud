/**
 * 
 */
package es.limit.cecocloud.ecom.back.ecommerce.persist.entity;

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

import es.limit.cecocloud.ecom.back.ecommerce.logic.api.dto.MenuEcom;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.AbstractWithIdentificadorAuditableEntity;
import es.limit.cecocloud.ecom.persist.entity.IdentificadorEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un article.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomBackMenuEcomEntity")
@Table(
		name = "tcom_men",
		indexes = {
				@Index(name = "icom_men_idf_fk", columnList = "men_idf_cod")
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "men_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "men_cod", length = 15)),
	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "men_cod", length = 15, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.icon", column = @Column(name = "men_icon", length = 20, nullable = false)),
	@AttributeOverride(name = "embedded.label", column = @Column(name = "men_label", length = 20, nullable = false)),
	@AttributeOverride(name = "embedded.labelKey", column = @Column(name = "men_label_key", length = 20, nullable = false)),
	@AttributeOverride(name = "embedded.resource", column = @Column(name = "men_esource", length = 20, nullable = false)),
	@AttributeOverride(name = "embedded.route", column = @Column(name = "men_route", length = 20, nullable = false)),

	@AttributeOverride(name = "createdBy", column = @Column(name = "men_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "men_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "men_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "men_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "men_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_men_idf_fk"))
})
public class MenuEcomEntity extends AbstractWithIdentificadorAuditableEntity<MenuEcom, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected MenuEcom embedded;

	@Builder
	public MenuEcomEntity(			
			WithIdentificadorAndCodiPk<String> pk,
			MenuEcom embedded,
			IdentificadorEntity identificador
			) {
		
		setId(pk);		
		this.embedded = embedded;
		this.identificador = identificador;		

	}

	@Override
	public void update(MenuEcom embedded) {
		this.embedded = embedded;
	}


	

}
