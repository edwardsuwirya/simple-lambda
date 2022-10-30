package com.enigmacamp.lambda.challange;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Answer {
    public static void main(String[] args) {
        List<Transaction> transactionList = new ArrayList<>(Arrays.asList(
                new Transaction("Manggarai", "01-01-2022", 1000, 30),
                new Transaction("BSD", "01-01-2022", 750, 19),
                new Transaction("Manggarai", "12-01-2022", 1025, 32),
                new Transaction("Ragunan", "01-01-2022", 375, 12),
                new Transaction("Ragunan", "02-01-2022", 397, 13),
                new Transaction("BSD", "03-01-2022", 803, 20),
                new Transaction("Ps.Minggu", "01-01-2022", 35, 3),
                new Transaction("Ps.Minggu", "12-01-2022", 5, 1),
                new Transaction("Manggarai", "15-01-2022", 1005, 31)
        ));

        //1.
        Transaction highestOmzet = transactionList.stream().max((trx1, trx2) -> trx1.getTotalOmzet() > trx2.getTotalOmzet() ? 1 : -1).get();
        System.out.println(highestOmzet);

        Transaction lowestOmzet = transactionList.stream().min((trx1, trx2) -> trx1.getTotalOmzet() > trx2.getTotalOmzet() ? 1 : -1).get();
        System.out.println(lowestOmzet);

        //2.
        int below = 500;
        List<Transaction> below500 = transactionList.stream().filter((trx) -> trx.getTotalOmzet() < below).collect(Collectors.toList());
        System.out.println(below500);

        //3.
        Transaction lowestTrx = transactionList.stream().min((trx1, trx2) -> trx1.getTotalTrx() > trx2.getTotalTrx() ? 1 : -1).get();
        System.out.println(lowestTrx.getPeriode());

        //4.
        Map<String, String> totalOmzet = transactionList
                .stream()
                .collect(Collectors.groupingBy((trx) -> trx.getOutlet(), Collectors.summingInt((trx) -> trx.getTotalOmzet())))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().toString()));

        Map<String, String> totalTrx = transactionList
                .stream()
                .collect(Collectors.groupingBy((trx) -> trx.getOutlet(), Collectors.summingInt((trx) -> trx.getTotalTrx())))
                .entrySet()
                .stream().
                collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().toString()));


        Stream<Map.Entry<String, String>> combined = Stream.concat(totalOmzet.entrySet().stream(), totalTrx.entrySet().stream());
        Map<String, String> merged = combined
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1 + "," + v2));
        System.out.println(merged);

        //5.
        int grandTotalOmzet = transactionList.stream().mapToInt(t -> t.getTotalOmzet()).sum();
        int grandTotalTrx = transactionList.stream().mapToInt(t -> t.getTotalTrx()).sum();
        Map grandTotal = new HashMap<String, Integer>();
        grandTotal.put("Total Omzet", grandTotalOmzet);
        grandTotal.put("Total Trx", grandTotalTrx);
        System.out.println(grandTotal);
    }
}
