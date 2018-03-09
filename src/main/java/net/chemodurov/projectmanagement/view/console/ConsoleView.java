package net.chemodurov.projectmanagement.view.console;


import net.chemodurov.projectmanagement.controller.*;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleView {
    private BufferedReader in;
    private int choice;

    public ConsoleView() {
        this.choice = 0;
        in = new BufferedReader(new InputStreamReader(System.in));


        view();
    }

    private void view() {
        boolean stopProgram = false;
        while (!stopProgram) {

            System.out.println("\n\nWelcome!\n" + "What do you want to work with?\n" +
                    "1 - Skill\t" + "2 - Developer\t" + "3 - Team\t" + "4 - Project\t" + "5 - Company\t" + "6 - Customer\t" + "0 - Exit");
            try {
                try {
                    choice = Integer.parseInt(in.readLine());
                } catch (NumberFormatException e) {
                    System.err.println("Error! Enter a positive integer with the option number!!!");
                    System.exit(0);
                }
                switch (choice) {
                    case 1:
                        new ConsoleSkillViewImpl();
                        break;
                    case 2:
                        new ConsoleDeveloperViewImpl();
                        break;
                    case 3:
                        new ConsoleTeamViewImpl();
                        break;
                    case 4:
                        new ConsoleProjectViewImpl();
                        break;
                    case 5:
                        new ConsoleCompanyViewImp();
                        break;
                    case 6:
                        new ConsoleCustomerViewImpl();
                        break;
                    case 0:
                        System.out.println("Good by!");
                        stopProgram = true;
                        System.exit(0);
                    default:
                        System.err.println("Error! Enter a positive integer with the option number!!!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
