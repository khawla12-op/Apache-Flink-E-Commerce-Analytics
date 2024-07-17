package Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
@Data
@AllArgsConstructor   //To pass them as arguments
public class SalesPerCategory {

    private Date transactionDate;
    private String category;
    private double totalSales;
}
