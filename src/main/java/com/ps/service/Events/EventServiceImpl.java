package com.ps.service.Events;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.Exception.ResourceNotFoundException;
import com.ps.model.Event;
import com.ps.payload.GeoLocation;
import com.ps.repository.EventRepo;
import com.ps.utilty.PSUId;
import com.ps.utilty.PSVaraible;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepo eventRepo;

	@Override
	public Event addEvent(Event event) {
		String uniqueId = PSUId.getUniqueId(PSVaraible.EVENTS_MODEL);
		Optional<Event> eventById = this.eventRepo.findById(uniqueId);
		if (eventById.isEmpty()) {
			event.setEventId(uniqueId);
		} else {
			addEvent(event);
		}
		return this.eventRepo.save(event);
	}

	@Override
	public Event updateEvent(Event event, String evntId) {
		Event currentEvent = this.eventRepo.findById(evntId)
		.orElseThrow(()->new ResourceNotFoundException("Event", "Id", evntId));
		if (event.getOrganiserName() != null) {
			currentEvent.setOrganiserName(event.getOrganiserName());
		}
		if (event.getCausesTag() != null) {
			currentEvent.setCausesTag(event.getCausesTag());
		}
		if (event.getBackgroundImgUrl() != null) {
			currentEvent.setBackgroundImgUrl(event.getBackgroundImgUrl());
		}
		if (event.getDate() != null) {
			currentEvent.setDate(event.getDate());
		}
		if (event.getDescription() != null) {
			currentEvent.setDescription(event.getDescription());
		}
		if (event.getEndTime() != null) {
			currentEvent.setEndTime(event.getEndTime());
		}
		if (event.getLocation() != null) {
			currentEvent.setLocation(event.getLocation());
		}
		if (event.getStartTime() != null) {
			currentEvent.setStartTime(event.getStartTime());
		}
		if (event.getTitle() != null) {
			currentEvent.setTitle(event.getTitle());
		}
		return this.eventRepo.save(currentEvent);
	}

	@Override
	public String deleteEvent(String eventId) {
		try {
			this.eventRepo.deleteById(eventId);
			return "sucess!!";
		} catch (Exception e) {
			return "Error!!";
		}
	}

	@Override
	public Event getEventById(String eventId) {
		return this.eventRepo.findById(eventId)
		.orElseThrow(()->new ResourceNotFoundException("Event", "Id", eventId));
	}

	@Override
	public List<Event> getAllEvent() {
		return this.eventRepo.findAll();
	}

	@Override
	public List<Event> getEventByLocation(GeoLocation geoLocation, Integer rangeInKm) {
		
		return null;
	}

	@Override
	public List<Event> getEventByAvailability(List<String> availablity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getEventByCause(String cause) {
		// TODO Auto-generated method stub
		return null;
	}

}
