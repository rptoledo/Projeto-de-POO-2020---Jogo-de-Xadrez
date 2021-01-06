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
    // Retorna o elemento que representa a peca Dama, que sera desenhada na tela:
    public char desenho()
    {
        return simbolo;
    }
    
    @Override
    // Verifica se o movimento que o usuario deseja fazer eh adequado para a peca Dama:
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
    public Dama(String cor)
    {
        try
        {
            switch (cor) {
                case "brc":
                    this.simbolo = 'd'; // 'd' simboliza a peca Dama Branca.
                    break;
                case "prt":
                    this.simbolo = 'D'; // 'D' simboliza a peca Dama Preta.
                    break;
                default:
                    throw new Error("O parametro para a cor da Dama eh invalido!\n");
            }
        }
        catch(Error e)
        {
            System.out.println(e.getMessage());
            System.exit(-1); // Termina o programa devido ao erro (-1) na passagem do parametro para a cor.
        }
        
        this.cor = cor; // "brc" (branco) ou "prt" (preto) representam a cor da peca Dama.
        this.capturado = false; // Usado para verificar se a peca Dama esta no jogo.
    }
}