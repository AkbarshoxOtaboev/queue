package uz.codeby.queue.customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerStatusDTO {
    private Integer waiting;
    private Integer beingServed;
    private Integer served;
    private Integer rejected;
}
