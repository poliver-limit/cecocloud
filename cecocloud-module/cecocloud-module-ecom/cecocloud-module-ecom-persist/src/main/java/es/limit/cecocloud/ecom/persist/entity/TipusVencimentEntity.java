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
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import es.limit.cecocloud.ecom.logic.api.dto.TipusVenciment;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.TipusVencimentEntity.TipusVencimentEntityListener;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil.PkBuilder;
import es.limit.cecocloud.ecom.persist.repository.TipusVencimentRepository;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un tipus de venciment.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomTipusVencimentEntity")
@Table(
		name = "tcom_tve",
		indexes = {
			@Index(name = "icom_tve_idf_fk", columnList = "tve_idf_cod"),
			@Index(name = "ircom_tve_pk", columnList = "tve_idf_cod,tve_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "tve_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "tve_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "tve_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.tipus", column = @Column(name = "tve_tip",  nullable = false, length = 1)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "tve_des", length = 30)),
	@AttributeOverride(name = "embedded.importTermini", column = @Column(name = "tve_imppla")),
	@AttributeOverride(name = "embedded.diaTermini", column = @Column(name = "tve_diapla")),
	@AttributeOverride(name = "embedded.nombreTerminis", column = @Column(name = "tve_numpla")),
	@AttributeOverride(name = "embedded.percentatgePrimerTermini", column = @Column(name = "tve_ptepla001")),
	@AttributeOverride(name = "embedded.percentatgeSegonTermini", column = @Column(name = "tve_ptepla002")),
	@AttributeOverride(name = "embedded.percentatgeTercerTermini", column = @Column(name = "tve_ptepla003")),
	@AttributeOverride(name = "embedded.percentatgeQuartTermini", column = @Column(name = "tve_ptepla004")),
	@AttributeOverride(name = "embedded.percentatgeQuintTermini", column = @Column(name = "tve_ptepla005")),
	@AttributeOverride(name = "embedded.diesPrimerTermini", column = @Column(name = "tve_diapla001")),
	@AttributeOverride(name = "embedded.diesSegonTermini", column = @Column(name = "tve_diapla002")),
	@AttributeOverride(name = "embedded.diesTercerTermini", column = @Column(name = "tve_diapla003")),
	@AttributeOverride(name = "embedded.diesQuartTermini", column = @Column(name = "tve_diapla004")),
	@AttributeOverride(name = "embedded.diesQuintTermini", column = @Column(name = "tve_diapla005")),
	@AttributeOverride(name = "embedded.minimDies", column = @Column(name = "tve_mindia")),
	@AttributeOverride(name = "embedded.dia2Terminis", column = @Column(name = "tve_dia002pla")),
	@AttributeOverride(name = "embedded.diaPagament", column = @Column(name = "tve_diapga")),
	@AttributeOverride(name = "embedded.classeVenciment", column = @Column(name = "tve_clsvtocmp")),
	@AttributeOverride(name = "embedded.mesTan", column = @Column(name = "tve_mestan")),
	@AttributeOverride(name = "embedded.mesPagament", column = @Column(name = "tve_mespga")),
	@AttributeOverride(name = "embedded.generarCobramentPagament", column = @Column(name = "tve_gencobpag", length = 1)),
	@AttributeOverride(name = "embedded.terminiAMesosComplets", column = @Column(name = "tve_mesclt", length = 1)),
	@AttributeOverride(name = "embedded.darrerDiaMesVentes", column = @Column(name = "tve_ultdiamesven", length = 1)),
	@AttributeOverride(name = "embedded.darrerDiaMesCompres", column = @Column(name = "tve_ultdiamescpr", length = 1)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "tve_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "tve_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "tve_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "tve_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "tve_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_tve_idf_fk"))
})
@EntityListeners({TipusVencimentEntityListener.class})
public class TipusVencimentEntity extends AbstractWithIdentificadorAuditableEntity<TipusVenciment, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected TipusVenciment embedded;

	@Builder
	public TipusVencimentEntity(
			WithIdentificadorAndCodiPk<String> pk,
			TipusVenciment embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(TipusVenciment embedded) {
		this.embedded = embedded;
	}
	
	public static class TipusVencimentEntityListener {
		@PrePersist
		public void calcular(TipusVencimentEntity tipusVenciment) {
			String codi = tipusVenciment.getEmbedded().getCodi();
			if (codi == null || codi.isEmpty()) {
				int seq = EntityListenerUtil.getSeguentNumComptadorComprovantPk(
						tipusVenciment.getId().getIdentificadorCodi(),
						"TCOM_TVE",
						new PkBuilder<WithIdentificadorAndCodiPk<String>>() {
							@Override
							public WithIdentificadorAndCodiPk<String> build(int seq) {
								return new WithIdentificadorAndCodiPk<String>(tipusVenciment.getId().getIdentificadorCodi(), Integer.toString(seq));
							}
						},
						EntityListenerUtil.getBean(TipusVencimentRepository.class));
				String seqST = addZeros(seq, 4);
				tipusVenciment.getEmbedded().setCodi(seqST);
				tipusVenciment.getId().setCodi(seqST);
			} else {
				if (isNumeric(codi)) {					
					codi = addZeros(Integer.parseInt(codi), 4);
					tipusVenciment.getEmbedded().setCodi(codi);
					tipusVenciment.getId().setCodi(codi);
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
