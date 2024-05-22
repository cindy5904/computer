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
public class SystemExplorer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "systemId")
    private int id;
    private String name;
    @OneToMany
    (mappedBy = "systemExplorers")
    private List<Computer> computer;

    @Override
    public String toString() {
        return "SystemExplorer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
