package asociaciones.asociaciones.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "clubs")
public class ClubEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(nullable = false)
  private String name;

  @OneToOne(targetEntity = CoachEntity.class, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "id_coach")
  private CoachEntity coach;

  @OneToMany(targetEntity = PlayerEntity.class, fetch = FetchType.LAZY, mappedBy = "club")
  private List<PlayerEntity> players;

  @ManyToOne(targetEntity = FootballAssociationEntity.class)
  private FootballAssociationEntity footballAssociation;

  @ManyToMany(targetEntity = FootballCompetition.class, fetch = FetchType.LAZY)
  @JoinTable(name = "club_competitions", joinColumns = @JoinColumn(name = "club"), inverseJoinColumns = @JoinColumn(name = "competition"))
  private List<FootballCompetition> footballCompetitions;
}
