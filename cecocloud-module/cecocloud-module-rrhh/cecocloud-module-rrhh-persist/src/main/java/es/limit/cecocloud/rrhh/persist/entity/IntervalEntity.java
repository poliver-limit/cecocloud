/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.entity;

import java.util.Date;

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

import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.rrhh.logic.api.dto.Interval;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un Interval.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "trhu_inr",
		indexes = {
				@Index(name = "irhu_inr_idf_fk", columnList = "inr_idf_cod"),
				@Index(name = "irrhu_inr_pk", columnList = "inr_idf_cod,inr_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "inr_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "inr_cod", length = 4)),
	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "inr_cod", insertable = false, updatable = false)),
	
	@AttributeOverride(name = "embedded.dataEntrada", column = @Column(name = "inr_dat")),
	@AttributeOverride(name = "embedded.dataInici", column = @Column(name = "inr_ini")),
	@AttributeOverride(name = "embedded.numeroNodeEnt", column = @Column(name = "inr_nod_nument", length=22)),
	@AttributeOverride(name = "embedded.numeroNodeSor", column = @Column(name = "inr_nod_numsor", length=22)),
	@AttributeOverride(name = "embedded.dataFi", column = @Column(name = "inr_fin")),
	@AttributeOverride(name = "embedded.observacio", column = @Column(name = "inr_obs", length = 1000)),
	@AttributeOverride(name = "embedded.concepteFeinaCodi", column = @Column(name = "inr_cof_cod", length = 4)),
	@AttributeOverride(name = "embedded.fullFeinaOperariCodi", column = @Column(name = "inr_ffo_cod", length = 4)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "inr_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "inr_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "inr_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "inr_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "inr_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rrhu_inr_idf_fk"))
})
public class IntervalEntity extends AbstractWithIdentificadorEntity<Interval, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected Interval embedded;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(
			value = { 
					@JoinColumn(name = "inr_idf_cod", referencedColumnName = "cln_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "inr_cln_dat", referencedColumnName = "cln_dat", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rrhu_inr_cln_fk"))
	private CalendariEntity diaCalendari;
	@Column(name = "inr_cln_dat", length = 4)
	private Date diaCalendariCodi;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(
			value = { 
					@JoinColumn(name = "inr_idf_cod", referencedColumnName = "zon_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "inr_zon_cod", referencedColumnName = "zon_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rrhu_inr_zon_fk"))
	private ZonaEntity zona;
	@Column(name = "inr_zon_cod", length = 4)
	private String zonaCodi;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(
			value = { 
					@JoinColumn(name = "inr_idf_cod", referencedColumnName = "ope_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "inr_ope_cod", referencedColumnName = "ope_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rrhu_inr_ope_fk"))
	private OperariEntity operari;
	@Column(name = "inr_ope_cod", length = 4, nullable = false)
	private String operariCodi;

	@Builder
	public IntervalEntity(
			WithIdentificadorAndCodiPk<String> pk,
			Interval embedded,
			IdentificadorEntity identificador,
			CalendariEntity diaCalendari,
			OperariEntity operari,
			ZonaEntity zona) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		
		this.diaCalendariCodi = diaCalendari.getEmbedded().getData();
		this.operariCodi = operari.getEmbedded().getCodi();
		this.zonaCodi = zona.getEmbedded().getCodi();
	}

	@Override
	public void update(Interval embedded) {
		this.embedded = embedded;
	}
	
	public void updateCalendari (CalendariEntity diaCalendari) {
		this.diaCalendariCodi = diaCalendari.getEmbedded().getData();
	}
	
	public void updateOperari (OperariEntity operari) {
		this.operariCodi = operari.getEmbedded().getCodi();
	}

	public void updateZona (ZonaEntity zona) {
		this.zonaCodi = zona.getEmbedded().getCodi();
	}
	

}
