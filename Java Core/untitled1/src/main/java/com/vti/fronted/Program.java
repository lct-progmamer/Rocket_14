package com.vti.fronted;

import com.vti.backend.datalayer.candidateRepository;

import java.io.IOException;
import java.sql.SQLException;

public class Program {
    public static void main(String[] args) throws SQLException, IOException {
        Function function = new Function();
        function.menu();
    }
}
