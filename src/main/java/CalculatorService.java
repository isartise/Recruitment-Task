import com.google.gson.Gson;
import spark.Request;
import spark.Response;


import static spark.Spark.*;
public class CalculatorService {
    public static void main(String[] args) {


        post("/calculator/add", CalculatorService::handleAdd);

        post("/calculator/subtract", CalculatorService::handleSubtract);

        post("/calculator/multiply", CalculatorService::handleMultiply);

        post("/calculator/divide", CalculatorService::handleDivide);

    }

    public static String handleAdd(spark.Request req, spark.Response res){
        TwoOperandsRequest requestObj = new Gson().fromJson(req.body(), TwoOperandsRequest.class);

        MetricConverter metricConverter=new MetricConverter();
        double operandA = metricConverter.convertToMeters(requestObj.operandA.value,requestObj.operandA.metric);
        double operandB = metricConverter.convertToMeters(requestObj.operandB.value,requestObj.operandB.metric);

        CalculatorEngine calculatorEngine = new CalculatorEngine();
        double calculationResult = calculatorEngine.Add(operandA, operandB);

        return prepareResponse(calculationResult, requestObj.expectedResultMetric);

    }

    public static String handleSubtract(spark.Request req, spark.Response res){
        TwoOperandsRequest requestObj = new Gson().fromJson(req.body(), TwoOperandsRequest.class);

        MetricConverter metricConverter=new MetricConverter();
        double operandA = metricConverter.convertToMeters(requestObj.operandA.value,requestObj.operandA.metric);
        double operandB = metricConverter.convertToMeters(requestObj.operandB.value,requestObj.operandB.metric);

        CalculatorEngine calculatorEngine = new CalculatorEngine();
        double calculationResult = calculatorEngine.Subtract(operandA, operandB);

        return prepareResponse(calculationResult, requestObj.expectedResultMetric);

    }
    public static String handleDivide(spark.Request req, spark.Response res){
        TwoOperandsRequest requestObj = new Gson().fromJson(req.body(), TwoOperandsRequest.class);

        MetricConverter metricConverter=new MetricConverter();
        double operandA = metricConverter.convertToMeters(requestObj.operandA.value,requestObj.operandA.metric);
        double operandB = metricConverter.convertToMeters(requestObj.operandB.value,requestObj.operandB.metric);

        CalculatorEngine calculatorEngine = new CalculatorEngine();
        double calculationResult = calculatorEngine.Divide(operandA, operandB);

        return prepareResponse(calculationResult, null);

    }

    public static String handleMultiply(spark.Request req, spark.Response res) {
        TwoOperandsRequest requestObj = new Gson().fromJson(req.body(), TwoOperandsRequest.class);

        MetricConverter metricConverter = new MetricConverter();
        double operandA = metricConverter.convertToMeters(requestObj.operandA.value, requestObj.operandA.metric);
        double operandB = requestObj.operandB.value;

        CalculatorEngine calculatorEngine = new CalculatorEngine();
        double calculationResult = calculatorEngine.Multiply(operandA, operandB);

        calculationResult = metricConverter.convertFromMeters(calculationResult, requestObj.expectedResultMetric);

        return prepareResponse(calculationResult, requestObj.expectedResultMetric);
    }
    private static String prepareResponse(double calculationResult, String expectedResultMetric){
        double roundedResult = Math.round(calculationResult * 100) / 100.0;
        ValueWithMetricRequest result = new ValueWithMetricRequest(roundedResult, expectedResultMetric);
        return new Gson().toJson(result);
    }
}