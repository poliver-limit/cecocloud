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

import es.limit.cecocloud.facturacio.logic.api.dto.FamiliaClient;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una família de client.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_fmc", 
		indexes = { 
				@Index(name = "iges_fmc_idf_fk", columnList = "fmc_idf_cod"),
				@Index(name = "irges_fmc_pk", columnList = "fmc_idf_cod,fmc_cod", unique = true) 
		}
)
@AttributeOverrides({
		@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "fmc_idf_cod", length = 4)),
		@AttributeOverride(name = "id.codi", column = @Column(name = "fmc_cod", length = 4)),
		@AttributeOverride(name = "embedded.codi", column = @Column(name = "fmc_cod", length = 4, insertable = false, updatable = false)),
		@AttributeOverride(name = "embedded.nom", column = @Column(name = "fmc_nom", length = 30, nullable = false)),
		@AttributeOverride(name = "embedded.compteVendesComptabilitat", column = @Column(name = "fmc_ctavencmp", length = 10)),
		@AttributeOverride(name = "embedded.observacions", column = @Column(name = "fmc_obs", length = 1000)),
		@AttributeOverride(name = "createdBy", column = @Column(name = "fmc_usucre")),
		@AttributeOverride(name = "createdDate", column = @Column(name = "fmc_datcre")),
		@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "fmc_usumod")),
		@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "fmc_datmod")) 
})
@AssociationOverrides({ 
	@AssociationOverride(
			name = "identificador", 
			joinColumns = {
					@JoinColumn(name = "fmc_idf_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rges_fmc_idf_fk")) 
	})

public class FamiliaClientEntity
		extends AbstractWithIdentificadorEntity<FamiliaClient, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected FamiliaClient embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(
				name = "fmc_idf_cod",
				referencedColumnName = "tri_idf_cod",
				insertable = false,
				updatable = false),
		@JoinColumn(
				name = "fmc_tri_cod",
				referencedColumnName = "tri_cod",
				insertable = false,
				updatable = false)
	})
	private TipusRiscEntity tipusRisc;
	@Column(name = "fmc_tri_cod", length = 4, nullable = false)
	private String tipusRiscCodi;

	@Builder
	public FamiliaClientEntity(
			WithIdentificadorAndCodiPk<String> pk,
			FamiliaClient embedded,
			IdentificadorEntity identificador,
			TipusRiscEntity tipusRisc) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		updateTipusRisc(tipusRisc);
	}

	@Override
	public void update(FamiliaClient embedded) {
		this.embedded = embedded;
	}
	public void updateTipusRisc(TipusRiscEntity tipusRisc) {
		this.tipusRisc = tipusRisc;
		if (tipusRisc != null) {
			this.tipusRiscCodi = tipusRisc.getId().getCodi();
		}
	}

}
