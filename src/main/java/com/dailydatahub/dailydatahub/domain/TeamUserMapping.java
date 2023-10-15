package com.dailydatahub.dailydatahub.domain;

import com.dailydatahub.dailydatahub.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@ToString
@Table(indexes = @Index(name = "idxSeq", columnList = "seq"))
public class TeamUserMapping extends BaseTimeEntity{
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;
	
	@Column(columnDefinition = "bigint", nullable = false)
	private Long teamSeq;
	
	@Column(columnDefinition = "bigint", nullable = false)
	private Long userSeq;

	@Column(columnDefinition = "text", nullable = false , length = 500)
	private String rank;
	
	@Builder
	public TeamUserMapping(Long seq, Long teamSeq, Long userSeq, String rank) {
		this.seq = seq;
		this.teamSeq = teamSeq;
		this.userSeq = userSeq;
		this.rank = rank;
	}

	public TeamUserMapping toEntity(TeamUserMapping teamUserMapping) {
        return TeamUserMapping.builder()
				.teamSeq(teamUserMapping.getTeamSeq())
				.userSeq(teamUserMapping.getUserSeq())
				.rank(teamUserMapping.getRank())
				.build();
    }

	public TeamUserMapping toEntityUpdate(TeamUserMapping teamUserMapping) {
        return TeamUserMapping.builder()
				.seq(teamUserMapping.getSeq())
				.teamSeq(teamUserMapping.getTeamSeq())
				.userSeq(teamUserMapping.getUserSeq())
				.rank(teamUserMapping.getRank())
				.build();
    }
}
