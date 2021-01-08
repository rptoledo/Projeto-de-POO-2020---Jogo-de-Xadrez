/*
 * => Descricao da classe Tabuleiro:
 *          -> O tabuleiro consiste em um quadrado de 8 linhas por 8 colunas, totalizando 64 CASAS.
 *          -> As CASAS sao da cor branca, representadas por ' ' (espaco em branco), ou da cor preta,
 *              representadas por '*' (asterisco), alternando entre as duas cores.
 *          -> As CASAS (1, h) e (8, a) sao da cor branca e servem como referencia para a distribuicao de cores do tabuleiro.
 *
 * => Funcionalidades da classe Tabuleiro:
 *          -> Criar um tabuleiro de 8 linhas e 8 colunas, cujas CASAS alternam entre brancas e pretas.
 *          -> Verificar se o movimento pretendido eh possivel de ser realizado dentro dos limites do tabuleiro.
 *          -> Verificar se o caminho para o movimento pretendido esta livre (proxima fase).
 *          -> Saber onde cada Peca esta dentro do Tabuleiro (proxima fase).
 *          -> Desenhar o tabuleiro na tela, com as Pecas nas posicoes ocupadas (proxima fase).
 */

package projeto02;

/**
 * ==========================================================================
 *  Universidade Federal de Sao Carlos - Campus Sorocaba
 *  Disciplina: Programacao Orientada a Objetos
 *  Profa Katti Faceli
 *  
 *  PROJETO 02
 *  
 *  RA: 743590
 *  Autor: Rafael P Toledo
 * ==========================================================================.
 */

public class Tabuleiro
{

/* ===========================================================================
 * ================================ ATRIBUTOS ================================
 * =========================================================================== */
    public final Posicao[][] CASAS; // Usado para armazenar um objeto do tipo Tabuleiro.

    
/* ===========================================================================
 * ============================= METODOS NORMAIS =============================
 * =========================================================================== */
    // Imprime na tela o Tabuleiro sem nenhuma Peca:
    public void imprimeTabuleiro()
    {
        System.out.print("\n");
        System.out.println("                      A     B     C     D     E     F     G     H     ");
        System.out.println("                   _________________________________________________  ");
        System.out.println("                   |     |     |     |     |     |     |     |     |  ");
        System.out.println("                 8 |  " + checaOcupacao(7, 0) + "  |  " + checaOcupacao(7, 1) + "  |  " + checaOcupacao(7, 2) + "  |  " + checaOcupacao(7, 3)
                + "  |  " + checaOcupacao(7, 4) + "  |  " + checaOcupacao(7, 5) + "  |  " + checaOcupacao(7, 6) + "  |  " + checaOcupacao(7, 7) + "  | 8");
        System.out.println("                   |_____|_____|_____|_____|_____|_____|_____|_____|  ");
        System.out.println("                   |     |     |     |     |     |     |     |     |  ");
        System.out.println("                 7 |  " + checaOcupacao(6, 0) + "  |  " + checaOcupacao(6, 1) + "  |  " + checaOcupacao(6, 2) + "  |  " + checaOcupacao(6, 3)
                + "  |  " + checaOcupacao(6, 4) + "  |  " + checaOcupacao(6, 5) + "  |  " + checaOcupacao(6, 6) + "  |  " + checaOcupacao(6, 7) + "  | 7");
        System.out.println("                   |_____|_____|_____|_____|_____|_____|_____|_____|  ");
        System.out.println("                   |     |     |     |     |     |     |     |     |  ");
        System.out.println("                 6 |  " + checaOcupacao(5, 0) + "  |  " + checaOcupacao(5, 1) + "  |  " + checaOcupacao(5, 2) + "  |  " + checaOcupacao(5, 3)
                + "  |  " + checaOcupacao(5, 4) + "  |  " + checaOcupacao(5, 5) + "  |  " + checaOcupacao(5, 6) + "  |  " + checaOcupacao(5, 7) + "  | 6");
        System.out.println("                   |_____|_____|_____|_____|_____|_____|_____|_____|  ");
        System.out.println("                   |     |     |     |     |     |     |     |     |  ");
        System.out.println("                 5 |  " + checaOcupacao(4, 0) + "  |  " + checaOcupacao(4, 1) + "  |  " + checaOcupacao(4, 2) + "  |  " + checaOcupacao(4, 3)
                + "  |  " + checaOcupacao(4, 4) + "  |  " + checaOcupacao(4, 5) + "  |  " + checaOcupacao(4, 6) + "  |  " + checaOcupacao(4, 7) + "  | 5");
        System.out.println("                   |_____|_____|_____|_____|_____|_____|_____|_____|  ");
        System.out.println("                   |     |     |     |     |     |     |     |     |  ");
        System.out.println("                 4 |  " + checaOcupacao(3, 0) + "  |  " + checaOcupacao(3, 1) + "  |  " + checaOcupacao(3, 2) + "  |  " + checaOcupacao(3, 3)
                + "  |  " + checaOcupacao(3, 4) + "  |  " + checaOcupacao(3, 5) + "  |  " + checaOcupacao(3, 6) + "  |  " + checaOcupacao(3, 7) + "  | 4");
        System.out.println("                   |_____|_____|_____|_____|_____|_____|_____|_____|  ");
        System.out.println("                   |     |     |     |     |     |     |     |     |  ");
        System.out.println("                 3 |  " + checaOcupacao(2, 0) + "  |  " + checaOcupacao(2, 1) + "  |  " + checaOcupacao(2, 2) + "  |  " + checaOcupacao(2, 3)
                + "  |  " + checaOcupacao(2, 4) + "  |  " + checaOcupacao(2, 5) + "  |  " + checaOcupacao(2, 6) + "  |  " + checaOcupacao(2, 7) + "  | 3");
        System.out.println("                   |_____|_____|_____|_____|_____|_____|_____|_____|  ");
        System.out.println("                   |     |     |     |     |     |     |     |     |  ");
        System.out.println("                 2 |  " + checaOcupacao(1, 0) + "  |  " + checaOcupacao(1, 1) + "  |  " + checaOcupacao(1, 2) + "  |  " + checaOcupacao(1, 3)
                + "  |  " + checaOcupacao(1, 4) + "  |  " + checaOcupacao(1, 5) + "  |  " + checaOcupacao(1, 6) + "  |  " + checaOcupacao(1, 7) + "  | 2");
        System.out.println("                   |_____|_____|_____|_____|_____|_____|_____|_____|  ");
        System.out.println("                   |     |     |     |     |     |     |     |     |  ");
        System.out.println("                 1 |  " + checaOcupacao(0, 0) + "  |  " + checaOcupacao(0, 1) + "  |  " + checaOcupacao(0, 2) + "  |  " + checaOcupacao(0, 3)
                + "  |  " + checaOcupacao(0, 4) + "  |  " + checaOcupacao(0, 5) + "  |  " + checaOcupacao(0, 6) + "  |  " + checaOcupacao(0, 7) + "  | 1");
        System.out.println("                   |_____|_____|_____|_____|_____|_____|_____|_____|  ");
        System.out.println("                      A     B     C     D     E     F     G     H     ");
        System.out.print("\n");
    }
    
    /* -> Verifica se a casa esta ocupada por uma peca ou vazia.
       -> Retorna o simbolo da peca, se a casa estiver ocupada e a cor da casa, caso contrario.
       -> Esse metodo eh usado em imprimeTabuleiro() para definir o que sera impresso. */
    private char checaOcupacao(int lin, int col)
    {
        // Se a casa estiver vazia, retorno a cor da casa:
        if (CASAS[lin][col].getPecaPosicao() == null)
        {
            return CASAS[lin][col].getCORPOSICAO();
        }
        // Se a casa estiver ocupada, retorno o simbolo da peca que esta na casa:
        else
        {
            
            return CASAS[lin][col].getPecaPosicao().simbolo;
        }
    }

    /* -> Verifica se o movimento que o usuario deseja fazer esta dentro dos limites do tabuleiro.
       -> Retorna true, se estiver dentro dos limites e false, caso contrario. */
    private boolean checaTabuleiro(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino)
    {
        /* -> As linhas e colunas passadas pelo usuario que estao entre (1 e 8) e (a a h), respectivamente, estao dentro dos limites do tabuleiro.
           -> As linhas e colunas foram manipuladas, de modo a ficarem no intervalo de (0 a 7), caso estejam dentro do limite do tabuleiro. */
        if (linhaOrigem >= 0 && linhaOrigem <= 7 && colunaOrigem >= 0 && colunaOrigem <= 7 && linhaDestino >= 0 && linhaDestino <= 7 && colunaDestino >= 0 && colunaDestino <= 7)
        {
            return true;
        }

        return false;
    }

    /* Verifica se nao ha nenhuma peca entre a casa de origem e a casa de destino.
        Retorna true, se o caminho estiver livre e false, caso contrario. */
    private boolean caminhoLivre(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino)
    {
        // O atributo pecaMov eh a peca que o jogador esta tentando movimentar:
        Peca pecaMov = CASAS[linhaOrigem][colunaOrigem].getPecaPosicao();

        // Percorre todo o tabuleiro para fazer as verificacoes:
        for (int linMeio = 0; linMeio <= 7; linMeio++)
        {
            for (int colMeio = 0; colMeio <= 7; colMeio++)
            {
/* <<< Checagem do caminho para Peoes Brancos: >>> */
                if (pecaMov.simbolo == 'p')
                {
    /* [Mov. Norte] -> A linhaOrigem eh menor que as linhas da proximas 2 casas ao norte.
                    -> A colunaOrigem eh igual em todas as casas ate a casa da colunaDestino, inclusive.
                    -> Ao realizar o movimento pela VERTICAL, a coluna de uma casa eh igual a coluna de qualquer outra casa. */
                    if (linhaOrigem < linMeio && linMeio < linhaDestino // linhaOrigem < linMeio < linhaDestino
                        && colunaOrigem == colMeio && colMeio == colunaDestino) // colunaOrigem = colMeio = colunaDestino.
                    {
                        // Verifica se ha alguma peca no caminho:
                        if (CASAS[linMeio][colMeio].getPecaPosicao() != null)
                        {
                            return false;
                        }
                    }
                }

/* <<< Checagem do caminho para Peoes Pretos: >>> */
                if (pecaMov.simbolo == 'P')
                {
    /* [Mov. Sul] -> A linhaOrigem eh maior que as linhas da proximas 2 casas ao sul.
                  -> A colunaOrigem eh igual em todas as casas ate a casa da colunaDestino, inclusive.
                  -> Ao realizar o movimento pela VERTICAL, a coluna de uma casa eh igual a coluna de qualquer outra casa. */
                    if (linhaDestino < linMeio && linMeio < linhaOrigem // linhaDestino < linMeio < linhaOrigem
                        && colunaOrigem == colMeio && colMeio == colunaDestino) // colunaOrigem = colMeio = colunaDestino.
                    {
                        // Verifica se ha alguma peca no caminho:
                        if (CASAS[linMeio][colMeio].getPecaPosicao() != null)
                        {
                            return false;
                        }
                    }
                }

/* <<< Checagem do caminho para Torres e Damas: >>> */
                if (pecaMov.simbolo == 't' || pecaMov.simbolo == 'T' || pecaMov.simbolo == 'd' || pecaMov.simbolo == 'D')
                {
    /* [Mov. Norte] -> A linhaOrigem eh menor que as linhas de todas as casas ate a casa da linhaDestino, inclusive.
                    -> A colunaOrigem eh igual em todas as casas ate a casa da colunaDestino, inclusive.
                    -> Ao realizar o movimento pela VERTICAL, a coluna de uma casa eh igual a coluna de qualquer outra casa. */
                    if (linhaOrigem < linMeio && linMeio < linhaDestino // linhaOrigem < linMeio < linhaDestino
                        && colunaOrigem == colMeio && colMeio == colunaDestino) // colunaOrigem = colMeio = colunaDestino.
                    {
                        // Verifica se ha alguma peca no caminho:
                        if (CASAS[linMeio][colMeio].getPecaPosicao() != null)
                        {
                            return false;
                        }
                    }

    /* [Mov. Sul] -> A linhaOrigem eh maior que as linhas de todas as casas ate a casa da linhaDestino, inclusive.
                  -> A colunaOrigem eh igual em todas as casas ate a casa da colunaDestino, inclusive.
                  -> Ao realizar o movimento pela VERTICAL, a coluna de uma casa eh igual a coluna de qualquer outra casa. */
                    if (linhaDestino < linMeio && linMeio < linhaOrigem // linhaDestino < linMeio < linhaOrigem
                        && colunaOrigem == colMeio && colMeio == colunaDestino) // colunaOrigem = colMeio = colunaDestino.
                    {
                        // Verifica se ha alguma peca no caminho:
                        if (CASAS[linMeio][colMeio].getPecaPosicao() != null)
                        {
                            return false;
                        }
                    }

    /* [Mov. Oeste] -> A linhaOrigem eh igual em todas as casas ate a casa da linhaDestino, inclusive.
                    -> A colunaOrigem eh maior que as colunas de todas as casas ate a casa da colunaDestino, inclusive.
                    -> Ao realizar o movimento pela HORIZONTAL, a linha de uma casa eh igual a linha de qualquer outra casa. */
                    if (linhaOrigem == linMeio && linMeio == linhaDestino // linhaOrigem = linMeio = linhaDestino
                        && colunaDestino < colMeio && colMeio < colunaOrigem) // colunaDestino < colMeio < colunaOrigem.
                    {
                        // Verifica se ha alguma peca no caminho:
                        if (CASAS[linMeio][colMeio].getPecaPosicao() != null)
                        {
                            return false;
                        }
                    }

    /* [Mov. Leste] -> A linhaOrigem eh igual em todas as casas ate a casa da linhaDestino, inclusive.
                    -> A colunaOrigem eh menor que as colunas de todas as casas ate a casa da colunaDestino, inclusive.
                    -> Ao realizar o movimento pela HORIZONTAL, a linha de uma casa eh igual a linha de qualquer outra casa. */
                    if (linhaOrigem == linMeio && linMeio == linhaDestino // linhaOrigem = linMeio = linhaDestino
                        && colunaOrigem < colMeio && colMeio < colunaDestino) // colunaOrigem < colMeio < colunaDestino.
                    {
                        // Verifica se ha alguma peca no caminho:
                        if (CASAS[linMeio][colMeio].getPecaPosicao() != null)
                        {
                            return false;
                        }
                    }
                }

/* <<< Checagem do caminho para Bispos e Damas: >>> */
                if (pecaMov.simbolo == 'b' || pecaMov.simbolo == 'B' || pecaMov.simbolo == 'd' || pecaMov.simbolo == 'D')
                {
    /* [Mov. Noroeste] -> A linhaOrigem eh menor que as linhas de todas as casas ate a casa da linhaDestino, inclusive.
                       -> A colunaOrigem eh maior que as colunas de todas as casas ate a casa da colunaDestino, inclusive.
                       -> Ao realizar o movimento pela DIAGONAL PRINCIPAL ou pelas diagonais paralelas a ela, a soma das linhas
                         e colunas de uma casa eh igual a soma das linhas e colunas de qualquer outra casa. */
                    if (linhaOrigem < linMeio && linMeio < linhaDestino // linhaOrigem < linMeio < linhaDestino
                        && colunaDestino < colMeio && colMeio < colunaOrigem // colunaDestino < colMeio < colunaOrigem.
                        && (linhaOrigem + colunaOrigem) == (linMeio + colMeio)) // Apenas a diagonal do movimento sera checada.
                    {
                        // Verifica se ha alguma peca no caminho:
                        if (CASAS[linMeio][colMeio].getPecaPosicao() != null)
                        {
                            return false;
                        }
                    }

    /* [Mov. Sudeste] -> A linhaOrigem eh maior que as linhas de todas as casas ate a casa da linhaDestino, inclusive.
                      -> A colunaOrigem eh menor que as colunas de todas as casas ate a casa da colunaDestino, inclusive.
                      -> Ao realizar o movimento pela DIAGONAL PRINCIPAL ou pelas diagonais paralelas a ela, a soma das linhas
                        e colunas de uma casa eh igual a soma das linhas e colunas de qualquer outra casa. */
                    if (linhaDestino < linMeio && linMeio < linhaOrigem // linhaDestino < linMeio < linhaOrigem
                        && colunaOrigem < colMeio && colMeio < colunaDestino // colunaOrigem < colMeio < colunaDestino.
                        && (linhaOrigem + colunaOrigem) == (linMeio + colMeio)) // Apenas a diagonal do movimento sera checada.
                    {
                        // Verifica se ha alguma peca no caminho:
                        if (CASAS[linMeio][colMeio].getPecaPosicao() != null)
                        {
                            return false;
                        }
                    }

    /* [Mov. Nordeste] -> A linhaOrigem eh menor que as linhas de todas as casas ate a casa da linhaDestino, inclusive.
                       -> A colunaOrigem eh menor que as colunas de todas as casas ate a casa da colunaDestino, inclusive.
                       -> Ao realizar o movimento pela DIAGONAL SECUNDARIA ou pelas diagonais paralelas a ela, as subtracoes
                         entre linhaOrigem e linMeio e entre colunaOrigem e colMeio sao equivalentes. */
                    if (linhaOrigem < linMeio && linMeio < linhaDestino // linhaOrigem < linMeio < linhaDestino
                        && colunaOrigem < colMeio && colMeio < colunaDestino // colunaOrigem < colMeio < colunaDestino.
                        && (linhaOrigem - linMeio) == (colunaOrigem - colMeio)) // Apenas a diagonal do movimento sera checada.
                    {
                        // Verifica se ha alguma peca no caminho:
                        if (CASAS[linMeio][colMeio].getPecaPosicao() != null)
                        {
                            return false;
                        }
                    }

    /* [Mov. Sudoeste] -> A linhaOrigem eh maior que as linhas de todas as casas ate a casa da linhaDestino, inclusive.
                       -> A colunaOrigem eh maior que as colunas de todas as casas ate a casa da colunaDestino, inclusive.
                       -> Ao realizar o movimento pela DIAGONAL SECUNDARIA ou pelas diagonais paralelas a ela, as subtracoes
                       entre linhaOrigem e linMeio e entre colunaOrigem e colMeio sao equivalentes. */
                    if (linhaDestino < linMeio && linMeio < linhaOrigem // linhaDestino < linMeio < linhaOrigem
                            && colunaDestino < colMeio && colMeio < colunaOrigem // colunaDestino < colMeio < colunaOrigem.
                            && (linhaOrigem - linMeio) == (colunaOrigem - colMeio)) // Apenas a diagonal do movimento sera checada.
                    {
                        // Verifica se ha alguma peca no caminho:
                        if (CASAS[linMeio][colMeio].getPecaPosicao() != null)
                        {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
    
    /* -> Registra quando um peao realiza o seu primeiro movimento.
       -> O atributo primeiroMov, de um peao que fez seu primeiro movimento, eh mudado para false. */
    private void moveuPeao(int lin, int col)
    {
        int simbolo = CASAS[lin][col].getPecaPosicao().desenho();

        // Se o deseho do simbolo for 'p' ou 'P', significa que eh um peao:
        if (simbolo == 'p' || simbolo == 'P')
        {
            // Downcast da classe Peca para a classe Peao, de modo que seja possivel acessar o metodo setPrimeiroMov(), da classe Peao:
            Peao peaoGenerico = (Peao) CASAS[lin][col].getPecaPosicao();
            peaoGenerico.setPrimeiroMov();
        }
    }

    /* Realiza todas as checagens relacionadas ao tabuleiro.
        Retorna true, se o movimento puder ser realizado, ou false, caso contrário. */
    public void checaTudo(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino, int vez)
    {
        Peca pecaOrigem = CASAS[linhaOrigem][colunaOrigem].getPecaPosicao();
        Peca pecaDestino = CASAS[linhaDestino][colunaDestino].getPecaPosicao();
        
        // O movimento que o usuario deseja fazer esta fora dos limites do tabuleiro:
        if (checaTabuleiro(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino) == false)
        {
            throw new Error("O movimento pretendido esta fora dos limites do tabuleiro!\n");
        }
        // Nao ha nenhuma peca na casa de origem:
        else if (pecaOrigem == null)
        {
            throw new Error("Voce nao possui peca para mover, na posicao que digitou!\n");
        }
        // Ha uma peca na casa de origem, mas ela eh do adversario:
        else if ((vez == 0 && pecaOrigem.getCor().equals("prt")) || (vez == 1 && pecaOrigem.getCor().equals("brc")))
        {
            throw new Error("A peca que voce esta tentando mover eh do seu adversario!\n");
        }
        // O jogador tem uma peca sua na casa de origem, mas esta tentando capturar sua propria peca:
        else if (pecaDestino != null && ((vez == 0 && pecaDestino.getCor().equals("brc")) || (vez == 1 && pecaDestino.getCor().equals("prt")))) {
            throw new Error("A peca que voce esta tentando capturar eh sua!\n");
        }
        // A casa de origem eh a mesma que a casa de destino, nesse caso, nao ha movimento:
        else if (linhaOrigem == linhaDestino && colunaOrigem == colunaDestino)
        {
            throw new Error("Voce nao esta realizando um movimento!\n");
        }
        
        
        // FALTA PENSAR A RESPEITO
        else if (pecaOrigem.desenho() == 'p' || pecaOrigem.desenho() == 'P' && pecaDestino == null)
        {    
            if (pecaOrigem.checaMovimento(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino) == false)
            {
                throw new Error("O movimento eh invalido para o tipo de peca selecionada!\n");
            }
        }
        else if (pecaOrigem.desenho() != 'p' && pecaOrigem.desenho() != 'P')
        {
            if (pecaOrigem.checaMovimento(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino) == false)
            {
                throw new Error("O movimento eh invalido para o tipo de peca selecionada!\n");
            }
        }
        
        
        // Ha pelo menos uma peca entre a casa de origem e a casa de destino, impedindo o movimento:
        else if (caminhoLivre(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino) == false)
        {
            throw new Error("Voce nao pode passar por cima das outras pecas!\n");
        }
        // O movimento da peca nao foi realizado:
        if (movimentaPeca(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino, false) == false)
        {
            throw new Error("O movimento eh invalido para o tipo de peca selecionada!\n");
        }
    }

    /* Realiza a movimentacao das pecas. Esse metodo so eh chamado se todos os metodos anteriores retorarem true.
        Retorna true, se o movimento tiver sido realizado, ou false, caso contrário. */
    private boolean movimentaPeca(int linOrigem, int colOrigem, int linDestino, int colDestino, boolean check)
    {
        Peca pecaOrigem = CASAS[linOrigem][colOrigem].getPecaPosicao();
        Peca pecaDestino = CASAS[linDestino][colDestino].getPecaPosicao();

        // Se a casa de destino estiver ocupada por uma peca:
        if (pecaDestino != null)
        {
            // A captura da peca nao foi realizada:
            if (capturaPeca(linOrigem, colOrigem, linDestino, colDestino, check) == false)
            {
                return false;
            }
        }
        // A casa de destino esta vazia, na simulacao, logo o rei nao eh atingido:
        else if (pecaDestino == null && check == true)
        {
            return false;
        }
        
        // Como nao esta em xeque, os as acoes precisam ser permanentes:
        if (check == false)
        {
            // Ocupa a casa de destino com a peca da origem, passando PecaOrigem para o atributo pecaPosicao:
            CASAS[linDestino][colDestino].setPecaPosicao(pecaOrigem);
            // Deixa a casa de origem vazia, passando null para o atributo pecaPosicao:
            CASAS[linOrigem][colOrigem].setPecaPosicao(null);

            // Registra quando um peao realiza o seu primeiro movimento:
            moveuPeao(linDestino, colDestino);
        }
        
        return true;
    }
    
    /* Realiza a captura das pecas. Esse metodo so eh chamado dentro do metodo movimentaPeca().
        Retorna true, se a captura tiver sido realizada, ou false, caso contrário. */
    private boolean capturaPeca(int linOrigem, int colOrigem, int linDestino, int colDestino, boolean check)
    {
        Peca pecaOrigem = CASAS[linOrigem][colOrigem].getPecaPosicao();
        Peca pecaDestino = CASAS[linDestino][colDestino].getPecaPosicao();

        // Captura especifico para um Peao Branco:
        if (pecaOrigem.simbolo == 'p') {
            /* -> Como para os peoes brancos a captura deve ser feita apenas uma casa ao norte,
                 a linOrigem eh uma unidade menor que a linDestino.
               -> Como a captura deve ser feita apenas uma casa a oeste ou a leste, a colOrigem
                 eh uma unidade maior ou uma unidade menor que a colDestino.
                 Uso Math.abs(), para que tanto 1 quanto -1 sejam convertidos em 1. */
            // Esta fora da area de captura do Peao Branco:
            if (((linOrigem - linDestino) != -1) && (Math.abs(colOrigem - colDestino) != 1)) {
                return false;
            }
        } // Captura especifico para um Peao Preto:
        else if (pecaOrigem.simbolo == 'P') {
            /* -> Como para os peoes pretos a captura deve ser feita apenas uma casa ao sul,
                 a linOrigem eh uma unidade maior que a linDestino.
               -> Como a captura deve ser feita apenas uma casa a oeste ou a leste, a colOrigem
                 eh uma unidade menor ou uma unidade maior que a colDestino.
                 Uso Math.abs(), para que tanto -1 quanto 1 sejam convertidos em 1. */
            // Esta fora da area de captura do Peao Preto:
            if (((linOrigem - linDestino) != 1) && (Math.abs(colOrigem - colDestino) != 1)) {
                return false;
            }
        }

        // O atributo capturado da Peca do destino eh mudado pra true:
        if (check == false) {
            pecaDestino.setCapturado();
        }

        return true;
    }

    public boolean xeque(int vez)
    {
        int linRei = -1, colRei = -1;
        Peca meuRei = null;

        // Percorro todo o tabuleiro para encontrar o Rei Branco ou o Rei Preto:
        for (int lin = 0; lin <= 7; lin++) {
            for (int col = 0; col <= 7; col++) {
                if (vez == 0 && CASAS[lin][col].getPecaPosicao() != null && CASAS[lin][col].getPecaPosicao().desenho() == 'r') {
                    linRei = lin;
                    colRei = col;
                    meuRei = CASAS[linRei][colRei].getPecaPosicao();
                    break;

                } else if (vez == 1 && CASAS[lin][col].getPecaPosicao() != null && CASAS[lin][col].getPecaPosicao().desenho() == 'R') {
                    linRei = lin;
                    colRei = col;
                    meuRei = CASAS[linRei][colRei].getPecaPosicao();
                    break;
                }
            }
        }
        //Apenas porque o netbeans encheu o saco
        if (linRei == -1 && colRei == -1) {
            return false;
        }

        for (int lin = 0; lin <= 7; lin++) {
            for (int col = 0; col <= 7; col++) {

                if (CASAS[lin][col].getPecaPosicao() != null
                        //&& CASAS[lin][col].getPecaPosicao().desenho() != 'p' && CASAS[lin][col].getPecaPosicao().desenho() != 'P'
                        && meuRei != null && !meuRei.getCor().equals(CASAS[lin][col].getPecaPosicao().getCor())) {

                    if (CASAS[lin][col].getPecaPosicao().checaMovimento(lin, col, linRei, colRei) == true
                            && caminhoLivre(lin, col, linRei, colRei) == true) {
                        if (movimentaPeca(lin, col, linRei, colRei, true)) {
                            System.out.println("Teste " + lin + " " + col + " " + CASAS[lin][col].getPecaPosicao().desenho());
                            return true;
                        }
                    }

                }
            }
        }

        return false;
    }

    /* ===========================================================================
 * ============================ METODOS ESPECIAIS ============================
 * =========================================================================== */
    // <<< Construtor da classe Tabuleiro: >>>
    public Tabuleiro(Peca[] pecas) {
        this.CASAS = new Posicao[8][8];
        
        // Percorre todo o tabuleiro para inicia-lo com as pecas:
        for (int i = 0; i <= 7; i++)
        {
            for (int j = 0; j <= 7; j++)
            {
                if (((j + i) % 2) == 1) // Casas brancas (espaco em branco):
                {
                    this.CASAS[i][j] = new Posicao(i + 1, (char) (97 + j), ' ');
                }
                else if (((j + i) % 2) == 0) // Casas pretas (asterisco):
                {
                    this.CASAS[i][j] = new Posicao(i + 1, (char) (97 + j), '*');
                }
            }
        }

/*--> ADICIONA AS 32 PECAS AS SUAS RESPECTIVAS CASAS: <--*/
       
/*--> 16 Pecas Brancas (indices de 0 a 15): <--*/
    // 8 Peoes Brancos:
        for (int id = 0; id < 8; id++)
        {
            this.CASAS[1][id].setPecaPosicao(pecas[id]);
        }

    // Torre Branca (Esquerda):
        this.CASAS[0][0].setPecaPosicao(pecas[8]);
    // Torre Branca (Direita):
        this.CASAS[0][7].setPecaPosicao(pecas[9]);
    // Cavalo Branco (Esquerda):
        this.CASAS[0][1].setPecaPosicao(pecas[10]);
    // Cavalo Branco (Direita):
        this.CASAS[0][6].setPecaPosicao(pecas[11]);
    // Bispo Branco (Esquerda):
        this.CASAS[0][2].setPecaPosicao(pecas[12]);
    // Bispo Branco (Direita):
        this.CASAS[0][5].setPecaPosicao(pecas[13]);
    // Dama Branca:
        this.CASAS[0][3].setPecaPosicao(pecas[14]);
    // Rei Branco:
        this.CASAS[0][4].setPecaPosicao(pecas[15]);

/*--> 16 Pecas Pretas (indices de 16 a 31): <--*/
    // 8 Peoes Pretos:
        for (int id = 16; id < 24; id++)
        {
            // Faco (id - 16) pois a primeira posicao da matriz eh 0 e o id comeca em 16:
            this.CASAS[6][id - 16].setPecaPosicao(pecas[id]);
        }
        
        // Torre Preta (Esquerda):
        this.CASAS[7][0].setPecaPosicao(pecas[24]);
        // Torre Preta (Direita):
        this.CASAS[7][7].setPecaPosicao(pecas[31]);
        // Cavalo Preto (Esquerda):
        this.CASAS[7][1].setPecaPosicao(pecas[25]);
        // Cavalo Preto (Direita):
        this.CASAS[7][6].setPecaPosicao(pecas[30]);
        // Bispo Preto (Esquerda):
        this.CASAS[7][2].setPecaPosicao(pecas[26]);
        // Bispo Preto (Direita):
        this.CASAS[7][5].setPecaPosicao(pecas[29]);
        // Dama Preta:
        this.CASAS[7][3].setPecaPosicao(pecas[27]);
        // Rei Preto:
        this.CASAS[7][4].setPecaPosicao(pecas[28]);
    }

// <<< Getters e Setters da classe Peca: >>>
    public Posicao[][] getCASAS()
    {
        return CASAS;
    }
}
