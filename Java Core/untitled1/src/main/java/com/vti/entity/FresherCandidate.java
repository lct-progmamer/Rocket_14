package com.vti.entity;

public class FresherCandidate extends Candidate{
    private GraduationRank graduationRank;


    public FresherCandidate(String firstName, String lastName, String email, String phone,candidateRole candidateRole , GraduationRank graduationRank) {
        super(firstName, lastName, email, phone, candidateRole.FRESHERCANDIDATE);
        this.graduationRank = graduationRank;

    }
}
