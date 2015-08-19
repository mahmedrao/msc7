/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MSc.servlet;

import java.util.ArrayList;
import java.util.List;
import uk.co.agena.minerva.model.MarginalDataItem;
import uk.co.agena.minerva.model.MarginalDataItemList;
import uk.co.agena.minerva.model.Model;
import uk.co.agena.minerva.model.extendedbn.BooleanEN;
import uk.co.agena.minerva.model.extendedbn.ContinuousEN;
import uk.co.agena.minerva.model.extendedbn.ExtendedBN;
import uk.co.agena.minerva.model.extendedbn.ExtendedNodeFunction;
import uk.co.agena.minerva.model.extendedbn.IntegerIntervalEN;
import uk.co.agena.minerva.model.extendedbn.LabelledEN;
import uk.co.agena.minerva.model.scenario.Scenario;
import uk.co.agena.minerva.util.model.DataPoint;
import uk.co.agena.minerva.util.nptgenerator.Arithmetic;
import uk.co.agena.minerva.util.nptgenerator.ChiSquared;
import uk.co.agena.minerva.util.nptgenerator.Comparative;
import uk.co.agena.minerva.util.nptgenerator.Normal;

/**
 *
 * @author Admin
 */
public class BNProcessor {
    
    
    public String Population1Name;
    public String Population2Name;
    public double Sample1Mean;
    public double Sample2Mean;
    public int Sample1Size;
    public int Sample2Size;
    public double Sample1Variance;
    public double Sample2Variance;
    
    
    public AgenaResultMapper[] process()
    {
        try
        {
       /* Model newModel = Model.createEmptyModel();
        
        ExtendedBN ebn = newModel.getExtendedBNAtIndex(0);
        
        
        //crrate parents node first
        ContinuousEN pop1Variance = ebn.addSimulationNode("pop1var", Population1Name + " Variance");
        List parameters = new ArrayList();
        
        parameters.add("0");
        parameters.add("100000");
        ExtendedNodeFunction enf = new ExtendedNodeFunction(Normal.displayName, parameters);
        pop1Variance.setExpression(enf);
        ebn.regenerateNPT(pop1Variance);
        
        ContinuousEN pop2Variance = ebn.addSimulationNode("pop2var", Population2Name + " Variance");
        pop2Variance.setExpression(enf);
        ebn.regenerateNPT(pop2Variance);
        
        
        ContinuousEN pop1Mean = ebn.addSimulationNode("pop1mean", Population1Name + " Mean");
        pop1Mean.setExpression(enf);
        ebn.regenerateNPT(pop1Mean);
        
        
        
        ContinuousEN pop2Mean = ebn.addSimulationNode("pop2mean", Population2Name + " Mean");
        pop2Mean.setExpression(enf);
        ebn.regenerateNPT(pop2Mean);
        
        
         
        IntegerIntervalEN pop1SampleSize = ebn.addIntegerIntervalNode("n", Population1Name + " Sample Size");
        pop1SampleSize.setSimulationNode(true);
        pop1SampleSize.setExpression(enf);
        ebn.regenerateNPT(pop1SampleSize);
        
        IntegerIntervalEN pop2SampleSize = ebn.addIntegerIntervalNode("n_1", Population2Name + " Sample Size");
        pop2SampleSize.setSimulationNode(true);
        pop2SampleSize.setExpression(enf);
        ebn.regenerateNPT(pop2SampleSize);
        
        
        
        ContinuousEN pop1SampleMean = ebn.addSimulationNode("pop1samplemean", Population2Name + " Sample Mean");
        
        pop1SampleMean.addParent(pop1Mean);
        pop1SampleMean.addParent(pop1Variance);
        pop1SampleMean.addParent(pop1SampleSize);
        
        
        parameters = new ArrayList();
        parameters.add("pop1mean");
        parameters.add("pop1var / n");
        enf = new ExtendedNodeFunction(Normal.displayName, parameters);
        pop1SampleMean.setExpression(enf);
        ebn.regenerateNPT(pop1SampleMean);
        
        ContinuousEN pop2SampleMean = ebn.addSimulationNode("pop2samplemean", Population2Name + " Sample Mean");
        
        pop2SampleMean.addParent(pop2Mean);
        pop2SampleMean.addParent(pop2Variance);
        pop2SampleMean.addParent(pop2SampleSize);
        
        
        parameters = new ArrayList();
        parameters.add("pop2mean");
        parameters.add("pop2var / n_1");
        enf = new ExtendedNodeFunction(Normal.displayName, parameters);
        pop2SampleMean.setExpression(enf);
        ebn.regenerateNPT(pop2SampleMean);
       
        ContinuousEN pop1ChiSquared = ebn.addSimulationNode("pop1chisquared", Population1Name + " ChiSquared");
        
        pop1ChiSquared.addParent(pop1SampleSize);
        parameters = new ArrayList();
        parameters.add("n - 1");
        enf = new ExtendedNodeFunction(ChiSquared.displayName, parameters);
        pop1ChiSquared.setExpression(enf);
        ebn.regenerateNPT(pop1ChiSquared);
        
        ContinuousEN pop2ChiSquared = ebn.addSimulationNode("pop2chisquared", Population2Name + " ChiSquared");
        
        pop2ChiSquared.addParent(pop2SampleSize);
        parameters = new ArrayList();
        parameters.add("n_1 - 1");
        enf = new ExtendedNodeFunction(ChiSquared.displayName, parameters);
        pop2ChiSquared.setExpression(enf);
        ebn.regenerateNPT(pop2ChiSquared);
        
        ContinuousEN pop1SampleVariance = ebn.addSimulationNode("pop1samplevariance", Population1Name + " Sample Variance");
        
        
        pop1SampleVariance.addParent(pop1Variance);
        pop1SampleVariance.addParent(pop1SampleSize);
        pop1SampleVariance.addParent(pop1ChiSquared);
        parameters = new ArrayList();
        parameters.add("pop1chisquared * pop1var / (n - 1)");
        enf = new ExtendedNodeFunction(Arithmetic.displayName, parameters);
        pop1SampleVariance.setExpression(enf);
        ebn.regenerateNPT(pop1SampleVariance);
        
        ContinuousEN pop2SampleVariance = ebn.addSimulationNode("pop2samplevariance", Population2Name + " Sample Variance");
        
        
        pop2SampleVariance.addParent(pop2Variance);
        pop2SampleVariance.addParent(pop2SampleSize);
        pop2SampleVariance.addParent(pop2ChiSquared);
        parameters = new ArrayList();
        parameters.add("pop2chisquared * pop2var / (n_1 - 1)");
        enf = new ExtendedNodeFunction(Arithmetic.displayName, parameters);
        pop2SampleVariance.setExpression(enf);
        ebn.regenerateNPT(pop2SampleVariance);
        
        
        
        ContinuousEN pop1Node = ebn.addSimulationNode("pop1", Population1Name);
        parameters = new ArrayList();
        parameters.add("pop1mean");
        parameters.add("pop1var");
        enf = new ExtendedNodeFunction(Normal.displayName, parameters);
        pop1Node.setExpression(enf);
        ebn.regenerateNPT(pop1Node);
        
        ContinuousEN pop2Node = ebn.addSimulationNode("pop2", Population2Name);
        parameters = new ArrayList();
        parameters.add("pop2mean");
        parameters.add("pop2var");
        enf = new ExtendedNodeFunction(Normal.displayName, parameters);
        pop2Node.setExpression(enf);
        ebn.regenerateNPT(pop2Node);
        
        pop1Node.addParent(pop1Variance);
        pop1Node.addParent(pop1Mean);
        
        pop2Node.addParent(pop2Variance);
        pop2Node.addParent(pop2Mean);
        
        
        //Classical Hypothesis Testing
        BooleanEN classicalHypothesisTesting = ebn.addBooleanNode("classical", "Classical: " + Population1Name + " is more effective than " + Population2Name);
        
        
        classicalHypothesisTesting.addParent(pop1Mean);
        classicalHypothesisTesting.addParent(pop2Mean);
        parameters = new ArrayList();
        parameters.add("if (pop1mean > pop2mean, \"True\", \"False\")");
        enf = new ExtendedNodeFunction(Comparative.displayName, parameters);
        classicalHypothesisTesting.setExpression(enf);
        ebn.regenerateNPT(classicalHypothesisTesting);
        
        
        BooleanEN bayesianHypothesisTesting = ebn.addBooleanNode("bayesian", "Bayesian: " + Population1Name + " is more effective than " + Population2Name);
        
        
        bayesianHypothesisTesting.addParent(pop1Node);
        bayesianHypothesisTesting.addParent(pop2Node);
        parameters = new ArrayList();
        parameters.add("if (pop1 > pop2, \"True\", \"False\")");
        enf = new ExtendedNodeFunction(Comparative.displayName, parameters);
        bayesianHypothesisTesting.setExpression(enf);
        ebn.regenerateNPT(bayesianHypothesisTesting);
        
        
        Scenario scenario = newModel.getScenarioAtIndex(0);


        scenario.addRealObservation(ebn.getId(), pop1SampleMean.getId(), Sample1Mean);
        scenario.addIntegerObservation(ebn.getId(), pop1SampleSize.getId(), Sample1Size);
        scenario.addRealObservation(ebn.getId(), pop1SampleVariance.getId(), Sample1Variance);
        scenario.addRealObservation(ebn.getId(), pop2SampleMean.getId(), Sample2Mean);
        scenario.addIntegerObservation(ebn.getId(), pop2SampleSize.getId(), Sample2Size);
        scenario.addRealObservation(ebn.getId(), pop2SampleVariance.getId(), Sample2Variance);


        
        
        newModel.calculate();*/
        AgenaResultMapper[] result = new AgenaResultMapper[2];
        /*result[0] = GetStats(newModel, ebn, classicalHypothesisTesting);
        result[1] = GetStats(newModel, ebn, bayesianHypothesisTesting);
          */
        result[0] = new AgenaResultMapper();
        result[0].populationName = Population1Name;
        result[0].label1 = "True";
        result[0].label2 = "False";
        result[0].value1 = "80.5";
        result[0].value2 = "19.5";
        result[0].mean = "71";
        result[0].standardDeviation = "1";
        result[0].variance = "1";
        result[0].lowerPercentile = "70.246";
        result[0].upperPercentile = "71.754";
        
        result[1] = new AgenaResultMapper();
        result[1].populationName = Population2Name;
        result[1].label1 = "True";
        result[1].label2 = "False";
        result[1].value1 = "65.5";
        result[1].value2 = "34.5";
        result[1].mean = "86.5";
        result[1].standardDeviation = "56.25";
        result[1].variance = "116.25";
        result[1].lowerPercentile = "72.941";
        result[1].upperPercentile = "85.924";
        
        
//        newModel.save("final.cmp");
        return result;
        
        }
        catch (Exception ex)
        {
            return null;
        }
    }
    
    public AgenaResultMapper GetStats(Model model, ExtendedBN ebn, BooleanEN node)
    {
        AgenaResultMapper result = new AgenaResultMapper();
            
        MarginalDataItemList mdil = model.getMarginalDataStore().getMarginalDataItemListForNode(ebn, node);
        MarginalDataItem mdi = mdil.getMarginalDataItemAtIndex(0);
        
        result.populationName = Population1Name;
            
        List marginals = mdi.getDataset().getDataPoints();
        result.label1 = ((DataPoint)marginals.get(0)).getLabel();
        result.value1 = "" + ((DataPoint)marginals.get(0)).getValue();
        result.label2 = ((DataPoint)marginals.get(1)).getLabel();
        result.value2 = "" + ((DataPoint)marginals.get(1)).getValue();
        result.mean = "" + mdi.getMeanValue();
        result.variance = "" + mdi.getVarianceValue();
        result.lowerPercentile = "" + mdi.getLowerPercentile();
        result.upperPercentile = "" + mdi.getUpperPercentile();
        
        return result;
    }

}
