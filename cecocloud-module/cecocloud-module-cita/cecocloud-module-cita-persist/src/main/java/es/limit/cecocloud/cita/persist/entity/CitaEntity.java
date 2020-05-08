/**
 * 
 */
package es.limit.cecocloud.cita.persist.entity;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
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

import org.springframework.security.crypto.codec.Hex;

import es.limit.cecocloud.cita.logic.api.dto.Cita;
import es.limit.cecocloud.cita.logic.api.dto.Cita.CitaPk;
import es.limit.cecocloud.cita.persist.entity.CitaEntity.CitaEntityListener;
import es.limit.cecocloud.fact.persist.entity.AbstractWithIdentificadorAuditableEntity;
import es.limit.cecocloud.fact.persist.entity.EmpresaEntity;
import es.limit.cecocloud.fact.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.fact.persist.entity.PuntVendaEntity;
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
		name = "tcec_cit",
		indexes = {
				@Index(name = "icec_cit_ptv_fk", columnList = "cit_idf_cod,cit_emp_cod,cit_ptv_cod")
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "cit_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "cit_emp_cod", length = 4)),
	@AttributeOverride(name = "id.puntVendaCodi", column = @Column(name = "cit_ptv_cod", length = 4)),
	@AttributeOverride(name = "id.sequencia", column = @Column(name = "cit_seq")),
	@AttributeOverride(name = "embedded.sequencia", column = @Column(name = "cit_seq", insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "cit_cod", length = 34, nullable = false)),
	@AttributeOverride(name = "embedded.data", column = @Column(name = "cit_dat", nullable = false)),
	@AttributeOverride(name = "embedded.anulacioData", column = @Column(name = "cit_anudat", nullable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "cit_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "cit_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "cit_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "cit_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "cit_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
})
@EntityListeners(CitaEntityListener.class)
public class CitaEntity extends AbstractWithIdentificadorAuditableEntity<Cita, CitaPk> {

	@Embedded
	protected Cita embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cit_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cit_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private EmpresaEntity empresa;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cit_idf_cod", referencedColumnName = "ptv_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cit_emp_cod", referencedColumnName = "ptv_emp_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cit_ptv_cod", referencedColumnName = "ptv_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(
					name = "rcec_cit_ptv_fk",
					foreignKeyDefinition = "foreign key (cit_idf_cod, cit_emp_cod, cit_ptv_cod) references tges_ptv (ptv_idf_cod, ptv_emp_cod, ptv_cod)"))
	private PuntVendaEntity puntVenda;

	@Builder
	public CitaEntity(
			CitaPk pk,
			Cita embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa,
			PuntVendaEntity puntVenda) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;
		this.puntVenda = puntVenda;
	}

	@Override
	public void update(Cita embedded) {
		this.embedded = embedded;
	}

	public CitaPk getPkFromCodi() {
		return fromCodiToPk(getEmbedded().getCodi());
	}

	private static String fromPkToCodi(CitaPk pk) {
		String codi = pk.getIdentificadorCodi() + pk.getEmpresaCodi() + pk.getPuntVendaCodi() + pk.getSequencia();
		return new BigInteger(new String(Hex.encode(codi.getBytes())), 16).toString(36).toUpperCase();
	}

	public static CitaPk fromCodiToPk(String codi) {
		byte[] bytes = new BigInteger(codi, 36).toByteArray();
		int zeroPrefixLength = bytes.length;
		for (int i = 0; i < bytes.length; i++) {
	        if (bytes[i] != 0) {
	        	zeroPrefixLength = i;
	        	break;
	        }
	    }
		String dec = new String(bytes, zeroPrefixLength, bytes.length-zeroPrefixLength, StandardCharsets.UTF_8);
		return new CitaPk(
				dec.substring(0, 4),
				dec.substring(4, 8),
				dec.substring(8, 12),
				Integer.parseInt(dec.substring(12)));
	}

	public static class CitaEntityListener {
		@PrePersist
		public void calcular(CitaEntity cita) throws NoSuchAlgorithmException {
			int seq = EntityListenerUtil.getSeguentNumComptador(
					cita.getIdentificador().getId(),
					"TCEC_CIT");
			cita.getId().setSequencia(seq);
			cita.getEmbedded().setCodi(fromPkToCodi(cita.getId()));
		}
	}

}
