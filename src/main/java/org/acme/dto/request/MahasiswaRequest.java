package org.acme.dto.request;

public class MahasiswaRequest {
    private String name;
    private String email;
    private String job;
    private Boolean isMale;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public Boolean getIsMale() {
        return isMale;
    }
    public void setIsMale(Boolean isMale) {
        this.isMale = isMale;
    }
}
