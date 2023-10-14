package com.dailydatahub.dailydatahub.domain;

import com.dailydatahub.dailydatahub.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@ToString
@Table(indexes = @Index(name = "idxSeq", columnList = "seq"))
public class CrawlJob extends BaseTimeEntity{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;

	@Column(columnDefinition = "bigint", nullable = false)
	private Long crawlSeq;

	@Column(columnDefinition = "int", nullable = false)
	private int jobOrder;

    @Column(columnDefinition = "text", nullable = false)
	private String domainUrl;

    @Column(columnDefinition = "text", nullable = false)
	private String domainUri;

    @Column(columnDefinition = "text", nullable = false)
	private String queryString;
	
    @Column(columnDefinition = "text", nullable = false)
	private String crawlType;

    @Column(columnDefinition = "text", nullable = false)
	private String linkTarget;

    @Column(columnDefinition = "text", nullable = false)
	private String info;

    @Builder
	public CrawlJob(Long seq, Long crawlSeq, int jobOrder, String domainUrl, String domainUri, String queyString, String crawlType, String linkTarget, String info) {
		this.seq = seq;
        this.crawlSeq = crawlSeq;
        this.jobOrder = jobOrder;
        this.domainUrl = domainUrl;
        this.domainUri = domainUri;
        this.queryString = queyString;
        this.crawlType = crawlType;
        this.linkTarget = linkTarget;
        this.info = info;
	}

	public CrawlJob toEntity(CrawlJob crawlJob) {
        return CrawlJob.builder()
                .crawlSeq(crawlJob.getCrawlSeq())
                .jobOrder(crawlJob.getJobOrder())
                .domainUrl(crawlJob.getDomainUrl())
                .domainUri(crawlJob.getDomainUri())
                .queyString(crawlJob.getQueryString())
                .crawlType(crawlJob.getCrawlType())
                .linkTarget(crawlJob.getLinkTarget())
                .info(crawlJob.getInfo())
				.build();
    }

	public CrawlJob toEntityUpdate(CrawlJob crawlJob) {
        return CrawlJob.builder()
                .seq(crawlJob.getSeq())
                .crawlSeq(crawlJob.getCrawlSeq())
                .jobOrder(crawlJob.getJobOrder())
                .domainUrl(crawlJob.getDomainUrl())
                .domainUri(crawlJob.getDomainUri())
                .queyString(crawlJob.getQueryString())
                .crawlType(crawlJob.getCrawlType())
                .linkTarget(crawlJob.getLinkTarget())
                .info(crawlJob.getInfo())
				.build();
    }
}
