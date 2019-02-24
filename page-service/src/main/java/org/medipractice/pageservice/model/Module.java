package org.medipractice.pageservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table
@NoArgsConstructor
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String label;

}