package asociaciones.asociaciones.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "football_competitions")
public class FootballCompetition {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(50)")
  private String name;
  @Column(name = "quantity_price", length = 10, nullable = false)
  private Integer quantityPrice;
  @Column(name = "start_date", columnDefinition = "DATE")
  private LocalDate startDate;
  @Column(name = "end_date", columnDefinition = "DATE")
  private LocalDate endDate;
}
