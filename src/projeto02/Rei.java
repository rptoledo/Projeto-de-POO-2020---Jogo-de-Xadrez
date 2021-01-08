/*
 * => Descricao da classe Rei:
 *          -> O Rei pode se mover em qualquer direcao, mas apenas uma casa e com a restricao de que
 *              ele nao pode se mover para alguma casa que esteja controlada por uma peca adversaria.
 *          -> Um Rei pode ser da cor branca, representado por 'r', ou da cor preta, representado por 'R'.
 *
 * => Funcionalidades da classe Rei:
 *          -> Retornar o elemento que vai representar a peca Rei no tabuleiro.
 *          -> Verificar se o movimento pretendido eh possivel de ser realizado por um Rei do jogo de xadrez.
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

public class Rei extends Peca
{
/* ===========================================================================
 * ============================= METODOS NORMAIS =============================
 * =========================================================================== */
    @Override
    // Retorna o simbolo do rei.
    public char desenho()
    {
        return simbolo;
    }
    
    @Override
    /* -> Verifica se o movimento pode ser realizado por um rei.
       -> Retorna true, se o movimento for adequedado e false, caso contrario. */
    public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino)
    {
        // Se as distancias entre a (linhaOrigem e linhaDestino) e a (colunaOrigem e colunaDestino) forem 0 ou 1:
        if (Math.abs(linhaDestino - linhaOrigem) < 2 && Math.abs(colunaDestino - colunaOrigem) < 2)
        {
            return true;
        }
        
        return false;
    }
    
    
/* ===========================================================================
 * ============================ METODOS ESPECIAIS ============================
 * =========================================================================== */
// <<< Construtor da classe Rei: >>>
    public Rei(String cor) throws CorPecaException
    {
        super(cor);
        
        if(cor.equals("brc"))
        {
            this.simbolo = 'r';
        }
        else if(cor.equals("prt"))
        {
            this.simbolo = 'R';
        }
    }
}