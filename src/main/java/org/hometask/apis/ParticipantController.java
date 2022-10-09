package org.hometask.apis;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hometask.dtos.event.Event;
import org.hometask.dtos.participants.Participant;
import org.hometask.dtos.participants.ParticipantCreate;
import org.hometask.dtos.participants.ParticipantUpdate;
import org.hometask.services.ParticipantService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@Tag(name = "Participants")
@RequestMapping("/participants")
public class ParticipantController {

    @Resource
    private ParticipantService participantService;

    @Operation(summary = "add participant and create person to database")
    @PostMapping
    public Participant addParticipant(@Valid @RequestBody Event event, ParticipantCreate participantCreate) throws Exception {
        return participantService.addParticipant(event, participantCreate);
    }

    @Operation(summary = "find all event participants")
    @GetMapping("/{eventId}")
    public List<Participant> findEventParticipants(@RequestParam UUID eventId) {
        return participantService.findEventParticipants(eventId);
    }

    @Operation(summary = "count all event participants")
    @GetMapping("/count/{eventId}")
    public Integer countEventParticipants(@RequestParam UUID eventId) {
        return participantService.sumEventParticipants(eventId);
    }

    @Operation(summary = "update participation information")
    @PutMapping("/{participantId}")
    public Participant updateParticipant(@RequestParam UUID participantId, @Valid @RequestBody Event event, ParticipantUpdate participantUpdate) throws Exception {
        return participantService.updateParticipant(participantId,event, participantUpdate);
    }

    @Operation(summary = "delete participation")
    @DeleteMapping("/{participantId}")
    public void deleteParticipant(@RequestParam UUID participantId) {
        participantService.deleteParticipant(participantId);
    }
}
