<%-- 
    Document   : home
    Created on : Aug 15, 2015, 3:46:21 PM
    Author     : Muhammad Ahmed Rao
--%>

<%@page import="java.io.File"%>
<%@page import="java.awt.Font"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src="https://www.google.com/jsapi"></script>
        <link href='http://fonts.googleapis.com/css?family=Enriqueta:400,700' rel='stylesheet' type='text/css'>
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/jquery-ui.css" rel="stylesheet" type="text/css"/>
        <script src="scripts/jquery-2.1.4.min.js" type="text/javascript"></script>
        <script src="scripts/jquery-ui.js" type="text/javascript"></script>
        
        <script src="scripts/page.js" type="text/javascript"></script>

        
        <title>Home Page</title>
    </head>
    <body>
        <div class="container">
        <div id="divProgressIndicator" style="position: fixed; width: 100%;margin: auto;z-index: 100004;background-color:#eee;height:1024px;opacity:0.5;filter:alpha(opacity=50);display:none;">
                                                            <div style="position:relative ; width: inherit;margin: auto;z-index: 100005;text-align:center;">
                                                                <img style="width:inherit;" src="images/loading.gif">
                                                            </div>
        </div>
            <div class="topBar"></div>
            <div class="containerWidth">
                <div class="headingContainer">
                <h1 style="line-height: 1em;" class="font_0 headingFont">
                    <font color="#ffffff">
                        Bayesian VS Classical Hypothesis Testing
                    </font>
                </h1>
                <p style="line-height: 0.5em;" class="font_8">&nbsp;</p>
                </div>
                
                <div class="menu">
                    <div clas="itemContainer">
                        <div class="menuButton">
                            <div class="gapper">
                                <div class="innerGapper">
                                    <p style="line-height: 20px; width: auto;" class="menuButtonLabel">
                                        HOME
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="menuButton">
                            <div class="gapper">
                                <div class="innerGapper">
                                    <p style="line-height: 20px; width: auto;" class="menuButtonLabel">
                                        EVALUATE ON AGENA
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="menuButton">
                            <div class="gapper">
                                <div class="innerGapper">
                                    <p style="line-height: 20px; width: auto;" class="menuButtonLabel">
                                        CONTACT
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="grdLineContainer">
                    <div class="grdLine"></div>
                </div>
            </div>
            <div class="pagesContainer">
                <div class="blankScreenWidthBackground"></div>
                <div class="centeredContent" style="width: 980px; margin-left: 0px;">
                    <div class="sitePages">
                        <div class="centeredContent">
                            <div id="home" class="page">
                                <div class="projectGoal">
                                    <h4 style="line-height: 1.2em;" class="font_4">
                                    The main goal of this project is to produce an automatic means of carrying out both Bayesian and Classical Hypothesis Testing within a BN framework using Agena API.
                                    </h4>
                                </div>  
                                <div class="grdLine grdLineGoal" ></div>
                                <div class="photo">
                                    <a>
                                        <div class="imageContainer">
                                            <img src="images/globe.gif_256"/>
                                        </div>  
                                    </a>
                                </div>
                                <div class="row" style="position: absolute">
                                    <div class="definition" style="background-color: yellow">
                                        <div class="col-md-4 tile-col">
                                        <ul>
                                            <div class="row tile green">
                                                <li><h3>What is Hypothesis Testing?</h3></li>
                                                <p>
                                                     Hypothesis testing refers to the formal procedures used by statisticians to accept or reject statistical hypotheses.
                                                </p>

                                            </div>
                                        </ul>
                                        </div>
                                    </div>
                                    <div class="definition" style="background-color: #B94E00;">
                                        <div class="col-md-4 tile-col">
                                        <ul>
                                            <div class="row tile">
                                                <li><h3>What is Classical Hypothesis Testing?</h3></li>
                                                <p>
                                                    Classical hypothesis testing is a method or a formal procedure used by statistician to accept or reject statistical hypothesis. The better way to find that whether the statistical hypothesis is true or not is to examine whole population, but this is not possible in practical. So what the statistician do is they observe a random sample from the population. If the sample data does not meet the criteria of the statistical hypothesis then the hypothesis is rejected.
                                                </p>

                                            </div>
                                        </ul>
                                        </div>
                                    </div>
                                    <div class="definition" style="background-color: gold">
                                        <div class="col-md-4 tile-col">
                                        <ul>
                                            <div class="row tile">
                                                <li><h3>What is Bayesian Hypothesis Testing?</h3></li>
                                                <p>
                                                    Hypothesis testing can also be conducted by Bayesian perspective using Bayes’ Theorem. Bayes’ Theorem gives us a simple method to calculate the probability given the prior assumptions. Basically, this approach takes into account the prior assumptions while testing the hypothesis. Prior assumptions convey information on those values of the vector of interest which may be taken to be compatible with the observed data. Bayesian hypothesis includes other information while judging the evidence.
                                                </p>
                                            </div>
                                        </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="evaluateOnAgena" class="page">
                                <div class="evaluationContainer setFont">
                                    <div id="intro" class="evaluation">
                                        <div class="headingFont">
                                            <font color="#ffffff">
                                                Evaluation is done in 2 steps
                                            </font>
                                        </div>
                                        <br>
                                        <button id="btnGoForIt">Go For It!</button>
                                    </div>
                                    <div id="step1" class="evaluation invisible">
                                        <fieldset>
                                            <legend>Step 1</legend>
                                                <div>
                                                    <span class="floatLeft">
                                                        Population 1 Name<span class="redAlert">*</span>:
                                                    </span>
                                                    <span class="floatRight">
                                                        <input required type="text" placeholder="Population 1 Name" id="txtPopulation1Name"/>
                                                    </span>
                                                </div>
                                            <br/>
                                            <br/>
                                                <div>
                                                    <span class="floatLeft">
                                                        Sample 1 Mean<span class="redAlert">*</span>:
                                                    </span>
                                                    <span class="floatRight">
                                                        <input required type="text" placeholder="Sample 1 Mean" id="txtSample1Mean"/>
                                                    </span>
                                                </div>
                                            <br/>
                                            <br/>
                                                <div>
                                                    <span class="floatLeft">
                                                        Sample 1 Size<span class="redAlert">*</span>:
                                                    </span>
                                                    <span class="floatRight">
                                                        <input required type="text" placeholder="Sample 1 Size" id="txtSample1Size"/>
                                                    </span>
                                                </div>
                                            <br/>
                                            <br/>
                                                <div>
                                                    <span class="floatLeft">
                                                        Sample 1 Variance<span class="redAlert">*</span>:
                                                    </span>
                                                    <span class="floatRight">
                                                        <input required type="text" placeholder="Sample 1 Variance" id="txtSample1Variance"/>
                                                    </span>
                                                </div>
                                        </fieldset>
                                        <br>
                                        <button id="btnStep2" type="button">Go To Step 2</button>
                                    </div>
                                    <div id="step2" class="evaluation invisible">
                                        <fieldset>
                                            <legend>Step 2</legend>
                                                <div>
                                                    <span class="floatLeft">
                                                        Population 2 Name<span class="redAlert">*</span>:
                                                    </span>
                                                    <span class="floatRight">
                                                        <input required type="text" placeholder="Population 2 Name" id="txtPopulation2Name"/>
                                                    </span>
                                                </div>
                                            <br/>
                                            <br/>
                                                <div>
                                                    <span class="floatLeft">
                                                        Sample 2 Mean<span class="redAlert">*</span>:
                                                    </span>
                                                    <span class="floatRight">
                                                        <input required type="text" placeholder="Sample 2 Mean" id="txtSample2Mean"/>
                                                    </span>
                                                </div>
                                            <br/>
                                            <br/>
                                                <div>
                                                    <span class="floatLeft">
                                                        Sample 2 Size<span class="redAlert">*</span>:
                                                    </span>
                                                    <span class="floatRight">
                                                        <input required type="text" placeholder="Sample 2 Size" id="txtSample2Size"/>
                                                    </span>
                                                </div>
                                            <br/>
                                            <br/>
                                                <div>
                                                    <span class="floatLeft">
                                                        Sample 2 Variance<span class="redAlert">*</span>:
                                                    </span>
                                                    <span class="floatRight">
                                                        <input required type="text" placeholder="Sample 2 Variance" id="txtSample2Variance"/>
                                                    </span>
                                                </div>
                                        </fieldset>
                                        <br>
                                        <button id="btnEvaluate">Evaluate!</button>
                                    </div>
                                </div>
                                <div id="evaluationResult" class="invisible">
                                    <div class="headingFont alignCenter" style="margin-left: -130px;">
                                        <font color="#ffffff">
                                            Evaluation Result
                                        </font>
                                    </div>
                                    <br>
                                    <br>
                                    <br>
                                    <div style="width: 80%;">
                                    <table style="width:100%">
                                        <tr>
                                            <td>
                                                <span class="headingFont resultFont">
                                                    <font color="#ffffff">
                                                        Classical Hypothesis Testing
                                                    </font>
                                                </span>
                                            </td>
                                            <td>
                                                <span class="headingFont floatLeft resultFont">
                                                    <font color="#ffffff">
                                                        Bayesian Hypothesis Testing
                                                    </font>
                                                </span>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <div id="divChartHypothesis" class="inline-block"></div>
                                            </td>
                                            <td>
                                                <div id="divChartBayesian" class="inline-block"></div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="2">
                                                <div class="headingFont downloadLink">
                                                    <a href="model/final_model.cmp">DOWNLOAD MODEL FILE!!!</a>

                                                </div>
                                            </td>
                                        </tr>
                                    </table>
                                    <table id="tblStats" class="headingFont resultFont">
                                        <tr>
                                            <td></td>
                                            <td>
                                                <span id="spanpop1" class="headingFont resultFont">
                                                    <font color="#ffffff">
                                                        
                                                    </font>
                                                </span>
                                            </td>
                                            <td>
                                                <span id="spanpop2" class="headingFont floatLeft resultFont">
                                                    <font color="#ffffff">
                                                        
                                                    </font>
                                                </span>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <span class="headingFont resultFont">
                                                    <font color="#ffffff">Mean</font>
                                                </span>
                                            </td>
                                            <td>mean1</td>
                                            <td>mean2</td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <span class="headingFont resultFont">
                                                    <font color="#ffffff">Variance</font>
                                                </span>
                                            </td>
                                            <td>var1</td>
                                            <td>var2</td>
                                            
                                        </tr>
                                        <tr>
                                            <td>
                                                <span class="headingFont resultFont">
                                                    <font color="#ffffff">Standard Deviation</font>
                                                </span>
                                            </td>
                                            <td>sd1</td>
                                            <td>sd2</td>
                                            
                                        </tr>
                                        <tr>
                                            <td>
                                                <span class="headingFont resultFont">
                                                    <font color="#ffffff">Lower Percentile</font>
                                                </span>
                                            </td>
                                            <td>lp1</td>
                                            <td>lp2</td>
                                            
                                        </tr>
                                        <tr>
                                            <td>
                                                <span class="headingFont resultFont">
                                                    <font color="#ffffff">Upper Percentile</font>
                                                </span>
                                            </td>
                                            <td>up1</td>
                                            <td>up2</td>
                                        </tr>
                                    </table>
                                    </div>
                                    
<!--                                    <div class="inline-block" style="width:50px;"></div>-->
                                    
                                    
                                </div>
                            
                            
                            
                            
                            
                            
                            
                            
                            </div>
                            <div id="contact" class="page headingFont" style="text-align: center">
                                <div>
                                    <font color="#ffffff">
                                        Project Supervisor<br>
                                        <span class="font_30">
                                            Professor Martin Neil<br>
                                            Professor of Computer Science and Statistics<br>
                                            martin@eecs.qmul.ac.uk
                                        </span>   
                                    </font>
                                <div class="grdLine" style="position: initial;"></div>
                                </div>
                                <div>
                                    <font color="#ffffff" class="font_30">
                                        Muhammad Ahmed Rao<br>
                                        Msc Big Data Science, QMUL<br>
                                        m.rao@se14.qmul.ac.uk
                                    </font>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
    </body>
</html>
