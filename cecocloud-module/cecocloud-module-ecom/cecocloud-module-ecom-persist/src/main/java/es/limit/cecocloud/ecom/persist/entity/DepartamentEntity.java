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

import es.limit.cecocloud.ecom.logic.api.dto.Departament;
import es.limit.cecocloud.ecom.logic.api.dto.Departament.DepartamentPk;
import es.limit.cecocloud.ecom.persist.entity.DepartamentEntity.DepartamentEntityListener;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil.PkBuilder;
import es.limit.cecocloud.ecom.persist.repository.DepartamentRepository;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un Departament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomDepartamentEntity")
@Table(
		name = "tcom_dep",
		indexes = {
				@Index(name = "icom_dep_idf_fk", columnList = "dep_idf_cod"),
				@Index(name = "ircom_dep_pk", columnList = "dep_idf_cod,dep_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "dep_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "dep_emp_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "dep_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "dep_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "dep_des", length = 60, nullable = false)),
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "dep_obs", length = 1000)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "dep_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "dep_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "dep_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "dep_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "dep_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_dep_idf_fk"))
})
@EntityListeners({DepartamentEntityListener.class})
public class DepartamentEntity extends AbstractWithIdentificadorAuditableEntity<Departament, DepartamentPk> {

	@Embedded
	protected Departament embedded;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "dep_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "dep_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_dep_emp_fk"))
	protected EmpresaEntity empresa;

	@Builder
	public DepartamentEntity(
			DepartamentPk pk,
			Departament embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;
	}

	@Override
	public void update(Departament embedded) {
		this.embedded = embedded;
	}
	
	public static class DepartamentEntityListener {
		@PrePersist
		public void calcular(DepartamentEntity departament) {
			String codi = departament.getEmbedded().getCodi();
			if (codi == null || codi.isEmpty()) {
				int seq = EntityListenerUtil.getSeguentNumComptadorComprovantPk(
						departament.getId().getIdentificadorCodi(),
						"TCOM_DEP",
						new PkBuilder<DepartamentPk>() {
							@Override
							public DepartamentPk build(int seq) {
								return new DepartamentPk(departament.getId().getIdentificadorCodi(), departament.getId().getEmpresaCodi(),Integer.toString(seq));
							}
						},
						EntityListenerUtil.getBean(DepartamentRepository.class));
				String seqST = addZeros(seq, 4);
				departament.getEmbedded().setCodi(seqST);
				departament.getId().setCodi(seqST);
			} else {
				if (isNumeric(codi)) {					
					codi = addZeros(Integer.parseInt(codi), 4);
					departament.getEmbedded().setCodi(codi);
					departament.getId().setCodi(codi);
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
