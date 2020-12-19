package com.arq3;
import java.io.FileWriter;
import java.io.IOException;
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

    public void SaveFileSerialized(BlockResult blockResult) throws IOException {

        StringBuilder output = new StringBuilder();
        output.append("Tamanho da cache: ").append(blockResult.cacheSize.value).append(" ").append(blockResult.cacheSize.type).append("\n");
        output.append("Número de bits do endereço: ").append(blockResult.addrBitsCount).append("\n");
        output.append("Número de bits para a posição no bloco: ").append(blockResult.bitsBlockPosition).append("\n");
        output.append("Número de bits para o número do conjunto: ").append(blockResult.bitsSet).append("\n");
        output.append("Número de bits para a TAG: ").append(blockResult.bitsTAG).append("\n");

        for(int i = 0; i < blockResult.processoEnderecos.linha.size(); i++) {
            output.append(blockResult.processoEnderecos.linha.get(i)).append("\n");
        }

        var newFile = new File(file.getPath().replace(".txt", "") + "novo.txt");
        try{
            if (newFile.createNewFile()) {
                System.out.println("Novo arquivo criado! [ " + newFile.getName() + " ]");
            } else {
                System.out.println("Já existe um arquivo com o nome [ " + newFile.getName() + " ]");
            }
        }
        catch (IOException e) {
            System.out.println("Erro [ " + e.getMessage() + " ]");
        }

        try {
            FileWriter myWriter = new FileWriter(newFile.getName());
            myWriter.write(output.toString());
            myWriter.close();
            System.out.println("Dados salvos no arquivo  [ " + newFile.getName() + " ]!");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro [" + e.getMessage() + "]!!");
        }
    }
}
