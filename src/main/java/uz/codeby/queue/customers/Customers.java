package uz.codeby.queue.customers;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;
import uz.codeby.queue.utils.TableName;

import java.time.LocalDate;
import java.util.Date;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = TableName.CUSTOMERS)
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer ticket;
    private Integer logStatus;
    private Integer status;
    @CreationTimestamp(source = SourceType.DB)
    private Date createdAt;
    @UpdateTimestamp(source = SourceType.DB)
    private Date updatedAt;
}
