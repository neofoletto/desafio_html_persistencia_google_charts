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

import java.util.ArrayList;
import java.util.List;

/**
 * @author neo
 * @create 08/08/2019
 */
public class EixoX {
  private String nome = "";
  private List<Double> dado = new ArrayList<Double>();

  public EixoX() {

  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<Double> getDado() {
    return dado;
  }

  public void setDado(double dado) {
    this.dado.add(dado);
  }
}
