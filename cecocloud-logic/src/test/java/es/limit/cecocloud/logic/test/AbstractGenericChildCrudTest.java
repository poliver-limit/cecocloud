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

import es.limit.cecocloud.logic.api.dto.util.IdentificableChild;
import es.limit.cecocloud.logic.api.service.GenericChildService;
import lombok.extern.slf4j.Slf4j;

/**
 * Test d'operacions CRUD.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public abstract class AbstractGenericChildCrudTest<S extends GenericChildService<D, PID, ID>, D extends IdentificableChild<PID, ID>, PID extends Serializable, ID extends Serializable> {

	@Test
	public void crudTest() {
		String dtoClassName = getDtoClassName();
		log.debug("Test CRUD per a elements de tipus " + dtoClassName);
		D dto = createDto();
		log.debug("    Creant " + dtoClassName + " (parentId=" + getParentId() + ", dto=" + dto + ")...");
		D created = getService().create(
				getParentId(),
				dto);
		assertNotNull(created);
		assertNotNull(created.getId());
		log.debug("   ...creat (resposta=" + created + ")");
		log.debug("   Verificant " + dtoClassName + " retornat...");
		compareDto(dto, created);
		log.debug("   ...verificació Ok");
		log.debug("   Consultant " + dtoClassName + " creat (parentId=" + getParentId() + ", id=" + created.getId() + ")...");
		D retrievedCreate = getService().getOne(
				getParentId(),
				created.getId());
		assertNotNull(retrievedCreate);
		assertNotNull(retrievedCreate.getId());
		log.debug("   ...consulta Ok (resposta=" + retrievedCreate + ")");
		log.debug("   Verificant " + dtoClassName + " retornat...");
		compareDto(dto, retrievedCreate);
		log.debug("   ...verificació Ok");
		updateDto(dto);
		log.debug("   Modificant " + dtoClassName + " (parentId=" + getParentId() + ", id=" + created.getId() + ", dto=" + dto + ")...");
		D updated = getService().update(
				getParentId(),
				created.getId(),
				dto);
		assertNotNull(updated);
		assertNotNull(updated.getId());
		log.debug("   ...modificat (resposta=" + updated + ")");
		log.debug("   Verificant " + dtoClassName + " retornat...");
		compareDto(dto, updated);
		log.debug("   ...verificació Ok");
		log.debug("   Consultant " + dtoClassName + " modificat (parentId=" + getParentId() + ", id=" + created.getId() + ")...");
		D retrievedUpdate = getService().getOne(
				getParentId(),
				created.getId());
		assertNotNull(retrievedUpdate);
		assertNotNull(retrievedUpdate.getId());
		log.debug("   ...consulta Ok (resposta=" + retrievedUpdate + ")");
		log.debug("   Verificant " + dtoClassName + " retornat...");
		compareDto(dto, retrievedUpdate);
		log.debug("   ...verificació Ok");
		log.debug("   Esborrant " + dtoClassName + " (parentId=" + getParentId() + ", id=" + created.getId() + ")...");
		getService().delete(
				getParentId(),
				created.getId());
		log.debug("   ...esborrat Ok");
		log.debug("   Verificant que el " + dtoClassName + " esborrat ja no existeix (parentId=" + getParentId() + ", id=" + created.getId() + ")...");
		try {
			getService().getOne(
					getParentId(),
					created.getId());
			fail("L'element esborrat encara existeix");
		} catch (EntityNotFoundException expected) {
			log.debug("   ...verificació Ok");
		}
	}

	protected abstract PID getParentId();
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
