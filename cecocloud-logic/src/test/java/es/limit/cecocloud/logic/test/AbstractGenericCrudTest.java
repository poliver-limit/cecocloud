/**
 * 
 */
package es.limit.cecocloud.logic.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.limit.cecocloud.logic.api.dto.util.Identificable;
import es.limit.cecocloud.logic.api.service.GenericService;
import lombok.extern.slf4j.Slf4j;

/**
 * Test d'operacions CRUD.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public abstract class AbstractGenericCrudTest<S extends GenericService<D, ID>, D extends Identificable<ID>, ID extends Serializable> {

	@Test
	public void crudTest() {
		String dtoClassName = getDtoClassName();
		log.debug("Test CRUD per a elements de tipus " + dtoClassName);
		D dto = createDto();
		log.debug("    Creant " + dtoClassName + " (dto=" + dto + ")...");
		D created = getService().create(dto);
		assertNotNull(created);
		assertNotNull(created.getId());
		log.debug("   ...creat (resposta=" + created + ")");
		log.debug("   Verificant " + dtoClassName + " retornat...");
		compareDto(dto, created);
		log.debug("   ...verificació Ok");
		log.debug("   Consultant " + dtoClassName + " creat (id=" + created.getId() + ")...");
		D retrievedCreate = getService().getOne(created.getId());
		assertNotNull(retrievedCreate);
		assertNotNull(retrievedCreate.getId());
		log.debug("   ...consulta Ok (resposta=" + retrievedCreate + ")");
		log.debug("   Verificant " + dtoClassName + " retornat...");
		compareDto(dto, retrievedCreate);
		log.debug("   ...verificació Ok");
		updateDto(dto);
		log.debug("   Modificant " + dtoClassName + " (id=" + created.getId() + ", dto=" + dto + ")...");
		D updated = getService().update(
				created.getId(),
				dto);
		assertNotNull(updated);
		assertNotNull(updated.getId());
		log.debug("   ...modificat (resposta=" + updated + ")");
		log.debug("   Verificant " + dtoClassName + " retornat...");
		compareDto(dto, updated);
		log.debug("   ...verificació Ok");
		log.debug("   Consultant " + dtoClassName + " modificat (id=" + created.getId() + ")...");
		D retrievedUpdate = getService().getOne(created.getId());
		assertNotNull(retrievedUpdate);
		assertNotNull(retrievedUpdate.getId());
		log.debug("   ...consulta Ok (resposta=" + retrievedUpdate + ")");
		log.debug("   Verificant " + dtoClassName + " retornat...");
		compareDto(dto, retrievedUpdate);
		log.debug("   ...verificació Ok");
		log.debug("   Esborrant " + dtoClassName + " (id=" + created.getId() + ")...");
		getService().delete(created.getId());
		log.debug("   ...esborrat Ok");
		log.debug("   Verificant que el " + dtoClassName + " esborrat ja no existeix (id=" + created.getId() + ")...");
		try {
			getService().getOne(created.getId());
			fail("L'element esborrat encara existeix");
		} catch (EntityNotFoundException expected) {
			log.debug("   ...verificació Ok");
		}
	}

	protected abstract D createDto();
	protected abstract void updateDto(D dto);
	protected abstract void compareDto(D expected, D actual);
	protected abstract S getService();

	protected String getDtoClassName() {
		return getClassFromGenericType(0).getSimpleName();
	}

	private Class<?> getClassFromGenericType(int index) {
		Type genericSuperClass = getClass().getGenericSuperclass();
		while (genericSuperClass != null && !(genericSuperClass instanceof ParameterizedType)) {
			genericSuperClass = ((Class<?>)genericSuperClass).getGenericSuperclass();
		}
		ParameterizedType parameterizedType = (ParameterizedType)genericSuperClass;
		return (Class<?>)parameterizedType.getActualTypeArguments()[index];
	}

}
