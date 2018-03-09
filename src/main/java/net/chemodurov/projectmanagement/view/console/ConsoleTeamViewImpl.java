package net.chemodurov.projectmanagement.view.console;

import net.chemodurov.projectmanagement.controller.TeamController;
import net.chemodurov.projectmanagement.controller.hibernate_controllers.HibernateTeamsControllerImpl;
import net.chemodurov.projectmanagement.dao.hibernate.HibernateTeamDAOImpl;
import net.chemodurov.projectmanagement.model.Developer;
import net.chemodurov.projectmanagement.model.Team;
import net.chemodurov.projectmanagement.service.implementations.TeamServiceImpl;
import net.chemodurov.projectmanagement.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ConsoleTeamViewImpl implements View {
    private int choice = 0;
    private String name;
    private Team team = null;
    private TeamController teamController;
    private BufferedReader in;

    ConsoleTeamViewImpl() {
        teamController = new HibernateTeamsControllerImpl(new TeamServiceImpl(new HibernateTeamDAOImpl()));
        in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("What do you want to do with Team?\n" +
                "1 - Create Team\t" + "2 - Read Team\t" + "3 - Update Team\t" +
                "4 - Delete Team\t" + "5 - Show all Teams\t" + "0 - Exit");

        try {
            choice = Integer.parseInt(in.readLine());
        } catch (NumberFormatException e) {
            System.err.println("Error! Enter a positive integer with the option number!!!");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (choice) {
            case 1:
                create();
                break;
            case 2:
                read();
                break;
            case 3:
                update();
                break;
            case 4:
                delete();
                break;
            case 5:
                showAll();
                break;
            case 0:
                //exit
                System.out.println("Good bye!");
                System.exit(0);

            default:
                System.err.println("Something wrong!");
        }
    }

    @Override
    public void showAll() {
        for (Team t : teamController.getAllTeams()) {
            System.out.println(t);
            System.out.println("\n==================================================\n");
        }
    }

    @Override
    public void delete() {
        System.out.println("Please enter the name of team which you want to delete: ");
        try {
            name = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        team = teamController.getTeamByName(name);

        System.out.println("Your team is: \n" + team);
        System.err.println("ARE YOU SURE? 1 - YES, DELETE \t || \t 0 - NO, EXIT");
        int choice3 = 0;
        try {
            choice3 = Integer.parseInt(in.readLine());
        } catch (NumberFormatException e) {
            System.err.println("Error! Enter a positive integer with the option number!!!");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (choice3 == 1) {
            teamController.deleteTeam(team.getId());
        } else {
            System.out.println("Good Bye.");
            System.exit(0);
        }
    }

    @Override
    public void update() {
        System.out.println("Please enter the name of team which you want to edit: ");
        try {
            name = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        team = teamController.getTeamByName(name);

        System.out.println("What do you want to do whit that Team?\n" +
                "1 - Edit name\t" + "2 - edit developers in team\t" + "3 - Exit");
        try {
            choice = Integer.parseInt(in.readLine());
        } catch (NumberFormatException e) {
            System.err.println("Error! Enter a positive integer with the option number!!!");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (choice == 1) {
            System.out.println("Enter the new name of team " + team.getName());
            try {
                name = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            team.setName(name);
        } else if (choice == 2) {
            System.out.println("Here are the developers in this team: ");
            for (Developer developer : team.getSet()) {
                System.out.println(developer.getFirstName() + " " + developer.getLastName());
            }
            System.out.println("Enter '1' to delete all developers");
            int choice2 = 0;
            try {
                choice2 = Integer.parseInt(in.readLine());
            } catch (NumberFormatException e) {
                System.out.println("You do not delete the developers.");
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (choice2 == 1) {
                team.getSet().removeAll(team.getSet());
            }
            //add new skills
            System.out.print("Please enter the names of the developers you want to add to the team split by ',' and press 'Enter' OR \"0\" to exit: ");
            try {
                String newDevelopers = in.readLine();

                String[] devsInStringArray = newDevelopers.split(",");
                for (String nameAndSur : devsInStringArray) {
                    if (nameAndSur.equals("0")) {
                        System.out.println("Good by!");
                        System.exit(0);
                    } else {
                        try {
                            team.getSet().add(teamController.getDeveloperByName(
                                    nameAndSur.substring(0, nameAndSur.indexOf(" ")), //firstName
                                    nameAndSur.substring(nameAndSur.indexOf(" ") + 1, nameAndSur.length()))); //lastName));
                        } catch (StringIndexOutOfBoundsException e) {
                            System.err.println("You did not add any developers!!!");
                            System.exit(0);
                        }

                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Good bye!");
            System.exit(0);
        }
        teamController.updateTeam(team);
        System.out.println("Team is updated \n" + teamController.getTeamByName(name));
    }

    @Override
    public void read() {
        System.out.println("Please enter name of team which you want: ");
        try {
            name = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        team = teamController.getTeamByName(name);
        System.out.println(team);
    }

    @Override
    public void create() {
        System.out.println("Enter the name of new Team: \t");
        try {
            name = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Set<Developer> set = new HashSet<>();
        String devInTeam;
        System.out.print("Please \n" +
                "Enter the first name and last name of the developers you wanted to add to the team split by ',' and press 'Enter' OR \"0\" to exit: ");
        try {
            devInTeam = in.readLine();

            String[] devsInStringArray = devInTeam.split(",");
            for (String nameAndSur : devsInStringArray) {
                if (nameAndSur.equals("0")) {
                    System.out.println("Good by!");
                    System.exit(0);
                } else {
                    String firstName = nameAndSur.substring(0, nameAndSur.indexOf(" "));
                    String lastName = nameAndSur.substring(nameAndSur.indexOf(" ") + 1, nameAndSur.length());
                    set.add(teamController.getDeveloperByName(firstName, lastName));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        team = new Team(name, set);
        teamController.addTeam(team);
    }
}
