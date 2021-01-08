/*
 * => Descricao da classe Jogador:
 *          -> Cada Jogador possui um nome e tem um conjunto de Pecas da cor branca ou preta.
 *          -> O Jogador sabe quais das suas Pecas ainda estao ativas no Jogo (proxima fase).
 *          -> O Jogador que controla as Pecas brancas comeca.
 *
 * => Funcionalidades da classe Jogador:
 *          -> Verificar se o nome digitado pelo usuario eh valido.
 *          -> Retornar quais Pecas do Jogador ainda estao ativas no Jogo (proxima fase).
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

public class Jogador
{
/* ===========================================================================
 * ================================ ATRIBUTOS ================================
 * =========================================================================== */
    private final String NOME; // Usado para armazenar o nome do Jogador.
    private final String CORPECAS; // Usado para armazenar a cor das pecas do Jogador
    private final Peca [] PECASPOSSUIDAS; // Usado para armazenar as 16 pecas do Jogador.
    
    
/* ===========================================================================
 * ============================= METODOS NORMAIS =============================
 * =========================================================================== */
    // Verifica se o nome digitado pelo usuario eh valido:
    private boolean checaNome(String nomeTestado)
    {
        /* O jogador pode escolher qualquer nome que queira, inclusive usando numeros e espacos,
            a unica limitacao eh que esse nome tenha pelo menos um e, no maximo, vinte caracteres. */
        if (nomeTestado.length() > 0 && nomeTestado.length() <= 20)
        {
            return true;
        }
        
        else
        {
            return false;
        }
    }
    
    // Retorna para o Jogador quais das suas Pecas ainda estao ativas no Jogo (proxima fase):
    /* public void pecasAtivas()
    {
        
    } */
    
    
/* ===========================================================================
 * ============================ METODOS ESPECIAIS ============================
 * =========================================================================== */
    // <<< Construtor da classe Jogador: >>>
    public Jogador(String corPecas)
    {
        Scanner leNome = new Scanner(System.in);
        String nomeTestado;
        
        System.out.print("\nDigite o nome do jogador (maximo 20 caracteres): ");
        
        nomeTestado = leNome.nextLine();
        
        if (checaNome(nomeTestado) == false)
        {
            while (checaNome(nomeTestado) == false)
            {
                // PRECISO DE UM TRY CATCH AQUI.
                System.out.println("O nome digitado eh invalido!");
                break; // Sai do laco de repeticao.
            }
            /* Como nessa primeira fase nao vou ficar pedindo para o usuario digitar de novo, em caso de erro, apenas
             aponto o erro e atribuo os valores que recebi, mas futuramente, vai ficar no while ate corrigir o erro. */
        }
        
        this.NOME = nomeTestado;
        
        if (!corPecas.equals("brancas") && !corPecas.equals("pretas") )
        {
            while (corPecas.compareTo("brancas") != 0 && corPecas.compareTo("pretas") != 0)
            {
                // PRECISO DE UM TRY CATCH AQUI.
                System.out.println("O parametro para cor das pecas eh invalido!");
                break; // Sai do laco de repeticao.
            }
        }
        
        this.CORPECAS = corPecas;
        this.PECASPOSSUIDAS = new Peca[16];
        
        System.out.println("O jogador " + this.getNOME() + " foi criado com sucesso!");
        System.out.println(this.getNOME() + " vai jogar com as pecas " + this.CORPECAS + ".");
    }
     
    // <<< Getters e Setters da classe Jogador: >>>
    public String getNOME() {
        return NOME;
    }

    public String getCORPECAS() {
        return CORPECAS;
    }
}