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
import es.limit.cecocloud.facturacio.logic.api.dto.SerieIntracomunitaria;
import es.limit.cecocloud.facturacio.logic.api.dto.SerieIntracomunitaria.SerieIntracomunitariaPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una serie intracomunitaria.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_sei",
		indexes = {
				@Index(name = "iges_sei_idf_fk", columnList = "sei_idf_cod"),
				@Index(name = "irges_sei_pk", columnList = "sei_idf_cod,sei_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "sei_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "sei_emp_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "sei_cod", length = 4)),
	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "sei_cod", length = 4, insertable = false, updatable = false)),	
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "sei_des", length = 60, nullable = false)),	
	@AttributeOverride(name = "embedded.ultimaFactura", column = @Column(name = "sei_ultfac")),			
	@AttributeOverride(name = "embedded.dia1", column = @Column(name = "sei_dia001", nullable = false)),			
	@AttributeOverride(name = "embedded.dia2", column = @Column(name = "sei_dia002", nullable = false)),			
	@AttributeOverride(name = "embedded.serieDefecto", column = @Column(name = "sei_serdef", length = 1)),
			
	@AttributeOverride(name = "createdBy", column = @Column(name = "sei_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "sei_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "sei_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "sei_datmod"))
})
public class SerieIntracomunitariaEntity extends AbstractAuditableCompositePkEntity<SerieIntracomunitaria, SerieIntracomunitariaPk> {

	@Embedded
	protected SerieIntracomunitaria embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "sei_idf_cod",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "rges_sei_idf_fk"))
	protected IdentificadorEntity identificador;

	@Builder
	public SerieIntracomunitariaEntity(
			SerieIntracomunitariaPk pk,
			SerieIntracomunitaria embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(SerieIntracomunitaria embedded) {
		this.embedded = embedded;
	}

}
