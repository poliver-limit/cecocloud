/**
 * 
 */
package es.limit.cecocloud.persist.tools;

import java.util.EnumSet;

import javax.persistence.Entity;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.reflections.Reflections;

import es.limit.base.boot.persist.entity.AbstractEntity;
import es.limit.cecocloud.persist.entity.CompanyiaEntity;

/**
 * Utilitat per a la generació dels scripts SQL de creació de la BBDD.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class DdlScriptGenerator {

	public static void main(String[] args) {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
				//applySetting("hibernate.dialect", "org.hibernate.dialect.Oracle9iDialect").
				//applySetting("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect").
				applySetting("hibernate.dialect", "org.hibernate.dialect.HSQLDialect").
				build();
		MetadataSources metadataSources = new MetadataSources(serviceRegistry);
		addEntitiesInPackages(
				metadataSources,
				new String[] {
						AbstractEntity.class.getPackage().getName(),
						CompanyiaEntity.class.getPackage().getName()});
		Metadata metadata = metadataSources.buildMetadata();
		new SchemaExport().
		setDelimiter(";").
		setFormat(true).
        setOutputFile("db-schema.hibernate5.ddl").
        createOnly(EnumSet.of(TargetType.SCRIPT), metadata);
	}

	private static void addEntitiesInPackages(
			MetadataSources metadataSources,
			String[] packages) {
		for (String pack: packages) {
			new Reflections(pack).
			getTypesAnnotatedWith(Entity.class).
			forEach(metadataSources::addAnnotatedClass);
		}
	}

}
