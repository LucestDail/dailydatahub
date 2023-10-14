package com.dailydatahub.dailydatahub.domain;

import com.dailydatahub.dailydatahub.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@ToString
@Table(indexes = @Index(name = "idxSeq", columnList = "seq"))
public class UserConfig extends BaseTimeEntity{
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;

	@Column(columnDefinition = "text", nullable = false , length = 500)
	private String configType;

	@Column(columnDefinition = "text", nullable = false , length = 500)
	private String configTarget;

	@Builder
	public UserConfig(Long seq, String configType, String configTarget) {
		this.seq = seq;
		this.configType = configType;
		this.configTarget = configTarget;
	}

	public UserConfig toEntity(UserConfig userConfig) {
        return UserConfig.builder()
				.configType(userConfig.getConfigType())
				.configTarget(userConfig.getConfigTarget())
				.build();
    }

	public UserConfig toEntityUpdate(UserConfig userConfig) {
        return UserConfig.builder()
				.seq(userConfig.getSeq())
				.configType(userConfig.getConfigType())
				.configTarget(userConfig.getConfigTarget())
				.build();
    }
}
