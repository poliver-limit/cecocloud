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

import es.limit.cecocloud.cita.logic.api.dto.Festiu;
import es.limit.cecocloud.cita.logic.api.dto.Festiu.FestiuPk;
import es.limit.cecocloud.cita.persist.entity.FestiuEntity.FestiuEntityListener;
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
		name = "tcec_fes",
		indexes = {
				@Index(name = "ircec_fes_pk", columnList = "fes_idf_cod,fes_seq", unique = true),
				@Index(name = "icec_fes_idf_fk", columnList = "fes_idf_cod"),
				@Index(name = "icec_fes_fgr_fk", columnList = "fes_idf_cod,fes_gfe_cod")
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "fes_idf_cod", length = 4)),
	@AttributeOverride(name = "id.festiuGrupCodi", column = @Column(name = "fes_gfe_cod", length = 4)),
	@AttributeOverride(name = "id.sequencia", column = @Column(name = "fes_seq", precision = 18)),
	@AttributeOverride(name = "embedded.sequencia", column = @Column(name = "fes_seq", insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "fes_nom", nullable = false)),
	@AttributeOverride(name = "embedded.diaMes", column = @Column(name = "fes_diames", nullable = false)),
	@AttributeOverride(name = "embedded.any", column = @Column(name = "fes_any", nullable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "fes_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "fes_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "fes_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "fes_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "fes_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_fes_idf_fk"))
})
@EntityListeners(FestiuEntityListener.class)
public class FestiuEntity extends AbstractWithIdentificadorAuditableEntity<Festiu, FestiuPk> {

	@Embedded
	protected Festiu embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "fes_idf_cod", referencedColumnName = "gfe_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "fes_gfe_cod", referencedColumnName = "gfe_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "fes_gfe_cod_fk"))
	private FestiuGrupEntity festiuGrup;

	@Builder
	public FestiuEntity(
			FestiuPk pk,
			Festiu embedded,
			IdentificadorEntity identificador,
			FestiuGrupEntity festiuGrup) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.festiuGrup = festiuGrup;
	}

	@Override
	public void update(Festiu embedded) {
		this.embedded = embedded;
	}

	public static class FestiuEntityListener {
		@PrePersist
		public void calcular(FestiuEntity festiu) {
			int seq = EntityListenerUtil.getSeguentNumComptador(
					festiu.getIdentificador().getId(),
					"TCEC_FES");
			festiu.getEmbedded().setSequencia(seq);
			festiu.getId().setSequencia(seq);
		}
	}

}
