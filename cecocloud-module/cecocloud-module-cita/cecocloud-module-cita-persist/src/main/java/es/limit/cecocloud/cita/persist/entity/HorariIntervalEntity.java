/**
 * 
 */
package es.limit.cecocloud.cita.persist.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import es.limit.cecocloud.cita.logic.api.dto.HorariInterval;
import es.limit.cecocloud.cita.logic.api.dto.HorariInterval.HorariIntervalPk;
import es.limit.cecocloud.cita.persist.entity.HorariIntervalEntity.HorariIntervalEntityListener;
import es.limit.cecocloud.fact.persist.entity.AbstractWithIdentificadorAuditableEntity;
import es.limit.cecocloud.fact.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.fact.persist.listener.EntityListenerUtil;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un grup de festius.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tcec_ihr",
		indexes = {
				@Index(name = "ircec_ihr_pk", columnList = "ihr_idf_cod,ihr_seq", unique = true),
				@Index(name = "icec_ihr_idf_fk", columnList = "ihr_idf_cod"),
				@Index(name = "icec_ihr_hor_fk", columnList = "ihr_idf_cod,ihr_hor_cod")
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "ihr_idf_cod", length = 4)),
	@AttributeOverride(name = "id.horariCodi", column = @Column(name = "ihr_hor_cod", length = 4)),
	@AttributeOverride(name = "id.sequencia", column = @Column(name = "ihr_seq", precision = 18)),
	@AttributeOverride(name = "embedded.sequencia", column = @Column(name = "ihr_seq", insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.diaSetmana", column = @Column(name = "ihr_diaset", nullable = false)),
	@AttributeOverride(name = "embedded.horaInici", column = @Column(name = "ihr_horini", nullable = false)),
	@AttributeOverride(name = "embedded.horaFi", column = @Column(name = "ihr_horfi", nullable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "ihr_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "ihr_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "ihr_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "ihr_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "ihr_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_ihr_idf_fk"))
})
@EntityListeners(HorariIntervalEntityListener.class)
public class HorariIntervalEntity extends AbstractWithIdentificadorAuditableEntity<HorariInterval, HorariIntervalPk> {

	@Embedded
	protected HorariInterval embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "ihr_idf_cod", referencedColumnName = "hor_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "ihr_hor_cod", referencedColumnName = "hor_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "ihr_hor_cod_fk"))
	private HorariEntity horari;

	@Builder
	public HorariIntervalEntity(
			HorariIntervalPk pk,
			HorariInterval embedded,
			IdentificadorEntity identificador,
			HorariEntity horari) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.horari = horari;
	}

	@Override
	public void update(HorariInterval embedded) {
		this.embedded = embedded;
	}

	public static class HorariIntervalEntityListener {
		@PrePersist
		public void calcular(HorariIntervalEntity horariInterval) {
			int seq = EntityListenerUtil.getSeguentNumComptador(
					horariInterval.getIdentificador().getId(),
					"TCEC_HOI");
			horariInterval.getEmbedded().setSequencia(seq);
			horariInterval.getId().setSequencia(seq);
		}
	}

}
