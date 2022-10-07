package org.hometask.entities;

import lombok.*;
import org.hometask.config.ServiceConfig;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "events", schema = ServiceConfig.SCHEMA_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventEntity extends IdEntity {

    @Column
    private String name;

    @Column
    private String address;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime eventDate;

    @Column
    private String additionalInfo;


}