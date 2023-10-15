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

	@Column(columnDefinition = "bigint", nullable = false)
	private Long userSeq;

	@Column(columnDefinition = "text", nullable = false , length = 500)
	private String categoryCode;

	@Column(columnDefinition = "text", nullable = false , length = 500)
	private String morphs;

	@Column(columnDefinition = "text", nullable = false , length = 500)
	private String info;

	@Builder
	public UserConfig(Long seq, Long userSeq, String categoryCode, String morphs, String info) {
		this.seq = seq;
		this.userSeq = userSeq;
		this.categoryCode = categoryCode;
		this.morphs = morphs;
		this.info = info;
	}

	public UserConfig toEntity(UserConfig userConfig) {
        return UserConfig.builder()
				.userSeq(userConfig.getUserSeq())
				.categoryCode(userConfig.getCategoryCode())
				.morphs(userConfig.getMorphs())
				.info(userConfig.getInfo())
				.build();
    }

	public UserConfig toEntityUpdate(UserConfig userConfig) {
        return UserConfig.builder()
				.seq(userConfig.getSeq())
				.userSeq(userConfig.getUserSeq())
				.categoryCode(userConfig.getCategoryCode())
				.morphs(userConfig.getMorphs())
				.info(userConfig.getInfo())
				.build();
    }
}
