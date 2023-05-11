package com.loan.controllers;

import java.util.List;

import com.loan.services.impl.EmiCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.loan.models.Loan;
import com.loan.services.iLoanService;

@RestController
@RequestMapping("/loan")
//@CrossOrigin(origins = "*")
public class LoanController {

	@Autowired(required = true)
	private iLoanService loanService;
	@Autowired(required = true)
	private EmiCalculation emiCalculation;

	@PostMapping
	public ResponseEntity<Loan> applyLoan(@RequestBody Loan loan) {
		return new ResponseEntity<Loan>(loanService.applyLoan(loan), HttpStatus.OK);
	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<List<Loan>> getLoansByCustomerId(@PathVariable int id) {
		return new ResponseEntity<List<Loan>>(loanService.getLoansByCustomerId(id), HttpStatus.OK);
	}

	@DeleteMapping("/foreclose/{loanId}")
	public ResponseEntity<String> forecloseLoan(@PathVariable int loanId) {
		loanService.foreCloseLoan(loanId);
		return new ResponseEntity<String>("Loan Foreclosed with Loan Id: " + loanId, HttpStatus.OK);
	}
	@PutMapping("/emiCalculate")
	public String  calculate(@RequestBody Loan loan)
	{
//		double ans=emiCalculation.calculate(loan);
//		return " Emi for the given loan " +ans;
		return "deepika";
	}

}
