/**
 * 
 */
package es.limit.cecocloud.logic.test;

import java.io.Serializable;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.junit.Test;

import es.limit.cecocloud.logic.api.dto.util.AbstractIdentificableChild;
import es.limit.cecocloud.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.logic.api.dto.util.Identificable;
import lombok.Getter;
import lombok.Setter;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * Test per a l'encritació de contrasenyes.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class DtoConversionTest {

	@Test
	public void generatePassword() {
		Exemple dto = new Exemple();
		dto.setReference(GenericReference.toGenericReference(1L));
		dto.setRef(GenRef.toGenericReference("1"));
		dto.setCodi("TEST");
		dto.setNom("Test");
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		Exemple dtoConverted = mapperFactory.getMapperFacade().map(
				dto,
				Exemple.class);
		System.out.println(">>> dtoConverted: " + dtoConverted);
	}

	@Getter @Setter
	public static class Exemple extends AbstractIdentificableChild<Long, Long> {
		@Transient
		private GenericReference<Exemple, Long> reference;
		@Transient
		private GenRef<String> ref;
		private String codi;
		private String nom;
	}
	@Getter @Setter
	public static class GenRef<ID extends Serializable> implements Identificable<ID> {
		@NotNull
		protected ID id;
		protected String description;
		public static <D extends Identificable<ID>, ID extends Serializable> GenRef<ID> toGenericReference(D dto) {
			return toGenericReference(dto.getId());
		}
		public static <ID extends Serializable> GenRef<ID> toGenericReference(ID id) {
			GenRef<ID> genref = new GenRef<ID>();
			genref.setId(id);
			return genref;
		}
	}
}
