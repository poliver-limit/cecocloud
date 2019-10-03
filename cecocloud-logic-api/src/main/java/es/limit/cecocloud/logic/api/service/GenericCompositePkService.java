/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import es.limit.cecocloud.logic.api.dto.util.IdentificableWithCompositePk;

/**
 * Servei genèric per a gestionar una entitat del model de dades amb clau
 * primària composta.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface GenericCompositePkService<D extends IdentificableWithCompositePk<?>> extends GenericService<D, String> {

}
