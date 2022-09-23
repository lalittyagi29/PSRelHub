package com.ps.service.Events;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.Exception.ResourceNotFoundException;
import com.ps.model.Event;
import com.ps.payload.CausesDto;
import com.ps.payload.EventDto;
import com.ps.payload.GeoLocation;
import com.ps.repository.EventRepo;
import com.ps.utilty.PSUId;
import com.ps.utilty.PSVaraible;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepo eventRepo;

	@Override
	public EventDto addEvent(Event event) {
		String uniqueId = PSUId.getUniqueId(PSVaraible.EVENTS_MODEL);
		Optional<Event> eventById = this.eventRepo.findById(uniqueId);
		if (eventById.isEmpty()) {
			event.setEventId(uniqueId);
		} else {
			addEvent(event);
		}
		Event saveEvent = this.eventRepo.save(event);
		return this.convertEventToEventDto(saveEvent);
	}

	@Override
	public EventDto updateEvent(Event event, String evntId) {
		Event currentEvent = this.eventRepo.findById(evntId)
				.orElseThrow(() -> new ResourceNotFoundException("Event", "Id", evntId));
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
		Event updatedEvent = this.eventRepo.save(currentEvent);
		return this.convertEventToEventDto(updatedEvent);
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
	public EventDto getEventById(String eventId) {
		Event event = this.eventRepo.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("Event", "Id", eventId));
		return convertEventToEventDto(event);
	}

	@Override
	public List<EventDto> getAllEvent() {
		List<EventDto> list_Of_Event = new ArrayList<>();
		List<Event> findAllEvent = this.eventRepo.findAll();
		for (Event event : findAllEvent) {
			EventDto convertEventToEventDto = this.convertEventToEventDto(event);
			list_Of_Event.add(convertEventToEventDto);
		}
		return list_Of_Event;
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
	public List<Event> getEventByCause(List<CausesDto> causeList) {

		List<Event> fullFilterListByCause = new ArrayList<>();

		for (CausesDto causesDto : causeList) {
			String cause = causesDto.getCause();
			List<Event> findByCausesTag = this.eventRepo.findByCausesTag(cause);
			fullFilterListByCause = Stream.concat(fullFilterListByCause.stream(), findByCausesTag.stream())
					.collect(Collectors.toList());
			findByCausesTag.clear();
		}

		return fullFilterListByCause;
	}

	public EventDto convertEventToEventDto(Event event) {
		EventDto eventDto = new EventDto();
		eventDto.setBackgroundImgUrl(event.getBackgroundImgUrl());
		eventDto.setCausesTag(event.getCausesTag());
		eventDto.setDate(event.getDate());
		eventDto.setDescription(event.getDescription());
		eventDto.setEndTime(event.getEndTime());
		eventDto.setEventId(event.getEventId());
		eventDto.setLocation(event.getLocation());
		eventDto.setStartTime(event.getStartTime());
		eventDto.setTitle(event.getTitle());
		eventDto.setOrganiserName(event.getOrganiserName());
		return eventDto;
	}

	@Override
	public List<Event> getEventBySorting(int option) {
		List<Event> findAllEvent = this.eventRepo.findAll();
		switch (option) {

		case 1:
			Comparator<Event> aToz = (o1, o2) -> {
				return (o1.getTitle().compareTo(o2.getTitle()));
			};
			Collections.sort(findAllEvent, aToz);
			return findAllEvent;

		case 2:
			Comparator<Event> zToa = (o1, o2) -> {
				return (o2.getTitle().compareTo(o1.getTitle()));
			};
			Collections.sort(findAllEvent, zToa);
			return findAllEvent;

		case 3:
		case 4:
		}
		return null;

	}

}
