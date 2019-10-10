package com.edu.spacecadets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


public class SpaceCadetsTask1 {
    public static void main(String[] args) {
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
            System.out.print("Enter the email: ");
            String email = reader.readLine();

            String webAddress = "";

            webAddress = "https://www.ecs.soton.ac.uk/people/";
            webAddress = webAddress + email;

            System.out.println("The constructed web address is: " + webAddress);

            URL myURL = new URL(webAddress);
            BufferedReader in = new BufferedReader(new InputStreamReader(myURL.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null)
                if(inputLine.contains("property=\"name\"")){

                    Integer nameStart;
                    Integer nameEnd;

                    nameStart = inputLine.indexOf("property=\"name\">") + "property=\"name\">".length();
                    nameEnd = inputLine.indexOf("<em property");

                    System.out.println(inputLine.substring(nameStart,nameEnd));
                }
            in.close();


        } catch (IOException ioe){
            ioe.printStackTrace();
        }

    }
}
