/*
 * => Descricao da classe Posicao:
 *          -> Cada Posicao tem uma linha (de 1 a 8) e uma coluna (de a a h).
 *          -> Cada Posicao pode estar vazia ou ocupada por uma peca, e deve saber que peca a ocupa.
 *          -> Uma Posicao pode ser da cor branca, representada por ' ' (quando estiver vazia),
 *              ou da cor preta, representada por '*' (quando estiver vazia), quando a Posicao estiver
 *              ocupada, ela sera representada pelo simbolo da Peca que a ocupa.
 *
 * => Funcionalidades da classe Posicao:
 *          -> Criar uma Posicao, que equivale a uma casa do jogo de xadrez.
 *          -> Verificar se a Posicao que sera criada eh valida.
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

public class Posicao
{
/* ===========================================================================
 * ================================ ATRIBUTOS ================================
 * =========================================================================== */
    private final int LINHAPOSICAO; // Usado para armazenar a linha da posicao.
    private final char COLUNAPOSICAO; // Usado para armazenar a coluna da posicao.
    private final char CORPOSICAO; // Usado para armazenar a cor da posicao.
    private Peca pecaPosicao; // Usado para armazenar a peca que eventualmente ocupa a posicao ou null.
    
    
/* ===========================================================================
 * ============================= METODOS NORMAIS =============================
 * =========================================================================== */
    /* -> Verifica se a posicao que sera criada eh valida, levando em consideracao linha, coluna e cor.
       -> Retorna true, se a posicao for valida e false, caso contrario. */
    private boolean checaPosicao(int linha, char coluna, char cor)
    {
        if (linha >= 1 && linha <= 8 && (int) coluna >= 97 && (int) coluna <= 104 && (cor == ' ' || cor == '*'))
        {
            return true;
        }
        
        else
        {
            return false;
        }
    }
    
    
/* ===========================================================================
 * ============================ METODOS ESPECIAIS ============================
 * =========================================================================== */
// <<< Construtor da classe Posicao: >>>
    public Posicao(int linha, char coluna, char cor)
    {
        try
        {
            if (checaPosicao(linha, coluna, cor) == false)
            {
                throw new Error("Um ou mais parametros passados para o construtor de posicao sao invalidos!\n");
            }
        }
        catch(Error e)
        {
            System.out.println(e.getMessage());
            // Termina o programa devido a um erro (-1) na passagem dos parametros do construtor:
            System.exit(-1);
        }
        
        this.LINHAPOSICAO = linha;
        this.COLUNAPOSICAO = coluna;
        this.CORPOSICAO = cor;
        this.pecaPosicao = null;
    }
    
// <<< Getters e Setters da classe Posicao: >>>
    public int getLINHAPOSICAO()
    {
        return this.LINHAPOSICAO;
    }
    
    public char getCOLUNAPOSICAO()
    {
        return this.COLUNAPOSICAO;
    }
    
    public char getCORPOSICAO()
    {
        return this.CORPOSICAO;
    }
    
    public Peca getPecaPosicao()
    {
        return pecaPosicao;
    }
    
    public void setPecaPosicao(Peca peca)
    {
        this.pecaPosicao = peca;
    }
}