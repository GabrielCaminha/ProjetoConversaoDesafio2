import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Caminho do arquivo Excel
        String caminhoExcel = "MagCurve-3.xlsx";
        
        // Ler dados da planilha (Coluna 0: MMF, Coluna 1: Fluxo)
        List<Double> mmf = ExcelReader.lerColuna(caminhoExcel, 0);
        List<Double> fluxo = ExcelReader.lerColuna(caminhoExcel, 1);

        // Evitar divisão por zero no fluxo
        for (int i = 0; i < fluxo.size(); i++) {
            if (fluxo.get(i) == 0) {
                fluxo.set(i, 1e-6);  // Pequeno valor para evitar zero
            }
        }

        // Calcular corrente de magnetização (MMF / Fluxo)
        List<Double> correnteMagnetizacao = new ArrayList<>();
        for (int i = 0; i < mmf.size(); i++) {
            correnteMagnetizacao.add(mmf.get(i) / fluxo.get(i));
        }

        // Gerar tempo (0 <= t <= 340ms; passo de 1/3000s)
        List<Double> tempo = new ArrayList<>();
        double passo = 1.0 / 3000;
        for (int i = 0; i < mmf.size(); i++) {
            tempo.add(i * passo * 1000);  // Tempo em milissegundos
        }

        // Exibir gráfico
        Grafico.exibirGrafico(tempo, correnteMagnetizacao);
    }
}
