package org.project.neutrino.nfvo.vim_interfaces;

import org.project.neutrino.nfvo.catalogue.mano.descriptor.VirtualDeploymentUnit;
import org.project.neutrino.nfvo.catalogue.mano.record.VirtualNetworkFunctionRecord;
import org.project.neutrino.nfvo.catalogue.nfvo.Server;
import org.project.neutrino.nfvo.catalogue.nfvo.VimInstance;
import org.project.neutrino.nfvo.vim_interfaces.exceptions.VimException;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.Future;

/**
 * Created by mpa on 30/04/15.
 */

public interface ResourceManagement {
	/**
	 * This operation allows requesting the instantiation and 
	 * assignment of a virtualised resource to the VNF, as 
	 * indicated by the consumer functional block.
	 */
	@Async
	Future<String> allocate(VirtualDeploymentUnit vdu, VirtualNetworkFunctionRecord virtualNetworkFunctionRecord) throws VimException;
	
	/**
	 * This operation allows querying a virtualised resource, 
	 * i.e. retrieve information about an instantiated virtualised 
	 * resource.
	 * @param vimInstance
	 */
	List<Server> queryResources(VimInstance vimInstance) throws VimException;
	
	/**
	 * This operation allows updating the configuration and/or 
	 * parameterization of an instantiated virtualised resource.
	 * @param vdu
	 */
	void update(VirtualDeploymentUnit vdu) throws VimException;
	
	/**
	 * This operation allows scaling a virtualised resource by 
	 * adding or removing capacity, e.g. adding vCPUs to a 
	 * virtual machine.
	 * @param vdu
	 */
	void scale(VirtualDeploymentUnit vdu) throws VimException;
	
	/**
	 * This operation allows moving virtualised resources 
	 * between locations. For instance, the operation performs 
	 * the migration of a computing resource from one host to 
	 * another host; while for a storage resource, it migrates 
	 * the resource from one storage location to another.
	 * @param vdu
	 */
	void migrate(VirtualDeploymentUnit vdu) throws VimException;

	/**
	* This operation allows executing specific commands on 
	* certain allocated virtualised resources. Examples on 
	* compute resources can include (but not limited to): start, 
	* stop, pause, suspend, capture snapshot, etc.
	* @param vdu
	* @param operation
	*/
	void operate(VirtualDeploymentUnit vdu, String operation) throws VimException;
	
	/**
	 * This operation allows de-allocating and terminating an 
	 * instantiated virtualised resource. This operation frees 
	 * resources and returns them to the NFVI resource pool.
	 * @param vdu
	 */
	void release(VirtualDeploymentUnit vdu) throws VimException;
	
	/**
	 * This operation allows requesting the reservation of a set 
	 * of virtualised resources to a consumer functional block 
	 * without performing the steps of "Allocate Resource".
	 * @param vdu
	 */
	void createReservation(VirtualDeploymentUnit vdu) throws VimException;
	
	/**
	 * This operation allows querying an issued resources 
	 * reservation, e.g. to discover the virtualised resources
	 * included in a specific reserved resources pool, or the 
	 * amount of free resources in such a pool.
	 */
	void queryReservation() throws VimException;
	
	/**
	 * This operation allows updating an issued resources 
	 * reservation to increase or decrease the amount of 
	 * virtualised resources in the reserved resources pool.
	 * @param vdu
	 */
	void updateReservation(VirtualDeploymentUnit vdu) throws VimException;
	
	/**
	 * This operation allows releasing an issued resources 
	 * reservation, hence freeing the reserved virtualised 
	 * resources.
	 * @param vdu
	 */
	void releaseReservation(VirtualDeploymentUnit vdu) throws VimException;
}
