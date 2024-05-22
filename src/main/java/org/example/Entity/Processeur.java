package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Processeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    private int nbCoeur;

    @OneToMany(mappedBy = "processeur")
    private List<Computer> computers;

    @Override
    public String toString() {
        return "Processeur{" +
                "type='" + type + '\'' +
                ", nbCoeur=" + nbCoeur +
                '}';
    }
}
