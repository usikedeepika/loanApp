package com.loan.services.impl;


import com.loan.models.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmiCalculation {

    @Autowired(required = true)
    private Loan loan;
    private int loanId;
    private double loanAmt;
    private int duration;
    private int interest;
    private double emi;

   public double calculate(Loan loan1)
    {
        loanId=loan1.getLoanId();
        loanAmt=loan1.getLoanAmt();
        duration=loan1.getDuration();
        interest= loan1.getInterest();
        interest=interest/(12*100);  /*one month interest*/
        duration=duration*12;   /*one month period*/


        emi= (loanAmt*interest*Math.pow(1+interest,duration))/(Math.pow(1+interest,duration)-1);
        return emi;
    }



}
