gwthighcharts
=============

Example project to show that in a hierarchy of ProvidesResize components the chart does not take 100% of the height of its container at first rendering.

Found out that the problem comes from the fact that the container must explicitly set the heigth to 100%

http://stackoverflow.com/questions/8809852/highcharts-how-to-have-a-chart-with-dynamic-height
http://api.highcharts.com/highcharts#chart.height
