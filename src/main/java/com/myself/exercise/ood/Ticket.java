package com.myself.exercise.ood;

import java.util.Date;

public class Ticket {

    private String id;

    private float amount;

    private Vehicle vehicle;

    private Date inTime;

    private Date outTIme;

    private int status; //已支付、未支付。

    private int paymentMethod; // credit ,debit,cash

}
