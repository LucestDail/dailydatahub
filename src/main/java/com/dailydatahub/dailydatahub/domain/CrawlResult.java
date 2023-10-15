package com.dailydatahub.dailydatahub.domain;

import com.dailydatahub.dailydatahub.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@ToString
@Table(indexes = @Index(name = "idxSeq", columnList = "seq"))
public class CrawlResult extends BaseTimeEntity{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;

	@Column(columnDefinition = "bigint", nullable = false)
	private Long crawlSeq;

	@Column(columnDefinition = "int", nullable = false)
	private int jobOrder;

	@Column(columnDefinition = "text", nullable = false)
	private String crawlLink;

	@Column(columnDefinition = "text", nullable = false)
	private String result;

	@Builder
	public CrawlResult(Long seq, Long crawlSeq, int jobOrder, String crawlLink, String result) {
		this.seq = seq;
		this.crawlSeq = crawlSeq;
		this.jobOrder = jobOrder;
		this.crawlLink = crawlLink;
		this.result = result;
	}

	public CrawlResult toEntity(CrawlResult crawlResult) {
        return CrawlResult.builder()
				.crawlSeq(crawlResult.getCrawlSeq())
				.jobOrder(crawlResult.getJobOrder())
				.crawlLink(crawlResult.getCrawlLink())
				.result(crawlResult.getResult())
				.build();
    }

	public CrawlResult toEntityUpdate(CrawlResult crawlResult) {
        return CrawlResult.builder()
				.seq(crawlResult.getSeq())
				.crawlSeq(crawlResult.getCrawlSeq())
				.jobOrder(crawlResult.getJobOrder())
				.crawlLink(crawlResult.getCrawlLink())
				.result(crawlResult.getResult())
				.build();
    }
}
