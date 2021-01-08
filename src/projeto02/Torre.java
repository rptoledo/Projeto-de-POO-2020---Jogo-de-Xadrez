/*
 * => Descricao da classe Torre:
 *          -> A Torre pode se mover quantas casas quiser na horizontal ou vertical, mas não pode se mover diagonalmente.
 *          -> Uma Torre pode ser da cor branca, representada por 't', ou da cor preta, representado por 'T'.
 *
 * => Funcionalidades da classe Torre:
 *          -> Retornar o elemento que vai representar a peca Torre no tabuleiro.
 *          -> Verificar se o movimento pretendido eh possivel de ser realizado por uma Torre do jogo de xadrez.
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

public class Torre extends Peca
{
/* ===========================================================================
 * ============================= METODOS NORMAIS =============================
 * =========================================================================== */
    @Override
    // Retorna o simbolo da torre.
    public char desenho()
    {
        return simbolo;
    }
    
    @Override
    /* -> Verifica se o movimento pode ser realizado por uma torre.
       -> Retorna true, se o movimento for adequedado e false, caso contrario. */
    public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino)
    {
        // Se mudar apenas a linha ou apenas a coluna, o movimento eh valido:
        if (linhaOrigem == linhaDestino || colunaOrigem == colunaDestino)
        {
            return true;
        }
        
        return false;
    }
    
    
/* ===========================================================================
 * ============================ METODOS ESPECIAIS ============================
 * =========================================================================== */
// <<< Construtor da classe Torre: >>>
    public Torre(String cor) throws CorPecaException
    {
        super(cor);
        
        if(cor.equals("brc"))
        {
            this.simbolo = 't';
        }
        else if(cor.equals("prt"))
        {
            this.simbolo = 'T';
        }
    }
}