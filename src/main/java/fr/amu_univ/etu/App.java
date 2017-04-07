package fr.amu_univ.etu;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App
{
    public static void main( String[] args )
    {
        try {
            List<String> motsInutiles = new ArrayList<>();
            BufferedReader buff = new BufferedReader(new FileReader("motsinutiles.txt"));
            motsInutiles = buff.lines().collect(Collectors.toList());
            BufferedReader buf = new BufferedReader(new FileReader("science-en.csv"));
            List<String> mots = new ArrayList<>();
            String line;
            while((line = buf.readLine()) != null){
                for(String str : line.split(";")){
                    str = str.replaceAll("\"", "");
                    if(!motsInutiles.contains(str.toLowerCase()))
                        System.out.println(str);
                        mots.add(str);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}