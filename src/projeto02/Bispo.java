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
    // Retorna o simbolo do bispo.
    public char desenho()
    {
        return simbolo;
    }
    
    @Override
    /* -> Verifica se o movimento pode ser realizado por um bispo.
       -> Retorna true, se o movimento for adequedado e false, caso contrario. */
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
    public Bispo(String cor) throws CorPecaException
    {
        super(cor);
        
        if(cor.equals("brc"))
        {
            this.simbolo = 'b';
        }
        else if(cor.equals("prt"))
        {
            this.simbolo = 'B';
        }
    }
}