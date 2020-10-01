package es.limit.cecocloud.fact.persist.entity;

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

import es.limit.cecocloud.fact.logic.api.dto.ConfiguracioImpressos;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity in database that represents configuracio d'impressos.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_cfg_rep",
		indexes = {
				@Index(name = "iges_cfg_idf_fk", columnList = "cfg_idf_cod"),
				@Index(name = "irges_cfg_pk", columnList = "cfg_idf_cod, cfg_emp_cod, cfg_ser_cod, cfg_cls, cfg_tip, cfg_subtip", unique = true)
		}
		
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "cfg_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "cfg_cod", length = 22)),
	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "cfg_cod", length = 22, precision = 10, scale = 0, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.tipo", column = @Column(name = "cfg_tip", length = 2, nullable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "cfg_nom", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.empresa", column = @Column(name = "cfg_emp_cod", length = 4)),
	@AttributeOverride(name = "embedded.serie", column = @Column(name = "cfg_ser_cod", length = 2)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "cfg_des", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.cls", column = @Column(name = "cfg_cls", length = 1)),
	@AttributeOverride(name = "embedded.subtipo", column = @Column(name = "cfg_subtip", length = 30)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "cfg_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "cfg_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "cfg_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "cfg_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "cfg_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_cfg_idf_fk"))
})
public class ConfiguracioImpressosEntity extends AbstractWithIdentificadorAuditableEntity<ConfiguracioImpressos, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected ConfiguracioImpressos embedded;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "cfg_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "cfg_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_cfg_emp_fk"))			
	protected EmpresaEntity empresa;	
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "cfg_idf_cod", referencedColumnName = "ser_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "cfg_ser_cod", referencedColumnName = "ser_cod", insertable = false, updatable = false),
					@JoinColumn(name = "cfg_emp_cod", referencedColumnName = "ser_emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_cfg_ser_fk"))			
	protected SerieVendaEntity serie;	

	@Builder
	public ConfiguracioImpressosEntity(
			WithIdentificadorAndCodiPk<String> pk,
			ConfiguracioImpressos embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa,
			SerieVendaEntity serie) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;
		this.serie = serie;
	}

	@Override
	public void update(ConfiguracioImpressos embedded) {
		this.embedded = embedded;
	}
	
}
