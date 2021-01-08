/*
 * => Descricao da classe Dama:
 *          -> A Dama eh a peca mais poderosa, pois pode andar quantas casas quiser na horizontal, vertical ou diagonal. 
 *          -> O movimento de uma Dama pode ser descrito como a combinacao do movimento do Bispo e da Torre.
 *          -> Uma Dama pode ser da cor branca, representada por 'd', ou da cor preta, representada por 'D'.
 *
 * => Funcionalidades da classe Dsma:
 *          -> Retornar o elemento que vai representar a peca Dama no tabuleiro.
 *          -> Verificar se o movimento pretendido eh possivel de ser realizado por uma Dama do jogo de xadrez.
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

public class Dama extends Peca
{
/* ===========================================================================
 * ============================= METODOS NORMAIS =============================
 * =========================================================================== */
    @Override
    // Retorna o simbolo da dama.
    public char desenho()
    {
        return simbolo;
    }
    
    @Override
    /* -> Verifica se o movimento pode ser realizado por uma dama.
       -> Retorna true, se o movimento for adequedado e false, caso contrario. */
    public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino)
    {
        // Movimento de Torre:
        if (linhaOrigem == linhaDestino || colunaOrigem == colunaDestino)
        {
            return true;
        }
        // Movimento de Bispo:
        else if (Math.abs(linhaDestino - linhaOrigem) == Math.abs(colunaDestino - colunaOrigem))
        {
            return true;
        }
        
        return false;
    }
    
    
/* ===========================================================================
 * ============================ METODOS ESPECIAIS ============================
 * =========================================================================== */
// <<< Construtor da classe Dama: >>>
    public Dama(String cor) throws CorPecaException
    {
        super(cor);
        
        if(cor.equals("brc"))
        {
            this.simbolo = 'd';
        }
        else if(cor.equals("prt"))
        {
            this.simbolo = 'D';
        }
    }
}