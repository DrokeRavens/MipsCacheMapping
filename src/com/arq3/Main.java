package com.arq3;

public class Main {

    public static void main(String[] args) {
        BlockInitial init = new BlockInitial();

        init.memorySize = BlockInitial.MemorySize.GetMemoryInBytes(2, "GB");
        init.acessosMemoria = new int[]{
                7432,
                1024,
                2860,
                14522,
                8500,
                16380,
                11024,
                1345880,
                945622,
                115900
        };

        init.mapType = 3;
        init.mainInfo = new BlockInitial.MainInfo(8,8,16,32,10);
        System.out.println("teste");
        var t = Mapping.CalculateAssociativeSet(init);

        var c = 0;

    }
}
