
package com.cg.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Screen {

	private Integer screenId;
	private Integer theaterId;
	private Integer rows;
	private Integer columns;
	private LocalDate movieEndDate;
	private String screenName;
	private List<Show> showList = new ArrayList<Show>();

	public Screen(Integer theaterId, String screenName) {

		this.theaterId = theaterId;
		this.screenId = screenIdGenerator();
		this.screenName = screenName;
	}

	public void searchShow(String show) {

	}

	public void showShows() {

	}

	public Integer getScreenId() {
		return screenId;
	}

	public Integer getTheaterId() {
		return theaterId;
	}

	public Integer getRows() {
		return rows;
	}

	public Integer getColumns() {
		return columns;
	}

	public LocalDate getMovieEndDate() {
		return movieEndDate;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setShow(Show show) {
		showList.add(show);
	}

	public List<Show> getShowList() {
		return showList;
	}

	public void removeShow(Show show) {

		showList.remove(show);
	}

	public Integer screenIdGenerator() {

		return new Random().nextInt(100) * 10000 + theaterId;

	}

}
