package com.dailydatahub.dailydatahub.domain;

import com.dailydatahub.dailydatahub.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@ToString
@Table(indexes = @Index(name = "idxSeq", columnList = "seq"))
public class CrawlExcluded extends BaseTimeEntity{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;

	@Column(columnDefinition = "text", nullable = false , length = 500)
	private String excludeType;

	@Column(columnDefinition = "text", nullable = false , length = 500)
	private String excludeTarget;

	@Builder
	public CrawlExcluded(Long seq, String excludeType, String excludeTarget) {
		this.seq = seq;
		this.excludeType = excludeType;
		this.excludeTarget = excludeTarget;
	}

	public CrawlExcluded toEntity(CrawlExcluded crawlExcluded) {
        return CrawlExcluded.builder()
				.excludeType(crawlExcluded.getExcludeType())
				.excludeTarget(crawlExcluded.getExcludeTarget())
				.build();
    }

	public CrawlExcluded toEntityUpdate(CrawlExcluded crawlExcluded) {
        return CrawlExcluded.builder()
				.seq(crawlExcluded.getSeq())
				.excludeType(crawlExcluded.getExcludeType())
				.excludeTarget(crawlExcluded.getExcludeTarget())
				.build();
    }
}
