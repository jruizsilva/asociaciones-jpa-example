package asociaciones.asociaciones.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "football_associations")
public class FootballAssociationEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(nullable = false)
  private String name;
  private String country;
  @Column(name = "president_name")
  private String presidentName;

  @OneToMany(targetEntity = ClubEntity.class, fetch = FetchType.LAZY, mappedBy = "footballAssociation")
  private List<ClubEntity> club;
}
