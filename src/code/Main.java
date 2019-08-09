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

import manip_files.ManipHtml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author neo
 * @create 08/08/2019
 */
public class Main {
  public static void main(String[] args) throws IOException {
    ManipHtml html = new ManipHtml();
    EixoX eixoX = new EixoX();
    Scanner imput = new Scanner(System.in);

    final String[] nameFile = {"AreaChart", "LineChart", "PipeChart"};

    final List<EixoX> listaEixoX  = new ArrayList<EixoX>();
    final List<String> listaEixoY = new ArrayList<String>();
    String title = "";
    String aux   = "a";
    int op       = 0;
    int cont     = 0;

    System.out.println("\nGerador de gráfico HTML");
    System.out.println("\n-- IMPROTANTE -- ");
    System.out.println("\nA quantidade de elementos no Eixo Y necessáriamente precisa ser igual no eixo X");
    while (true) {
      System.out.println("\n1- Area Chart");
      System.out.println("2- Line Chart");
      System.out.println("3- Pipe Chart");
      System.out.println("0- Sair");
      System.out.print("Informe qual gráfico deseja gerar: ");
      op = imput.nextInt();
      while (op < 0 || op > 3) {
        System.out.print("ERRO!: Difite novamente: ");
        op = imput.nextInt();
      }
      if (op == 0) {
        System.out.println("Finalizando!!");
        return;
      }

      imput.nextLine();
      System.out.print("Título do Gráfico: ");
      title = imput.nextLine();
      System.out.println("\nInfromações sobre eixo Y\n");
      System.out.print("Título: ");
      listaEixoY.add(imput.nextLine());
      while (true) {
        System.out.print("Dado: ");
        aux = imput.nextLine();
        if (!aux.isEmpty() || !aux.isBlank())
          listaEixoY.add(aux);
        else
          break;
      }

      System.out.println("\nInfromações sobre eixo X\n");
      while (true) {
        System.out.print("Título: ");
        eixoX.setNome(imput.nextLine());
        while (true) {
          System.out.print("Dado: ");
          aux = imput.nextLine();
          if (!aux.isEmpty()) {
            eixoX.setDado(Double.valueOf(aux));
            cont++;
          } else
            if (cont >= listaEixoY.size() - 1) {
              listaEixoX.add(eixoX);
              break;
            } else
              System.out.printf("\nElementos no Eixo X < Eixo Y, informe mais %d elemento(s).\n", ((listaEixoY.size() - 1)- cont));
        }
        if (op != 3) {
          System.out.print("\nDeseja inserir mais dados? (Sim / Não): ");
          if (imput.nextLine().toLowerCase().charAt(0) == 'n')
            break;
          else
            eixoX = new EixoX();
        } else
          break;
      }

      switch (op) {
        case 1:
          html.grava(nameFile[op - 1], title, listaEixoY, listaEixoX);
          break;
        case 2:
          html.grava(nameFile[op - 1], title, listaEixoY, listaEixoX);
          break;
        case 3:
          html.grava(nameFile[op - 1], title, listaEixoY, listaEixoX);
          break;
      }
    }
  }
}
