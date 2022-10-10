package org.hometask.apis;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hometask.dtos.event.Event;
import org.hometask.dtos.event.EventCreate;
import org.hometask.dtos.event.EventUpdate;
import org.hometask.services.EventService;
import org.hometask.services.ParticipantService;
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
    @Resource
    private ParticipantService participantService;

    @Operation(summary = "create new event")
    @PostMapping("/create")
    public Event createEvent(@Valid @RequestBody EventCreate eventCreate) {
        return eventService.createEvent(eventCreate);
    }

    @Operation(summary = "get single event")
    @GetMapping("/event/{eventId}")
    public Event getEvent(@PathVariable UUID eventId) {
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
    @PutMapping("/update/{eventId}")
    public Event updateEvent(@PathVariable UUID eventId, @Valid @RequestBody EventUpdate eventUpdate) throws Exception {
        return eventService.updateEvent(eventId, eventUpdate);
    }

    @Operation(summary = "delete upcoming event")
    @DeleteMapping("/delete/{eventId}")
    public void deleteEvent(@PathVariable UUID eventId) throws Exception {
         eventService.deleteEvent(eventId);
    }

}
