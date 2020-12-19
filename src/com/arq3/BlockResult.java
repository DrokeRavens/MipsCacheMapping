package com.arq3;

import java.util.ArrayList;

/*
 * Essa classe será um objeto que irá conter as informaçoes já processadas e prontas para serem escritas no arquivo final.
 * */
public class BlockResult {
    public MemorySizeStr cacheSize;
    public int addrBitsCount;
    public int bitsBlockPosition;
    public int bitsSet;
    public int bitsTAG;
    public ProcessoEnderecos processoEnderecos;

    public static class ProcessoEnderecos {
        public ArrayList<String> linha = new ArrayList<>();
    }

    public static class MemorySizeStr {
        public enum MemoryType {
            B,
            KB,
            MB,
            GB;
        }
        public String type;
        public long value;


        public static MemorySizeStr GetMemoryResult(long value){
            var retorno = new MemorySizeStr();

            var tmp = value / 1024;
            if(tmp <= 0){
                retorno.value = value;
                retorno.type = "B";
                return retorno;
            }

            tmp = tmp / 1024;

            if(tmp <= 0){
                retorno.value = value / 1024;
                retorno.type = "KB";
                return retorno;
            }

            tmp = tmp / 1024;

            if(tmp <= 0){
                retorno.value = value / 1024 / 1024;
                retorno.type = "MB";
                return retorno;
            }

            tmp = tmp / 1024;

            if(tmp <= 0){
                retorno.value = value / 1024 / 1024 / 1024;
                retorno.type = "GB";
                return retorno;
            }

            return retorno;
        }
    }
}
