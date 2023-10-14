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

	@Column(columnDefinition = "text", nullable = false , length = 500)
	private String configType;

	@Column(columnDefinition = "text", nullable = false , length = 500)
	private String configTarget;

	@Builder
	public TeamConfig(Long seq, String configType, String configTarget) {
		this.seq = seq;
		this.configType = configType;
		this.configTarget = configTarget;
	}

	public TeamConfig toEntity(TeamConfig teamConfig) {
        return TeamConfig.builder()
				.configType(teamConfig.getConfigType())
				.configTarget(teamConfig.getConfigTarget())
				.build();
    }

	public TeamConfig toEntityUpdate(TeamConfig teamConfig) {
        return TeamConfig.builder()
				.seq(teamConfig.getSeq())
				.configType(teamConfig.getConfigType())
				.configTarget(teamConfig.getConfigTarget())
				.build();
    }
}

