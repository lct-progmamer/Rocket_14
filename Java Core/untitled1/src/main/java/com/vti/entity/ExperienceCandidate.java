package com.vti.entity;

public class ExperienceCandidate extends Candidate{

    private int ExpInYear;
    private String ProSkill;


    public ExperienceCandidate(String firstName, String lastName, String email, String phone, com.vti.entity.candidateRole candidateRole , int ExpInYear , String ProSkill) {
        super(firstName, lastName, email, phone, candidateRole.EXPERIENCECANDIDATE);
        this.ExpInYear = ExpInYear;
        this.ProSkill = ProSkill;


    }



}
