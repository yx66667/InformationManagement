package model;

import java.sql.Date;

public class Film {
	private int id;
	private String name;
	private String type;
	private Date showtime;
	private int producer_id;
	public Film(){
		
	}
	public Film(int id, String name, String type, Date showtime, int producer_id) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.showtime = showtime;
		this.producer_id = producer_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getShowtime() {
		return showtime;
	}
	public void setShowtime(Date showtime) {
		this.showtime = showtime;
	}
	public int getProducer_id() {
		return producer_id;
	}
	public void setProducer_id(int producer_id) {
		this.producer_id = producer_id;
	}

}
