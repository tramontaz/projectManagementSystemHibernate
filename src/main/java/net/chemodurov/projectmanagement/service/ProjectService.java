package net.chemodurov.projectmanagement.service;

import net.chemodurov.projectmanagement.dao.ProjectDAO;
import net.chemodurov.projectmanagement.dao.hibernate.HibernateProjectDAOImpl;
import net.chemodurov.projectmanagement.model.Project;
import net.chemodurov.projectmanagement.model.Team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ProjectService {
    private int choice = 0;
    private String name;
    private Project project = null;
    private ProjectDAO projectDAO;
    private BufferedReader in;

    public ProjectService() {
        projectDAO = new HibernateProjectDAOImpl();
        in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("What do you want to do with Project?\n" +
                "1 - Create Project\t" + "2 - Read Project\t" + "3 - Update Project\t" +
                "4 - Delete Project\t" + "5 - Show all Projects\t" + "0 - Exit");

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
                //create
                create();
                break;
            case 2:
                //read
                read();
                break;
            case 3:
                //update
                update();
                break;
            case 4:
                //delete
                delete();
                break;
            case 5:
                //show all
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

    private void showAll() {
        for (Project p : projectDAO.getAll()) {
            System.out.println(p);
        }
    }

    private void delete() {
        System.out.println("Please enter the name of project which you want to delete: ");
        try {
            name = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            project = projectDAO.getByName(name);
        } catch (Exception e) {
            System.err.println("There is no team with that name!");
            System.exit(0);
        }
        System.out.println(project);
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
            projectDAO.delete(project.getId());
        } else {
            System.out.println("Good Bye.");
            System.exit(0);
        }
    }

    private void update() {
        System.out.println("Please enter the name of project which you want to edit: ");
        try {
            name = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            project = projectDAO.getByName(name);
        } catch (Exception e) {
            System.err.println("There is no project with that name!");
            System.exit(0);
        }
        System.out.println("What do you want to do whit that Team?\n" +
                "1 - Edit name\t" + "2 - edit teams into project\t" + "3 - Exit");
        try {
            choice = Integer.parseInt(in.readLine());
        } catch (NumberFormatException e) {
            System.err.println("Error! Enter a positive integer with the option number!!!");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (choice == 1) {
            System.out.println("Enter the new name of project " + project.getName());
            try {
                name = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            project.setName(name);
        } else if (choice == 2) {
            System.out.println("Here are the team in this project: ");
            for (Team team : project.getSet()) {
                System.out.println(team.getName());
            }
            System.out.println("Enter '1' to delete all teams");
            int choice2 = 0;
            try {
                try {
                    choice2 = Integer.parseInt(in.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (NumberFormatException e) {
                System.out.println("You do not delete the developers.");
            }
            if (choice2 == 1) {
                projectDAO.deleteTeamsFromProject(project.getId());
            }
            //add new skills
            System.out.print("Please enter the names of the teams you want to add to the team split by ',' and press 'Enter' OR \"0\" to exit: ");
            try {
                String newTeams = in.readLine();

                String[] teamsInStringArray = newTeams.split(",");
                for (String teamName : teamsInStringArray) {
                    if (teamName.equals("0")) {
                        System.out.println("Good by!");
                        System.exit(0);
                    } else {
                        try {
                            project.getSet().add(projectDAO.getTeamByName(teamName));
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
        projectDAO.update(project);
        System.out.println("Team is updated \n" + projectDAO.getByName(name));
    }

    private void read() {
        System.out.println("Please enter name of project which you want: ");
        try {
            name = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            project = projectDAO.getByName(name);
            System.out.println(project);
        } catch (Exception e) {
            System.err.println("There is no project with that name!");
        }
    }

    private void create() {
        System.out.println("Enter the name of new Project: \t");
        try {
            name = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Set<Team> set = new HashSet<>();
        String teamIntoProject;
        System.out.print("Please \n" +
                "Enter the name of the teams you wanted to add to the project split by ',' and press 'Enter' OR \"0\" to exit: ");
        try {
            teamIntoProject = in.readLine();

            String[] teamsInStringArray = teamIntoProject.split(",");
            for (String teamName : teamsInStringArray) {
                if (teamName.equals("0")) {
                    System.out.println("Good by!");
                    System.exit(0);
                } else {
                    set.add(projectDAO.getTeamByName(teamName));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        projectDAO.insert(new Project(name, set));
    }
}
