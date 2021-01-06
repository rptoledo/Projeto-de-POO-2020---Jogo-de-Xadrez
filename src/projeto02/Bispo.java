/*
 * => Descricao da classe Bispo:
 *          -> O Bispo pode andar quantas casas quiser, desde que na diagonal, ou seja, se o Bispo comecou em
 *              uma casa de cor branca, ele nunca vai conseguir trocar para uma casa de cor preta e vice-versa.
 *          -> Um Bispo pode ser da cor branca, representado por 'b', ou da cor preta, representado por 'B'.
 *
 * => Funcionalidades da classe Bispo:
 *          -> Retornar o elemento que vai representar a peca Bispo no tabuleiro.
 *          -> Verificar se o movimento pretendido eh possivel de ser realizado por um Bispo do jogo de xadrez.
 */

package projeto02;

import java.util.Scanner;

/** ==========================================================================
 *  Universidade Federal de Sao Carlos - Campus Sorocaba
 *  Disciplina: Programacao Orientada a Objetos
 *  Profa Katti Faceli
 *
 *  PROJETO 02
 *
 *  RA: 743590
 *  Autor: Rafael P Toledo
 *  ==========================================================================. */

public class Bispo extends Peca
{
/* ===========================================================================
 * ============================= METODOS NORMAIS =============================
 * =========================================================================== */
    @Override
    // Retorna o elemento que representa a peca Bispo, que sera desenhada na tela:
    public char desenho()
    {
        return simbolo;
    }
    
    @Override
    // Verifica se o movimento que o usuario deseja fazer eh adequado para a peca Bispo:
    public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino)
    {
        // Sentido da Diagonal Secundária:
        // Se as distancias entre a (linhaOrigem e linhaDestino) e a (colunaOrigem e colunaDestino) sao iguais:
        if ((linhaDestino - linhaOrigem) ==  (colunaDestino - colunaOrigem))
        {
            return true;
        }
        // Sentido da Diagonal Principal:
        // Se as distancias entre a (linhaOrigem e linhaDestino) e a (colunaOrigem e colunaDestino) sao iguais, com sinal invertido:
        else if ((linhaDestino - linhaOrigem) ==  - (colunaDestino - colunaOrigem))
        {
            return true;
        }
        
        return false;
    }
    
    
/* ===========================================================================
 * ============================ METODOS ESPECIAIS ============================
 * =========================================================================== */
    // <<< Construtor da classe Bispo: >>>
    public Bispo(String cor)
    {
        try
        {
            switch (cor) {
                case "brc":
                    this.simbolo = 'b'; // 'b' simboliza a peca Bispo Branco.
                    break;
                case "prt":
                    this.simbolo = 'B'; // 'B' simboliza a peca Bispo Preto.
                    break;
                default:
                    throw new Error("O parametro para a cor do Bispo eh invalido!\n");
            }
        }
        catch(Error e)
        {
            System.out.println(e.getMessage());
            System.exit(-1); // Termina o programa devido ao erro (-1) na passagem do parametro para a cor.
        }
        
        this.cor = cor; // "brc" (branco) ou "prt" (preto) representam a cor da peca Bispo.
        this.capturado = false; // Usado para verificar se a peca Bispo esta no jogo.
    }
}