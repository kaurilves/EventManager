package org.hometask.apis;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hometask.dtos.event.Event;
import org.hometask.dtos.participants.Participant;
import org.hometask.dtos.participants.ParticipantCreate;
import org.hometask.dtos.participants.ParticipantUpdate;
import org.hometask.services.EventService;
import org.hometask.services.ParticipantService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@Tag(name = "Participants")
@RequestMapping("/participant")
public  class ParticipantController {

    @Resource
    private ParticipantService participantService;
    @Resource
    private EventService eventService;

    @Operation(summary = "add participant")
    @PostMapping("/{eventId}")
    public Participant addParticipant(@Valid @RequestBody ParticipantCreate participantCreate, @PathVariable UUID eventId)   throws Exception {
        Event event = eventService.getEvent(eventId);
        return participantService.addParticipant(event, participantCreate);
    }


    @Operation(summary = "find all event participants")
    @GetMapping("/participants/{eventId}")
    public List<Participant> findEventParticipants(@PathVariable UUID eventId) {
        return participantService.findEventParticipants(eventId);
    }

    @Operation(summary = "count all event participants")
    @GetMapping("/count/{eventId}")
    public Integer countEventParticipants(@PathVariable UUID eventId) {
        return participantService.sumEventParticipants(eventId);
    }


    @Operation(summary = "update participation information")
    @PutMapping("/{eventId}/{participantId}")
    public Participant updateParticipant(@PathVariable UUID eventId, @PathVariable UUID participantId, @Valid @RequestBody ParticipantUpdate participantUpdate) throws Exception {
        return participantService.updateParticipant(eventService.getEvent(eventId), participantId, participantUpdate);
    }

    @Operation(summary = "delete participation")
    @DeleteMapping("/{participantId}")
    public void deleteParticipant(@PathVariable UUID participantId) {
        participantService.deleteParticipant(participantId);
    }
}
