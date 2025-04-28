package uz.codeby.queue.day;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;
import uz.codeby.queue.utils.TableName;

import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = TableName.DAYS)
public class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private Integer status;
    @CreationTimestamp(source = SourceType.DB)
    private Date createdAt;
    @UpdateTimestamp(source = SourceType.DB)
    private Date updatedAt;
}
