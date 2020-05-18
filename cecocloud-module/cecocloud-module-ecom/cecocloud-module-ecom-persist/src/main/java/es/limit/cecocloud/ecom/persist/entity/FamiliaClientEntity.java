/**
 * 
 */
package es.limit.cecocloud.ecom.persist.entity;

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

import org.hibernate.annotations.Formula;

import es.limit.cecocloud.ecom.logic.api.dto.FamiliaClient;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
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
@Entity(name = "ecomFamiliaClientEntity")
@Table(name = "tcom_fmc", indexes = { @Index(name = "icom_fmc_idf_fk", columnList = "fmc_idf_cod"),
		@Index(name = "ircom_fmc_pk", columnList = "fmc_idf_cod,fmc_cod", unique = true) })
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
					@JoinColumn(name = "fmc_idf_cod", insertable = false, updatable = false) }, 
			foreignKey = @ForeignKey(name = "rcom_fmc_idf_fk"))
})

public class FamiliaClientEntity
		extends AbstractWithIdentificadorAuditableEntity<FamiliaClient, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected FamiliaClient embedded;
	
	@Formula(value="(SELECT CONCAT(CONCAT(fmc.fmc_nom,' - '),fmc.fmc_cod) FROM tcom_fmc fmc where fmc.fmc_cod = fmc_cod and fmc.fmc_idf_cod = fmc_idf_cod)")
	private String nomCodiTxt;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "fmc_idf_cod", referencedColumnName = "tri_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "fmc_tri_cod", referencedColumnName = "tri_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "fmc_tri_cod_fk"))
	private TipusRiscEntity tipusRisc;
	@Column(name = "fmc_tri_cod", length = 4, nullable = true)
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
		
		this.updateTipusRisc(tipusRisc);
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