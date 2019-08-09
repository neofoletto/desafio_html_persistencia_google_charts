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

package manip_html;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author neo
 * @create 08/08/2019
 */
public class ManipHtml {

  private final String PATH = "charts/";
  private String style = "";

  public void grava(String fileName) throws IOException {
    Scanner imput = new Scanner(System.in);

    FileWriter arquivo = new FileWriter(this.PATH.concat(fileName).concat(".html"));
    PrintWriter persistir = new PrintWriter(arquivo);

    persistir.printf("%s\n", cabecalho(fileName));
    persistir.printf("%s\n", corpo(fileName));
    persistir.printf("%s\n", rodape());

    arquivo.close();
    imput.close();
  }

  private String cabecalho(String type) {
    StringBuilder html = new StringBuilder();

    html.append("<!DOCTYPE html>\n");
    html.append("<html>\n");
    html.append("<head>\n");
      html.append("<title>");
      html.append(type);
      html.append("</title>\n");

      html.append(script(type));

    html.append("</head>\n");

    return html.toString();
  }

  private String rodape() {
    StringBuilder html = new StringBuilder();
    html.append("</html>\n");
    return html.toString();
  }

  private StringBuilder corpo(String style) {
    StringBuilder html = new StringBuilder();

    html.append("<body>\n");
      html.append("<div \n");
      html.append("id=\"chart_div\" style=\"");
      html.append(this.style);
      html.append("\">\n");
      html.append("</div>\n");
    html.append("</body>\n");

    return html;
  }

  private StringBuilder script(String type) {
    StringBuilder html = new StringBuilder();

    html.append("<script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n");
    html.append("<script type=\"text/javascript\">\n");
    html.append("google.charts.load('current', {'packages':['corechart']});\n");
    html.append("google.charts.setOnLoadCallback(drawChart);\n");

    html.append("function drawChart() {\n");
    html.append("var data = google.visualization.arrayToDataTable([\n");

    html.append(dados());

    html.append("]);\n");

    html.append("var options = {\n");
    switch (type) {
      case "AreaChart":
        this.style = "width: 100%; height: 500px;";

        html.append("title: 'Company Performance',\n");
        html.append("hAxis: {title: 'Year',  titleTextStyle: {color: '#333'}},\n");
        html.append("vAxis: {minValue: 0}\n");
        break;
      case "LineChart":
        this.style = "width: 900px; height: 500px";

        html.append("title: 'Company Performance',");
        html.append("curveType: 'function',");
        html.append("legend: { position: 'bottom' }");
        break;
      case "PieChart":
        this.style = "width: 900px; height: 500px;";

        html.append("title: 'My Daily Activities',");
        html.append("is3D: true,");
        break;
    }
    html.append("};\n");

    html.append("var chart = new google.visualization.");
    html.append(type);
    html.append("(document.getElementById('chart_div'));\n");
    html.append("chart.draw(data, options);\n");
    html.append("}\n");
    html.append("</script>\n");

    return html;
  }

  private StringBuilder dados() {
    StringBuilder html = new StringBuilder();

    html.append("['Year', 'Sales', 'Expenses'],");
    html.append("['2013',  1000,      400],");
    html.append("['2014',  1170,      460],");
    html.append("['2015',  660,       1120],");
    html.append("['2016',  1030,      540]");

    return html;
  }
}