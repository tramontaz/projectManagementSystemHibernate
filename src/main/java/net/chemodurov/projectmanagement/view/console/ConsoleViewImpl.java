package net.chemodurov.projectmanagement.view.console;

import net.chemodurov.projectmanagement.controller.hibernate_controllers.HibernateSkillControllerImpl;
import net.chemodurov.projectmanagement.controller.SkillController;
import net.chemodurov.projectmanagement.dao.hibernate.HibernateSkillDAOImpl;
import net.chemodurov.projectmanagement.model.Skill;

import net.chemodurov.projectmanagement.service.implementations.SkillServiceImpl;
import net.chemodurov.projectmanagement.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleViewImpl implements View {
    private int choice = 0;
    private String name;
    private Skill skill = null;
    private SkillController skillController;
    private BufferedReader in;

    public ConsoleViewImpl() {
        skillController = new HibernateSkillControllerImpl(new SkillServiceImpl(new HibernateSkillDAOImpl()));
        in = new BufferedReader(new InputStreamReader(System.in));


        System.out.println("What do you want to do with Skill?\n" +
                "1 - Create Skill\t" + "2 - Read Skill\t" + "3 - Update Skill\t" +
                "4 - Delete Skill\t" + "5 - Show all Skills\t" + "0 - Exit");
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
        if (!this.skillController.getAllSkills().isEmpty()) {
            for (Skill s : this.skillController.getAllSkills()) {
                System.out.println(s);
            }
        } else {
            System.out.println("\nSkills table is empty.");
        }
    }

    @Override
    public void delete() {
        System.out.println("Please enter the name of skill which you want to delete or '0' for exit: ");
        try {
            name = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (name.equals("0")) {
            System.out.println("Good bye!");
            System.exit(0);
        }
        try {
            skill = this.skillController.getSkillByName(name);
        } catch (NullPointerException e) {
            System.err.println("There is no skill with that name! Nothing has been deleted.");
            System.exit(0);
        }
        this.skillController.deleteSkill(skill.getId());
        System.out.println("Skill: " + skill.getName() + " has been successfully deleted.");

    }

    @Override
    public void update() {
        System.out.println("Please enter the name of skill which you want to edit: ");
        try {
            name = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String newName = null;
        try {
            skill = this.skillController.getSkillByName(name);
        } catch (Exception e) {
            System.err.println("There is no skill with that name!");
            System.exit(0);
        }
        System.out.println("What do you want to do whit that Skill?\n" + "1 - Rename\t" + "2 - Exit");
        try {
            choice = Integer.parseInt(in.readLine());
        } catch (NumberFormatException e) {
            System.err.println("Error! Enter a positive integer with the option number!!!");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (choice == 1) {
            System.out.println("Enter the new name of Skill " + skill.getName());
            try {
                newName = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            skill.setName(newName);
            this.skillController.updateSkill(skill);
        } else {
            System.out.println("Good bye!");
            System.exit(0);
        }
        System.out.println(this.skillController.getSkillByName(newName));
    }

    @Override
    public void read() {
        System.out.println("Please enter the name of skill which you want: ");
        try {
            name = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        skill = this.skillController.getSkillByName(name);
        if (skill != null) {
            System.out.println("Skill:\n" + skill);
        } else System.out.println("\nThere is no skill with that name.");
    }

    @Override
    public void create() {
        System.out.println("Enter the name of new skill: \t");
        try {
            name = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        skill = new Skill(name);
        this.skillController.addSkill(skill);
    }
}
