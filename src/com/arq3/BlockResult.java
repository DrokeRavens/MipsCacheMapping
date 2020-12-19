package com.arq3;

import java.util.ArrayList;

/*
 * Essa classe será um objeto que irá conter as informaçoes já processadas e prontas para serem escritas no arquivo final.
 * */
public class BlockResult {
    public int cacheSize;
    public int addrBitsCount;
    public int bitsBlockPosition;
    public int bitsSet;
    public int bitsTAG;
    public ProcessoEnderecos processoEnderecos;

    public static class ProcessoEnderecos {
        public ArrayList<String> linha = new ArrayList<>();
    }
}
