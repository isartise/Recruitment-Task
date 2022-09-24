import com.google.gson.Gson;

import static spark.Spark.*;
public class CalculatorService {
    public static void main(String[] args) {

        get("/hello", (req, res)->"Hello World");

        get("/hello/:name", (req,res)->{
            //return "Hello, "+ req.params(":name");
            TwoOperandsRequest d=new TwoOperandsRequest();

            return new Gson().toJson(d);
        });
        post("/calculator/add",(req,res)->{
            TwoOperandsRequest requestObj=new Gson().fromJson(req.body(), TwoOperandsRequest.class);
            return new CalculatorEngine().Add(requestObj.getA(), requestObj.getB());

        });
        post("/calculator/subtract",(req,res)->{
            TwoOperandsRequest requestObj=new Gson().fromJson(req.body(), TwoOperandsRequest.class);
            return new CalculatorEngine().Subtract(requestObj.getA(), requestObj.getB());

        });
    }
}
