package com.dailydatahub.dailydatahub.domain;

import com.dailydatahub.dailydatahub.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@ToString
@Table(indexes = @Index(name = "idxSeq", columnList = "seq"))
public class ScrapExcluded extends BaseTimeEntity{
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;

	@Column(columnDefinition = "text", nullable = false , length = 500)
	private String excludeType;

	@Column(columnDefinition = "text", nullable = false , length = 500)
	private String excludeTarget;

	@Builder
	public ScrapExcluded(Long seq, String excludeType, String excludeTarget) {
		this.seq = seq;
		this.excludeType = excludeType;
		this.excludeTarget = excludeTarget;
	}

	public ScrapExcluded toEntity(ScrapExcluded scrapExcluded) {
        return ScrapExcluded.builder()
				.excludeType(scrapExcluded.getExcludeType())
				.excludeTarget(scrapExcluded.getExcludeTarget())
				.build();
    }

	public ScrapExcluded toEntityUpdate(ScrapExcluded scrapExcluded) {
        return ScrapExcluded.builder()
				.seq(scrapExcluded.getSeq())
				.excludeType(scrapExcluded.getExcludeType())
				.excludeTarget(scrapExcluded.getExcludeTarget())
				.build();
    }
}
