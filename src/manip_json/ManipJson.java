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

package manip_json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author neo
 * @create 08/08/2019
 */
public class ManipJson {

  final private String PATH = "json/numeros.json";

  private GsonBuilder builder;
  private Gson gson;

  /**
   * Realizar persistência dos dados em um aqruivo .json por meio da biblioteca
   * GSON.
   *
   * @param lista -> recebe lista com os dados inteiros.
   * @return List<Integer>.
   * @throws IOException
   */
  public String grava (List<Integer> lista) throws IOException {
    builder = new GsonBuilder();
    gson = builder.create();
    FileWriter writer = new FileWriter(PATH);
    writer.write(gson.toJson(lista));
    writer.close();

    return gson.toJson(lista);
  }

  /**
   * Localizar e abre o arquivo .json, de forma a recuperar as informações perstidas
   * no mesmo.
   *
   * @return List<Integer>
   * @throws FileNotFoundException
   */
  public List ler() throws FileNotFoundException {
    GsonBuilder builder = new GsonBuilder();
    gson = builder.create();
    BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH));

    Type listType = new TypeToken<ArrayList<Integer>>() {}.getType();

    List<Integer> lista = new Gson().fromJson(bufferedReader, listType);

    return lista;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();

    try {
      for (Iterator iterator = ler().iterator(); iterator.hasNext(); ) {
        stringBuilder.append((int) iterator.next());
        stringBuilder.append(" ");
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return stringBuilder.toString();
  }
}
