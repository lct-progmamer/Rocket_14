package com.vti.entity;

public class Candidate {
    private int Id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private candidateRole candidateRole;

    public Candidate(String firstName, String lastName, String email, String phone, com.vti.entity.candidateRole candidateRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.candidateRole = candidateRole;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public com.vti.entity.candidateRole getCandidateRole() {
        return candidateRole;
    }

    public void setCandidateRole(com.vti.entity.candidateRole candidateRole) {
        this.candidateRole = candidateRole;
    }
}
