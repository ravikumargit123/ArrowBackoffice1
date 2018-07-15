/**
 *
 */
package com.arrow.backoffice.dao;

import java.util.List;

import com.arrow.backoffice.dto.ArgoPriceDTO;


/**
 * @author ravi kumar
 *
 */
public interface ArrowBackofficeServicesDao
{

	void persistArgoprice(ArgoPriceDTO argoPriceDTO);

	List<ArgoPriceDTO> findAll();

	void updateArgoPrice(ArgoPriceDTO argoPriceDTO);

	void deleteArgoPrice(Integer partId);
}
