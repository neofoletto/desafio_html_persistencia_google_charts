/*
 *                     GNU GENERAL PUBLIC LICENSE
 *                        Version 3, 29 June 2007
 *
 *  Copyright (C) 2007 Free Software Foundation, Inc. <https://fsf.org/>
 *  Everyone is permitted to copy and distribute verbatim copies
 *  of this license document, but changing it is not allowed.
 *
 *                             Preamble
 *
 *   The GNU General Public License is a free, copyleft license for
 * software and other kinds of works.
 */

package code;

import manip_html.ManipHtml;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author neo
 * @create 08/08/2019
 */
public class Main {
  public static void main(String[] args) throws IOException {
    ManipHtml html = new ManipHtml();
    Scanner imput = new Scanner(System.in);

    final String[] nameFile = {"AreaChart", "LineChart", "PipeChart"};

    int op = 0;

    System.out.println("\nGerador de gráfico HTML\n");
    System.out.println("1- Area Chart");
    System.out.println("2- Line Chart");
    System.out.println("3- Pipe Chart");
    System.out.println("0- Sair");
    System.out.print("Informe qual gráfico deseja gerar: ");
    op = imput.nextInt();
    while (op < 0 || op > 3) {
      System.out.print("ERRO!: Difite novamente: ");
      op = imput.nextInt();
    }

    switch (op) {
      case 0:
        System.out.println("Finalizando!!");
        return;
      case 1:
        html.grava(nameFile[op - 1]);
        break;
      case 2:

        break;
      case 3:

        break;
    }
  }
}
