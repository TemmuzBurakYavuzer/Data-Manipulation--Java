import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static ArrayList<Flight> myFlights = new ArrayList<>();
    public static void main(String[] args) {
        String csvName = "flights.csv";
        File file = new File(csvName);
        long start= System.currentTimeMillis();
        try { Scanner inpStrm = new Scanner(file);
            while (inpStrm.hasNextLine()) {
                String data = inpStrm.nextLine();
                String values[] = data.split(",");
                Flight tmp = new Flight();
                tmp.year = values[0];tmp.month = values[1];
                tmp.day = values[2];tmp.airlineName = values[4];
                tmp.flightNumber = values[5];tmp.originAirport = values[7];
                tmp.destinationAirport = values[8];tmp.departureDelay = values[11] + "";
                myFlights.add(tmp); }
        }catch (FileNotFoundException e){
            e.printStackTrace(); }
                q1();
                q2();
        long end= System.currentTimeMillis();long diff = end-start;
        System.out.println("total " + diff +" ms"); }

    public static void q1() {
        Scanner scan = new Scanner(System.in);
        int startMonth,startDay,endMonth,endDay;String wantName;

        System.out.print("airline name ");wantName = scan.next();
        System.out.print("start time ");
        String start = scan.next();String startArr[] = start.split("-");
        startMonth = Integer.parseInt(startArr[1]);
        startDay = Integer.parseInt(startArr[0]);
        System.out.print("end time ");
        String end = scan.next();String endArr[] = end.split("-");
        endMonth = Integer.parseInt(endArr[1]);
        endDay = Integer.parseInt(endArr[0]);
        ArrayList<Flight> outputFlights = new ArrayList<>();

        for (Flight flight : myFlights) {
            if (flight.airlineName.equals(wantName)) {
                if (Integer.parseInt(flight.month) >= startMonth && Integer.parseInt(flight.month) <= endMonth) {
                    if (Integer.parseInt(flight.day) >= startDay && Integer.parseInt(flight.day) <= endDay) {
                            outputFlights.add(flight);
                        } } } }
        if(outputFlights.isEmpty()){
            System.out.println("no flights "); }
        printFlights(outputFlights); }

    public static void q2(){
        Scanner scan = new Scanner(System.in);int startMonth,startDay,endMonth,endDay;
        System.out.print("start time ");
        String start = scan.next();String startArr[] = start.split("-");
        startMonth = Integer.parseInt(startArr[1]);startDay = Integer.parseInt(startArr[0]);
        System.out.print("end time ");
        String end = scan.next();String endArr[] = end.split("-");
        endMonth = Integer.parseInt(endArr[1]);endDay = Integer.parseInt(endArr[0]);

        ArrayList<Flight> outputFlights = new ArrayList<>();

        for (Flight flight : myFlights.subList(1,myFlights.size())) {
                if (Integer.parseInt(flight.month) >= startMonth && Integer.parseInt(flight.month) <= endMonth) {
                    if (Integer.parseInt(flight.day) >= startDay && Integer.parseInt(flight.day) <= endDay) {
                        outputFlights.add(flight); } }  }

        if(outputFlights.isEmpty()){
            System.out.println("no flights "); }
        printFlights(outputFlights); }

    public static void avgDel(float minDelay, float maxDelay){
        System.out.println();
        System.out.println("Min Delay " + minDelay );System.out.println("Max Delay " + maxDelay );
        System.out.println();
        float averageDelayTime=(minDelay+maxDelay)/2;
        System.out.println("Avg Delay "+averageDelayTime); }

    public static void printFlights(ArrayList<Flight> outputFlights){
        float maxDelayTime=Integer.MIN_VALUE;float minDelayTime=Integer.MAX_VALUE;int j = 0;
        for(Flight flight : outputFlights){ j++;
            if(!(flight.departureDelay.isEmpty()) &&minDelayTime>Integer.parseInt(flight.departureDelay)){
                minDelayTime = Integer.parseInt(flight.departureDelay); }
            if(!(flight.departureDelay.isEmpty()) &&maxDelayTime<Integer.parseInt(flight.departureDelay)){
                maxDelayTime = Integer.parseInt(flight.departureDelay); }

            System.out.println();
            System.out.print(j+" --- ");
            System.out.println(flight.toString()); }
        avgDel(minDelayTime,maxDelayTime);
    }}