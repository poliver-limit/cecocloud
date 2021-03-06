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

import es.limit.cecocloud.rrhh.logic.api.dto.Calendari;
import es.limit.cecocloud.rrhh.logic.api.dto.Calendari.CalendariPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un Calendari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "trhu_cln",
		indexes = {
				@Index(name = "irhu_cln_idf_fk", columnList = "cln_idf_cod"),
				@Index(name = "irrhu_cln_pk", columnList = "cln_idf_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "cln_idf_cod", length = 4)),
	@AttributeOverride(name = "id.data", column = @Column(name = "cln_dat")),
	@AttributeOverride(name = "embedded.data", column = @Column(name = "cln_dat", insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.tipusDiaCodi", column = @Column(name = "cln_tdi_cod", length = 4)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "cln_des", length = 1000)),
	@AttributeOverride(name = "embedded.observacio", column = @Column(name = "cln_obs", length = 1000)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "cln_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "cln_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "cln_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "cln_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "cln_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rrhu_cln_idf_fk")
	)
})
public class CalendariEntity extends AbstractWithIdentificadorEntity<Calendari, CalendariPk> {

	@Embedded
	protected Calendari embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = { 
					@JoinColumn(name = "cln_idf_cod", referencedColumnName = "tdi_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "cln_tdi_cod", referencedColumnName = "tdi_cod", insertable = false, updatable = false)
					},
			foreignKey = @ForeignKey(name = "rrhu_cln_tdi_fk"))
	protected TipusDiaEntity tipusDia;	
	@Column(name = "cln_tdi_cod", length = 4)
	private String tipusDiaCodi;

	@Builder
	public CalendariEntity(
			CalendariPk pk,
			Calendari embedded,
			IdentificadorEntity identificador,
			TipusDiaEntity tipusDia) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		
		this.tipusDiaCodi = tipusDia.getEmbedded().getCodi();		
	}

	@Override
	public void update(Calendari embedded) {
		this.embedded = embedded;
	}
	
	public void updateTipusDia (TipusDiaEntity tipusDia) {
		this.tipusDiaCodi = tipusDia.getEmbedded().getCodi();
	}

}
