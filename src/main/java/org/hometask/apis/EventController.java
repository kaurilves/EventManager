package org.hometask.apis;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hometask.dtos.event.Event;
import org.hometask.dtos.event.EventCreate;
import org.hometask.dtos.event.EventUpdate;
import org.hometask.services.EventService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@Tag(name = "Events")
@RequestMapping("/events")
public class EventController {

    @Resource
    private EventService eventService;

    @Operation(summary = "create new event")
    @PostMapping
    public Event createEvent(@Valid @RequestBody EventCreate eventCreate) {
        return eventService.createEvent(eventCreate);
    }

    @Operation(summary = "get single event")
    @GetMapping("/{eventId}")
    public Event getEvent(@RequestParam UUID eventId) {
        return eventService.getEvent(eventId);
    }

    @Operation(summary = "find all future events")
    @GetMapping("/future")
    public List<Event> findAllFutureEvents() {
        return eventService.findAllFutureEvents();
    }

    @Operation(summary = "find all past events")
    @GetMapping("/past")
    public List<Event> findAllPastEvents() {
        return eventService.findAllPastEvents();
    }

    @Operation(summary = "update upcoming event")
    @PutMapping("/{eventId}")
    public Event updateEvent(@RequestParam UUID eventId, @Valid @RequestBody EventUpdate eventUpdate) {
        return eventService.updateEvent(eventId, eventUpdate);
    }

    @Operation(summary = "delete upcoming event")
    @DeleteMapping("/{eventId}")
    public void deleteEvent(@RequestParam UUID eventId) {
        eventService.deleteEvent(eventId);
    }

}
