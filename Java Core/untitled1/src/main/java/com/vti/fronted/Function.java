package com.vti.fronted;

import com.vti.backend.Presentation.candidateController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;


public class Function {
    private candidateController candidateController;

    public Function() throws SQLException, IOException {
        candidateController = new candidateController();
    }


    public void menu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------------------------------------");
        System.out.println("|-------------1.Register---------------|");
        System.out.println("|---------------2.Login----------------|");
        System.out.println("|------------Khác --> THOÁT------------|");
        System.out.println("---------------------------------------");
        System.out.println("Nhap lua chon: ");
        int select = scanner.nextInt();
        if(select==1){
            candidateController.Register();
            return;
        }
        else if(select == 2)
        {
            candidateController.Login();
            return;
        }
        else
            return;
    }
}
