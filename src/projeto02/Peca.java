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
    protected char simbolo; // Representa uma peca, sendo letra minuscula para pecas brancas e letra maiuscula para pecas pretas.
    protected String cor; // Representa a cor de uma peca, sendo "brc" para pecas brancas e "prt" para pecas pretas.
    protected boolean capturado; // Representa se uma peca foi capturada.
    
    
/* ===========================================================================
 * ============================= METODOS NORMAIS =============================
 * =========================================================================== */
    // Retorna o simbolo de uma peca.
    public abstract char desenho();
    /* -> Verifica se o movimento pode ser realizado por umz peca.
       -> Retorna true, se o movimento for adequedado e false, caso contrario. */
    public abstract boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino);
    

/* ===========================================================================
 * ============================ METODOS ESPECIAIS ============================
 * =========================================================================== */
// <<< Construtor da classe Peca: >>>
    public Peca(String cor) throws CorPecaException
    {
        if (!cor.equals("brc") && !cor.equals("prt"))
        {
            throw new CorPecaException();
        }
        
        this.cor = cor;
        this.capturado = false;
    }
        
// <<< Getters e Setters da classe Peca: >>>
    public String getCor()
    {
        return cor;
    }

    public boolean isCapturado()
    {
        return this.capturado;
    }
    
    public void setCapturado()
    {
        this.capturado = true;
    }
}
