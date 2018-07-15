/**
 *
 */
package com.arrow.backoffice.dto;

import java.sql.Timestamp;


/**
 * @author ravi kumar
 *
 */
public class ArgoPriceDTO
{
	private Integer partId;
	private String sourceCode;
	private String sourcePartId;
	private Double price;
	private Integer minQuantity;
	private Integer maxQuantity;
	private String resaleNote;
	private Timestamp modifiedDate;

	/**
	 * @return the partId
	 */
	public Integer getPartId()
	{
		return partId;
	}

	/**
	 * @param partId
	 *           the partId to set
	 */
	public void setPartId(final Integer partId)
	{
		this.partId = partId;
	}

	/**
	 * @return the sourceCode
	 */
	public String getSourceCode()
	{
		return sourceCode;
	}

	/**
	 * @param sourceCode
	 *           the sourceCode to set
	 */
	public void setSourceCode(final String sourceCode)
	{
		this.sourceCode = sourceCode;
	}

	/**
	 * @return the sourcePartId
	 */
	public String getSourcePartId()
	{
		return sourcePartId;
	}

	/**
	 * @param sourcePartId
	 *           the sourcePartId to set
	 */
	public void setSourcePartId(final String sourcePartId)
	{
		this.sourcePartId = sourcePartId;
	}

	/**
	 * @return the price
	 */
	public Double getPrice()
	{
		return price;
	}

	/**
	 * @param price
	 *           the price to set
	 */
	public void setPrice(final Double price)
	{
		this.price = price;
	}

	/**
	 * @return the minQuantity
	 */
	public Integer getMinQuantity()
	{
		return minQuantity;
	}

	/**
	 * @param minQuantity
	 *           the minQuantity to set
	 */
	public void setMinQuantity(final Integer minQuantity)
	{
		this.minQuantity = minQuantity;
	}

	/**
	 * @return the maxQuantity
	 */
	public Integer getMaxQuantity()
	{
		return maxQuantity;
	}

	/**
	 * @param maxQuantity
	 *           the maxQuantity to set
	 */
	public void setMaxQuantity(final Integer maxQuantity)
	{
		this.maxQuantity = maxQuantity;
	}

	/**
	 * @return the resaleNote
	 */
	public String getResaleNote()
	{
		return resaleNote;
	}

	/**
	 * @param resaleNote
	 *           the resaleNote to set
	 */
	public void setResaleNote(final String resaleNote)
	{
		this.resaleNote = resaleNote;
	}

	/**
	 * @return the modifiedDate
	 */
	public Timestamp getModifiedDate()
	{
		return modifiedDate;
	}

	/**
	 * @param modifiedDate
	 *           the modifiedDate to set
	 */
	public void setModifiedDate(final Timestamp modifiedDate)
	{
		this.modifiedDate = modifiedDate;
	}




}
