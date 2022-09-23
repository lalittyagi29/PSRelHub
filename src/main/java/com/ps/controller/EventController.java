package com.ps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.ps.model.Event;
import com.ps.payload.CausesDto;
import com.ps.payload.EventDto;
import com.ps.service.Events.EventService;

@RestController
@RequestMapping("/v1/api/event")
public class EventController {

	@Autowired
	private EventService eventService;

	@PostMapping("/add")
	public EventDto addEvent(@RequestBody Event event) {
		return this.eventService.addEvent(event);
	}

	@PutMapping("/update")
	@ResponseBody
	public EventDto updateEvent(@RequestBody Event event, @RequestParam String eventId) {
		return this.eventService.updateEvent(event, eventId);
	}

	@GetMapping("/list")
	public List<EventDto> getAllEvent() {
		return this.eventService.getAllEvent();
	}

	@DeleteMapping("/delete")
	@ResponseBody
	public String deletEventById(@RequestParam String eventId) {
		return this.eventService.deleteEvent(eventId);
	}

	@GetMapping("")
	@ResponseBody
	public EventDto getEventById(@RequestParam String eventId) {
		return this.eventService.getEventById(eventId);
	}

	@GetMapping("/filter/cause")
	public List<EventDto> getEventByCause(@RequestBody List<CausesDto> causesDtos) {
		return this.eventService.getEventByCause(causesDtos);
	}

	@GetMapping("/filter/sorting")
	@ResponseBody
	public List<EventDto> getEventBySorting(@RequestParam Integer option) {
		return this.eventService.getEventBySorting(option);
	}

}
