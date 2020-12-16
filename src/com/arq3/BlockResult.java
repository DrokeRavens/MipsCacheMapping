package com.arq3;

import java.util.ArrayList;

/*
 * Essa classe será um objeto que irá conter as informaçoes já processadas e prontas para serem escritas no arquivo final.
 * */
public class BlockResult {
    private int cacheSize;
    private int addrBitsCount;
    private int bitsBlockPosition;
    private int bitsSet;
    private int bitsTAG;
    private ArrayList<ArrayList<Integer>> tagSetBlock = new ArrayList<ArrayList<Integer>>();
}
