package com.vti.backend.bussinesslayer;

import com.vti.backend.datalayer.candidateRepository;

import java.io.IOException;
import java.sql.SQLException;

public class candidateService {
    private candidateRepository candidateRepository;
    public candidateService() throws SQLException, IOException {
       candidateRepository = new candidateRepository();
    }

    public void Register() throws SQLException {
        candidateRepository.Register();
    }
    public void Login() throws SQLException {
        candidateRepository.Login();
    }



}
