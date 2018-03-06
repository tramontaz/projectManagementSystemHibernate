package net.chemodurov.projectmanagement.service;

import net.chemodurov.projectmanagement.dao.CustomerDAO;
import net.chemodurov.projectmanagement.dao.hibernate.HibernateCustomerDAOImpl;
import net.chemodurov.projectmanagement.dao.db.SQLRuntimeException;
import net.chemodurov.projectmanagement.model.Customer;
import net.chemodurov.projectmanagement.model.Project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class CustomersService {
    private int choice = 0;
    private String firstName;
    private String lastName;
    private String address;
    private Customer customer = null;
    private CustomerDAO customerDAO;

    public CustomersService() {
        customerDAO = new HibernateCustomerDAOImpl();

        System.out.println("What do you want to do with Customer?\n" +
                "1 - Create Customer\t" + "2 - Read Customer\t" + "3 - Update Customer\t" +
                "4 - Delete Customer\t" + "5 - Show all Customers\t" + "0 - Exit");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            choice = Integer.parseInt(in.readLine());
        } catch (NumberFormatException e) {
            System.err.println("Error! Enter a positive integer with the option number!!!");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (choice)

        {
            case 1:
                //create
                create(in);
                break;
            case 2:
                //read
                read(in);
                break;
            case 3:
                //update
                update(in);
                break;
            case 4:
                //delete
                delete(in);
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
        for (Customer c : customerDAO.getAll()) {
            System.out.println(c);
        }
    }

    private void delete(BufferedReader in) {
        try {
            System.out.println("Please enter the first name of customer which you want to delete: ");
            firstName = in.readLine();
            System.out.println("Please enter the last name of customer which you want to delete: ");
            lastName = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            customer = customerDAO.getByName(firstName, lastName);
        } catch (Exception e) {
            System.err.println("There is no customer with that name!");
            System.exit(0);
        }
        System.out.println(customer);
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
            customerDAO.delete(customer.getId());
        } else {
            System.out.println("Good Bye.");
            System.exit(0);
        }
    }

    private void update(BufferedReader in) {
        try {
            System.out.println("Please enter the first name of customer which you want to edit: ");
            firstName = in.readLine();
            System.out.println("Please enter the last name of customer which you want to edit: ");
            lastName = in.readLine();
        } catch (IOException e) {
            throw new SQLRuntimeException(e);
        }
        try {
            customer = customerDAO.getByName(firstName, lastName);
        } catch (Exception e) {
            System.err.println("There is no customer with that name!");
            System.exit(0);
        }
        System.out.println("What do you want to do whit that Customer?\n" +
                "1 - Edit first name\t" + "2 - Edit last name\t" + "3 - Edit address\t" +
                "5 - edit projects\t" + "6 - Exit");
        try {
            choice = Integer.parseInt(in.readLine());
        } catch (NumberFormatException e) {
            System.err.println("Error! Enter a positive integer with the option number!!!");
            System.exit(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (choice == 1) {
            System.out.println("Enter the new first name of customer " + customer.getLastName());
            try {
                firstName = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            customer.setFirstName(firstName);
        } else if (choice == 2) {
            System.out.println("Enter the new last name of customer " + customer.getLastName());
            try {
                lastName = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            customer.setLastName(lastName);
        } else if (choice == 3) {
            System.out.println("Enter the new address of customer " + customer.getLastName());
            try {
                address = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            customer.setAddress(address);
        } else if (choice == 5) {
            System.out.println("There is/are customer's projects: ");
            for (Project project : customer.getSet()) {
                System.out.println(project.getName());
            }
            System.out.println("Enter '1' to delete all projects");
            int choice2 = 0;
            try {
                choice2 = Integer.parseInt(in.readLine());
            } catch (NumberFormatException e) {
                System.out.println("You do not delete the projects.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (choice2 == 1) {
                customerDAO.deleteProjectsFromCustomer(customer.getId());
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
                            customer.getSet().add(customerDAO.getProjectByName(projectName));
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
        customerDAO.update(customer);
        System.out.println("Customer is updated \n" + customerDAO.getByName(firstName, lastName));
    }

    private void read(BufferedReader in) {
        try {
            System.out.println("Please enter first name of Customer which you want: ");
            firstName = in.readLine();
            System.out.println("Please enter last name of Customer which you want: ");
            lastName = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            customer = customerDAO.getByName(firstName, lastName);
            System.out.println(customer);
        } catch (Exception e) {
            System.err.println("There is no customer with that name!");
        }
    }

    private void create(BufferedReader in) {
        try {
            System.out.println("Enter the first name of new Customer: \t");
            firstName = in.readLine();
            System.out.println("Enter the last name of new Customer: \t");
            lastName = in.readLine();
            System.out.println("Enter the address of new Customer: \t");
            address = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Set<Project> set = new HashSet<>();
        String projectsInCompany;
        System.out.print("Please \n" +
                "Enter the name of the projects you wanted to add to the customer split by ',' and press 'Enter' OR \"0\" to exit: ");
        try {
            projectsInCompany = in.readLine();

            String[] projectsInStringArray = projectsInCompany.split(",");
            for (String projectName : projectsInStringArray) {
                if (projectName.equals("0")) {
                    System.out.println("Good by!");
                    System.exit(0);
                } else {
                    set.add(customerDAO.getProjectByName(projectName));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        customerDAO.insert(new Customer(firstName, lastName, address, set));
    }
}
