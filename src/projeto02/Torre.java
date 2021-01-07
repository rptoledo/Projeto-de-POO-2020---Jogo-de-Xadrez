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
    // Retorna o elemento que representa a peca Torre, que sera desenhada na tela:
    public char desenho()
    {
        return simbolo;
    }
    
    @Override
    // Verifica se o movimento que o usuario deseja fazer eh adequado para a peca Torre:
    public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino)
    {
        // Se mudar apenas a linha ou apenas a coluna, o movimento eh valido.
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
    public Torre(String cor)
    {
        try
        {
            switch (cor) {
                case "brc":
                    this.simbolo = 't'; // 't' simboliza a peca Torre Branca.
                    break;
                case "prt":
                    this.simbolo = 'T'; // 'T' simboliza a peca Torre Preta.
                    break;
                default:
                    throw new Error("O parametro para a cor da Torre eh invalido!\n");
            }
        }
        catch(Error e)
        {
            System.out.println(e.getMessage() );
            System.exit(-1); // Termina o programa devido ao erro (-1) na passagem do parametro para a cor.
        }
        
        this.cor = cor; // "brc" (branco) ou "prt" (preto) representam a cor da peca Torre.
        this.capturado = false; // Usado para verificar se a peca Torre esta no jogo.
    }
}