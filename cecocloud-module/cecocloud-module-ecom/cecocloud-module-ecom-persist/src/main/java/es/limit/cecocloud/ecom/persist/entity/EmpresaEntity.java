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

import es.limit.cecocloud.ecom.logic.api.dto.Empresa;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.EmpresaEntity.EmpresaEntityListener;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil.PkBuilder;
import es.limit.cecocloud.ecom.persist.repository.EmpresaRepository;
import es.limit.cecocloud.ecom.persist.entity.DivisaEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomEmpresaEntity")
@Table(
		name = "tcom_emp",
		indexes = {
				@Index(name = "icom_emp_idf_fk", columnList = "emp_idf_cod"),
				@Index(name = "ircom_emp_pk", columnList = "emp_idf_cod,emp_cod", unique = true)
		}
)

@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "emp_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "emp_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "emp_cod", insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nomComercial", column = @Column(name = "emp_nomcom", length = 40, nullable = false)),

	@AttributeOverride(name = "createdBy", column = @Column(name = "emp_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "emp_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "emp_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "emp_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "emp_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_emp_idf_fk"))
})
@EntityListeners({EmpresaEntityListener.class})
public class EmpresaEntity extends AbstractWithIdentificadorAuditableEntity<Empresa, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected Empresa embedded;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "emp_idf_cod", referencedColumnName = "div_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "emp_div_cod", referencedColumnName = "div_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_emp_div_fk"))
	private DivisaEntity divisa;	
	@Column(name = "emp_div_cod", length = 4, nullable = false)
	private String divisaCodi;
	
	@Builder
	public EmpresaEntity(
			WithIdentificadorAndCodiPk<String> pk,
			Empresa embedded,
			DivisaEntity divisa,
			IdentificadorEntity identificador
		) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		
		this.updateDivisa(divisa);
	}

	@Override
	public void update(Empresa embedded) {
		this.embedded = embedded;
	}
	
	public void updateDivisa(DivisaEntity divisa) {
		this.divisa = divisa;
		this.divisaCodi = divisa.getEmbedded().getCodi();
	}
	
	public static class EmpresaEntityListener {
		@PrePersist
		public void calcular(EmpresaEntity empresa) {
			String codi = empresa.getEmbedded().getCodi();
			if (codi == null || codi.isEmpty()) {
				int seq = EntityListenerUtil.getSeguentNumComptadorComprovantPk(
						empresa.getId().getIdentificadorCodi(),
						"TCOM_EMP",
						new PkBuilder<WithIdentificadorAndCodiPk<String>>() {
							@Override
							public WithIdentificadorAndCodiPk<String> build(int seq) {
								return new WithIdentificadorAndCodiPk<String>(empresa.getId().getIdentificadorCodi(), Integer.toString(seq));
							}
						},
						EntityListenerUtil.getBean(EmpresaRepository.class));
				String seqST = addZeros(seq, 4);
				empresa.getEmbedded().setCodi(seqST);
				empresa.getId().setCodi(seqST);
			} else {
				if (isNumeric(codi)) {					
					codi = addZeros(Integer.parseInt(codi), 4);
					empresa.getEmbedded().setCodi(codi);
					empresa.getId().setCodi(codi);
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
