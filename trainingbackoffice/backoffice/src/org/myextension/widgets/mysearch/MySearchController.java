package org.myextension.widgets.mysearch;

import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.ext.Selectable;

import com.arrow.backoffice.dto.ArgoPriceDTO;
import com.arrow.backoffice.service.ArrowBackofficeServicesService;
import com.hybris.cockpitng.annotations.ViewEvent;
import com.hybris.cockpitng.util.DefaultWidgetController;


public class MySearchController extends DefaultWidgetController
{

	@Wire
	private Textbox keywordBox;
	@Wire
	private Textbox partIdText;
	@Wire
	private Textbox sourceCodeText;
	@Wire
	private Textbox sourcePartIdText;
	@Wire
	private Textbox priceText;
	@Wire
	private Textbox minQuantityText;
	@Wire
	private Textbox maxQuantityText;
	@Wire
	private Textbox resaleNoteText;
	@Wire
	private Groupbox visibleGroupBox;
	@Wire
	private Datebox modifiedDateText;
	@Wire
	private Listbox argoPriceListBox;


	@WireVariable
	private ArrowBackofficeServicesService arrowBackofficeServicesService;


	/*
	 * (non-Javadoc)
	 *
	 * @see com.hybris.cockpitng.util.DefaultWidgetController#initialize(org.zkoss.zk.ui.Component)
	 */
	@Override
	public void initialize(final Component comp)
	{
		super.initialize(comp);
		argoPriceListBox.setModel(new ListModelList<ArgoPriceDTO>(arrowBackofficeServicesService.findAll()));
		visibleGroupBox.setVisible(false);

	}


	@ViewEvent(componentID = "searchButton", eventName = Events.ON_CLICK)
	public void search()
	{
		visibleGroupBox.setVisible(false);
		final String keyword = keywordBox.getValue();
		final List<ArgoPriceDTO> result = search(keyword);
		argoPriceListBox.setModel(new ListModelList<ArgoPriceDTO>(result));
	}


	@ViewEvent(componentID = "refreshButton", eventName = Events.ON_CLICK)
	public void refreshArgoPriceList()
	{
		argoPriceListBox.setModel(new ListModelList<ArgoPriceDTO>(arrowBackofficeServicesService.findAll()));
		visibleGroupBox.setVisible(false);
	}

	@ViewEvent(componentID = "argoPriceListBox", eventName = Events.ON_SELECT)
	public void showDetail()
	{
		final Set<ArgoPriceDTO> selection = ((Selectable<ArgoPriceDTO>) argoPriceListBox.getModel()).getSelection();
		if (selection != null && !selection.isEmpty())
		{
			visibleGroupBox.setVisible(true);
			final ArgoPriceDTO selected = selection.iterator().next();
			partIdText.setValue(selected.getPartId().toString());
			sourceCodeText.setValue(selected.getSourceCode());
			//sourcePartIdText.setValue(selected.getSourcePartId());
			priceText.setValue(selected.getPrice().toString());
			minQuantityText.setValue(selected.getMinQuantity().toString());
			maxQuantityText.setValue(selected.getMaxQuantity().toString());
			modifiedDateText.setValue(selected.getModifiedDate());
		}
	}

	@ViewEvent(componentID = "getCreateForm", eventName = Events.ON_CLICK)
	public void getCreateForm(final Event componentID)
	{
		visibleGroupBox.setVisible(true);
		sourceCodeText = (Textbox) componentID.getTarget().getFellow("sourceCodeText");
		sourceCodeText.setValue("");
		priceText = (Textbox) componentID.getTarget().getFellow("priceText");
		priceText.setValue("");
		minQuantityText = (Textbox) componentID.getTarget().getFellow("minQuantityText");
		minQuantityText.setValue("");
		maxQuantityText = (Textbox) componentID.getTarget().getFellow("maxQuantityText");
		maxQuantityText.setValue("");
		partIdText = (Textbox) componentID.getTarget().getFellow("partIdText");
		partIdText.setValue("");

	}


	@ViewEvent(componentID = "createPrice", eventName = Events.ON_CLICK)
	public void createArgoPrice(final Event componentID)
	{

		final Date date = modifiedDateText.getValue();
		final Timestamp timestamp = new Timestamp(date.getTime());
		final ArgoPriceDTO argoPriceDTO = new ArgoPriceDTO();
		argoPriceDTO.setPartId(Integer.parseInt(partIdText.getValue()));
		argoPriceDTO.setSourceCode(sourceCodeText.getValue());
		//argoPriceDTO.setSourcePartId(sourcePartIdText.getValue());
		argoPriceDTO.setMinQuantity(Integer.parseInt(minQuantityText.getValue()));
		argoPriceDTO.setMaxQuantity(Integer.parseInt(maxQuantityText.getValue()));
		argoPriceDTO.setPrice(Double.parseDouble(priceText.getValue()));
		//argoPriceDTO.setResaleNote(resaleNoteText.getValue());
		argoPriceDTO.setModifiedDate(timestamp);
		arrowBackofficeServicesService.persistArgoprice(argoPriceDTO);
		Messagebox.show("ArgoPrice created successfully");
		visibleGroupBox.setVisible(false);
		sourceCodeText = (Textbox) componentID.getTarget().getFellow("sourceCodeText");
		sourceCodeText.setValue("");
		priceText = (Textbox) componentID.getTarget().getFellow("priceText");
		priceText.setValue("");
		minQuantityText = (Textbox) componentID.getTarget().getFellow("minQuantityText");
		minQuantityText.setValue("");
		maxQuantityText = (Textbox) componentID.getTarget().getFellow("maxQuantityText");
		maxQuantityText.setValue("");
		partIdText = (Textbox) componentID.getTarget().getFellow("partIdText");
		partIdText.setValue("");

	}

	@ViewEvent(componentID = "editPrice", eventName = Events.ON_CLICK)
	public void editArgoPrice()
	{
		final Date date = modifiedDateText.getValue();
		final Timestamp timestamp = new Timestamp(date.getTime());
		final ArgoPriceDTO argoPriceDTO = new ArgoPriceDTO();
		argoPriceDTO.setPartId(Integer.parseInt(partIdText.getValue()));
		argoPriceDTO.setSourceCode(sourceCodeText.getValue());
		//argoPriceDTO.setSourcePartId(sourcePartIdText.getValue());
		argoPriceDTO.setMinQuantity(Integer.parseInt(minQuantityText.getValue()));
		argoPriceDTO.setMaxQuantity(Integer.parseInt(maxQuantityText.getValue()));
		argoPriceDTO.setPrice(Double.parseDouble(priceText.getValue()));
		//argoPriceDTO.setResaleNote(resaleNoteText.getValue());
		argoPriceDTO.setModifiedDate(timestamp);
		arrowBackofficeServicesService.updateArgoPrice(argoPriceDTO);
		Messagebox.show("ArgoPrice updated successfully");

	}

	@ViewEvent(componentID = "deletePrice", eventName = Events.ON_CLICK)
	public void deleteArgoPrice()
	{
		final String partId = partIdText.getValue();
		arrowBackofficeServicesService.deleteArgoPrice(Integer.parseInt(partId));
		Messagebox.show("ArgoPrice deleted successfully");

	}

	public List<ArgoPriceDTO> search(final String keyword)
	{
		final List<ArgoPriceDTO> argoPriceList = arrowBackofficeServicesService.findAll();
		List<ArgoPriceDTO> result = new LinkedList<ArgoPriceDTO>();
		if (keyword == null || "".equals(keyword))
		{
			result = argoPriceList;
		}
		else
		{
			for (final ArgoPriceDTO argoPriceDTO : argoPriceList)
			{
				if (argoPriceDTO.getSourceCode().toLowerCase().contains(keyword.toLowerCase()))

				{
					result.add(argoPriceDTO);
				}
			}
		}
		return result;
	}

	/**
	 * @return the argoPriceListBox
	 */
	public Listbox getArgoPriceListBox()
	{
		return argoPriceListBox;
	}

	/**
	 * @param argoPriceListBox
	 *           the argoPriceListBox to set
	 */
	public void setArgoPriceListBox(final Listbox argoPriceListBox)
	{
		this.argoPriceListBox = argoPriceListBox;
	}





}
