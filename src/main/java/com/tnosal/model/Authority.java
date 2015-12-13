package com.tnosal.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by gohilukk on 2015-12-12.
 */
@Entity
@Table(name = "AUTHORITY", uniqueConstraints = {
        @UniqueConstraint(columnNames = "NAME")})
@SequenceGenerator(name = "AuthoritySeq", sequenceName = "AUTHORITY_SEQ")
public class Authority {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "AuthoritySeq")
    private Long id;

    @NotNull
    @Size(min = 0, max = 50)
    @Column(name = "NAME")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "authorities")
    private Set<User> user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Authority authority = (Authority) o;

        if (!name.equals(authority.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Authority{" +
                "name='" + name + '\'' +
                '}';
    }
}
