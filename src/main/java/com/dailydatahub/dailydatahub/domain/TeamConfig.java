package com.dailydatahub.dailydatahub.domain;

import com.dailydatahub.dailydatahub.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@ToString
@Table(indexes = @Index(name = "idxSeq", columnList = "seq"))
public class TeamConfig extends BaseTimeEntity{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;

	@Column(columnDefinition = "bigint", nullable = false)
	private Long teamSeq;

	@Column(columnDefinition = "text", nullable = false , length = 500)
	private String morphs;

	@Builder
	public TeamConfig(Long seq, Long teamSeq, String morphs) {
		this.seq = seq;
		this.teamSeq = teamSeq;
		this.morphs = morphs;
	}

	public TeamConfig toEntity(TeamConfig teamConfig) {
        return TeamConfig.builder()
				.teamSeq(teamConfig.getTeamSeq())
				.morphs(teamConfig.getMorphs())
				.build();
    }

	public TeamConfig toEntityUpdate(TeamConfig teamConfig) {
        return TeamConfig.builder()
				.seq(teamConfig.getSeq())
				.teamSeq(teamConfig.getTeamSeq())
				.morphs(teamConfig.getMorphs())
				.build();
    }
}

