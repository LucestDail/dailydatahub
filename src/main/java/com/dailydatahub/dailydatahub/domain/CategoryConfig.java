package com.dailydatahub.dailydatahub.domain;

import com.dailydatahub.dailydatahub.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@ToString
@Table(indexes = @Index(name = "idxSeq", columnList = "seq"))
public class CategoryConfig extends BaseTimeEntity{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;

	@Column(columnDefinition = "text", nullable = false , length = 500)
	private String configType;

	@Column(columnDefinition = "text", nullable = false , length = 500)
	private String configTarget;

	@Builder
	public CategoryConfig(Long seq, String configType, String configTarget) {
		this.seq = seq;
		this.configType = configType;
		this.configTarget = configTarget;
	}

	public CategoryConfig toEntity(CategoryConfig categoryConfig) {
        return CategoryConfig.builder()
				.configType(categoryConfig.getConfigType())
				.configTarget(categoryConfig.getConfigTarget())
				.build();
    }

	public CategoryConfig toEntityUpdate(CategoryConfig categoryConfig) {
        return CategoryConfig.builder()
				.seq(categoryConfig.getSeq())
				.configType(categoryConfig.getConfigType())
				.configTarget(categoryConfig.getConfigTarget())
				.build();
    }
}
