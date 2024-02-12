package com.school.projectschool;

import com.school.projectschool.util.database.MySqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try (Connection connection = MySqlConnection.getConnection()) {
            // Realiza operaciones con la base de datos aquí
            String query = "SELECT * FROM student";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    // Procesa los resultados
                    String columna1 = resultSet.getString("columna1");
                    String columna2 = resultSet.getString("columna2");
                    // Realiza operaciones con los datos obtenidos
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Getting Parameters
        char mainMenu = 'a';
        boolean mainMenu_bol;
        Scanner menuOption = new Scanner(System.in);
        // variables menu initializer
        char studentMenu = 'a';
        char teacherMenu = 'a';
        char classMenu = 'a';
        char roomMenu = 'a';
        char gradesMenu = 'a';
      // database string initializers
      
        String selectDB = "select";
        String insertDB = "insert";
        String deleteDB = "remove";
        String updateDB = "update";




        //main menu call
        System.out.println("Welcome to this Basic School Management Program \n");


        do { // loops the main menu until they are ready to quit. So every change or action done, calls back to the menu in question.
            System.out.println("Please select from the options: \n "
                    + "\n For Student management, select S "
                    + "\n For Teacher management, select T "
                    + "\n For Class management, select C "
                    + "\n For Class room management, select R "
                    + "\n For Grades  management, select G "
                    + "\n To leave, press X ");
            mainMenu = menuOption.next().charAt(0);
            switch (mainMenu) {
                case 'S': {
                    System.out.println("Selecting Student Management \n");
                    do {
                        System.out.println("\n Please select from the options: ");
                        System.out.println("For inserting new student data, select N");
                        System.out.println("For Editing student data, select  E ");
                        System.out.println("For Deleting student data, select  D ");
                        System.out.println("To return to the prior menu press  X ");
                        studentMenu = menuOption.next().charAt(0);

                        switch (studentMenu) {
                            case 'N': {
                                System.out.println("Insert Student mode enabled: ");
                                // call external class for connecting to DB
                                break;
                            }
                            case 'E': {
                                System.out.println("Editing Student mode enabled: ");
                                // call external class for connecting to DB

                                break;
                            }
                            case 'D': {
                                System.out.println("Deleting Student mode enabled: ");
                                // call external class for connecting to DB

                                break;
                            }
                            case 'X': {
                                System.out.println("Returning to main menu. ");
                                studentMenu = 'X';
                                break;
                            }
                            default: {
                                System.out.println("Unknown response, try again: \n ");
                                break;
                            }

                        }
                    }
                    while (  studentMenu != 'X') ;


                    break;
                }
                case 'T': {
                    System.out.println("Selecting Teacher Management \n");
                    do {
                        System.out.println("Please select from the options: ");
                        System.out.println("For inserting new Teacher data, select N ");
                        System.out.println("For Editing Teacher data, select  E ");
                        System.out.println("For Deleting Teacher data, select  D ");
                        System.out.println("To return to the prior menu press  X ");
                        teacherMenu = menuOption.next().charAt(0);

                        switch (teacherMenu) {
                            case 'N': {
                                System.out.println("Insert Teacher mode enabled: ");
                                // call external class for connecting to DB
                                break;
                            }
                            case 'E': {
                                System.out.println("Editing Teacher mode enabled: ");
                                // call external class for connecting to DB

                                break;
                            }
                            case 'D': {
                                System.out.println("Deleting Teacher mode enabled: ");
                                // call external class for connecting to DB

                                break;
                            }
                            case 'X': {
                                System.out.println("Returning to main menu. ");
                                teacherMenu = 'X';
                                break;
                            }
                            default: {
                                System.out.println("Unknown response, try again: ");
                                break;
                            }

                        }
                    }
                    while (  teacherMenu != 'X') ;
                    break;
                }
                case 'C': {
                    System.out.println("\n Selecting Class Management \n");
                    do {
                        System.out.println("\nPlease select from the options: \n");
                        System.out.println("For inserting new Class data, select N ");
                        System.out.println("For Editing Class data, select E: ");
                        System.out.println("For Deleting Class data, select D: ");
                        System.out.println("To return to the prior menu press X \n");
                        classMenu = menuOption.next().charAt(0);

                        switch (classMenu) {
                            case 'N': {
                                System.out.println("Insert Class mode enabled: ");

                                try (Connection connection = MySqlConnection.getConnection()) {
                                    // performsn first select from to showcase what the user is seeing.
                                    String query = "SELECT * FROM test";
                                    System.out.println("Class DB contains: ");
                                    try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                                         ResultSet resultSet = preparedStatement.executeQuery()) {
                                        while (resultSet.next()) {
                                            System.out.println(resultSet.getString((1)) + ", " + resultSet.getString(2)+ ", " + resultSet.getString(3));

                                        }
                                    }
                                } catch (SQLException e) {
                                    throw new RuntimeException(e); }

                                System.out.println("\n Please insert the new Class' name: ");
                                String className = scan.nextLine();
                                System.out.println("Assign the Teacher ID now: ");
                                int teacherID = Integer.parseInt(scan.nextLine());
                                //String query = "INSERT INTO test (Classname,TeacherId) values ('" + className + "',"+ teacherID +");";

                                try
                                        (Connection connection = MySqlConnection.getConnection()) {
                                    // Does the INSERT function
                                    String query = "INSERT INTO test (Classname,TeacherId) values ('" + className + "',"+ teacherID +");";
                                    System.out.println(query);
                                       try (PreparedStatement conn = connection.prepareStatement(query)) {
                                           int return1 = conn.executeUpdate();
                                           System.out.println("Updated Rows: " + return1); // returns the number of rows affected
                                           }
                                     query = "SELECT * FROM test"; // shows the resulted table
                                       System.out.println("\nUpdated Table \n");
                                    try (PreparedStatement conn = connection.prepareStatement(query);
                                        ResultSet resultSet = conn.executeQuery()) {
                                            while (resultSet.next()) {
                                                System.out.println(resultSet.getString((1)) + ", " + resultSet.getString(2)+ ", " + resultSet.getString(3));
                                            }
                                    }



                                } catch (SQLException e) {
                                    throw new RuntimeException(e); }


                                    break;
                                }

                            case 'E': {
                                System.out.println("Editing Class mode enabled: ");
                                // call external class for connecting to DB

                                try (Connection connection = MySqlConnection.getConnection()) {
                                    // performsn first select from to showcase what the user is seeing.
                                    String query = "SELECT * FROM test";
                                    System.out.println("Class DB contains: ");
                                    try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                                         ResultSet resultSet = preparedStatement.executeQuery()) {
                                        while (resultSet.next()) {
                                            System.out.println(resultSet.getString((1)) + ", " + resultSet.getString(2)+ ", " + resultSet.getString(3));

                                        }
                                    }
                                } catch (SQLException e) {
                                    throw new RuntimeException(e); }

                                System.out.println("\n Please insert the ID of the class row to edit: ");
                                int classID = Integer.parseInt(scan.nextLine());
                                System.out.println("Enter the replacement name for this class: ");
                                String className = scan.nextLine();
                                System.out.println("Assign the Teacher ID now: ");
                                int teacherID = Integer.parseInt(scan.nextLine());
                                //String query = "UPDATE test set Classname = " +className+ ", TeacherId " + teacherID + " WHERE id = " + classID +";";

                                try
                                        (Connection connection = MySqlConnection.getConnection()) {
                                    // Does the UPDATE function
                                    String query = "UPDATE test SET Classname = '" +className+ "', TeacherId = " + teacherID + " WHERE id = " + classID +";";
                                    System.out.println(query);
                                    try (PreparedStatement conn = connection.prepareStatement(query)) {
                                        int return1 = conn.executeUpdate();
                                        System.out.println("Updated Rows: " + return1); // returns the number of rows affected
                                    }
                                    query = "SELECT * FROM test"; // shows the resulted table
                                    System.out.println("\nUpdated Table \n");
                                    try (PreparedStatement conn = connection.prepareStatement(query);
                                         ResultSet resultSet = conn.executeQuery()) {
                                        while (resultSet.next()) {
                                            System.out.println(resultSet.getString((1)) + ", " + resultSet.getString(2)+ ", " + resultSet.getString(3));
                                        }
                                    }



                                } catch (SQLException e) {
                                    throw new RuntimeException(e); }


                                break;
                            }
                            case 'D': {
                                System.out.println("Deleting Class mode enabled: ");
                                // call external class for connecting to DB
                                try (Connection connection = MySqlConnection.getConnection()) {
                                    // performsn first select from to showcase what the user is seeing.
                                    String query = "SELECT * FROM test";
                                    System.out.println("Class DB contains: ");
                                    try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                                         ResultSet resultSet = preparedStatement.executeQuery()) {
                                        while (resultSet.next()) {
                                            System.out.println(resultSet.getString((1)) + ", " + resultSet.getString(2)+ ", " + resultSet.getString(3));

                                        }
                                    }
                                } catch (SQLException e) {
                                    throw new RuntimeException(e); }

                                System.out.println("\n Please insert the ID of the class row to DELETE: ");
                                int classID = Integer.parseInt(scan.nextLine());
                                //String query = "DELETE FROM test WHERE id = " + classID +";";

                                String query = "DELETE FROM test WHERE id = " + (classID) + ";";
                                System.out.println(query + "\n");
                                System.out.println("Are you sure you want to delete this class? (Yes/No)\n");
                                String AreYouSure = scan.nextLine();
                                if (AreYouSure.equals("Yes")) {
                                    try (Connection connection = MySqlConnection.getConnection()) {
                                        // Does the DELETE function
                                        try (PreparedStatement conn = connection.prepareStatement(query)) {
                                            int return1 = conn.executeUpdate();
                                            System.out.println("Updated Rows: " + return1); // returns the number of rows affected

                                        }
                                    } catch (SQLException e) {
                                        throw new RuntimeException(e);
                                    }

                                    query = "SELECT * FROM test"; // shows the resulted table
                                    System.out.println("\nUpdated Table \n");
                                    try (Connection connection = MySqlConnection.getConnection()) {
                                        try (PreparedStatement conn = connection.prepareStatement(query);
                                             ResultSet resultSet = conn.executeQuery()) {
                                            while (resultSet.next()) {
                                                System.out.println(resultSet.getString((1)) + ", " + resultSet.getString(2) + ", " + resultSet.getString(3));
                                            }


                                        } catch (SQLException e) {
                                            throw new RuntimeException(e);
                                        }
                                    } catch (SQLException e) {
                                        throw new RuntimeException(e);
                                    }
                                }else { }


                                break; }

                            case 'X': {
                                System.out.println("Returning to main menu. \n");
                                classMenu = 'X';
                                break;
                            }
                            default: {
                                System.out.println("Unknown response, try again: ");
                                break;
                            }

                        }
                    }
                    while (  classMenu != 'X') ;
                    break;
                }
                case 'R': {
                    System.out.println("Selecting Class room Management ");
                    do {
                        System.out.println("Please select from the options: ");
                        System.out.println("For inserting new Class room data, select N ");
                        System.out.println("For Editing Class room data, select E: ");
                        System.out.println("For Deleting Class room data, select D: ");
                        System.out.println("To return to the prior menu press X: ");
                        roomMenu = menuOption.next().charAt(0);

                        switch (roomMenu) {
                            case 'N': {
                                System.out.println("Insert Class room mode enabled: ");
                                // call external class for connecting to DB
                                break;
                            }
                            case 'E': {
                                System.out.println("Editing Class room mode enabled: ");
                                // call external class for connecting to DB

                                break;
                            }
                            case 'D': {
                                System.out.println("Deleting Class room mode enabled: ");
                                // call external class for connecting to DB

                                break;
                            }
                            case 'X': {
                                System.out.println("Returning to main menu. ");
                                roomMenu = 'X';
                                break;
                            }
                            default: {
                                System.out.println("Unknown response, try again: ");
                                break;
                            }

                        }
                    }
                    while (  roomMenu != 'X') ;
                    break;
                }
                case 'G':{
                    System.out.println("Selecting Grades Management ");
                    do {
                        System.out.println("Please select from the options: ");
                        System.out.println("For inserting new Grades data, select N ");
                        System.out.println("For Editing Grades data, select E ");
                        System.out.println("For Deleting Grades data, select D ");
                        System.out.println("To return to the prior menu press X ");
                        gradesMenu = menuOption.next().charAt(0);

                        switch (gradesMenu) {
                            case 'N': {
                                System.out.println("Insert Grades mode enabled: ");
                                // call external class for connecting to DB
                                break;
                            }
                            case 'E': {
                                System.out.println("Editing Grades mode enabled: ");
                                // call external class for connecting to DB

                                break;
                            }
                            case 'D': {
                                System.out.println("Deleting Grades mode enabled: ");
                                // call external class for connecting to DB

                                break;
                            }
                            case 'X': {
                                System.out.println("Returning to main menu. ");
                                gradesMenu = 'X';
                                break;
                            }
                            default: {
                                System.out.println("Unknown response, try again: ");
                                break;
                            }

                        }
                    }
                    while (  gradesMenu != 'X') ;
                    break;
                }
                case 'X':{
                    System.out.println("Exiting now... \n");
                    mainMenu = 'X';
                    break;
                }
                default: {
                    System.out.println("Unknown response, try again.... \n");
                    mainMenu = 'L';
                }
            }

        }
        while (  mainMenu != 'X') ;
        System.out.println("Thanks for using this program.");

        }
    }
