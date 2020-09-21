public class Flight {
    String year;
    String month;
    String airlineName;
    String day;
    String flightNumber;
    String originAirport;
    String destinationAirport;
    String departureDelay;

    public String toString(){
        return day + "." + month + "." + year + "\nname and number  " + airlineName +" "+  flightNumber
                + "\norigin airp and desti airp  " + originAirport + " to " + destinationAirport + "\ndelay  " + departureDelay;
    }
}
