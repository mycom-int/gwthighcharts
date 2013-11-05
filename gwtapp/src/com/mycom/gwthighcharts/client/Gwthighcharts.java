package com.mycom.gwthighcharts.client;

import org.moxieapps.gwt.highcharts.client.Chart;
import org.moxieapps.gwt.highcharts.client.ChartSubtitle;
import org.moxieapps.gwt.highcharts.client.ChartTitle;
import org.moxieapps.gwt.highcharts.client.Legend;
import org.moxieapps.gwt.highcharts.client.Series;
import org.moxieapps.gwt.highcharts.client.ToolTip;
import org.moxieapps.gwt.highcharts.client.ToolTipData;
import org.moxieapps.gwt.highcharts.client.ToolTipFormatter;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;


public class Gwthighcharts implements EntryPoint
{

   @Override
   public void onModuleLoad()
   {
      RootLayoutPanel.get().add(createChart());
   }

   public Chart createChart()
   {

      final Chart chart = new Chart().setType(Series.Type.LINE)
         .setMarginRight(130)
         .setMarginBottom(25)
         .setChartTitle(new ChartTitle().setText("Monthly Average Temperature").setX(-20) // center
         )
         .setChartSubtitle(new ChartSubtitle().setText("Source: WorldClimate.com").setX(-20))
         .setLegend(
            new Legend().setLayout(Legend.Layout.VERTICAL)
               .setAlign(Legend.Align.RIGHT)
               .setVerticalAlign(Legend.VerticalAlign.TOP)
               .setX(-10)
               .setY(100)
               .setBorderWidth(0))
         .setToolTip(new ToolTip().setFormatter(new ToolTipFormatter()
         {
            @Override
            public String format(ToolTipData toolTipData)
            {
               return "<b>" + toolTipData.getSeriesName() + "</b><br/>" + toolTipData.getXAsString() + ": " + toolTipData.getYAsDouble() + "°C";
            }
         }));

      chart.getXAxis().setCategories("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");

      chart.getYAxis().setAxisTitleText("Temperature °C");

      chart.addSeries(chart.createSeries().setName("Tokyo").setPoints(new Number[] { 7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6 }));
      chart.addSeries(chart.createSeries().setName("New York").setPoints(new Number[] { -0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5 }));
      chart.addSeries(chart.createSeries().setName("Berlin").setPoints(new Number[] { -0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3, 9.0, 3.9, 1.0 }));
      chart.addSeries(chart.createSeries().setName("London").setPoints(new Number[] { 3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8 }));

      return chart;
   }
}
