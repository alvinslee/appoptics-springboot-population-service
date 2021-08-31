package com.github.alvinslee.appopticsspringbootpopulationservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Population {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    private int year;
    private int total;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Population that = (Population) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 1054211295;
    }
}
