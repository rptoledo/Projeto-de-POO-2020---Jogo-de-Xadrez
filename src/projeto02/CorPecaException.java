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

public class CorPecaException extends Exception
{
    @Override
    public String getMessage()
    {
        return "O parametro para a cor da peca eh invalido!\n";
    }
}

