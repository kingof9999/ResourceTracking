package model.bean;

/**
 * PublicHoliday
 * 
 * Version 1.3
 * 
 * Date: 03/05/2017
 *
 * Copyright
 * 
 * Modification Logs:
 * DATE				AUTHOR			DECRIPTION
 * -------------------------------------------
 * 05/05/2017		TinLQ			Create
 */
public class PublicHoliday {
	private String nameCountry;
	private String datePublicHoliday;
	private String idPublicHoliday;
	private String message;
	
	/**
	 * the message to get
	 * @return
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * @param message
	 * the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * the idPublicHoliday to get
	 * @return
	 */
	public String getIdPublicHoliday() {
		return idPublicHoliday;
	}
	
	/**
	 * @param idPublicHoliday
	 * the idPublicHoliday to set
	 */
	public void setIdPublicHoliday(String idPublicHoliday) {
		this.idPublicHoliday = idPublicHoliday;
	}
	
	/**
	 * the nameCountry to get
	 * @return
	 */
	public String getNameCountry() {
		return nameCountry;
	}
	
	/**
	 * @param nameCountry
	 * the nameCountry to set
	 */
	public void setNameCountry(String nameCountry) {
		this.nameCountry = nameCountry;
	}
	
	/**
	 * the datePublicHoliday to get
	 * @return
	 */
	public String getDatePublicHoliday() {
		return datePublicHoliday;
	}
	
	/**
	 * @param datePublicHoliday
	 * the datePublicHoliday to set
	 */
	public void setDatePublicHoliday(String datePublicHoliday) {
		this.datePublicHoliday = datePublicHoliday;
	}
	
	
	
}
