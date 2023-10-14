package com.dailydatahub.dailydatahub.domain;

import com.dailydatahub.dailydatahub.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@ToString
@Table(indexes = @Index(name = "idxSeq", columnList = "seq"))
public class Team extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;

	@Column(columnDefinition = "text", nullable = false , length = 500)
	private String name;

	@Column(columnDefinition = "text", nullable = false , length = 500)
	private String info;

	@Builder
	public Team(Long seq, String name, String info) {
        this.seq = seq;
		this.name = name;
		this.info = info;
	}

	public Team toEntity(Team team) {
        return Team.builder()
				.name(team.getName())
				.info(team.getInfo())
				.build();
    }

	public Team toEntityUpdate(Team team) {
        return Team.builder()
				.seq(team.getSeq())
				.name(team.getName())
				.info(team.getInfo())
				.build();
    }
}