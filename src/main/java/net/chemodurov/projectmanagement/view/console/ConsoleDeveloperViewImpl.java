package net.chemodurov.projectmanagement.view.console;

import net.chemodurov.projectmanagement.controller.DeveloperController;
import net.chemodurov.projectmanagement.controller.hibernate_controllers.HibernateDeveloperController;
import net.chemodurov.projectmanagement.dao.hibernate.HibernateDeveloperDAOImpl;
import net.chemodurov.projectmanagement.model.Developer;
import net.chemodurov.projectmanagement.model.Skill;
import net.chemodurov.projectmanagement.service.implementations.DeveloperServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class ConsoleDeveloperViewImpl {
    private int choice = 0;
    private String firstName;
    private String lastName;
    private String specialty;
    private BigDecimal salary;
    private Developer developer = null;
    private BufferedReader in;
    private DeveloperController developerController;

    public ConsoleDeveloperViewImpl() {
        developerController = new HibernateDeveloperController(new DeveloperServiceImpl(new HibernateDeveloperDAOImpl()));

        System.out.println("What do you want to do with Developer?\n" +
                "1 - Create Developer\t" + "2 - Read Developer\t" + "3 - Update Developer\t" +
                "4 - Delete Developer\t" + "5 - Show all Developers\t" + "0 - Exit");
        in = new BufferedReader(new InputStreamReader(System.in));
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

    private void showAll() {
        for (Developer d : developerController.getAllDevelopers()) {
            System.out.println(d);
        }
    }

    private void read() {
        try {
            System.out.println("Please enter first name of developer which you want: ");
            firstName = in.readLine();
            System.out.println("Please enter last name of developer which you want: ");
            lastName = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
            developer = developerController.getDeveloperByName(firstName, lastName);
            System.out.println(developer);
    }

    private void create() {
        try {
            System.out.println("Enter the first name of new developer: \t");
            firstName = in.readLine();
            System.out.println("Enter the last name of new developer: \t");
            lastName = in.readLine();
            System.out.println("Enter the specialty of new developer: \t");
            specialty = in.readLine();
            System.out.println("Enter the salary of new developer: \t");
            String line = in.readLine();
            salary = new BigDecimal(line);

        }catch (IOException e) {
            e.printStackTrace();
        }

        Set<Skill> set = new HashSet<>();
        String devSkill;
        System.out.print("Please enter developer's skill's split by ',' and press 'Enter' OR \"0\" to exit: ");
        try {
            devSkill = in.readLine();

            String[] skillsInStringArray = devSkill.split(",");
            for (String name : skillsInStringArray) {
                if (name.equals("0")) {
                    System.out.println("Good by!");
                    System.exit(0);
                } else set.add(developerController.getSkillByName(name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        developer = new Developer(firstName, lastName, specialty, set, salary);
        developerController.addDeveloper(developer);
    }

    private void delete() {
        try {
            System.out.println("Please enter the first name of developer which you want to delete: ");
            firstName = in.readLine();
            System.out.println("Please enter the last name of developer which you want to delete: ");
            lastName = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            developer = developerController.getDeveloperByName(firstName, lastName);
        } catch (Exception e) {
            System.err.println("There is no developer with that name!");
            System.exit(0);
        }
        System.out.println(developer);
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
            developerController.deleteDeveloper(developer.getId());
        } else {
            System.out.println("Good Bye.");
            System.exit(0);
        }
    }

    private void update() {
        try {
            System.out.println("Please enter the first name of developer which you want to edit: ");
            firstName = in.readLine();
            System.out.println("Please enter the last name of developer which you want to edit: ");
            lastName = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            developer = developerController.getDeveloperByName(firstName, lastName);
        } catch (Exception e) {
            System.err.println("There is no developer with that name!");
            System.exit(0);
        }
        System.out.println("What do you want to do whit that Developer?\n" +
                "1 - Edit first name\t" + "2 - Edit last name\t" + "3 - Edit specialty\t" + "4 - Edit salary\t" +
                "5 - edit skills\t" + "6 - Exit");
        try {
            choice = Integer.parseInt(in.readLine());
        } catch (NumberFormatException e) {
            System.err.println("Error! Enter a positive integer with the option number!!!");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (choice == 1) {
            System.out.println("Enter the new first name of developer " + developer.getLastName());
            try {
                firstName = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            developer.setFirstName(firstName);
        } else if (choice == 2) {
            System.out.println("Enter the new last name of developer " + developer.getLastName());
            try {
                lastName = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            developer.setLastName(lastName);
        } else if (choice == 3) {
            System.out.println("Enter the new specialty of developer " + developer.getLastName());
            try {
                specialty = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            developer.setSpecialty(specialty);
        } else if (choice == 4) {
            System.out.println("Enter the new salary of developer " + developer.getLastName());
            try {
                salary = new BigDecimal(in.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            developer.setSalary(salary);
        } else if (choice == 5) {
            System.out.println("There is/are developer's skills: ");
            for (Skill skill : developer.getSet()) {
                System.out.println(skill.getName());
            }
            System.out.println("Enter '1' to delete all skills");
            int choice2 = 0;
            try {
                choice2 = Integer.parseInt(in.readLine());
            } catch (NumberFormatException e) {
                System.out.println("You do not delete the skills.");
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (choice2 == 1) {
                developerController.deleteSkillsFromDev(developer.getId());
            }
            //add new skills
            System.out.print("Please enter developer's skill's split by ',' and press 'Enter' OR \"0\" to exit: ");
            try {
                String newSkills = in.readLine();

                String[] skillsInStringArray = newSkills.split(",");
                for (String name : skillsInStringArray) {
                    if (name.equals("0")) {
                        System.out.println("Good by!");
                        System.exit(0);
                    } else {
                        developer.getSet().add(developerController.getSkillByName(name));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Good bye!");
            System.exit(0);
        }
        developerController.updateDeveloper(developer);
        System.out.println("Developer is updated \n" + developerController.getDeveloperByName(firstName, lastName));
    }
}
