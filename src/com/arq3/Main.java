package com.arq3;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        while(true){
            System.out.println("Olá! Seja bem vindo ao conversor digital versao 12231213123, será um honra converter seu arquivo!");
            System.out.println("Por favor, digite o nome do arquivo, ou o caminho do mesmo:");
            var cmd = sc.nextLine();

            if(cmd.equalsIgnoreCase("sair"))
                System.exit(0);

            FileController fileController = new FileController(cmd);
            var lines = fileController.ReadAllLines();

            try{
                var initBlock = new BlockInitial();
                initBlock.mapType = Integer.parseInt(lines[0]);
                long memoryValue = Long.parseLong(lines[1].split(" ")[0]);
                initBlock.memorySize = BlockInitial.MemorySize.GetMemoryInBytes(memoryValue, lines[1].split(" ")[1]);

                var splitedMainInfo = lines[2].split(" ");
                var splitedMainInfoListInt = Arrays.stream(splitedMainInfo).map(Integer::parseInt).collect(Collectors.toList());

                initBlock.mainInfo = new BlockInitial.MainInfo(splitedMainInfoListInt.get(0), splitedMainInfoListInt.get(1),splitedMainInfoListInt.get(2),
                        splitedMainInfoListInt.get(3),splitedMainInfoListInt.get(4));

                initBlock.acessosMemoria = new int[lines.length-3];
                for(int i =3, j =0 ; i < lines.length; i++, j++){
                    initBlock.acessosMemoria[j] = Integer.parseInt(lines[i]);
                }
                BlockResult result = new BlockResult();
                switch (initBlock.mapType){
                    case 1: //direto
                        result = Mapping.CalculateDirect(initBlock);
                        break;
                    case 2: //associativo
                        result = Mapping.CalculateAssociative(initBlock);
                        break;
                    case 3: //associativoconjunto
                        result = Mapping.CalculateAssociativeSet(initBlock);
                        break;
                }

                fileController.SaveFileSerialized(result);

            }
            catch (Exception ex){
                System.out.println("Ocorreu um erro [" + ex.getMessage() + "]");
            }

        }
            //System.in is a standard input stream


    }
}
