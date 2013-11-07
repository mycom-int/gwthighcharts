gwthighcharts
=============

Example project to show that in a hierarchy of ProvidesResize components the chart does not take 100% of the height of its container at first rendering.

Only solution found
        
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
