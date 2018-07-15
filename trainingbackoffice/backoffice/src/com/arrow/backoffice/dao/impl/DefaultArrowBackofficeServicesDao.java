/**
 *
 */
package com.arrow.backoffice.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.arrow.backoffice.dao.ArrowBackofficeServicesDao;
import com.arrow.backoffice.dto.ArgoPriceDTO;


/**
 * @author ravi kumar
 *
 */
public class DefaultArrowBackofficeServicesDao implements ArrowBackofficeServicesDao
{

	private static final Logger LOG = Logger.getLogger(DefaultArrowBackofficeServicesDao.class);
	private DataSource dataSource;

	public void setDataSource(final DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	@Override
	public void persistArgoprice(final ArgoPriceDTO argoPriceDTO)
	{
		final String query = "insert into source_inventory_resale(part_id, source_code, price, min_quantity, max_quantity, modified_date) values (?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, argoPriceDTO.getPartId());
			ps.setString(2, argoPriceDTO.getSourceCode());
			//ps.setString(3, argoPriceDTO.getSourcePartId());
			ps.setDouble(3, argoPriceDTO.getPrice());
			ps.setInt(4, argoPriceDTO.getMinQuantity());
			ps.setInt(5, argoPriceDTO.getMaxQuantity());
			//ps.setString(7, argoPriceDTO.getResaleNote());
			ps.setTimestamp(6, argoPriceDTO.getModifiedDate());

			final int out = ps.executeUpdate();
			if (out != 0)
			{
				LOG.info("ArgoPrice saved with id=" + argoPriceDTO.getPartId());
			}
			else
			{
				LOG.info("ArgoPrice save failed with id=" + argoPriceDTO.getPartId());
			}
		}
		catch (final SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				ps.close();
				con.close();
			}
			catch (final SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.arrow.backoffice.dao.ArrowBackofficeServicesDao#findAll()
	 */
	@Override
	public List<ArgoPriceDTO> findAll()
	{
		final String query = "select part_id, source_code, price, min_quantity, max_quantity, modified_date from source_inventory_resale";
		final List<ArgoPriceDTO> argoPriceList = new ArrayList<ArgoPriceDTO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try
		{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next())
			{
				final ArgoPriceDTO argoPriceDTO = new ArgoPriceDTO();
				argoPriceDTO.setPartId(rs.getInt("part_id"));
				argoPriceDTO.setSourceCode(rs.getString("source_code"));
				//argoPriceDTO.setSourcePartId(rs.getString("source_part_id"));
				argoPriceDTO.setPrice(rs.getDouble("price"));
				argoPriceDTO.setMinQuantity(rs.getInt("min_quantity"));
				argoPriceDTO.setMaxQuantity(rs.getInt("max_quantity"));
				//argoPriceDTO.setResaleNote(rs.getString("resalenote"));
				argoPriceDTO.setModifiedDate(rs.getTimestamp("modified_date"));
				argoPriceList.add(argoPriceDTO);
			}
		}
		catch (final SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				rs.close();
				ps.close();
				con.close();
			}
			catch (final SQLException e)
			{
				e.printStackTrace();
			}
		}
		return argoPriceList;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.arrow.backoffice.dao.ArrowBackofficeServicesDao#updateArgoPrice(int)
	 */
	@Override
	public void updateArgoPrice(final ArgoPriceDTO argoPriceDTO)
	{
		final String query = "update source_inventory_resale set source_code=?, price=?, min_quantity=?, max_quantity=?,  modified_date=? where part_id=?";
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, argoPriceDTO.getSourceCode());
			//ps.setString(2, argoPriceDTO.getSourcePartId());
			ps.setDouble(2, argoPriceDTO.getPrice());
			ps.setInt(3, argoPriceDTO.getMinQuantity());
			ps.setInt(4, argoPriceDTO.getMaxQuantity());
			//ps.setString(6, argoPriceDTO.getResaleNote());
			ps.setTimestamp(5, argoPriceDTO.getModifiedDate());
			ps.setInt(6, argoPriceDTO.getPartId());
			final int out = ps.executeUpdate();
			if (out != 0)
			{
				LOG.info("ArgoPrice updated with id=" + argoPriceDTO.getPartId());
			}
			else
			{
				LOG.info("No ArgoPrice found with id=" + argoPriceDTO.getPartId());
			}
		}
		catch (final SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				ps.close();
				con.close();
			}
			catch (final SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.arrow.backoffice.dao.ArrowBackofficeServicesDao#deleteArgoPrice(int)
	 */
	@Override
	public void deleteArgoPrice(final Integer partId)
	{
		final String query = "delete from source_inventory_resale where part_id=?";
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, partId);
			final int out = ps.executeUpdate();
			if (out != 0)
			{
				LOG.info("ArgoPrice deleted with id=" + partId);
			}
			else
			{
				LOG.info("No ArgoPrice found with id=" + partId);
			}
		}
		catch (final SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				ps.close();
				con.close();
			}
			catch (final SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

}
