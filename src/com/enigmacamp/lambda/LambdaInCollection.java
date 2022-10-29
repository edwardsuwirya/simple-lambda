package com.enigmacamp.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaInCollection {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Fajri");
        list.add("Fadli");
        list.add("Agus");

        /*
            ForEach example
         */
        System.out.println("For Each");
        list.forEach(
                (nama) -> System.out.println(nama)
        );
        /*
            Sort example
         */
        System.out.println("Sorting");
        list.sort((nama1, nama2) -> {
            return nama1.compareTo(nama2);
        });
        list.forEach(
                (nama) -> System.out.println(nama)
        );

        /*
            Creating Stream
         */
        Collection<String> collection = Arrays.asList("coll-a", "coll-b", "coll-c");
        Stream<String> streamOfCollection = collection.stream();
        streamOfCollection.forEach((coll) -> System.out.println(coll));

        Stream<String> streamBuilder =
                Stream.<String>builder().add("builder-a").add("builder-b").add("builder-c").build();

        streamBuilder.forEach((coll) -> System.out.println(coll));

        IntStream.range(1, 10).forEach((i) -> System.out.println("Iteration " + i));
        /*
            Filter example
         */
        System.out.println("Filtering");
        Stream result = list.stream().filter((nama) -> nama.startsWith("A"));
        result.forEach(n -> System.out.println(n));

        /*
            Reduce example
         */
        List<BillTransaction> billTransactions = new ArrayList<>();
        billTransactions.add(new BillTransaction("1", "Susu", 1, 1400));
        billTransactions.add(new BillTransaction("2", "Kopi", 1, 800));
        billTransactions.add(new BillTransaction("3", "Gula", 2, 425));
        billTransactions.add(new BillTransaction("4", "Creamer", 1, 950));

        int totalQty = billTransactions.stream()
                .map(bill -> bill.getQty())
                .reduce(0, (total, qty) -> total + qty);
        System.out.println(totalQty);

        double grandTotal = billTransactions.stream()
                .map(bill -> bill.getQty() * bill.getPrice())
                .reduce(0.0, (totalPrice, price) -> totalPrice + price);
        System.out.println(grandTotal);

        /*
            Collect example
         */
        List<String> collectorCollection =
                billTransactions.stream().map(BillTransaction::getName).collect(Collectors.toList());
        System.out.println(collectorCollection);

        /*
            ParallelStream example
         */
        boolean isQtyMoreThanOneExist = billTransactions.parallelStream()
                .map(bill -> bill.getQty())
                .anyMatch(qty -> qty > 1);
        System.out.println(isQtyMoreThanOneExist);
    }
}

class BillTransaction {
    private String id;
    private String name;

    private int qty;
    private double price;

    public BillTransaction(String id, String name, int qty, double price) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
