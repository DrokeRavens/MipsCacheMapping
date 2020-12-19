package com.arq3;

/**
 * Esta classe realiza o mapeamento direto
 *
 */
public class Mapping {

    public static BlockResult CalculateDirect(BlockInitial blockInitial) {
        int cacheSize = blockInitial.mainInfo.bytesNaPalavra *
                blockInitial.mainInfo.palavrasNoBloco *
                blockInitial.mainInfo.conjuntoCache;
        //Contando que o valor de memorySize já esteja em bytes
        int addrBitsCount = Long.toBinaryString(blockInitial.memorySize.value-1).length();
        int bitsBlockPosition = Integer.toBinaryString((blockInitial.mainInfo.palavrasNoBloco*blockInitial.mainInfo.bytesNaPalavra)-1).length();
        int bitsSet = Integer.toBinaryString(blockInitial.mainInfo.conjuntoCache-1).length();
        int bitsTag = addrBitsCount-bitsBlockPosition-bitsSet;
        BlockResult result = new BlockResult();
        result.addrBitsCount = addrBitsCount;
        result.cacheSize = BlockResult.MemorySizeStr.GetMemoryResult(cacheSize);
        result.bitsBlockPosition = bitsBlockPosition;
        result.bitsSet = bitsSet;
        result.bitsTAG = bitsTag;
        result.processoEnderecos = new BlockResult.ProcessoEnderecos();

        for (int i = 0; i < blockInitial.acessosMemoria.length; i++) {
                String baseString =
                        "0".repeat(addrBitsCount - Integer.toBinaryString(blockInitial.acessosMemoria[i]).length())
                        .concat(Integer.toBinaryString(blockInitial.acessosMemoria[i]));

                int tag = Integer.parseInt(baseString.substring(0, bitsTag), 2);
                int line = Integer.parseInt(baseString.substring(bitsTag, bitsTag + bitsBlockPosition), 2);
                int block = Integer.parseInt(baseString.substring(bitsTag+bitsSet), 2);
            result.processoEnderecos.linha.add(tag + " " + line + " " + block);
        }

        return result;
    }

    public static BlockResult CalculateAssociativeSet(BlockInitial blockInitial) {
        int cacheSize = blockInitial.mainInfo.bytesNaPalavra *
                blockInitial.mainInfo.palavrasNoBloco *
                blockInitial.mainInfo.viasNoConjunto *
                blockInitial.mainInfo.conjuntoCache;
        //Contando que o valor de memorySize já esteja em bytes
        int addrBitsCount = Long.toBinaryString(blockInitial.memorySize.value-1).length();
        int bitsBlockPosition = Integer.toBinaryString((blockInitial.mainInfo.palavrasNoBloco*blockInitial.mainInfo.bytesNaPalavra)-1).length();
        int bitsSet = Integer.toBinaryString(blockInitial.mainInfo.conjuntoCache-1).length();
        int bitsTag = addrBitsCount-bitsBlockPosition-bitsSet;
        BlockResult result = new BlockResult();
        result.addrBitsCount = addrBitsCount;
        result.cacheSize = BlockResult.MemorySizeStr.GetMemoryResult(cacheSize);
        result.bitsBlockPosition = bitsBlockPosition;
        result.bitsSet = bitsSet;
        result.bitsTAG = bitsTag;
        result.processoEnderecos = new BlockResult.ProcessoEnderecos();

        for (int i = 0; i < blockInitial.acessosMemoria.length; i++) {
            String baseString =
                    "0".repeat(addrBitsCount - Integer.toBinaryString(blockInitial.acessosMemoria[i]).length())
                            .concat(Integer.toBinaryString(blockInitial.acessosMemoria[i]));

            int tag = Integer.parseInt(baseString.substring(0, bitsTag), 2);
            int conjunto = Integer.parseInt(baseString.substring(bitsTag, bitsTag + bitsSet), 2);
            int blockPosition = Integer.parseInt(baseString.substring(bitsTag+bitsSet), 2);
            result.processoEnderecos.linha.add(tag + " " + conjunto + " " + blockPosition);
        }

        return result;
    }
    
    public static BlockResult CalculateAssociative(BlockInitial blockInitial) {
        int cacheSize = blockInitial.mainInfo.bytesNaPalavra *
                blockInitial.mainInfo.palavrasNoBloco *
                blockInitial.mainInfo.conjuntoCache * 
                blockInitial.mainInfo.viasNoConjunto;
        //Contando que o valor de memorySize já esteja em bytes
        int addrBitsCount = Long.toBinaryString(blockInitial.memorySize.value-1).length();
        int bitsBlockPosition = Integer.toBinaryString((blockInitial.mainInfo.palavrasNoBloco*blockInitial.mainInfo.bytesNaPalavra)-1).length();
        int bitsSet = 0;
        int bitsTag = addrBitsCount-bitsBlockPosition-bitsSet;
        BlockResult result = new BlockResult();
        result.addrBitsCount = addrBitsCount;
        result.cacheSize = BlockResult.MemorySizeStr.GetMemoryResult(cacheSize);
        result.bitsBlockPosition = bitsBlockPosition;
        result.bitsSet = bitsSet;
        result.bitsTAG = bitsTag;
        result.processoEnderecos = new BlockResult.ProcessoEnderecos();

        for (int i = 0; i < blockInitial.acessosMemoria.length; i++) {
                String baseString =
                        "0".repeat(addrBitsCount - Integer.toBinaryString(blockInitial.acessosMemoria[i]).length())
                        .concat(Integer.toBinaryString(blockInitial.acessosMemoria[i]));

                int tag = Integer.parseInt(baseString.substring(0, bitsTag), 2);
                int line = 0;
                int block = Integer.parseInt(baseString.substring(bitsTag), 2);
            result.processoEnderecos.linha.add(tag + " " + line + " " + block);
        }

        return result;
    }

}
