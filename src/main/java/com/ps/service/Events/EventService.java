package com.ps.service.Events;

import java.util.List;

import com.ps.model.Event;
import com.ps.payload.GeoLocation;

public interface EventService {

	Event addEvent(Event event);

	Event updateEvent(Event event, String evntId);

	String deleteEvent(String eventId);

	Event getEventById(String eventId);

	List<Event> getAllEvent();

	List<Event> getEventByLocation(GeoLocation geoLocation, Integer rangeInkm);

	List<Event> getEventByAvailability(List<String> availablity);

	List<Event> getEventByCause(String cause);

}
