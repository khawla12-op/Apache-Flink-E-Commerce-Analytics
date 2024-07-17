package Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SalesPerMonth {
    private int month;
    private int year;
    private double totalSales;
}
