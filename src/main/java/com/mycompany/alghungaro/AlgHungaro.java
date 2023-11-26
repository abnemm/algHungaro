package com.mycompany.alghungaro;

public class AlgHungaro {

    //Nomes das variaveis do problema
    static String eixoHorizontal = "Funcionario";
    static String eixoVertical = "Árvore";
    static String unidadeMedida = "Reais";

    //matrizes de facil acesso para teste
    public static double[][] matriz1 = new double[][]{ //matriz referente ao problema do trabalho
        {6.7, 5.0, 9.8, 2.0, 3.5},
        {3.0, 9.0, 8.4, 7.0, 9.7},
        {8.0, 5.6, 4.0, 6.0, 4.0},
        {4.0, 2.2, 5.6, 5.2, 6.0},
        {7.0, 3.0, 8.0, 4.7, 5.2}};

    public static double[][] matriz2 = new double[][]{ //matriz do exercicio 2 slide 8
        {1.0, 4.0, 6.0, 3.0},
        {9.0, 7.0, 10.0, 9.0},
        {4.0, 5.0, 11.0, 7.0},
        {8.0, 7.0, 8.0, 5.0}};

    public static double[][] matriz3 = new double[][]{ //matriz de exercicio da internet
        {192, 109, 198},
        {192, 107, 165},
        {134, 198, 181}};

    public static double[][] matriz4 = new double[][]{ //matriz exercicio 1 slide 8
        {15, 10, 9},
        {9, 15, 10},
        {10, 12, 8}};

    public static void main(String[] args) {

        //escolha da matriz utilizada 
        double[][] matrizOriginal = copiaMatriz(matriz1);
        double[][] matrizUtilizada = matriz1;

        //printa a matriz inicial
        System.out.println("MATRIZ iNICIAL");
        printaMatrizNumerica(matrizUtilizada);

        //fazendo a redução de linhas horizontalmente
        System.out.println("\n\nREDUZINDO LINHAS");
        double[][] matrizReduzida = reduzLinhas(matrizUtilizada);
        printaMatrizNumerica(matrizReduzida);

        //fazendo a redução de colunas verticalmente
        System.out.println("\n\nREDUZINDO COLUNAS");
        matrizReduzida = reduzColunas(matrizReduzida);
        printaMatrizNumerica(matrizReduzida);

        //verificando a quantidade de traços e colunas para encontrar a solução otima
        System.out.println("\n\nVERIFICANDO LINHAS X TRACOS\n");
        matrizReduzida = encontraTracos(matrizReduzida);
        printaMatrizNumerica(matrizReduzida);

        //encontrando o 0 inicial que esteja em uma sozinho na linha
        System.out.println("\n\nENCONTRANDO ZERO INICIAL");
        String[][] matrizString = encontraZeros(matrizReduzida);
        printaMatrizString(matrizString);

        //fazendo  adesignação das linhas certas do passo 6
        System.out.println("\n\nFAZENDO LINHAS");
        matrizString = terminaLinhasHorizontal(matrizReduzida, matrizString);
        printaMatrizString(matrizString);

        //fazendo  adesignação das colunas certas do passo 6
        System.out.println("\n\nFAZENDO COLUNAS");
        matrizString = terminaLinhasVertical(matrizReduzida, matrizString);
        printaMatrizNumerica(matrizReduzida);

        //mostrando na tela resultados finais
        System.out.println("\nMATRIZ APÓS AS MOVIMENTAÇÕES ");
        printaMatrizNumerica(matrizReduzida);
        System.out.println("\nMATRIZ DE PONTOS ÓTIMOS ");
        printaMatrizString(matrizString);
        System.out.println("\nMATRIZ ORIGINAL");
        printaMatrizNumerica(matrizOriginal);
        System.out.println(" ");
        retornaResultado(matrizOriginal, matrizString);

        //System.out.println("REDUZINDO COLUNAS");
    }

    public static double[][] reduzLinhas(double[][] matriz) {

        double[][] matrizReduzida = matriz;

        for (int i = 0; i < matriz.length; i++) {

            double menor = matriz[i][0];

            for (int j = 1; j < matriz[0].length; j++) {

                if (matriz[i][j] < menor) {
                    menor = matriz[i][j];
                }
            }
            for (int j = 0; j < matriz[0].length; j++) {
                matrizReduzida[i][j] = arredondarDouble(matriz[i][j] - menor);
            }
        }
        return matrizReduzida;
    }

    public static double[][] reduzColunas(double[][] matriz) {

        double[][] matrizReduzida = matriz;

        for (int i = 0; i < matriz[0].length; i++) {

            double menor = matriz[0][i];

            for (int j = 1; j < matriz.length; j++) {

                if (matriz[j][i] < menor) {
                    menor = matriz[j][i];
                }
            }
            for (int j = 0; j < matriz.length; j++) {
                matrizReduzida[j][i] = arredondarDouble(matriz[j][i] - menor);
            }
        }
        return matrizReduzida;
    }

    public static double[][] encontraTracos(double[][] matrizNum) {

        int qtdTracos = 0;
        int[] zerosPorLinhas = new int[matrizNum.length];
        int[] zerosPorColunas = new int[matrizNum.length];
        String[][] matrizResultado = new String[matrizNum.length][matrizNum[0].length];

        while (qtdTracos < matrizNum.length) {
            qtdTracos = 0;
            for (int i = 0; i < matrizResultado.length; i++) {
                for (int j = 0; j < matrizResultado.length; j++) {
                    matrizResultado[i][j] = "X";
                }
            }

            for (int i = 0; i < matrizNum.length; i++) {
                zerosPorLinhas[i] = 0;
                zerosPorColunas[i] = 0;
            }

            for (int i = 0; i < matrizNum.length; i++) {
                for (int j = 0; j < matrizNum[0].length; j++) {
                    if (matrizNum[i][j] == 0) {
                        zerosPorLinhas[i]++;
                        zerosPorColunas[j]++;
                    }
                }
            }

            int maiorLinhas = 0;
            for (int i = 0; i < zerosPorLinhas.length; i++) {
                if (zerosPorLinhas[i] > maiorLinhas) {
                    maiorLinhas = zerosPorLinhas[i];
                }
            }

            int maiorColunas = 0;
            for (int i = 0; i < zerosPorColunas.length; i++) {
                if (zerosPorColunas[i] > maiorColunas) {
                    maiorColunas = zerosPorColunas[i];
                }
            }

            for (int i = 0; i < matrizNum.length; i++) {
                if (zerosPorLinhas[i] == maiorLinhas) {
                    qtdTracos++;
                    for (int j = 0; j < matrizNum.length; j++) {
                        matrizResultado[i][j] = "-";
                    }
                }
            }

            for (int i = 0; i < matrizNum[0].length; i++) {
                for (int j = 0; j < matrizNum[0].length; j++) {
                    if (matrizNum[j][i] == 0) {
                        if ("X".equals(matrizResultado[j][i])) {
                            qtdTracos++;
                            for (int k = 0; k < matrizNum[0].length; k++) {
                                if ("-".equals(matrizResultado[k][i])) {
                                    matrizResultado[k][i] = "+";
                                } else {
                                    matrizResultado[k][i] = "|";
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(" ");
            printaMatrizString(matrizResultado);
            printaMatrizNumerica(matrizNum);
            if (qtdTracos != matrizNum.length) {
                matrizNum = formataMatriz(matrizNum, matrizResultado);
            }
        }
        printaMatrizString(matrizResultado);
        return matrizNum;
    }

    public static double[][] formataMatriz(double[][] matrizNum, String[][] matrizResultado) {

        double menorDescoberto = 999999999;
        for (int i = 0; i < matrizNum.length; i++) {
            for (int j = 0; j < matrizNum[0].length; j++) {
                if ("X".equals(matrizResultado[i][j])) {
                    if (matrizNum[i][j] < menorDescoberto) {
                        menorDescoberto = matrizNum[i][j];
                    }
                }
            }
        }

        for (int i = 0; i < matrizNum.length; i++) {
            for (int j = 0; j < matrizNum[0].length; j++) {
                if ("X".equals(matrizResultado[i][j])) {
                    matrizNum[i][j] = matrizNum[i][j] - menorDescoberto;
                }
                if ("+".equals(matrizResultado[i][j])) {
                    matrizNum[i][j] = matrizNum[i][j] + menorDescoberto;
                }
            }
        }
        return matrizNum;

    }

    public static String[][] encontraZeros(double[][] matriz) {

        int linha = -1, coluna = -1;
        String[][] matrizResultado = new String[matriz.length][matriz[0].length];

        for (int i = 0; i < matrizResultado.length; i++) {
            for (int j = 0; j < matrizResultado.length; j++) {
                matrizResultado[i][j] = "X";
            }
        }

        for (int i = 0; i < matriz.length; i++) {

            int contadorDeZeros = 0, ultimaLinha = 0, ultimaColuna = 0;

            for (int j = 0; j < matriz[0].length; j++) {

                if (matriz[i][j] == 0) {
                    contadorDeZeros++;
                    ultimaLinha = i;
                    ultimaColuna = j;
                }
            }
            if (contadorDeZeros == 1) {

                linha = ultimaLinha;
                coluna = ultimaColuna;
                break;

            }
        }

        if (coluna == -1 || linha == -1) {
            return matrizResultado;
        }

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[0].length; j++) {
                if (i == linha && j == coluna) {
                    matrizResultado[i][j] = "0";
                } else if (linha == i) {
                    matrizResultado[i][j] = "-";
                } else if (coluna == j) {
                    matrizResultado[i][j] = "|";
                }
            }

        }

        return matrizResultado;
    }

    public static String[][] terminaLinhasHorizontal(double[][] matrizNum, String[][] matrizString) {

        int linha = -1, coluna = -1;

        for (int i = 0; i < matrizNum.length; i++) {

            int contadorDeZeros = 0, ultimaLinha = 0, ultimaColuna = 0;

            for (int j = 0; j < matrizNum[0].length; j++) {

                if (matrizNum[i][j] == 0 && "X".equals(matrizString[i][j])) {
                    contadorDeZeros++;
                    ultimaLinha = i;
                    ultimaColuna = j;
                }
            }
            if (contadorDeZeros == 1) {

                linha = ultimaLinha;
                coluna = ultimaColuna;
                break;

            }
        }

        if (coluna == -1 || linha == -1) {
            return matrizString;
        }

        for (int i = 0; i < matrizNum.length; i++) {
            for (int j = 0; j < matrizNum[0].length; j++) {
                if (i == linha && j == coluna) {
                    matrizString[i][j] = "0";
                } else if (linha == i) {
                    if ("|".equals(matrizString[i][j])) {
                        matrizString[i][j] = "+";
                    } else {
                        matrizString[i][j] = "-";
                    }
                } else if (coluna == j) {
                    if ("-".equals(matrizString[i][j])) {
                        matrizString[i][j] = "+";
                    } else {
                        matrizString[i][j] = "|";
                    }
                }
            }
        }

        return terminaLinhasHorizontal(matrizNum, matrizString);

    }

    public static String[][] terminaLinhasVertical(double[][] matrizNum, String[][] matrizString) {

        int linha = -1, coluna = -1;

        for (int i = 0; i < matrizNum[0].length; i++) {

            int contadorDeZeros = 0, ultimaLinha = 0, ultimaColuna = 0;

            for (int j = 0; j < matrizNum.length; j++) {

                if (matrizNum[j][i] == 0 && "X".equals(matrizString[j][i])) {
                    contadorDeZeros++;
                    ultimaLinha = j;
                    ultimaColuna = i;
                }
            }
            if (contadorDeZeros == 1) {

                linha = ultimaLinha;
                coluna = ultimaColuna;
                break;

            }
        }

        if (coluna == -1 || linha == -1) {
            return matrizString;
        }

        for (int i = 0; i < matrizNum.length; i++) {
            for (int j = 0; j < matrizNum[0].length; j++) {
                if (i == linha && j == coluna) {
                    matrizString[i][j] = "0";
                } else if (linha == i) {
                    if ("|".equals(matrizString[i][j])) {
                        matrizString[i][j] = "+";
                    } else {
                        matrizString[i][j] = "-";
                    }
                } else if (coluna == j) {
                    if ("-".equals(matrizString[i][j])) {
                        matrizString[i][j] = "+";
                    } else {
                        matrizString[i][j] = "|";
                    }
                }
            }
        }
        return terminaLinhasVertical(matrizNum, matrizString);
    }

    public static double[][] resolvendoEntradasNaoRiscadas(double[][] matrizNum, String[][] matrizString) {

        double menor = -1;

        for (int i = 0; i < matrizString.length; i++) {
            for (int j = 0; j < matrizString[0].length; j++) {
                if ("X".equals(matrizString[i][j])) {
                    if (menor == -1) {
                        menor = matrizNum[i][j];
                    } else if (matrizNum[i][j] < menor) {
                        menor = matrizNum[i][j];
                    }
                }
            }
        }

        for (int i = 0; i < matrizString.length; i++) {
            for (int j = 0; j < matrizString[0].length; j++) {
                if ("X".equals(matrizString[i][j])) {
                    matrizNum[i][j] = matrizNum[i][j] - menor;
                }
                if ("+".equals(matrizString[i][j])) {
                    matrizNum[i][j] = matrizNum[i][j] + menor;
                }
            }
        }

        printaMatrizNumerica(matrizNum);
        System.out.println(" \n");
        printaMatrizString(matrizString);

        return matrizNum;
    }

    public static void retornaResultado(double[][] matrizNum, String[][] matrizString) {
        double valorTotal = 0;
        for (int i = 0; i < matrizString.length; i++) {
            for (int j = 0; j < matrizString[0].length; j++) {
                if ("0".equals(matrizString[i][j])) {
                    System.out.println(eixoHorizontal + " " + (i) + " cortará a " + eixoVertical + " " + (j) + " custando R$:" + matrizNum[i][j] + " " + unidadeMedida);
                    valorTotal = valorTotal + matrizNum[i][j];
                }
            }
        }
        System.out.println("O custo total dos " + eixoHorizontal + "s será de R$: " + valorTotal);
    }

    public static double[][] copiaMatriz(double[][] matrizOriginal) {

        double[][] matrizNova = new double[matrizOriginal.length][matrizOriginal[0].length];

        for (int i = 0; i < matrizOriginal.length; i++) {
            for (int j = 0; j < matrizOriginal[0].length; j++) {
                matrizNova[i][j] = matrizOriginal[i][j];
            }
        }

        return matrizNova;
    }

    public static void printaMatrizNumerica(double[][] matriz) {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "  ");
            }
            System.out.println(" "); //muda de linha
        }

    }

    public static void printaMatrizString(String[][] matriz) {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "  ");
            }
            System.out.println(" "); //muda de linha
        }

    }

    private static double arredondarDouble(double numero) {
        return Math.round(numero * 100.0) / 100.0;
    }
}
