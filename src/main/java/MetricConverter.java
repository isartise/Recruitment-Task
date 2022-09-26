public class MetricConverter {

    public double MetersToFeet(double meters){
        return meters * 3.2808;
    }

    public double FeetToMeters(double feet){
        return feet / 3.2808;
    }

    public double MetersToNauticalMiles( double meters){
       return meters * 0.0005399568;
    }

    public double NauticalMilesToMeters(double nauticalMiles){
        return nauticalMiles * 1852;
    }

    public double FeetToNauticalMiles(double feet){
        return feet * 0.0001645788;
    }

    public double NauticalMilesToFeet(double nauticalMiles){
        return nauticalMiles * 6076.11672949;
    }
    public double convertToMeters(double value,String metric) {
        double valueInMeters = 0;
        if(metric.equals("ft")){
            valueInMeters = FeetToMeters(value);
        }else if(metric.equals("NM")){
            valueInMeters = NauticalMilesToMeters(value);
        }else if(metric.equals("m")) {
            valueInMeters = value;
        }
        return valueInMeters;
    }
    public double convertFromMeters(double valueInMeters,String destinationMetric) {
        double valueInDestinationMetric = 0;
        if(destinationMetric.equals("ft")){
            valueInDestinationMetric = MetersToFeet(valueInMeters);
        }else if(destinationMetric.equals("NM")){
            valueInDestinationMetric = MetersToNauticalMiles(valueInMeters);
        }else if(destinationMetric.equals("m")) {
            valueInDestinationMetric = valueInMeters;
        }
        return valueInDestinationMetric;
    }
}
