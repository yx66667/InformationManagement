package model;

import java.sql.Date;

public class FilmProducer {
	private int film_id;
	private String film_name;
	private String film_type;
	private Date showtime;
	private String producer_name;
	private int producer_age;
	private String producer_gender;
	
	
	public FilmProducer() {
		super();
	}

	public FilmProducer(int film_id, String film_name, String film_type, Date showtime, String producer_name,
			int producer_age, String producer_gender) {
		super();
		this.film_id = film_id;
		this.film_name = film_name;
		this.film_type = film_type;
		this.showtime = showtime;
		this.producer_name = producer_name;
		this.producer_age = producer_age;
		this.producer_gender = producer_gender;
	}

	public int getFilm_id() {
		return film_id;
	}

	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}

	public String getFilm_name() {
		return film_name;
	}

	public void setFilm_name(String film_name) {
		this.film_name = film_name;
	}

	public String getFilm_type() {
		return film_type;
	}

	public void setFilm_type(String film_type) {
		this.film_type = film_type;
	}

	public Date getShowtime() {
		return showtime;
	}

	public void setShowtime(Date showtime) {
		this.showtime = showtime;
	}

	public String getProducer_name() {
		return producer_name;
	}

	public void setProducer_name(String producer_name) {
		this.producer_name = producer_name;
	}

	public int getProducer_age() {
		return producer_age;
	}

	public void setProducer_age(int producer_age) {
		this.producer_age = producer_age;
	}

	public String getProducer_gender() {
		return producer_gender;
	}

	public void setProducer_gender(String producer_gender) {
		this.producer_gender = producer_gender;
	}
	
	

}
