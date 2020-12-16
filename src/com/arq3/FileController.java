package com.arq3;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class FileController {
    private File file;
    public FileController(String path){
        file = new File(path);
    }

    public String[] ReadAllLines(){
        var fileReader = ReadFile();
        List<String> retorno = new ArrayList<>();
        if(fileReader != null)
        {
            while(fileReader.hasNextLine())
                retorno.add(fileReader.nextLine());
        }
        return retorno.toArray(String[]::new);
    }

    public Scanner ReadFile(){
        try{
            return new Scanner(file);
        }
        catch (FileNotFoundException ex){
            System.out.println("Arquivo não encontrado!");
            return null;
        }
    }
}
