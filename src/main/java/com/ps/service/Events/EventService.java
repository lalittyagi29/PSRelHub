package com.ps.service.Events;

import java.util.List;

import com.ps.model.Event;
import com.ps.payload.CausesDto;
import com.ps.payload.EventDto;
import com.ps.payload.GeoLocation;

public interface EventService {

	EventDto addEvent(Event event);

	EventDto updateEvent(Event event, String evntId);

	String deleteEvent(String eventId);

	EventDto getEventById(String eventId);

	List<EventDto> getAllEvent();

	List<Event> getEventByLocation(GeoLocation geoLocation, Integer rangeInkm);

	List<Event> getEventByAvailability(List<String> availablity);

	List<EventDto> getEventByCause(List<CausesDto> cause);
	
	List<EventDto> getEventBySorting(int option);

}
