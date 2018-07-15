/**
 *
 */
package com.arrow.backoffice.service.impl;

import java.util.List;

import com.arrow.backoffice.dao.ArrowBackofficeServicesDao;
import com.arrow.backoffice.dto.ArgoPriceDTO;
import com.arrow.backoffice.service.ArrowBackofficeServicesService;


/**
 * @author ravi kumar
 *
 */
public class DefaultArrowBackofficeServicesService implements ArrowBackofficeServicesService
{

	ArrowBackofficeServicesDao arrowBackofficeServicesDao;


	/**
	 * @return the arrowBackofficeServicesDao
	 */
	public ArrowBackofficeServicesDao getArrowBackofficeServicesDao()
	{
		return arrowBackofficeServicesDao;
	}

	/**
	 * @param arrowBackofficeServicesDao
	 *           the arrowBackofficeServicesDao to set
	 */
	public void setArrowBackofficeServicesDao(final ArrowBackofficeServicesDao arrowBackofficeServicesDao)
	{
		this.arrowBackofficeServicesDao = arrowBackofficeServicesDao;
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see com.arrow.backoffice.service.ArrowBackofficeServicesService#persistArgoprice(com.arrow.backoffice.dto.
	 * ArgoPriceDTO)
	 */
	@Override
	public void persistArgoprice(final ArgoPriceDTO argoPriceDTO)
	{
		getArrowBackofficeServicesDao().persistArgoprice(argoPriceDTO);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.arrow.backoffice.service.ArrowBackofficeServicesService#findAll()
	 */
	@Override
	public List<ArgoPriceDTO> findAll()
	{
		return getArrowBackofficeServicesDao().findAll();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.arrow.backoffice.service.ArrowBackofficeServicesService#updateArgoPrice(int)
	 */
	@Override
	public void updateArgoPrice(final ArgoPriceDTO argoPriceDTO)
	{

		getArrowBackofficeServicesDao().updateArgoPrice(argoPriceDTO);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.arrow.backoffice.service.ArrowBackofficeServicesService#deleteArgoPrice(int)
	 */
	@Override
	public void deleteArgoPrice(final Integer partId)
	{
		getArrowBackofficeServicesDao().deleteArgoPrice(partId);
	}

}
