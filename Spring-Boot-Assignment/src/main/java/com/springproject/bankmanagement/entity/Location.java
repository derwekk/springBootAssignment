package com.springproject.bankmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "location")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long id;

    @Column(nullable = false)
    private String address;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "bank_location", joinColumns = @JoinColumn(name = "location_id"), inverseJoinColumns = @JoinColumn(name = "bank_id"))
    @Valid
    private Set<Bank> banks = new HashSet<>();

    public Location(long l, String s) {
    }
}

