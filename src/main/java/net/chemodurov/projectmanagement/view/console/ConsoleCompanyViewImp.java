package net.chemodurov.projectmanagement.view.console;

import net.chemodurov.projectmanagement.controller.CompanyController;
import net.chemodurov.projectmanagement.controller.hibernate_controllers.HibernateCompanyControllerImpl;
import net.chemodurov.projectmanagement.dao.hibernate.HibernateCompanyDAOImpl;
import net.chemodurov.projectmanagement.model.Company;
import net.chemodurov.projectmanagement.model.Project;
import net.chemodurov.projectmanagement.service.implementations.CompanyServiceImpl;
import net.chemodurov.projectmanagement.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ConsoleCompanyViewImp implements View {
    private int choice = 0;
    private String name;
    private Company company;
    private CompanyController companyController;
    private BufferedReader in;

    ConsoleCompanyViewImp() {
        companyController = new HibernateCompanyControllerImpl(new CompanyServiceImpl(new HibernateCompanyDAOImpl()));
        in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("What do you want to do with Companies?\n" +
                "1 - Create Company\t" + "2 - Read Company\t" + "3 - Update Company\t" +
                "4 - Delete Company\t" + "5 - Show all Companies\t" + "0 - Exit");
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
        for (Company c : companyController.getAllCompanies()) {
            System.out.println(c);
        }
    }

    @Override
    public void delete() {
        System.out.println("Please enter the name of company which you want to delete: ");
        try {
            name = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        company = companyController.getCompanyByName(name);

        System.out.println(company);
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
            companyController.deleteCompany(company.getId());
        } else {
            System.out.println("Good Bye.");
            System.exit(0);
        }
    }

    @Override
    public void update() {
        System.out.println("Please enter the name of company which you want to edit: ");
        try {
            name = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        company = companyController.getCompanyByName(name);

        System.out.println("What do you want to do whit that Company?\n" +
                "1 - Edit name\t" + "2 - edit projects into company\t" + "3 - Exit");
        try {
            choice = Integer.parseInt(in.readLine());
        } catch (NumberFormatException e) {
            System.err.println("Error! Enter a positive integer with the option number!!!");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (choice == 1) {
            System.out.println("Enter the new name of company " + company.getName());
            try {
                name = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            company.setName(name);
        } else if (choice == 2) {
            System.out.println("Here are the projects in this company: ");
            for (Project project : company.getSet()) {
                System.out.println(project.getName());
            }
            System.out.println("Enter '1' to delete all projects");
            int choice2 = 0;
            try {
                choice2 = Integer.parseInt(in.readLine());
            } catch (NumberFormatException e) {
                System.out.println("You do not delete the projects.");
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (choice2 == 1) {
                company.getSet().removeAll(company.getSet());
            }
            //add new projects
            System.out.print("Please enter the names of the projects you want to add to the company split by ',' and press 'Enter' OR \"0\" to exit: ");
            try {
                String newProjects = in.readLine();

                String[] projectsInStringArray = newProjects.split(",");
                for (String projectName : projectsInStringArray) {
                    if (projectName.equals("0")) {
                        System.out.println("Good by!");
                        System.exit(0);
                    } else {
                        try {
                            company.getSet().add(companyController.getProjectByName(projectName));
                        } catch (StringIndexOutOfBoundsException e) {
                            System.err.println("You did not add any projects!!!");
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
        companyController.updateCompany(company);
        System.out.println("Team is updated \n" + companyController.getCompanyByName(name));
    }

    @Override
    public void read() {
        System.out.println("Please enter name of company which you want: ");
        try {
            name = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        company = companyController.getCompanyByName(name);
        System.out.println(company);
    }

    @Override
    public void create() {
        System.out.println("Enter the name of new Company: \t");
        try {
            name = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Set<Project> set = new HashSet<>();
        String projectsInCompany;
        System.out.print("Please \n" +
                "Enter the name of the projects you wanted to add to the company split by ',' and press 'Enter' OR \"0\" to exit: ");
        try {
            projectsInCompany = in.readLine();

            String[] projectsInStringArray = projectsInCompany.split(",");
            for (String projectName : projectsInStringArray) {
                if (projectName.equals("0")) {
                    System.out.println("Good by!");
                    System.exit(0);
                } else {
                    set.add(companyController.getProjectByName(projectName));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        companyController.addCompany(new Company(name, set));
    }
}
