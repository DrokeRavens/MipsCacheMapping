package com.arq3;

/*
* Essa classe será um objeto que irá conter as informaçoes lidas, para que podemos processa-las.
* */
public class BlockInitial {
    //Direto, completamente associativo, associativo por conjunto
    public int mapType;
    //Tamanho da memoria
    public MemorySize memorySize;
    //5 inteiros separados por espaço:
    /*
    * o número inteiro ‘x’ de bytes na palavra
    * ○ o número inteiro ‘p’ de palavras no bloco
    * ○ o número inteiro ‘b’ de blocos/vias no conjunto (para o caso de mapeamento direto esse valor será 1)
    * ○ o número inteiro ‘c’ de conjunto na cache (para o caso de mapeamento associativo esse valor será 1)
     * ○ um número inteiro ‘n’ que dirá quantos acessos à memória deverão ser processado
    * */
    public MainInfo mainInfo;
    public int[] acessosMemoria;
    public static class MainInfo {
        public int bytesNaPalavra;
        public int palavrasNoBloco;
        public int viasNoConjunto;
        public int conjuntoCache;
        public int qntdAcessosMemoria;

        public MainInfo(int bytesNaPalavra, int palavrasNoBloco, int viasNoConjunto, int conjuntoCache, int qntdAcessosMemoria) {
            this.bytesNaPalavra = bytesNaPalavra;
            this.palavrasNoBloco = palavrasNoBloco;
            this.viasNoConjunto = viasNoConjunto;
            this.conjuntoCache = conjuntoCache;
            this.qntdAcessosMemoria = qntdAcessosMemoria;
        }
    }

    public static class MemorySize {
        public enum MemoryType {
            B,
            KB,
            MB,
            GB;
        }
        public MemoryType type;
        public long value;


        public static MemorySize GetMemoryInBytes(long value, String memoryType){
            var retorno = new MemorySize();
            if(memoryType.equalsIgnoreCase("kb")){
                retorno.value = value * 1024;
                retorno.type = MemoryType.KB;
            }
            else if(memoryType.equalsIgnoreCase("mb")){
                retorno.value = value * 1024 * 1024;
                retorno.type = MemoryType.MB;
            }
            else if(memoryType.equalsIgnoreCase("gb")){
                retorno.value = value * 1024 * 1024 * 1024;
                retorno.type = MemoryType.GB;
            }
            else{
                retorno.value = value;
                retorno.type = MemoryType.B;
            }

            return retorno;
        }
    }
}
