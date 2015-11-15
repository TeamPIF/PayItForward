function addAxesAndLegend (svg, xAxis, yAxis, margin, chartWidth, chartHeight) {
    var legendWidth  = 200,
        legendHeight = 100;

    var axes = svg.append('g')
        .attr('clip-path', 'url(#axes-clip)');

    axes.append('g')
        .attr('class', 'x axis')
        .attr('transform', 'translate(0,' + chartHeight + ')')
        .call(xAxis);

    axes.append('g')
        .attr('class', 'y axis')
        .call(yAxis)
        .append('text')
        .attr('transform', 'rotate(-90)')
        .attr('y', 6)
        .attr('dy', '.71em')
        .style('text-anchor', 'end')
        .text('Number of Donations');
}






function drawPaths (svg, data, x, y) {
    //console.log("2");
    //console.log(data);
    var format = d3.time.format("%b %Y");
    colors = ["rgb(0,72,105)", "rgb(14,111,112)", "rgb(0,147,152)", "rgb(56,90,186)", 'violet', 'cyan', 'black']
    data.forEach(function (d, i) {
        //console.log("4");
        //console.log(d);
        var medianLine = d3.svg.line()
            .interpolate('basis')
            .x(function (d) {
                //console.log("5");
                //console.log(d['count']);
                return x(format.parse(d['time'])); })
            .y(function (d) {
                //console.log("6");
                //console.log(d['count']);
                return y(d['count']); });

        svg.datum(d.data);

        svg.append('path')
            .attr('stroke',colors[i])
            //.attr('class', 'median-line')
            .attr('d', medianLine)
            .attr('fill','none')
            .attr('stroke-width','6')
            .attr('clip-path', 'url(#rect-clip)');


    });

}

function addMarker (marker, svg, chartHeight, x) {
    var radius = 32,
        xPos = x(marker.date) - radius - 3,
        yPosStart = chartHeight - radius - 3,
        yPosEnd = (marker.type === 'Client' ? 80 : 160) + radius - 3;

    var markerG = svg.append('g')
        .attr('class', 'marker '+marker.type.toLowerCase())
        .attr('transform', 'translate(' + xPos + ', ' + yPosStart + ')')
        .attr('opacity', 0);

    markerG.transition()
        .duration(1000)
        .attr('transform', 'translate(' + xPos + ', ' + yPosEnd + ')')
        .attr('opacity', 1);

    markerG.append('path')
        .attr('d', 'M' + radius + ',' + (chartHeight-yPosStart) + 'L' + radius + ',' + (chartHeight-yPosStart))
        .transition()
        .duration(1000)
        .attr('d', 'M' + radius + ',' + (chartHeight-yPosEnd) + 'L' + radius + ',' + (radius*2));

    markerG.append('circle')
        .attr('class', 'marker-bg')
        .attr('cx', radius)
        .attr('cy', radius)
        .attr('r', radius);

    markerG.append('text')
        .attr('x', radius)
        .attr('y', radius*0.9)
        .text(marker.type);

    markerG.append('text')
        .attr('x', radius)
        .attr('y', radius*1.5)
        .text(marker.version);
}

function startTransitions (svg, chartWidth, chartHeight, rectClip, markers, x) {
    rectClip.transition()
        .duration(1000*markers.length)
        .attr('width', chartWidth);

    markers.forEach(function (marker, i) {
        setTimeout(function () {
            //addMarker(marker, svg, chartHeight, x);
        }, 1000 + 500*i);
    });
}


function makeChart (rubins, markers) {
    var svgWidth  = 960,
        svgHeight = 500,
        margin = { top: 20, right: 20, bottom: 40, left: 40 },
        chartWidth  = svgWidth  - margin.left - margin.right,
        chartHeight = svgHeight - margin.top  - margin.bottom;

    var format = d3.time.format("%b %Y");
    var x = d3.time.scale().range([0, chartWidth])
        .domain(d3.extent(rubins[0].data, function (d) {
            //console.log("1");
            //console.log(d['time']);
            return format.parse(d['time']); })),
        y = d3.scale.linear().range([chartHeight, 0])
            .domain([0, d3.max(rubins,
                function (d) { return d3.max(d.data,
                function (donation) {
                    //console.log("3");
                    //console.log(donation['count']);
                    return donation['count']
                }); })]);
    //console.log("7")
    //console.log(x.domain())

    var xAxis = d3.svg.axis().scale(x).orient('bottom')
        .innerTickSize(-chartHeight).outerTickSize(0).tickPadding(10),
        yAxis = d3.svg.axis().scale(y).orient('left')
            .innerTickSize(-chartWidth).outerTickSize(0).tickPadding(10);

    var svg = d3.select('#graph').append('svg')
        .attr('width',  svgWidth)
        .attr('height', svgHeight)
        .append('g')
        .attr('transform', 'translate(' + margin.left + ',' + margin.top + ')')
        .style("display", "block")
        .style("margin", "auto");

// clipping to start chart hidden and slide it in later
    var rectClip = svg.append('clipPath')
        .attr('id', 'rect-clip')
        .append('rect')
        .attr('width', 0)
        .attr('height', chartHeight);

    addAxesAndLegend(svg, xAxis, yAxis, margin, chartWidth, chartHeight);
    drawPaths(svg, rubins, x, y);
    startTransitions(svg, chartWidth, chartHeight, rectClip, markers, x);
}

function isScrolledIntoView(elem)
{
    var docViewTop = $(window).scrollTop();
    var docViewBottom = docViewTop + $(window).height();

    var elemTop = $(elem).offset().top;
    var elemBottom = elemTop + $(elem).height();

    return ((elemTop <= docViewBottom) && (elemBottom >= docViewTop));
}

var parseDate  = d3.time.format('%Y-%m-%d').parse;
var inView = false;
d3.json('data.json', function (error, rawData) {
    if (error) {
        console.error(error);
        return;
    }

    var data = rawData.map(function (d) {
        return {
            date:  parseDate(d.date),
            pct05: d.pct05 / 1000,
            pct25: d.pct25 / 1000,
            pct50: d.pct50 / 1000,
            pct75: d.pct75 / 1000,
            pct95: d.pct95 / 1000
        };
    });
    var things;
    d3.json('markers.json', function (error, markerData) {
        if (error) {
            console.error(error);
            return;
        }

        var markers = markerData.map(function (marker) {
            return {
                date: parseDate(marker.date),
                type: marker.type,
                version: marker.version
            };
        });
        things = markers
    });

    d3.json('rubinData.json', function (error, rubinData) {
        if (error) {
            console.error(error);
            return;
        }

        var rubins = rubinData.map(function (companyInfo) {
            //companyInfo['donations'].forEach(function(d){
            //    d['time'] = convertTime(d['time']);
            //});
            //console.log(companyInfo);
            return {
                name: companyInfo['business'],
                data: companyInfo['donations']
            };
        });
        $(window).scroll(function() {
            if (isScrolledIntoView('#graph')) {
                if (inView) { return; }
                inView = true;
                makeChart(rubins, things);
            }
        });
    });
});
