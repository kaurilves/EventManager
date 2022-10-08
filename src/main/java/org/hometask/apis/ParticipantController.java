package org.hometask.apis;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    public Participant addParticipant(@Valid @RequestBody ParticipantCreate participantCreate) throws Exception {
        return participantService.addParticipant(participantCreate);
    }

    @Operation(summary = "find all event participants")
    @GetMapping("/{eventId}")
    public List<Participant> findEventParticipants(@RequestParam UUID eventId) {
        return participantService.findEventParticipants(eventId);
    }

    @Operation(summary = "count all event participants")
    @GetMapping("/count/{eventId}")
    public Integer countEventParticipants(@RequestParam UUID eventId) {
        return participantService.countEventParticipants(eventId);
    }

    @Operation(summary = "update participation information")
    @PutMapping("/{participantId}")
    public Participant updateParticipant(@RequestParam UUID participantId, @Valid @RequestBody ParticipantUpdate participantUpdate) {
        return participantService.updateParticipant(participantId, participantUpdate);
    }

    @Operation(summary = "update participation information")
    @DeleteMapping("/{participantId}")
    public void deleteParticipant(@RequestParam UUID participantId) {
        participantService.deleteParticipant(participantId);
    }


}
