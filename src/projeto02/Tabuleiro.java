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

public class Tabuleiro
{
/* ===========================================================================
 * ================================ ATRIBUTOS ================================
 * =========================================================================== */
    public final Posicao [][] CASAS; // Usado para armazenar um objeto do tipo Tabuleiro.
    
    
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
    
    // Verifica se a casa esta ocupada e retorna o simbolo da peca que esta nela, em caso positivo ou a cor da casa, em caso negativo:
    /* Vai ser usada na funcao imprimeTabuleiro(), para definir o que sera impresso. */
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
    
    // Verifica se o movimento que o usuario deseja fazer esta dentro dos limites do Tabuleiro:
    public boolean checaTabuleiro(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino)
    {
        // Se as linhas e colunas, passadas pelo usuario, estiverem, respectivamente entre (1 e 8) e (a a h), esta no tabuleiro:
        /* Realizei manipulacoes para que as linhas e colunas fossem convertidas de modo a ficarem no intervalo de (0 a 7), caso estejam dentro do limite do tabuleiro. */
        if (linhaOrigem >= 0 && linhaOrigem <= 7 && colunaOrigem >= 0 && colunaOrigem <= 7 && linhaDestino >= 0 && linhaDestino <= 7 && colunaDestino >= 0 && colunaDestino <= 7)
        {
            return true;
        }
        
        return false;
    }
    
    // Serve para checar se nao ha nenhuma peca que atrapalha a realizacao do movimento:
    private boolean caminhoLivre(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino)
    {
        // pecaMov eh a peca que o jogador esta tentando movimentar:
        Peca pecaMov = CASAS[linhaOrigem][colunaOrigem].getPecaPosicao();
        
        // Percorro todo o tabuleiro para fazer as verificacoes:
        for (int linDest = 0; linDest <= 7; linDest++)
        {
            for (int colDest = 0; colDest <= 7; colDest++)
            {
/* <<< Checagem do caminho para Peoes Brancos: >>> */
                if (pecaMov.simbolo == 'p')
                {
    /* [Mov. Norte] -> A linhaOrigem eh menor que as linhas da proximas 2 casas ao norte.
                    -> A colunaOrigem eh igual em todas as casas ate a casa da colunaDestino, inclusive.
                    -> Ao realizar o movimento pela VERTICAL, a coluna de uma casa eh igual a coluna de qualquer outra casa. */
                    if (linhaOrigem < linDest && linDest < linhaDestino // linhaOrigem < linDest < linhaDestino
                     && colunaOrigem == colDest && colDest == colunaDestino) // colunaOrigem = colDest = colunaDestino.
                    {
                        // Verifica se ha alguma peca no caminho:
                        if (CASAS[linDest][colDest].getPecaPosicao() != null)
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
                    if (linhaDestino < linDest && linDest < linhaOrigem // linhaDestino < linDest < linhaOrigem
                     && colunaOrigem == colDest && colDest == colunaDestino) // colunaOrigem = colDest = colunaDestino.
                    {
                        // Verifica se ha alguma peca no caminho:
                        if (CASAS[linDest][colDest].getPecaPosicao() != null)
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
                    if (linhaOrigem < linDest && linDest < linhaDestino // linhaOrigem < linDest < linhaDestino
                     && colunaOrigem == colDest && colDest == colunaDestino) // colunaOrigem = colDest = colunaDestino.
                    {
                        // Verifica se ha alguma peca no caminho:
                        if (CASAS[linDest][colDest].getPecaPosicao() != null)
                        {
                            return false;
                        }
                    }
                    
    /* [Mov. Sul] -> A linhaOrigem eh maior que as linhas de todas as casas ate a casa da linhaDestino, inclusive.
                  -> A colunaOrigem eh igual em todas as casas ate a casa da colunaDestino, inclusive.
                  -> Ao realizar o movimento pela VERTICAL, a coluna de uma casa eh igual a coluna de qualquer outra casa. */
                    if (linhaDestino < linDest && linDest < linhaOrigem // linhaDestino < linDest < linhaOrigem
                     && colunaOrigem == colDest && colDest == colunaDestino) // colunaOrigem = colDest = colunaDestino.
                    {
                        // Verifica se ha alguma peca no caminho:
                        if (CASAS[linDest][colDest].getPecaPosicao() != null)
                        {
                            return false;
                        }
                    }
                    
    /* [Mov. Oeste] -> A linhaOrigem eh igual em todas as casas ate a casa da linhaDestino, inclusive.
                    -> A colunaOrigem eh maior que as colunas de todas as casas ate a casa da colunaDestino, inclusive.
                    -> Ao realizar o movimento pela HORIZONTAL, a linha de uma casa eh igual a linha de qualquer outra casa. */
                    if (linhaOrigem == linDest && linDest == linhaDestino // linhaOrigem = linDest = linhaDestino
                     && colunaDestino < colDest && colDest < colunaOrigem) // colunaDestino < colDest < colunaOrigem.
                    {
                        // Verifica se ha alguma peca no caminho:
                        if (CASAS[linDest][colDest].getPecaPosicao() != null)
                        {
                            return false;
                        }
                    }
                    
    /* [Mov. Leste] -> A linhaOrigem eh igual em todas as casas ate a casa da linhaDestino, inclusive.
                    -> A colunaOrigem eh menor que as colunas de todas as casas ate a casa da colunaDestino, inclusive.
                    -> Ao realizar o movimento pela HORIZONTAL, a linha de uma casa eh igual a linha de qualquer outra casa. */
                    if (linhaOrigem == linDest && linDest == linhaDestino // linhaOrigem = linDest = linhaDestino
                     && colunaOrigem < colDest && colDest < colunaDestino) // colunaOrigem < colDest < colunaDestino.
                    {
                        // Verifica se ha alguma peca no caminho:
                        if (CASAS[linDest][colDest].getPecaPosicao() != null)
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
                    if (linhaOrigem < linDest && linDest < linhaDestino // linhaOrigem < linDest < linhaDestino
                     && colunaDestino < colDest && colDest < colunaOrigem // colunaDestino < colDest < colunaOrigem.
                     && (linhaOrigem + colunaOrigem) == (linDest + colDest) ) // Apenas a diagonal do movimento sera checada.
                    {
                        // Verifica se ha alguma peca no caminho:
                        if (CASAS[linDest][colDest].getPecaPosicao() != null)
                        {
                            return false;
                        }
                    }
                    
    /* [Mov. Sudeste] -> A linhaOrigem eh maior que as linhas de todas as casas ate a casa da linhaDestino, inclusive.
                      -> A colunaOrigem eh menor que as colunas de todas as casas ate a casa da colunaDestino, inclusive.
                      -> Ao realizar o movimento pela DIAGONAL PRINCIPAL ou pelas diagonais paralelas a ela, a soma das linhas
                        e colunas de uma casa eh igual a soma das linhas e colunas de qualquer outra casa. */
                    if (linhaDestino < linDest && linDest < linhaOrigem // linhaDestino < linDest < linhaOrigem
                     && colunaOrigem < colDest && colDest < colunaDestino // colunaOrigem < colDest < colunaDestino.
                     && (linhaOrigem + colunaOrigem) == (linDest + colDest) ) // Apenas a diagonal do movimento sera checada.
                    {
                        // Verifica se ha alguma peca no caminho:
                        if (CASAS[linDest][colDest].getPecaPosicao() != null)
                        {
                            return false;
                        }
                    }
                    
    /* [Mov. Nordeste] -> A linhaOrigem eh menor que as linhas de todas as casas ate a casa da linhaDestino, inclusive.
                       -> A colunaOrigem eh menor que as colunas de todas as casas ate a casa da colunaDestino, inclusive.
                       -> Ao realizar o movimento pela DIAGONAL SECUNDARIA ou pelas diagonais paralelas a ela, as subtracoes
                         entre linhaOrigem e linDest e entre colunaOrigem e colDest sao equivalentes. */
                    if (linhaOrigem < linDest && linDest < linhaDestino // linhaOrigem < linDest < linhaDestino
                     && colunaOrigem < colDest && colDest < colunaDestino // colunaOrigem < colDest < colunaDestino.
                     && (linhaOrigem - linDest) == (colunaOrigem - colDest) ) // Apenas a diagonal do movimento sera checada.
                    {
                        // Verifica se ha alguma peca no caminho:
                        if (CASAS[linDest][colDest].getPecaPosicao() != null)
                        {
                            return false;
                        }
                    }
                    
    /* [Mov. Sudoeste] -> A linhaOrigem eh maior que as linhas de todas as casas ate a casa da linhaDestino, inclusive.
                       -> A colunaOrigem eh maior que as colunas de todas as casas ate a casa da colunaDestino, inclusive.
                       -> Ao realizar o movimento pela DIAGONAL SECUNDARIA ou pelas diagonais paralelas a ela, as subtracoes
                         entre linhaOrigem e linDest e entre colunaOrigem e colDest sao equivalentes. */
                    if (linhaDestino < linDest && linDest < linhaOrigem // linhaDestino < linDest < linhaOrigem
                     && colunaDestino < colDest && colDest < colunaOrigem // colunaDestino < colDest < colunaOrigem.
                     && (linhaOrigem - linDest) == (colunaOrigem - colDest) ) // Apenas a diagonal do movimento sera checada.
                    {
                        // Verifica se ha alguma peca no caminho:
                        if (CASAS[linDest][colDest].getPecaPosicao() != null)
                        {
                            return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
    
    // Realiza todas as checagens relacionadas ao tabuleiro e retorna true se o movimento puder ser realizado, ou false, caso contrário:
    public boolean checaTudo(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino)
    {
        // Verifico se a posicao de origem eh a mesma que a posicao de destino, se for, eh um movimento invalido:
        if (linhaOrigem == linhaDestino && colunaOrigem == colunaDestino)
        {
            return false;
        }
        // Verifico se o movimento eh valido para o tipo especifico de peca que esta sendo movimentada, se retornar false, eh um movimento invalido:
        else if (CASAS[linhaOrigem][colunaOrigem].getPecaPosicao().checaMovimento(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino) == false)
        {
            return false;
        }
        // Verifico se nao ha nenhuma peca que atrapalha a realizacao do movimento, se retornar false, eh um movimento invalido:
        else if (caminhoLivre(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino) == false)
        {
            return false;
        }
        
        // Se nenhuma das condicoes acima for desrespeitada, o movimento eh valido:
        return true;
    }
    
    // Realiza a movimentacao das pecas (esse metodo so eh chamado depois de todas as checagens retornarem positivamente):
    public boolean movimenta(Tabuleiro MESA, boolean jogoRetomado, int linOrigem, int colOrigem, Peca pecaOrigem, int linDestino, int colDestino, Peca pecaDestino)
    {
        // Se houver uma peca na posicao destino:
        if (pecaDestino != null)
        {
            // Se a captura nao foi realizada, retorna false:
            if (capturaPeca(MESA, linOrigem, colOrigem, pecaOrigem, linDestino, colDestino, pecaDestino) == false)
            {
                return false;
            }
        }

        // Ocupa a casa de destino com a Peca da origem (atributo pecaPosicao recebe pecaOrigem):
        MESA.CASAS[linDestino][colDestino].setPecaPosicao(pecaOrigem);
        // Deixa a casa de origem vazia (atributo pecaPosicao recebe null):
        MESA.CASAS[linOrigem][colOrigem].setPecaPosicao(null);

        // Registra quando um Peao realiza seu primeiro movimento:
        moveuPeao(MESA, linDestino, colDestino);

        // Se o jogo nao estiver sendo carregado, imprimo uma confirmacao da jogada e o tabuleiro:
        if (jogoRetomado == false)
        {
            System.out.println("Jogada realizada com sucesso!\n");
            imprimeTabuleiro();
        }
        
        return true;
    }
    
    // Realiza a captura de pecas, retornando true em caso de sucesso e false, caso contrário:
    public boolean capturaPeca(Tabuleiro MESA, int linOrigem, int colOrigem, Peca pecaOrigem, int linDestino, int colDestino, Peca pecaDestino)
    {
        // Captura de um Peao Branco:
        if (pecaOrigem.simbolo == 'p')
        {
            /* -> Como para os peoes brancos a captura deve ser feita apenas uma casa ao norte,
                 a linOrigem eh uma unidade menor que a linDestino.
               -> Como a captura deve ser feita apenas uma casa a oeste ou a leste, a colOrigem
                 eh uma unidade maior ou uma unidade menor que a colDestino.
                 Uso Math.abs(), para que tanto 1 quanto -1 sejam convertidos em 1. */
            // Esta fora da area de captura do Peao Branco:
            if ( ( (linOrigem - linDestino) != -1) && (Math.abs(colOrigem - colDestino) != 1) )
            {
                return false;
            }
        }
        // Captura de um Peao Preto:
        else if (pecaOrigem.simbolo == 'P')
        {
            /* -> Como para os peoes pretos a captura deve ser feita apenas uma casa ao sul,
                 a linOrigem eh uma unidade maior que a linDestino.
               -> Como a captura deve ser feita apenas uma casa a oeste ou a leste, a colOrigem
                 eh uma unidade menor ou uma unidade maior que a colDestino.
                 Uso Math.abs(), para que tanto -1 quanto 1 sejam convertidos em 1. */
            // Esta fora da area de captura do Peao Preto:
            if ( ( (linOrigem - linDestino) != 1) && (Math.abs(colOrigem - colDestino) != 1) )
            {
                return false;
            }
        }
        
        // O atributo capturado da Peca do destino eh mudado pra true:
        pecaDestino.setCapturado();

        return true;
    }
    
    // Registra quando um Peao realiza seu primeiro movimento, mudando o atributo primeiroMov para false:
    private void moveuPeao(Tabuleiro MESA, int lin, int col)
    {
        int simbolo = MESA.CASAS[lin][col].getPecaPosicao().desenho();

        // Se o deseho do simbolo for `p` ou `P`, significa que eh um peao:
        if (simbolo == 'p' || simbolo == 'P')
        {
            // Faco downcast de Peca para Peao, de modo que consigo acessar o metodo setPrimeiroMov(), da classe Peao:
            Peao peaoGenerico = (Peao) MESA.CASAS[lin][col].getPecaPosicao();
            peaoGenerico.setPrimeiroMov();
        }
    }
    
    
/* ===========================================================================
 * ============================ METODOS ESPECIAIS ============================
 * =========================================================================== */
    // <<< Construtor da classe Tabuleiro: >>>
    public Tabuleiro()
    {
        this.CASAS = new Posicao[8][8];
        
        for (int i = 0; i <= 7; i++)
        {
            for (int j = 0; j <= 7; j++)
            {
                if ( ( (j + i) % 2) == 1) // Casas brancas (espaco em branco):
                {
                    this.CASAS[i][j] = new Posicao(i + 1, (char) (97 + j), ' ');
                }
                else if ( ( (j + i) % 2) == 0) // Casas pretas (asterisco):
                {
                    this.CASAS[i][j] = new Posicao(i + 1, (char) (97 + j), '*');
                }
            }
        }
    }
    
// <<< Getters e Setters da classe Peca: >>>
    public Posicao[][] getCASAS() {
        return CASAS;
    }
}