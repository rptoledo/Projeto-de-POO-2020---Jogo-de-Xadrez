/*
 * => Descricao da classe Jogo:
 *          -> Jogo eh a classe responsavel pelo gerenciamento do jogo, controlando tudo o que acontece na partida de xadrez.
 *          -> A classe contem um tabuleiro, dois jogadores e o conjunto de 32 Pecas disponiveis (proxima fase).
 *          -> A classe Jogo sabe o estado em que se encontra a partida a cada momento, por exemplo: inicio do jogo, xeque e xeque-mate (proxima fase).
 *          -> Ela tambem sabe de qual jogador eh a vez.
 *
 * => Funcionalidades da classe Jogo:
 *          -> Alternar as jogadas entre os dois Jogadores.
 *          -> Verificar se o formato do movimento que o usuario inseriu esta correto.
 *          -> Controlar o estado em que se encontra a partida, por exemplo: inicio do jogo, xeque e xeque-mate (proxima fase).
 */

package projeto02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

public class Jogo
{
/* ===========================================================================
 * ================================ ATRIBUTOS ================================
 * =========================================================================== */
    private final Tabuleiro MESA; // Usado para criar uma mesa de jogo da classe Tabuleiro.
    private final Jogador JOGADOR1; // Usado para criar o primeiro Jogador.
    private final Jogador JOGADOR2; // Usado para criar o segundo Jogador.
    private final Peca[] PECAS; // Usado para armazenar todas as 32 pecas do Jogo.
    private String estado; // Atributo que define em que estado o jogo se encontra, podendo ser "inicio", "xeque" e "xeque-mate".
    private final ArrayList<String> JOGADASVALIDAS; // Serve para armazenar as jogadas validas que serao salvas no arquivo.


/* ===========================================================================
 * ============================= METODOS NORMAIS =============================
 * =========================================================================== */
    // Alterna as jogadas entre os dois Jogadores:
    public void alternaJogadas()
    {
        boolean jogoRetomado = false;
        int pretasEmXeque = 0;
        int brancasEmXeque = 0;
        // Carrega o jogo na variavel jogadasValidasAux:
        ArrayList<String> jogadasValidasAux = new ArrayList();

        char escolhaCont;

        do
        {
            escolhaCont = desejaContinuar();
            if (escolhaCont != 's' && escolhaCont != 'n')
            {
                System.out.println("A escolha eh invalida.");
            }
        } while (escolhaCont != 's' && escolhaCont != 'n');

        if (JOGADASVALIDAS.isEmpty() && escolhaCont == 's')
        {
            retomaJogo(jogadasValidasAux);
        }
        else
        {

            jogoRetomado = true;
            JOGADASVALIDAS.clear();

            System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------------");
            System.out.println("\t\t*****  Os limites do tabuleiro sao (1 a 8) para linhas e (a a h) para colunas.  *****");
            System.out.println("Todas as jogadas devem estar no formato '(linhaOrigem, colunaOrigem) -> (linhaDestino, colunaDestino)', usando espacos.");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------\n");

            this.MESA.imprimeTabuleiro();
        }

        for (int alt = 0; !this.estado.equals("xeque-mate"); alt++)
        {
            if (jogoRetomado == false)
            {
                if (this.MESA.xeque(alt % 2))
                {
                    if (alt % 2 == 0)
                    {
                        System.out.println("As peças brancas estão em xeque");
                        brancasEmXeque += 1;
                    }
                    else if (alt % 2 == 1)
                    {
                        System.out.println("As peças pretas estão em xeque");
                        pretasEmXeque += 1;
                    }
                }
                else if (!this.MESA.xeque(alt % 2))
                {
                    if (alt % 2 == 0)
                    {
                        brancasEmXeque = 0;
                        System.out.println("As peças brancas estão em xeque");
                    }
                    else if (alt % 2 == 1)
                    {
                        brancasEmXeque = 0;
                        System.out.println("As peças pretas estão em xeque");
                    }
                }

                // O ponto e virgula a esquerda do for significa que vou usar o alt para iniciar o for:
                for (; alt < jogadasValidasAux.size(); alt++)
                {
                    if (alt % 2 == 0 && recebeJogada(alt, jogadasValidasAux.get(alt), true) == false)
                    {
                        alt--;
                    }
                    else if (alt % 2 == 1 && recebeJogada(alt, jogadasValidasAux.get(alt), true) == false)
                    {
                        alt--;
                    }

                }

                jogoRetomado = true;

                System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------------");
                System.out.println("\t\t*****  Os limites do tabuleiro sao (1 a 8) para linhas e (a a h) para colunas.  *****");
                System.out.println("Todas as jogadas devem estar no formato '(linhaOrigem, colunaOrigem) -> (linhaDestino, colunaDestino)', usando espacos.");
                System.out.println("-----------------------------------------------------------------------------------------------------------------------\n");

                this.MESA.imprimeTabuleiro();
            }

            if (jogoRetomado == true)
            {
                if (this.MESA.xeque(alt % 2))
                {
                    if (alt % 2 == 0)
                    {
                        System.out.println("As peças brancas estão em xeque");
                        brancasEmXeque += 1;
                    }
                    else if (alt % 2 == 1)
                    {
                        System.out.println("As peças pretas estão em xeque");
                        pretasEmXeque += 1;
                    }
                }
                else if (!this.MESA.xeque(alt % 2))
                {
                    if (alt % 2 == 0)
                    {
                        brancasEmXeque = 0;
                    }
                    else if (alt % 2 == 1)
                    {
                        pretasEmXeque = 0;
                    }
                }

                System.out.println("Brancas: " + brancasEmXeque);
                System.out.println("Pretas: " + pretasEmXeque);

                // Rei preto for capturado, o branco ganha
                if (this.PECAS[28].isCapturado() == true)
                {
                    System.out.println("O jogador " + JOGADOR1.getNOME() + " das peças brancas ganhou!");
                    break;
                    // Rei branco for capturado, o preto ganha 
                }
                else if (this.PECAS[15].isCapturado() == true)
                {
                    System.out.println("O jogador " + JOGADOR2.getNOME() + " das peças pretas ganhou!");
                    break;
                }

                if (alt % 2 == 0 && recebeJogada(JOGADOR1, alt) == false)
                {
                    alt--;
                }
                else if (alt % 2 == 1 && recebeJogada(JOGADOR2, alt) == false)
                {
                    alt--;
                }

            }
        }
    }

    // Recebe a jogada do Jogador:
    private boolean recebeJogada(Jogador jogador, int alt)
    {
        String jogada;
        Scanner leJogada = new Scanner(System.in);

        // Imprime o numero da rodada e as pecas que ja foram capturadas:
        imprimeMenu(jogador, alt);

        System.out.println("\n" + jogador.getNOME() + ", digite sua jogada no formato '(X, X) -> (X, X)', usando espacos.");
        System.out.println("Insira na ordem linha de origem, coluna de origem, linha de destino e coluna de destino.");
        System.out.print("Caso deseje salvar o jogo, digite 'salvar', caso deseje sair do jogo, digite 'fechar': ");

        // Le a jogada do usuario:
        jogada = leJogada.nextLine();
        // Converte a jogada para letras minusculas:
        jogada = jogada.toLowerCase();

        return realizaJogada(jogada, alt, false);
    }

    // Sobrecarrego o recebeJogada, para retomar o jogo salvo:
    private boolean recebeJogada(int alt, String jogada, boolean impressaoJogoRetomado)
    {
        return realizaJogada(jogada, alt, impressaoJogoRetomado);
    }

    // Serve para realizar a jogada, caso ela seja valida, ou entao informar o erro:
    private boolean realizaJogada(String jogada, int alt, boolean jogoRetomado)
    {
        try
        {
            if (jogada.equals("salvar"))
            {
                this.salvaJogo();
                return false; // Serve para nao incrementar, quando salvar o jogo.
            } else if (jogada.equals("fechar"))
            {
                System.exit(0); // Termina o programa com sucesso (representado por 0).
            } // Esta no tamanho da formatacao correta:
            else if (checaFormato(jogada) == true)
            {
                // Converto os valores referentes as linhas e colunas que foram passadas:
                /* Faco (linha - 49) e typecast ((int) coluna - 97), para lidar com a matriz do tabuleiro.
                                    Desse modo, temos linhas de (0 a 7) e colunas de (0 a 7). */
                int linOrigem = jogada.charAt(1) - 49;
                int colOrigem = (int) (jogada.charAt(4) - 97);
                int linDestino = jogada.charAt(11) - 49;
                int colDestino = (int) (jogada.charAt(14) - 97);

                MESA.checaTudo(linOrigem, colOrigem, linDestino, colDestino, alt % 2);
                // Armazena as jogadas validas que serao salvas no arquivo:
                this.JOGADASVALIDAS.add(jogada);

                if (jogoRetomado == false)
                {
                    // Se o jogo nao estiver sendo carregado, imprimo uma confirmacao da jogada e o tabuleiro:
                    System.out.println("Jogada realizada com sucesso!\n");
                    MESA.imprimeTabuleiro();
                }

                // Nao esta no tamanho da formatacao correta:
                /* "(X, X) -> (X, X)", 16 caracteres no total. */
                // Esta no tamanho da formatacao correta, mas ao menos um caractere difere do formato esperado:
            }
            else
            {
                throw new Error("A formatacao da jogada esta incorreta!\n");
            }

            return true;
        }
        catch (Error e)
        {
            System.out.println(e.getMessage());

            return false;
        }
    }

    // Verifica se o formato do movimento que o usuario inseriu esta correto:
    private boolean checaFormato(String jogada)
    {
        /* Se a entrada estiver dentro do padrao "(X, X) -> (X, X)", com cada X representando apenas um
                    caractere referente as linhas e colunas de origem e destino do jogador, o formato eh valido.
                    A validade das linhas e colunas inseridas, eh verificada no metodo checaTabuleiro dedicado a isso. */
        if (jogada.length() == 16 && jogada.charAt(0) == '(' && jogada.charAt(2) == ',' && jogada.charAt(3) == ' ' && jogada.charAt(5) == ')'
          && jogada.charAt(6) == ' ' && jogada.charAt(7) == '-' && jogada.charAt(8) == '>' && jogada.charAt(9) == ' '
          && jogada.charAt(10) == '(' && jogada.charAt(12) == ',' && jogada.charAt(13) == ' ' && jogada.charAt(15) == ')')
        {
            return true;
        }

        return false;
    }

    // Imprime um menu com o numero da rodada e todas as pecas que ja foram capturadas:
    private void imprimeMenu(Jogador jogador, int alt)
    {
        // A funcao Math.floor arredonda as casas decimais para baixo.
        /* Somo 1 a alt para que a primeira jogada do JOGADOR1 seja contabilizada
            e somo 2 a alt para que a rodada inicial seja 1, ao inves de 0. */
        System.out.println("\nRodada: " + (int) Math.floor((alt + 2) / 2) + " (Aguardando " + jogador.getCORPECAS() + ")");

        // Imprime as pecas de cada jogador que ja foram capturadas:
        this.imprimeCapturadas(JOGADOR1);
        this.imprimeCapturadas(JOGADOR2);
    }

    // Imprime todas as pecas de um jogador especifico, que ja foram capturadas:
    private void imprimeCapturadas(Jogador jogador)
    {
        ArrayList<String> pecasCapturadas = new ArrayList();

        // Se o jogador que joga com as pecas brancas, n recebe 16, caso contrario, n recebe 32:
        int n = (jogador.getCORPECAS().equals("brancas")) ? 16 : 32;

        // Se o jogador que joga com as pecas brancas, i recebe 0, caso contrario, i recebe 16:
        for (int i = (jogador.getCORPECAS().equals("brancas")) ? 0 : 16; i < n; i++)
        {
            if (PECAS[i].isCapturado())
            {
                // Coloco "" + para converter o desenho da Peca de char para String:
                pecasCapturadas.add("" + PECAS[i].desenho());
            }
        }

        System.out.println("Pecas " + jogador.getCORPECAS() + " capturadas: " + pecasCapturadas);
    }

    // Serve para salvar o jogo:
    private void salvaJogo()
    {
        try
        {
            Scanner leNomeArquivo = new Scanner(System.in);

            System.out.print("\nDigite o nome do arquivo onde sera salvo o jogo: ");
            String nomeArquivo = leNomeArquivo.nextLine();

            FileWriter fw = new FileWriter(nomeArquivo + ".txt");
            PrintWriter pw = new PrintWriter(fw);
            System.out.println("O arquivo foi escrito com sucesso!\n");

            int n = this.JOGADASVALIDAS.size();
            for (int i = 0; i < n; i++)
            {
                pw.println(this.JOGADASVALIDAS.get(i));
            }
            pw.close();
        }
        catch (IOException ex)
        {
            System.out.println("\nOcorreu um erro ao tentar salvar o jogo no arquivo.");
        }
    }

    // Serve para retomar o jogo da onde ele foi parado:
    private void retomaJogo(ArrayList<String> jogadasValidasAux)
    {
        try
        {
            Scanner leNomeArquivo = new Scanner(System.in);

            System.out.print("\nDigite o nome do arquivo da onde o jogo sera carregado: ");
            String nomeArquivo = leNomeArquivo.nextLine();

            FileReader fr = new FileReader(nomeArquivo + ".txt");
            BufferedReader br = new BufferedReader(fr);

            String str;

            while ((str = br.readLine()) != null)
            {
                jogadasValidasAux.add(str);
            }

        }
        catch (FileNotFoundException e)
        {
            System.out.println("Arquivo nao encontrado, foi impossivel carregar o jogo.");
        }
        catch (IOException ex)
        {
            System.err.println("Ocorreu um erro, tente novamente!");
        }
    }

    private char desejaContinuar()
    {
        Scanner leEscolha = new Scanner(System.in);

        System.out.print("\n\nDeseja continuar um jogo salvo? Caso deseje, digite 'S', caso contrario, digite 'N': ");
        char escolha = leEscolha.next().charAt(0);

        // Converte a escolha para letras minusculas:
        escolha = Character.toLowerCase(escolha);

        return escolha;
    }

/* ===========================================================================
 * ============================ METODOS ESPECIAIS ============================
 * =========================================================================== */
// <<< Construtor da classe Jogo: >>>
    public Jogo() throws CorPecaException
    {
        // O jogo comeca no estado "inicio":
        this.estado = "inicio";

        // Cria o Primeiro Jogador, que controla as Pecas Brancas:
        this.JOGADOR1 = new Jogador("brancas");

        // Cria o Segundo Jogador, que controla as Pecas Pretas:
        this.JOGADOR2 = new Jogador("pretas");

    /*--> CRIA E AS 32 PECAS: <--*/
        this.PECAS = new Peca[32];

        try
        {
    /*--> 16 Pecas Brancas (indices de 0 a 15): <--*/
        // 8 Peoes Brancos:
            for (int id = 0; id < 8; id++)
            {
                this.PECAS[id] = new Peao("brc");
            }

        // Torre Branca (Esquerda):
            this.PECAS[8] = new Torre("brc");
        // Torre Branca (Direita):
            this.PECAS[9] = new Torre("brc");
        // Cavalo Branco (Esquerda):
            this.PECAS[10] = new Cavalo("brc");
        // Cavalo Branco (Direita):
            this.PECAS[11] = new Cavalo("brc");
        // Bispo Branco (Esquerda):
            this.PECAS[12] = new Bispo("brc");
        // Bispo Branco (Direita):
            this.PECAS[13] = new Bispo("brc");
        // Dama Branca:
            this.PECAS[14] = new Dama("brc");
        // Rei Branco:
            this.PECAS[15] = new Rei("brc");

    /*--> 16 Pecas Pretas (indices de 16 a 31): <--*/
        // 8 Peoes Pretos:
            for (int id = 16; id < 24; id++)
            {
                this.PECAS[id] = new Peao("prt");
            }

        // Torre Preta (Esquerda):
            this.PECAS[24] = new Torre("prt");
        // Torre Preta (Direita):
            this.PECAS[31] = new Torre("prt");
        // Cavalo Preto (Esquerda):
            this.PECAS[25] = new Cavalo("prt");
        // Cavalo Preto (Direita):
            this.PECAS[30] = new Cavalo("prt");
        // Bispo Preto (Esquerda):
            this.PECAS[26] = new Bispo("prt");
        // Bispo Preto (Direita):
            this.PECAS[29] = new Bispo("prt");
        // Dama Preta:
            this.PECAS[27] = new Dama("prt");
        // Rei Preto:
            this.PECAS[28] = new Rei("prt");
        }
        catch (CorPecaException e)
        {
            System.out.println("O parametro para a cor da peca eh invalido!\n");
        }
        
        // Cria o Tabuleiro:
        this.MESA = new Tabuleiro(PECAS);
        // Cria um objeto do tipo ArrayList para armazenar os movimentos validos:
        this.JOGADASVALIDAS = new ArrayList();
    }

// <<< Getters e Setters da classe Jogo: >>>
    public String getEstado()
    {
        return estado;
    }

    public void setEstado(String estado)
    {
        this.estado = estado;
    }
}
