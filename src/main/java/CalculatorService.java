import com.google.gson.Gson;


import static spark.Spark.*;
public class CalculatorService {
    public static void main(String[] args) {

        get("/hello", (req, res) -> "Hello World");

        get("/hello/:name", (req, res) -> {
            //return "Hello, "+ req.params(":name");
            TwoOperandsRequest d = new TwoOperandsRequest();

            return new Gson().toJson(d);
        });
        post("/calculator/add", (req, res) -> {
            TwoOperandsRequest requestObj = new Gson().fromJson(req.body(), TwoOperandsRequest.class);
            MetricConverter metricConverter = new MetricConverter();
            double operandA = 0;
            if(requestObj.operandA.metric.equals("ft")){
                operandA = metricConverter.FeetToMeters(requestObj.operandA.value);
            }else if(requestObj.operandA.metric.equals("NM")){
                operandA = metricConverter.NauticalMilesToMeters(requestObj.operandA.value);
            }else if(requestObj.operandA.metric.equals("m"))
                return requestObj.operandA.value;
            double operandB = 0;
            if(requestObj.operandB.metric.equals("ft")){
                operandB = metricConverter.FeetToMeters(requestObj.operandB.value);
            }else if(requestObj.operandB.metric.equals("NM")){
                operandB = metricConverter.NauticalMilesToMeters(requestObj.operandB.value);
            }else if(requestObj.operandB.metric.equals("m"))
                return requestObj.operandB.value;
            CalculatorEngine calculatorEngine = new CalculatorEngine();
            double calculationResult = calculatorEngine.Add(operandA, operandB);
            calculationResult = metricConverter.MetersToFeet(calculationResult);
            double roundedResult = Math.round((calculationResult*100)/100);
            ValueWithMetricRequest result = new ValueWithMetricRequest(roundedResult,requestObj.expectedResultMetric);
            return new Gson().toJson(result);

        });
        post("/calculator/subtract", (req, res) -> {
            TwoOperandsRequest requestObj = new Gson().fromJson(req.body(), TwoOperandsRequest.class);
            MetricConverter metricConverter = new MetricConverter();
            double operandA = 0;
            if(requestObj.operandA.metric.equals("ft")){
                operandA = metricConverter.FeetToMeters(requestObj.operandA.value);
            }else if(requestObj.operandA.metric.equals("NM")){
                operandA = metricConverter.NauticalMilesToMeters(requestObj.operandA.value);
            }else if(requestObj.operandA.metric.equals("m"))
                return requestObj.operandA.value;
            double operandB = 0;
            if(requestObj.operandB.metric.equals("ft")){
                operandB = metricConverter.FeetToMeters(requestObj.operandB.value);
            }else if(requestObj.operandB.metric.equals("NM")){
                operandB = metricConverter.NauticalMilesToMeters(requestObj.operandB.value);
            }else if(requestObj.operandB.metric.equals("m"))
                return requestObj.operandB.value;
            CalculatorEngine calculatorEngine = new CalculatorEngine();
            double calculationResult = calculatorEngine.Subtract(operandA, operandB);
            calculationResult = metricConverter.MetersToFeet(calculationResult);
            double roundedResult = Math.round((calculationResult*100)/100);
            ValueWithMetricRequest result = new ValueWithMetricRequest(roundedResult,requestObj.expectedResultMetric);
            return new Gson().toJson(result);


        });
        post("/calculator/multiply", (req, res) -> {
            TwoOperandsRequest requestObj = new Gson().fromJson(req.body(), TwoOperandsRequest.class);
            MetricConverter metricConverter = new MetricConverter();
            double operandA = 0;
            if(requestObj.operandA.metric.equals("ft")){
                operandA = metricConverter.FeetToMeters(requestObj.operandA.value);
            }else if(requestObj.operandA.metric.equals("NM")){
                operandA = metricConverter.NauticalMilesToMeters(requestObj.operandA.value);
            }else if(requestObj.operandA.metric.equals("m"))
                return requestObj.operandA.value;
            double operandB = 0;
            if(requestObj.operandB.metric.equals("ft")){
                operandB = metricConverter.FeetToMeters(requestObj.operandB.value);
            }else if(requestObj.operandB.metric.equals("NM")){
                operandB = metricConverter.NauticalMilesToMeters(requestObj.operandB.value);
            }else if(requestObj.operandB.metric.equals("m"))
                return requestObj.operandB.value;
            CalculatorEngine calculatorEngine = new CalculatorEngine();
            double calculationResult = calculatorEngine.Multiply(operandA, operandB);
            calculationResult = metricConverter.MetersToFeet(calculationResult);
            double roundedResult = Math.round((calculationResult*100)/100);
            ValueWithMetricRequest result = new ValueWithMetricRequest(roundedResult,requestObj.expectedResultMetric);
            return new Gson().toJson(result);

        });
        post("/calculator/divide", (req, res) -> {
            TwoOperandsRequest requestObj = new Gson().fromJson(req.body(), TwoOperandsRequest.class);
            MetricConverter metricConverter = new MetricConverter();
            double operandA = 0;
            if(requestObj.operandA.metric.equals("ft")){
                operandA = metricConverter.FeetToMeters(requestObj.operandA.value);
            }else if(requestObj.operandA.metric.equals("NM")){
                operandA = metricConverter.NauticalMilesToMeters(requestObj.operandA.value);
            }else if(requestObj.operandA.metric.equals("m"))
                return requestObj.operandA.value;
            double operandB = 0;
            if(requestObj.operandB.metric.equals("ft")){
                operandB = metricConverter.FeetToMeters(requestObj.operandB.value);
            }else if(requestObj.operandB.metric.equals("NM")){
                operandB = metricConverter.NauticalMilesToMeters(requestObj.operandB.value);
            }else if(requestObj.operandB.metric.equals("m"))
                return requestObj.operandB.value;
            CalculatorEngine calculatorEngine = new CalculatorEngine();
            double calculationResult = calculatorEngine.Divide(operandA, operandB);
            calculationResult = metricConverter.MetersToFeet(calculationResult);
            double roundedResult = Math.round((calculationResult*100)/100);
            ValueWithMetricRequest result = new ValueWithMetricRequest(roundedResult,requestObj.expectedResultMetric);
            return new Gson().toJson(result);

        });

    }
}