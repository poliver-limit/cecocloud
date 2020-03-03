/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.entity;

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

import es.limit.cecocloud.rrhh.logic.api.dto.Node;
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
//import es.limit.cecocloud.rrhh.logic.api.dto.Node.NodePk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un Node.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "trhu_nod",
		indexes = {
				@Index(name = "irhu_nod_idf_fk", columnList = "nod_idf_cod"),
				@Index(name = "irrhu_nod_pk", columnList = "nod_idf_cod,nod_num", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "nod_idf_cod", length = 4)),
//	@AttributeOverride(name = "id.numero", column = @Column(name = "nod_num")),
	@AttributeOverride(name = "id.codi", column = @Column(name = "nod_num")),
	
//	@AttributeOverride(name = "embedded.numero", column = @Column(name = "nod_num", insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "nod_num", insertable = false, updatable = false)),
	
	@AttributeOverride(name = "embedded.tipus", column = @Column(name = "nod_tip")),
//	@AttributeOverride(name = "embedded.zonaOrigenCodi", column = @Column(name = "nod_zon_codori", length = 4)),
//	@AttributeOverride(name = "embedded.zonaDestiCodi", column = @Column(name = "nod_zon_coddti", length = 4)),
//	@AttributeOverride(name = "embedded.servidorCodi", column = @Column(name = "nod_sno_cod", length = 4)),
	@AttributeOverride(name = "embedded.tipus1", column = @Column(name = "nod_tip1", length = 10)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "nod_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "nod_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "nod_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "nod_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "nod_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rrhu_nod_idf_fk"))
})

//public class NodeEntity extends AbstractAmbIdentificadorEntity<Node, NodePk> {
public class NodeEntity extends AbstractWithIdentificadorAuditableEntity<Node, WithIdentificadorAndCodiPk<String>> {


	@Embedded
	protected Node embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = { 
					@JoinColumn(name = "nod_idf_cod", referencedColumnName = "zon_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "nod_zon_codori", referencedColumnName = "zon_cod", insertable = false, updatable = false)
					},
			foreignKey = @ForeignKey(name = "rrhu_nod_zon_ori_fk"))
	protected ZonaEntity zonaOrigen;	
	@Column(name = "nod_zon_codori", length = 4)
	private String zonaOrigenCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = { 
					@JoinColumn(name = "nod_idf_cod", referencedColumnName = "zon_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "nod_zon_coddti", referencedColumnName = "zon_cod", insertable = false, updatable = false)
					},
			foreignKey = @ForeignKey(name = "rrhu_nod_zon_dti_fk"))
	protected ZonaEntity zonaDesti;	
	@Column(name = "nod_zon_coddti", length = 4)
	private String zonaDestiCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = { 
					@JoinColumn(name = "nod_idf_cod", referencedColumnName = "sno_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "nod_sno_cod", referencedColumnName = "sno_cod", insertable = false, updatable = false)
					},
					foreignKey = @ForeignKey(name = "rrhu_nod_sno_fk"))
	protected ServidorEntity servidor;
	@Column(name = "nod_sno_cod", length = 4)
	private String servidorCodi;

	@Builder
	public NodeEntity(
//			NodePk pk,
			WithIdentificadorAndCodiPk<String> pk,
			Node embedded,
			IdentificadorEntity identificador,
			ServidorEntity servidor,
			ZonaEntity zonaOrigen,
			ZonaEntity zonaDesti) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		
		this.servidorCodi = servidor.getEmbedded().getCodi();
		this.zonaOrigenCodi = zonaOrigen.getEmbedded().getCodi();
		this.zonaDestiCodi = zonaDesti.getEmbedded().getCodi();
		
	}

	@Override
	public void update(Node embedded) {
		this.embedded = embedded;
	}
	
	public void updateServidor (ServidorEntity servidor) {
		this.servidorCodi = servidor.getEmbedded().getCodi();
	}
	
	public void updateZonaOrigen (ZonaEntity zonaOrigen) {
		this.zonaOrigenCodi = zonaOrigen.getEmbedded().getCodi();
	}
	
	public void updateZonaDesti (ZonaEntity zonaDesti) {
		this.zonaDestiCodi = zonaDesti.getEmbedded().getCodi();
	}

}
