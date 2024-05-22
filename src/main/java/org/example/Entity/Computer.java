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
public class Computer {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String name;
        private float price;
        @Embedded
        private Identification identification;

        @ManyToOne
        @JoinColumn(name = "processor_id")
        private Processeur processeur;

        @ManyToOne
        @JoinColumn(name = "systemId")

        private SystemExplorer systemExplorers;

    }

