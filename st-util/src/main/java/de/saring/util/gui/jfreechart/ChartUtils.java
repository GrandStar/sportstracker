package de.saring.util.gui.jfreechart;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;

/**
 * Utility class for JFreeChart usage.
 *
 * @author Stefan Saring
 */
public final class ChartUtils {

    private ChartUtils() {
    }

    /**
     * Customizes the chart for SportsTracker requirements. The chart background will use the default JavaFX background
     * color. The plot background is white and the gridlines are grey. The diagram will use the default font for
     * JavaFX labels, the default chart fonts are much bigger.
     *
     * @param chart the chart component
     */
    public static void customizeChart(JFreeChart chart) {

        // unfortunately there is no API to get the default JavaFX backgound color, so it needs to hardcoded
        // (transparent background with alpha 0.0 also does not work, it causes font rendering problems)
        // => I've filed a bug for JFreeChart-FX -> https://github.com/jfree/jfreechart-fx/issues/2
        // => use transparent color again, when this bug has been fixed
        java.awt.Color background = new java.awt.Color(244, 244, 244);
        chart.setBackgroundPaint(background);

        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(java.awt.Color.WHITE);
        plot.setDomainGridlinePaint(java.awt.Color.GRAY);
        plot.setRangeGridlinePaint(java.awt.Color.GRAY);

        // get default JavaFX label font and convert it to a AWT font
        javafx.scene.text.Font fxLabelFont = new javafx.scene.control.Label().getFont();
        java.awt.Font chartFont = new java.awt.Font(fxLabelFont.getName(), java.awt.Font.PLAIN,
                (int) fxLabelFont.getSize());
        plot.getDomainAxis().setTickLabelFont(chartFont);
        plot.getRangeAxis().setTickLabelFont(chartFont);
        plot.getDomainAxis().setLabelFont(chartFont);
        plot.getRangeAxis().setLabelFont(chartFont);

        if (chart.getLegend() != null) {
            chart.getLegend().setItemFont(chartFont);
            chart.getLegend().setBackgroundPaint(background);
        }
    }
}
