import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import javax.swing.*;
import java.util.List;

public class Grafico extends ApplicationFrame {

    public Grafico(String titulo, List<Double> tempo, List<Double> corrente) {
        super(titulo);
        XYSeries series = new XYSeries("Corrente de Magnetização");

        // Adicionar dados à série
        for (int i = 0; i < tempo.size(); i++) {
            series.add(tempo.get(i), corrente.get(i));
        }

        XYSeriesCollection dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Curva da Corrente de Magnetização",
                "Tempo (ms)",
                "Corrente (A)",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
    }

    public static void exibirGrafico(List<Double> tempo, List<Double> corrente) {
        Grafico chart = new Grafico("Curva da Corrente de Magnetização", tempo, corrente);
        chart.pack();
        chart.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        chart.setVisible(true);
    }
}
