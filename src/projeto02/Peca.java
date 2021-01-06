/*
 * => Descricao da classe Peca:
 *          -> O 
 *          -> U
 *
 * => Funcionalidades da classe Peca:
 *          -> O
 *          -> O
 */

package projeto02;

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

public abstract class Peca
{
/* ===========================================================================
 * ================================ ATRIBUTOS ================================
 * =========================================================================== */
    protected char simbolo; // Letra minuscula para pecas brancas ou letra maiuscula para pecas pretas, representam uma peca.
    protected String cor; // Pecas brancas tem sua cor representada por "br" e pecas pretas por "pr".
    protected boolean capturado; // Usado para verificar se uma determinada peca esta no jogo.
    
    
/* ===========================================================================
 * ============================= METODOS NORMAIS =============================
 * =========================================================================== */
    // Retorna o elemento que representa uma peca especifica, que sera desenhada na tela:
    public abstract char desenho();
    // Verifica se o movimento que o usuario deseja fazer eh adequado para uma peca especifica:
    public abstract boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino);
    

    /* ===========================================================================
     * ============================ METODOS ESPECIAIS ============================
     * =========================================================================== */
    // <<< Getters e Setters da classe Peca: >>>
    public String getCor() {
        return cor;
    }

    public boolean isCapturado() {
        return this.capturado;
    }
    
    public void setCapturado() {
        this.capturado = true;
    }
}
