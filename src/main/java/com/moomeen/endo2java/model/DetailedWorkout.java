package com.moomeen.endo2java.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DetailedWorkout extends Workout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer weatherType;
	private String feedStory;

	private List<Point> points;

	@JsonProperty("weather")
	public void setWeather(Map<String, Object> weather) {
		this.weatherType = (Integer) weather.get("weather_type");
	}

	@JsonProperty("feed")
	public void setFeed(Map<String, Object> feed) {
		this.feedStory = (String) feed.get("story");
	}

	public Integer getWeatherType() {
		return weatherType;
	}

	public String getFeedStory() {
		return feedStory;
	}

	public List<Point> getPoints() {
		return points;
	}

	@Override
	public String toString() {
		return "DetailedWorkout [weatherType=" + weatherType + ", feedStory=" + feedStory + ", points=" + points + "]";
	}

}
