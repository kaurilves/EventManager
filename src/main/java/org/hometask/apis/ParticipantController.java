package org.hometask.apis;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hometask.dtos.event.Event;
import org.hometask.dtos.participants.Participant;
import org.hometask.dtos.participants.ParticipantCreate;
import org.hometask.dtos.participants.PersonCreate;
import org.hometask.services.ParticipantService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@Tag(name = "Participants")
@RequestMapping("/participants")
public class ParticipantController {

    @Resource
    private ParticipantService participantService;

    @Operation(summary = "add participant and create person to database")
    @PostMapping
    public Participant addParticipant(@RequestBody PersonCreate personCreate, @RequestBody ParticipantCreate participantCreate) {
        return participantService.addParticipant(personCreate, participantCreate);
    }



}
