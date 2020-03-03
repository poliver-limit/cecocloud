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
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.rrhh.logic.api.dto.GrupFestiu;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un GrupFestiu.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "trhu_gfe",
		indexes = {
				@Index(name = "irhu_gfe_idf_fk", columnList = "gfe_idf_cod"),
				@Index(name = "irrhu_gfe_pk", columnList = "gfe_idf_cod,gfe_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "gfe_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "gfe_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "gfe_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "gfe_nom", length = 60, nullable = false)),
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "gfe_obs", length = 1000))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "gfe_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rrhu_gfe_idf_fk"))
})
public class GrupFestiuEntity extends AbstractWithIdentificadorEntity<GrupFestiu, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected GrupFestiu embedded;	

	@Builder
	public GrupFestiuEntity(
			WithIdentificadorAndCodiPk<String> pk,
			GrupFestiu embedded,
			IdentificadorEntity identificador
		) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;			

	}

	@Override
	public void update(GrupFestiu embedded) {
		this.embedded = embedded;
	}

}
