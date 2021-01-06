/*
 * => Descricao da classe Gerenciador:
 *          -> O 
 *          -> U
 *
 * => Funcionalidades da classe Gerenciador:
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

import java.io.IOException;

public class Gerenciador
{
    public static void main(String[] args)
    {
        System.out.println("\n ====================================================================================== "
         + "\n ======================== PROJETO DE POO 2020 - JOGO DE XADREZ ======================== "
         + "\n ====================================================================================== ");
        
        Jogo game = new Jogo();
        
        game.alternaJogadas();
    }
}
