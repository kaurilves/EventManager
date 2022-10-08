package org.hometask.entities;

import lombok.*;
import org.hibernate.annotations.Type;
import org.hometask.config.ServiceConfig;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name = "events", schema = ServiceConfig.SCHEMA_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventEntity{

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column
    private String name;

    @Column
    private String address;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime eventDate;

    @Column
    private String additionalInfo;


}