package com.arq3;

/*
* Essa classe será um objeto que irá conter as informaçoes lidas, para que podemos processa-las.
* */
public class BlockInitial {
    //Direto, completamente associativo, associativo por conjunto
    private int mapType;
    //Tamanho da memoria
    private int memorySize;
    //5 inteiros separados por espaço:
    /*
    * o número inteiro ‘x’ de bytes na palavra
    * ○ o número inteiro ‘p’ de palavras no bloco
    * ○ o número inteiro ‘b’ de blocos/vias no conjunto (para o caso de mapeamento direto esse valor será 1)
    * ○ o número inteiro ‘c’ de conjunto na cache (para o caso de mapeamento associativo esse valor será 1)
     * ○ um número inteiro ‘n’ que dirá quantos acessos à memória deverão ser processado
    * */
    private int[] mainInfo;
}
