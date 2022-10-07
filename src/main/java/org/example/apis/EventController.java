package org.example.apis;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.dtos.Event;
import org.example.dtos.EventCreate;
import org.example.services.EventService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

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
}
