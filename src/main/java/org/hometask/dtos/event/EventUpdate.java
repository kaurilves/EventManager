package org.hometask.dtos.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;


@Data
public class EventUpdate implements Serializable {
    @NotNull
    @NotBlank
    @Size(max = 200)
    private  String name;

    @NotNull
    @NotBlank
    @Size(max = 200)
    private  String address;

    @Future(message = "Date has to be in the future")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd.MM.yyyy HH:mm")
    private  LocalDateTime eventDate;

    private  String additionalInfo;
}