package com.mycom.gwthighcharts.client;

import org.moxieapps.gwt.highcharts.client.Chart;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;

public class ChartSimpleLayoutPanel extends SimpleLayoutPanel
{
   private final ResizeChartTimer timer;

   public ChartSimpleLayoutPanel(Chart chart)
   {
      super();
      this.add(chart);

      timer = new ResizeChartTimer(chart);
   }

   @Override
   public void onResize()
   {
      super.onResize();
      if (timer != null)
         timer.schedule(300);
   }

   private static class ResizeChartTimer extends Timer
   {
      private Chart chart;

      public ResizeChartTimer(Chart chart)
      {
         this.chart = chart;
      }

      @Override
      public void run()
      {
         chart.setSizeToMatchContainer();
      }
   }
}
