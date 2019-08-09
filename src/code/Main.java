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
    ManipHtml html;
    EixoX eixoX;
    Scanner imput = new Scanner(System.in);

    final String[] nameFile = {"AreaChart", "LineChart", "PieChart"};

    List<EixoX> listaEixoX;
    List<String> listaEixoY;
    String title;
    String aux;
    int op;
    int cont;

    System.out.println("\nGerador de gráfico HTML");
    System.out.println("\n-- IMPROTANTE -- ");
    System.out.println("\nA quantidade de elementos no Eixo Y necessáriamente precisa ser igual no eixo X");
    while (true) {
      System.out.println("\n1- Area Chart");
      System.out.println("2- Line Chart");
      System.out.println("3- Pie Chart");
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

      listaEixoX = new ArrayList<>();
      listaEixoY = new ArrayList<>();
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
        eixoX = new EixoX();
        cont = 0;
        System.out.print("Título: ");
        eixoX.setNome(imput.nextLine());
        while (true) {
          System.out.print("Dado: ");
          aux = imput.nextLine();
          if (!aux.isEmpty()) {
            eixoX.setDado(Double.parseDouble(aux));
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
            cont = 0;
        } else
          break;
      }

      html = new ManipHtml();
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
