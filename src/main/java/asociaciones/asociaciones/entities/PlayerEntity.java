package asociaciones.asociaciones.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "players")
public class PlayerEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(nullable = false)
  private String name;
  @Column(name = "last_name")
  private String lastNameprivate;
  private String nationality;
  private Integer age;
  private String position;

  @ManyToOne(targetEntity = ClubEntity.class)
  private ClubEntity club;
}
