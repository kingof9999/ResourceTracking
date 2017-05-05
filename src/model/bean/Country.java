package model.bean;

/**
 * Country
 * 
 * Version 1.0
 * 
 * Date: 03/05/2017
 *
 * Copyright
 * 
 * Modification Logs:
 * DATE				AUTHOR			DECRIPTION
 * -------------------------------------------
 * 03/05/2017		TinLQ			Create
 */
public class Country {
	private String idCountry;
	private String nameCountry;
	
	/**
	 * the idCountry to get
	 * @return
	 */
	public String getIdCountry() {
		return idCountry;
	}
	
	/**
	 * @param idCountry
	 * the idCountry to set
	 */
	public void setIdCountry(String idCountry) {
		this.idCountry = idCountry;
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
	
}
