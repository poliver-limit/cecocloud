/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.jdbc.dialect.internal.StandardDialectResolver;
import org.hibernate.engine.jdbc.dialect.spi.DatabaseMetaDataDialectResolutionInfoAdapter;
import org.hibernate.engine.jdbc.dialect.spi.DialectResolver;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.api.dto.util.AuthenticationFacade;
import es.limit.base.boot.logic.service.AuthServiceImpl.BaseBootAuthenticationToken;
import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.service.IdentificadorService;
import es.limit.cecocloud.persist.entity.CompanyiaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.CompanyiaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió d'identificadors.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("comuIdentificadorServiceImpl")
public class IdentificadorServiceImpl extends AbstractGenericServiceImpl<Identificador, IdentificadorEntity, String> implements IdentificadorService {

	@Autowired
	private CompanyiaRepository companyiaRepository;
	@Autowired
	private IdentificadorRepository identificadorRepository;
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	@Autowired
	private AuthenticationFacade authenticationFacade;
	
	@Override
	protected void beforeCreate(IdentificadorEntity entity, Identificador dto) {
		// Agafam la companyia de la sessió
		
		BaseBootAuthenticationToken auth = (BaseBootAuthenticationToken)authenticationFacade.getAuthentication();
		UserSession session = (UserSession)auth.getSession();
		CompanyiaEntity companyia = companyiaRepository.getOne(session.getCompanyia());
		entity.updateCompanyia(companyia);
		String codi;
		boolean exist = false;
		do {
			codi = generateCode();
			Optional<IdentificadorEntity> idf = identificadorRepository.findById(codi);
			exist = idf.isPresent();
		} while (exist);
		entity.setCodi(codi);
	}

	private String generateCode() {
        ReturningWork<Long> codeReturningWork = new ReturningWork<Long>() {
            @Override
            public Long execute(Connection connection) throws SQLException {
                DialectResolver dialectResolver = new StandardDialectResolver();
                Dialect dialect =  dialectResolver.resolveDialect(
                        new DatabaseMetaDataDialectResolutionInfoAdapter(connection.getMetaData()));
                PreparedStatement preparedStatement = null;
                ResultSet resultSet = null;
                try {
                    preparedStatement = connection.prepareStatement( dialect.getSequenceNextValString("identificador_sequence"));
                    resultSet = preparedStatement.executeQuery();
                    resultSet.next();
                    return resultSet.getLong(1);
                }catch (SQLException e) {
                    throw e;
                } finally {
                    if(preparedStatement != null) {
                        preparedStatement.close();
                    }
                    if(resultSet != null) {
                        resultSet.close();
                    }
                }

            }
        };
        
        Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
        Long longCode = session.doReturningWork(codeReturningWork);
        session.close();
        return StringUtils.leftPad(Long.toString(longCode, 36).toUpperCase(), 4, "0");
    }
}
