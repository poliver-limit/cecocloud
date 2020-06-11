/**
 * 
 */
package es.limit.cecocloud.ecom.persist.entity;

import java.util.regex.Pattern;

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

import org.hibernate.annotations.Formula;

import es.limit.cecocloud.ecom.logic.api.dto.FamiliaClient;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.FamiliaClientEntity.FamiliaClientEntityListener;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil.PkBuilder;
import es.limit.cecocloud.ecom.persist.repository.FamiliaClientRepository;
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
@EntityListeners({FamiliaClientEntityListener.class})
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
	
	public static class FamiliaClientEntityListener {
		@PrePersist
		public void calcular(FamiliaClientEntity familiaClient) {
			String codi = familiaClient.getEmbedded().getCodi();
			if (codi == null || codi.isEmpty()) {
				int seq = EntityListenerUtil.getSeguentNumComptadorComprovantPk(
						familiaClient.getId().getIdentificadorCodi(),
						"TCOM_FMC",
						new PkBuilder<WithIdentificadorAndCodiPk<String>>() {
							@Override
							public WithIdentificadorAndCodiPk<String> build(int seq) {
								return new WithIdentificadorAndCodiPk<String>(familiaClient.getId().getIdentificadorCodi(), Integer.toString(seq));
							}
						},
						EntityListenerUtil.getBean(FamiliaClientRepository.class));
				String seqST = addZeros(seq, 4);
				familiaClient.getEmbedded().setCodi(seqST);
				familiaClient.getId().setCodi(seqST);
			} else {
				if (isNumeric(codi)) {					
					codi = addZeros(Integer.parseInt(codi), 4);
					familiaClient.getEmbedded().setCodi(codi);
					familiaClient.getId().setCodi(codi);
				}
			}
		}
	}
	
	private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
	 
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false; 
	    }
	    return pattern.matcher(strNum).matches();
	}
	
	public static String addZeros(int codi, int tamanyCodi) {
		String codiSt = String.format("%04d",codi).toString();
		return codiSt;
	}


}
