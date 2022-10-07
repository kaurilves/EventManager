package org.hometask.apis;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hometask.dtos.Event;
import org.hometask.dtos.EventCreate;
import org.hometask.dtos.EventUpdate;
import org.hometask.services.EventService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.UUID;

@RestController
@Tag(name = "Events")
@RequestMapping("/events")
public class EventController {

    @Resource
    private EventService eventService;

    @Operation(summary = "create new event")
    @PostMapping
    public Event createEvent (@Valid @RequestBody EventCreate eventCreate){
        return eventService.createEvent(eventCreate);
    }
    @Operation(summary = "update new event")
    @PutMapping("/{eventId}")
    public Event updateEvent (@RequestParam UUID eventId, @Valid @RequestBody EventUpdate eventUpdate){
        return eventService.updateEvent(eventId, eventUpdate);
    }

}
