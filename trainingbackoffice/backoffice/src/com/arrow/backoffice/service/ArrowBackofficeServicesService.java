/**
 *
 */
package com.arrow.backoffice.service;

import java.util.List;

import com.arrow.backoffice.dto.ArgoPriceDTO;


/**
 * @author ravi kumar
 *
 */
public interface ArrowBackofficeServicesService
{
	void persistArgoprice(ArgoPriceDTO argoPriceDTO);

	List<ArgoPriceDTO> findAll();

	void updateArgoPrice(ArgoPriceDTO argoPriceDTO);

	void deleteArgoPrice(Integer partId);
}
