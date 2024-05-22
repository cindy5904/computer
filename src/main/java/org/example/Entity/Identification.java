package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Identification {
    private String addressImac;
    private String addressIp;
}
