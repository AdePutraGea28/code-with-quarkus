package org.acme.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="mahasiswa")
public class Mahasiswa {

    @Id
    @Column(name = "id")
    private String id;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    private String name;

    @Column(name = "is_male")
    private Boolean isMale;


    private String job;
    private String email;

    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Boolean getIsMale() {
        return isMale;
    }
    public void setIsMale(Boolean isMale) {
        this.isMale = isMale;
    }

}
