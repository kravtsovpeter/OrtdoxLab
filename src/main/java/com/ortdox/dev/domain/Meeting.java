package com.ortdox.dev.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Бизнес объект встреча
 * @author pkravtsov
 */
@Entity
public class Meeting {
	
	/**
	 * Пустой конструктоор для Spring
	 */
	public Meeting() {
	}
	
	
	/**
	 * Конструктор встречи
	 * @param place Место встречи
	 * @param owner Автор встречи
	 */
	public Meeting(String place, String owner, Date date) {
		super();
		this.place = place;
		this.owner = owner;
		this.date = date;
	}



	/** Идентификатор встречи */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	/** Место встречи */
	private String place;
	
	/** Автор втречи */
	private String owner;
	
	/** Дата встречи */
	@Column(name="meetingDate", columnDefinition="DATE")
	private Date date;
	
	@Transient
	private String formatedDate;

	/**
	 * @return Идентификатор встречи
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Установить идентификатор встречи
	 * @param id Идентификатор встречи
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return Место встречи
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * Установить место встречи
	 * @param place Место встречи
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * @return Автор встречи
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Установить автора встречи
	 * @param owner Автор встречи
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return Дата встречи
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Установить дату встречи
	 * @param date Дата встречи
	 */
	public void setDate(Date date) {
		this.date = date;
	}


	public String getFormatedDate() {
		return formatedDate;
	}


	public void setFormatedDate(String formatedDate) {
		this.formatedDate = formatedDate;
	}

}
