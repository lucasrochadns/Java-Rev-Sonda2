package br.com.java.rev.sonda2.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProgramTwo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        String path = "C:\\Java-Rev-Sonda2\\Java-Rev-Sonda2\\src\\nomes.txt";

        try(BufferedReader rd = new BufferedReader(new FileReader(path)))
        {
            String name = rd.readLine();
            while(name != null){
                names.add(name);
                name = rd.readLine();
        }
         names.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
