/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
google.load('visualization', '1', {packages: ['corechart', 'bar']});

$(document).ready(function(){



    var obj = new Object();
    //set appearance of the pages
    $("#contact,#evaluateOnAgena").hide();
    $("#home").show();
         
    //set styling of button
    $( "input[type=submit], button" )
   .button()
      .click(function( event ) {
        event.preventDefault();
      });
      
   
    
    $("#btnGoForIt").click(function(){
      
       $("#intro").hide("fast", function(){
           $("#step1").show("fast");
       }); 
    });
      
    $("#btnStep2").click(function(){
       var goFurther = true;
      $( '#step1 input[required]' ).each(function( index ) {
          
          if ($(this).val() == '')
          {
              $(this).addClass("error");
              goFurther = false;
          }
          else
          {
              $(this).removeClass("error");
          }
      });
      
      if (goFurther)
      {
       $("#step1").hide("fast", function(){
          $("#step2").show("fast");
       });
      }
    });
    
    $("#btnEvaluate").click(function(){
        goFurther = true;
      $( '#step2 input[required]' ).each(function( index ) {
          
          if ($(this).val() == '')
          {
              $(this).addClass("error");
              goFurther = false;
          }
          else
          {
              $(this).removeClass("error");
          }
          
          
      });
      
      if (goFurther)
      {
          $("#divProgressIndicator").show();
             $.get("PresentConjecture", { pop1Name: $('#txtPopulation1Name').val(),
                    sample1Mean: $('#txtSample1Mean').val(),
                    sample1Size: $('#txtSample1Size').val(),
                    sample1Variance: $('#txtSample1Variance').val(),
                    pop2Name: $('#txtPopulation2Name').val(),
                    sample2Mean: $('#txtSample2Mean').val(),
                    sample2Size: $('#txtSample2Size').val(),
                    sample2Variance: $('#txtSample2Variance').val()
                }, function(responseText){
                    $('.evaluationContainer').hide("slow", function(){
                        
                    
                        obj = $.parseJSON(responseText);

                        google.setOnLoadCallback(drawChart());

                        $("#divProgressIndicator").hide();
                        $('#evaluationResult').show("slow");
                        
                    });
                    
                }); 

      }  
        
        
        
    });
function drawChart()
    {
        var graphContainers = ["divChartHypothesis", "divChartBayesian"];
        
        for (var index = 0; index < 2; index++)
        {
            var data = new google.visualization.DataTable();
            data.addColumn('string', ' ');
            data.addColumn('number', ' ');
            data.addColumn({type: 'string', role: 'tooltip'});

            data.addRows([
                [obj[index].label1, parseFloat(obj[index].value1),  "Mean: " + obj[index].mean + "\n" + 
                               "Variance: " + obj[index].variance + "\n" + 
                               "Standard Deviation: " + obj[index].standardDeviation + "\n" + 
                               "Lower Percentile: " + obj[index].lowerPercentile + "\n" + 
                               "Upper Percentile: " + obj[index].upperPercentile],
               [obj[index].label2, parseFloat(obj[index].value2), "Mean: " + obj[index].mean + "\n" + 
                               "Variance: " + obj[index].variance + "\n" + 
                               "Standard Deviation: " + obj[index].standardDeviation + "\n" + 
                               "Lower Percentile: " + obj[index].lowerPercentile + "\n" + 
                               "Upper Percentile: " + obj[index].upperPercentile]
               ]);
               var options = {
               title: obj[0].populationName + ' is more effective than ' + obj[1].populationName,
               chartArea: {width: '50%'},
               colors: ['#BC0000'],
               vAxis: {
                   minValue: 0
               },
               legend: 'none',
               tooltip: {isHtml: true}
             };

            var chart = new google.visualization.BarChart(document.getElementById(graphContainers[index]));
            chart.draw(data, options);
            
            $('#tblStats tr td:eq(1)').text(obj[0].populationName + " Stats");
            $('#tblStats tr td:eq(2)').text(obj[1].populationName + " Stats");
            
            $("#tblStats tr").slice(1,$("#tblStats tr").length).each(function(index, trs){ 
               
                $(this).find('td').slice(1,3).each(function(index1,tds){ 
                 
                     if ($(this).parent().find('td:contains("Mean")').length == 1)
                     {
                        $(this).text(obj[index1].mean ); 
                     }
                     else if ($(this).parent().find('td:contains("Variance")').length == 1)
                     {
                        $(this).text(obj[index1].variance );
                     }
                     else if ($(this).parent().find('td:contains("Standard Deviation")').length == 1)
                     {
                        $(this).text(obj[index1].standardDeviation );
                     }
                     else if ($(this).parent().find('td:contains("Lower Percentile")').length == 1)
                     {
                        $(this).text(obj[index1].lowerPercentile );
                     }
                     else if ($(this).parent().find('td:contains("Upper Percentile")').length == 1)
                     {
                        $(this).text(obj[index1].upperPercentile );
                     }
                    
                }) 
            });
     }
    }
    //menu button click event
    $(".menuButton").click(function(){
        
        if ($(this).text().indexOf("HOME") !== -1)
        {
            $("#contact").hide("slow");
            $("#evaluateOnAgena").hide("slow", function(){
                $("#home").show("slow");
            });
        }
        
        else if ($(this).text().indexOf("EVALUATE") !== -1)
        {
            $("#intro").show();
            $("#step1").hide();
            $("#step2").hide();
            
            $("#contact").hide("slow");
            $("#home").hide("slow", function(){
                $("#evaluateOnAgena").show("slow");
            });
        }
        
        else if ($(this).text().indexOf("CONTACT") !== -1)
        {
            $("#evaluateOnAgena").hide("slow");
            $("#home").hide("slow", function(){
                $("#contact").show("slow");
            });
        }
    });
});


    
