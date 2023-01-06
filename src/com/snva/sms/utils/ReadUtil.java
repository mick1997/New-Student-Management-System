package com.snva.sms.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadUtil {

    private BufferedReader reader;

    public ReadUtil() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * This function reads a string value from the console and converts it to the integer value.
     * @param userMsg This is the message for the user to enter integer value.
     * @param warningMsg This message is raised if the user wants to enter
     * anything other than the integer value.
     * @return Val. Returns an integer value.
     * @exception NumberFormatException to indicate that the application
     * has attempted to convert a string to one of the numeric types, but that
     * the string does not have the appropriate format.
     * @exception IOException produced by failed or interrupted I/O operations
     */
    public int readInt(String userMsg, String warningMsg) {

        int val = 0;
        System.out.println(userMsg);
        try {
            val = Integer.parseInt(reader.readLine());
        }
        catch (NumberFormatException e) {
            System.out.println("Please enter a valid number!");
            val = readInt(userMsg, warningMsg);
        }
        catch (IOException e) {
            System.out.println("Not a appropriate input, please try again!");
        }
        return val;
    }

    /**
     * This function reads a string value from the console.
     * @param userMsg This is the message for the user to enter string value.
     * @param warningMsg This message is raised if the user wants to enter
     * an empty string.
     * @return str. String is returned.
     * @exception IOException produced by failed or interrupted I/O operations
     */
    public String readString(String userMsg, String warningMsg) {

        String str = "";
        try {
            System.out.println(userMsg);
            str = reader.readLine();
            if (str.trim().length() == 0) {
                System.out.println(warningMsg);
                str = readString(userMsg, warningMsg);
            }
        }
        catch (IOException e) {
            System.out.println("Not a appropriate input, please try again!");
        }
        return str;
    }

    /**
     * This function reads a string value from the console and converts it to the double value.
     * @param userMsg This is the message for the user to enter double value.
     * @param warningMsg This message is raised if the user wants to enter
     * anything other than the double value.
     * @return doub. Returns a double value.
     * @exception NumberFormatException to indicate that the application
     * has attempted to convert a string to one of the numeric types, but that
     * the string does not have the appropriate format.
     * @exception IOException produced by failed or interrupted I/O operations
     */
    public Double readDouble(String userMsg, String warningMsg) {

        Double dob = 0.0;

        try {
            System.out.println(userMsg);
            dob = Double.parseDouble(reader.readLine());
        }
        catch (NumberFormatException e) {
            System.out.println(warningMsg);
            dob = readDouble(userMsg, warningMsg);
        }
        catch (IOException e) {
            System.out.println("Not a appropriate input, please try again!");
        }
        return dob;
    }

    /**
     * This function reads a date as a string value from the console and converts it to the date of specific format.
     * @param userMsg This is the message for the user to enter date in given format.
     * @param warningMsg This message is raised if the user wants to enter
     * date in any other format as specified.
     * @return date Returns a date.
     * @exception ParseException Signals that an error has been reached unexpectedly
     * while parsing.
     * @exception IOException Exceptions produced by failed or interrupted I/O operations.
     */
    public Date readDate(String userMsg, String warningMsg) {

        Date date = null;
        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
        try {
            System.out.println(userMsg);
            date = (Date)format.parse(reader.readLine());
        }
        catch (ParseException e) {
            System.out.println(warningMsg);
            date = readDate(userMsg, warningMsg);
        }
        catch (IOException e) {
            System.out.println(e);
        }
        return date;
    }
}
