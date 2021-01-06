/*
 * => Descricao da classe Cavalo:
 *          -> O Cavalo se movimenta em L, duas casas em linha reta (horizontal ou vertical) em
 *              qualquer direção, e depois uma casa na direcao perpendicular a primeira.
 *          -> O Cavalo eh a unica peca que pode pular sobre as outras pecas.
 *          -> Um Cavalo pode ser da cor branca, representado por 'c', ou da cor preta, representado por 'C'.
 *
 * => Funcionalidades da classe Bispo:
 *          -> Retornar o elemento que vai representar a peca Cavalo no tabuleiro.
 *          -> Verificar se o movimento pretendido eh possivel de ser realizado por um Cavalo do jogo de xadrez.
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

public class Cavalo extends Peca
{
/* ===========================================================================
 * ============================= METODOS NORMAIS =============================
 * =========================================================================== */
    @Override
    // Retorna o elemento que representa a peca Cavalo, que sera desenhada na tela:
    public char desenho()
    {
        return simbolo;
    }
    
    @Override
    // Verifica se o movimento que o usuario deseja fazer eh adequado para a peca Cavalo:
    public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino)
    {
        // Fazendo o L para cima:
        if (linhaDestino - linhaOrigem == 2)
        {
            // Uso o valor absoluto (modulo matematico), ja que o Cavalo pode fazer o L tanto para esquerda, quanto para a direita.
            if (Math.abs(colunaDestino - colunaOrigem) == 1)
            {
                return true;
            }
        }
        // Fazendo o L para a direita:
        else if (colunaDestino - colunaOrigem == 2)
        {
            // Uso o valor absoluto (modulo matematico), ja que o Cavalo pode fazer o L tanto para cima, quanto para baixo.
            if (Math.abs(linhaDestino - linhaOrigem) == 1)
            {
                return true;
            }
        }
        // Fazendo o L para baixo:
        if (linhaDestino - linhaOrigem == -2)
        {
            // Uso o valor absoluto (modulo matematico), ja que o Cavalo pode fazer o L tanto para esquerda, quanto para a direita.
            if (Math.abs(colunaDestino - colunaOrigem) == 1)
            {
                return true;
            }
        }
        // Fazendo o L para a esquerda:
        else if (colunaDestino - colunaOrigem == -2)
        {
            // Uso o valor absoluto (modulo matematico), ja que o Cavalo pode fazer o L tanto para cima, quanto para baixo.
            if (Math.abs(linhaDestino - linhaOrigem) == 1)
            {
                return true;
            }
        }
        
        return false;
    }
    
    
/* ===========================================================================
 * ============================ METODOS ESPECIAIS ============================
 * =========================================================================== */
    // <<< Construtor da classe Cavalo: >>>
    public Cavalo(String cor)
    {
        try
        {
            switch (cor) {
                case "brc":
                    this.simbolo = 'c'; // 'c' simboliza a peca Cavalo Branco.
                    break;
                case "prt":
                    this.simbolo = 'C'; // 'C' simboliza a peca Cavalo Preto.
                    break;
                default:
                    throw new Error("O parametro para a cor do Cavalo eh invalido!\n");
            }
        }
        catch(Error e)
        {
            System.out.println(e.getMessage());
            System.exit(-1); // Termina o programa devido ao erro na passagem do parametro para a cor (representado por -1).
        }
        
        this.cor = cor; // "brc" (branco) ou "prt" (preto) representam a cor da peca Cavalo.
        this.capturado = false; // Usado para verificar se a peca Cavalo esta no jogo.
    }
}