package com.vti.backend.Presentation;

import com.vti.backend.bussinesslayer.candidateService;

import java.io.IOException;
import java.sql.SQLException;

public class candidateController {
    private candidateService candidateService;
    public candidateController() throws SQLException, IOException {
        candidateService = new candidateService();
    }

    public void Register() throws SQLException {
        candidateService.Register();
    }
    public void Login() throws SQLException {
        candidateService.Login();
    }
}
