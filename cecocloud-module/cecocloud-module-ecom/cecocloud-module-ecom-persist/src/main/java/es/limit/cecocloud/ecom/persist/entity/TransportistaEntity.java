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

import es.limit.cecocloud.ecom.logic.api.dto.Transportista;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.TransportistaEntity.TransportistaEntityListener;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil.PkBuilder;
import es.limit.cecocloud.ecom.persist.repository.TransportistaRepository;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un transportista
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomTransportistaEntity")
@Table(
		name = "tcom_tra",
		indexes = {
				@Index(name = "icom_tra_idf_fk", columnList = "tra_idf_cod"),
				@Index(name = "ircom_tra_pk", columnList = "tra_idf_cod,tra_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "tra_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "tra_cod", length = 6)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "tra_cod", length = 6, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "tra_nom", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.nif", column = @Column(name = "tra_nif", length = 12, nullable = false)),
	
	@AttributeOverride(name = "embedded.domicili", column = @Column(name = "tra_dom")),
	@AttributeOverride(name = "embedded.telefon", column = @Column(name = "tra_tel")),
	@AttributeOverride(name = "embedded.fax", column = @Column(name = "tra_fax")),
	@AttributeOverride(name = "embedded.email", column = @Column(name = "tra_eml")),
	@AttributeOverride(name = "embedded.adresaWeb", column = @Column(name = "tra_www")),
	@AttributeOverride(name = "embedded.contacte", column = @Column(name = "tra_con")),
	@AttributeOverride(name = "embedded.formaPagament", column = @Column(name = "tra_fpa")),
	@AttributeOverride(name = "embedded.horariRepartiment", column = @Column(name = "tra_hri")),
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "tra_obs")),
	@AttributeOverride(name = "embedded.vehicleEmpresa", column = @Column(name = "tra_vehemp")),
//	@AttributeOverride(name = "embedded.codiPostalCodi", column = @Column(name = "tra_cpo_cod", length = 8, nullable = false)),
//	@AttributeOverride(name = "embedded.divisaCodi", column = @Column(name = "tra_div_cod", length = 4, nullable = false)),
//	@AttributeOverride(name = "embedded.proveidorCodi", column = @Column(name = "tra_pro_cod")),
	@AttributeOverride(name = "createdBy", column = @Column(name = "tra_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "tra_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "tra_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "tra_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "tra_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_tra_idf_fk"))
})
@EntityListeners({TransportistaEntityListener.class})
public class TransportistaEntity extends AbstractWithIdentificadorAuditableEntity<Transportista, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected Transportista embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "tra_idf_cod", referencedColumnName = "cpo_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "tra_cpo_cod", referencedColumnName = "cpo_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_tra_cpo_fk"))
	private CodiPostalEntity codiPostal;
	@Column(name = "tra_cpo_cod", length = 8, nullable = false)
	private String codiPostalCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "tra_idf_cod", referencedColumnName = "div_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "tra_div_cod", referencedColumnName = "div_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_tra_div_fk"))
	private DivisaEntity divisa;
	@Column(name = "tra_div_cod", length = 4, nullable = false)
	private String divisaCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "tra_idf_cod", referencedColumnName = "pro_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "tra_pro_cod", referencedColumnName = "pro_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_tra_pro_fk"))
	private ProveidorEntity proveidor;
	@Column(name = "tra_pro_cod", length = 6)
	private String proveidorCodi;
	
	@Builder
	public TransportistaEntity(
			WithIdentificadorAndCodiPk<String> pk,
			Transportista embedded,
			IdentificadorEntity identificador,
			CodiPostalEntity codiPostal,
			DivisaEntity divisa,
			ProveidorEntity proveidor) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;		
		
		this.updateCodiPostal(codiPostal);		
		this.updateDivisa(divisa);		
		this.updateProveidor(proveidor);		
	}

	@Override
	public void update(Transportista embedded) {
		this.embedded = embedded;
	}
	
	public void updateCodiPostal (CodiPostalEntity codiPostal) {
		this.codiPostal = codiPostal;
		this.codiPostalCodi = codiPostal.getEmbedded().getCodi();
	}
	
	public void updateDivisa (DivisaEntity divisa) {
		this.divisa = divisa;
		this.divisaCodi = divisa.getEmbedded().getCodi();
	}
	
	public void updateProveidor (ProveidorEntity proveidor) {
		this.proveidor = proveidor;
		this.proveidorCodi = proveidor.getEmbedded().getCodi();
	}
	
	public static class TransportistaEntityListener {
		@PrePersist
		public void calcular(TransportistaEntity transportista) {
			String codi = transportista.getEmbedded().getCodi();
			if (codi == null || codi.isEmpty()) {
				int seq = EntityListenerUtil.getSeguentNumComptadorComprovantPk(
						transportista.getId().getIdentificadorCodi(),
						"TCOM_TRA",
						new PkBuilder<WithIdentificadorAndCodiPk<String>>() {
							@Override
							public WithIdentificadorAndCodiPk<String> build(int seq) {
								return new WithIdentificadorAndCodiPk<String>(transportista.getId().getIdentificadorCodi(), Integer.toString(seq));
							}
						},
						EntityListenerUtil.getBean(TransportistaRepository.class));
				String seqST = addZeros(seq, 6);
				transportista.getEmbedded().setCodi(seqST);
				transportista.getId().setCodi(seqST);
			} else {
				if (isNumeric(codi)) {					
					codi = addZeros(Integer.parseInt(codi), 6);
					transportista.getEmbedded().setCodi(codi);
					transportista.getId().setCodi(codi);
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
		String codiSt = String.format("%06d",codi).toString();
		return codiSt;
	}

}
