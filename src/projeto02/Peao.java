/*
 * => Descricao da classe Peao:
 *          -> O Peao pode andar apenas uma casa para frente, na mesma coluna, desde que a casa nao esteja ocupada.
 *          -> A excecao para esta regra acontece quando o Peao ainda nao realizou seu primeiro movimento, neste caso,
 *              o jogador pode optar entre avancar o Peao uma casa, ou duas casas, desde que ambas estejam livres.
 *          -> Um Peao pode ser da cor branca, representado por 'p', ou da cor preta, representado por 'P'.
 *
 * => Funcionalidades da classe Peao:
 *          -> Retornar o elemento que vai representar a peca Peao no tabuleiro.
 *          -> Verificar se o movimento pretendido eh possivel de ser realizado por um Peao do jogo de xadrez.
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

public class Peao extends Peca
{
/* ===========================================================================
 * ================================ ATRIBUTOS ================================
 * =========================================================================== */
    private boolean primeiroMov; // Usado para verificar se um determinado peao ja foi movimentado.
    
    
/* ===========================================================================
 * ============================= METODOS NORMAIS =============================
 * =========================================================================== */
    @Override
    // Retorna o simbolo do peao.
    public char desenho()
    {
        return simbolo;
    }
    
    @Override
    /* -> Verifica se o movimento pode ser realizado por um peao.
       -> Retorna true, se o movimento for adequedado e false, caso contrario. */
    public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino)
    {
        // Se mudar de coluna, o movimento eh invalido.
        if (colunaOrigem != colunaDestino)
        {
            return false;
        }
        
        // Se a cor for branca, ASCII = 112 (p):
        if (this.cor == "brc")
        {
            // Checagem para os outros movimentos do Peao Branco (pode se mover apenas 1 casa para frente).
            if (linhaDestino - linhaOrigem == 1)
            {
                return true;
            }
            // Checagem para o primeiro movimento do Peao Branco andando 2 casas para frente.
            else if (linhaDestino - linhaOrigem == 2 && this.isPrimeiroMov() == true)
            {
                return true;
            }
        }
        // Se a cor for preta, ASCII = 80 (P):
        else if (this.cor == "prt")
        {
            // Checagem para os outros movimentos do Peao Preto (pode se mover apenas 1 casa para frente).
            if (linhaOrigem - linhaDestino == 1)
            {
                return true;
            }
            // Checagem para o primeiro movimento do Peao Preto andando 2 casas para frente.
            else if (linhaOrigem - linhaDestino == 2 && this.isPrimeiroMov() == true)
            {
                return true;
            }
        }
        
        return false;
    }
    
    
/* ===========================================================================
 * ============================ METODOS ESPECIAIS ============================
 * =========================================================================== */
// <<< Construtor da classe Peao: >>>
    public Peao(String cor) throws CorPecaException
    {
        super(cor);
        
        if(cor.equals("brc"))
        {
            this.simbolo = 'p';
        }
        else if(cor.equals("prt"))
        {
            this.simbolo = 'P';
        }
        
        this.primeiroMov = true;
    }
    
// <<< Getters e Setters da classe Peca: >>>
    public boolean isPrimeiroMov() {
        return this.primeiroMov;
    }

    public void setPrimeiroMov() {
        this.primeiroMov = false;
    }
}