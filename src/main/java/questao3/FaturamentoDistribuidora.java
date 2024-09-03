package questao3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class FaturamentoDistribuidora {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        ArrayList<Double> faturamento = new ArrayList<>();
        double soma = 0;

        try {
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("src/main/resources/faturamento.json"));

            for (Object o : jsonArray) {
                JSONObject jsonObject = (JSONObject) o;
                double valor = (double) jsonObject.get("valor");

                if (valor > 0) {
                    faturamento.add(valor);
                    soma += valor;
                }
            }

            double mediaMensal = soma / faturamento.size();
            int diasAcimaDaMedia = 0;

            for (double valor : faturamento) {
                if (valor > mediaMensal) {
                    diasAcimaDaMedia++;
                }
            }

            System.out.println("Menor valor de faturamento: " + Collections.min(faturamento));
            System.out.println("Maior valor de faturamento: " + Collections.max(faturamento));
            System.out.println("Dias com faturamento acima da media: " + diasAcimaDaMedia);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
