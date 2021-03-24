package com.codecool.chessopen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ChessResults {

    public List<String> getCompetitorsNamesFromFile(String fileName){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            List<Competitors> competitors = new ArrayList<>();
            String theLine;

            while ((theLine = bufferedReader.readLine()) != null){
                String[] lineData = theLine.split(",");
                String name = lineData[0];
                competitors.add(new Competitors(name, Arrays.asList(Integer.parseInt(lineData[1]),
                        Integer.parseInt(lineData[2]), Integer.parseInt(lineData[3]),
                        Integer.parseInt(lineData[4]), Integer.parseInt(lineData[5]))));
            }
            Collections.sort(competitors);
            List<String> orderedNames = new ArrayList<>();

            for(Competitors competitor : competitors){
                orderedNames.add(competitor.getName());
            }
            Collections.reverse(orderedNames);
            return orderedNames;

        }catch (IOException ioe){
            System.out.println("File not found!");
        }
        return null;
    }

}
