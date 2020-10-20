package com.cobitsa.server.bus;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class BusFlag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long flagId;

    @JsonIgnore
    @NotNull
    private String busId;

    @Builder.Default
    private Boolean willRide = Boolean.FALSE;

    @Builder.Default
    private Boolean willGetOff = Boolean.FALSE;
}
