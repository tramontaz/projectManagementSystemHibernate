package net.chemodurov.projectmanagement.view.console;

import net.chemodurov.projectmanagement.controller.ProjectController;
import net.chemodurov.projectmanagement.controller.hibernate_controllers.HibernateProjectControllerImpl;
import net.chemodurov.projectmanagement.dao.hibernate.HibernateProjectDAOImpl;
import net.chemodurov.projectmanagement.model.Project;
import net.chemodurov.projectmanagement.model.Team;
import net.chemodurov.projectmanagement.service.implementations.ProjectServiceImpl;
import net.chemodurov.projectmanagement.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ConsoleProjectViewImpl implements View {

    private int choice = 0;
    private String name;
    private Project project = null;
    private ProjectController projectController;
    private BufferedReader in;

    ConsoleProjectViewImpl() {
        projectController = new HibernateProjectControllerImpl(new ProjectServiceImpl(new HibernateProjectDAOImpl()));
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

    @Override
    public void showAll() {
        for (Project p : projectController.getAllProjects()) {
            System.out.println(p);
        }
    }

    @Override
    public void delete() {
        System.out.println("Please enter the name of project which you want to delete: ");
        try {
            name = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        project = projectController.getProjectByName(name);

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
            projectController.deleteProject(project.getId());
        } else {
            System.out.println("Good Bye.");
            System.exit(0);
        }
    }

    @Override
    public void update() {
        System.out.println("Please enter the name of project which you want to edit: ");
        try {
            name = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        project = projectController.getProjectByName(name);

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
                project.getSet().removeAll(project.getSet());
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
                            project.getSet().add(projectController.getTeamByName(teamName));
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
        projectController.updateProject(project);
        System.out.println("Team is updated \n" + projectController.getProjectByName(name));
    }

    @Override
    public void read() {
        System.out.println("Please enter name of project which you want: ");
        try {
            name = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        project = projectController.getProjectByName(name);
        System.out.println(project);
    }

    @Override
    public void create() {
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
                    set.add(projectController.getTeamByName(teamName));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        projectController.addProject(new Project(name, set));
    }
}
