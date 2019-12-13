/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.entity;

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

import es.limit.cecocloud.facturacio.logic.api.dto.Ubicacio;
import es.limit.cecocloud.facturacio.logic.api.dto.Ubicacio.UbicacioPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una ubicació.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_ubi",
		indexes = {
				@Index(name = "iges_ubi_idf_fk", columnList = "ubi_idf_cod"),
				@Index(name = "irges_ubi_pk", columnList = "ubi_idf_cod,ubi_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "ubi_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "ubi_cod", length = 4)),
	@AttributeOverride(name = "id.magatzemCodi", column = @Column(name = "ubi_mag_cod", length = 6)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "ubi_cod", length = 6, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "ubi_des", length = 30)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "ubi_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "ubi_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "ubi_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "ubi_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "ubi_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_ubi_idf_fk"))
})
public class UbicacioEntity extends AbstractAmbIdentificadorEntity<Ubicacio, UbicacioPk> {

	@Embedded
	protected Ubicacio embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ubi_idf_cod", referencedColumnName = "mag_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ubi_mag_cod", referencedColumnName = "mag_cod", insertable = false, updatable = false)				
			},
			foreignKey = @ForeignKey(name = "rges_ubi_mag_fk"))
	protected MagatzemEntity magatzem;

	@Builder
	public UbicacioEntity(
			UbicacioPk pk,
			Ubicacio embedded,
			IdentificadorEntity identificador,
			MagatzemEntity magatzem) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.magatzem = magatzem;
	}

	@Override
	public void update(Ubicacio embedded) {
		this.embedded = embedded;
	}

}
