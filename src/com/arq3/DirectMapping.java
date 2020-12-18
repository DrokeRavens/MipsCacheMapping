package com.arq3;

/**
 * Esta classe realiza o mapeamento direto
 *
 */
public class DirectMapping {

    private int memorySize;

    private int wordSize;

    private int wordsPerBlock;

    final int linesPerSet = 1;

    private int cacheSets;

    private int[] memoryAccess;

    public DirectMapping(int size, int x, int p, int c, int[] Access) {
        memorySize = size;
        wordSize = x;
        wordsPerBlock = p;
        cacheSets = c;
        memoryAccess = Access;
    }

    public void calculate() {
        int cacheSize = wordSize * wordsPerBlock * cacheSets;
        //Contando que o valor de memorySize já esteja em bytes
        int addrBitsCount = Integer.toBinaryString(memorySize-1).length();
        int bitsBlockPosition = Integer.toBinaryString((wordsPerBlock*wordSize)-1).length();
        int bitsSet = Integer.toBinaryString(cacheSets-1).length();
        int bitsTag = addrBitsCount-bitsBlockPosition-bitsSet;
        
        for (int i = 0; i < memoryAccess.length; i++) {
                String baseString = "0".repeat(addrBitsCount - Integer.toBinaryString(memoryAccess[i]).length()).concat(Integer.toBinaryString(memoryAccess[i]));
                int tag = Integer.parseInt(baseString.substring(0, bitsTag), 2);
                int line = Integer.parseInt(baseString.substring(bitsTag, bitsTag + bitsBlockPosition), 2);
                int block = Integer.parseInt(baseString.substring(bitsTag+bitsSet), 2);
                System.out.println(tag);
                System.out.println(line);
                System.out.println(block);
        }
    }
}
