gwthighcharts
=============

#Responsive Highcharts in GWT

I this project we demonstrate how to handle responsive charts in layout panels.

We use Highcharts 3.0.10
Moxie wrapper 1.6

## Initial rendering
At first rendering the chart does not have the right size. So we use a defereed scheduler to resize the chart.

        
        Scheduler scheduler = Scheduler.get();
        scheduler.scheduleDeferred(new ScheduledCommand()
        {
            @Override
             public void execute()
             {
                chart.setSizeToMatchContainer();
             }
        });

Corresponding stackoverflow question
http://stackoverflow.com/questions/19807079/gwt-highcharts-auto-resize-width-and-height-in-layout-panel

Other related topics
http://stackoverflow.com/questions/8809852/highcharts-how-to-have-a-chart-with-dynamic-height
http://api.highcharts.com/highcharts#chart.height

##Responsiveness

To achieve the responsiveness, we use the RequireResize interface and launch the `setSizeToMatchContainer`  inside the `onResize` method.

To avoid resize the chart too frequently and thus freezing the UI we added a timer that will trigger the resize after 300ms if nothing more happens

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


