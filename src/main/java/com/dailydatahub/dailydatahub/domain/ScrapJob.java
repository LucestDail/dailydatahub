package com.dailydatahub.dailydatahub.domain;

import com.dailydatahub.dailydatahub.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@ToString
@Table(indexes = @Index(name = "idxSeq", columnList = "seq"))
public class ScrapJob extends BaseTimeEntity{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;

	@Column(columnDefinition = "bigint", nullable = false)
	private Long scrapSeq;

	@Column(columnDefinition = "int", nullable = false)
	private int jobOrder;

    @Column(columnDefinition = "text", nullable = false)
	private String domainUrl;

    @Column(columnDefinition = "text", nullable = false)
	private String domainUri;

    @Column(columnDefinition = "text", nullable = false)
	private String queryString;
	
    @Column(columnDefinition = "text", nullable = false)
	private String scrapType;

    @Column(columnDefinition = "text", nullable = true)
	private String titleElement;

    @Column(columnDefinition = "text", nullable = true)
	private String titleXpath;

    @Column(columnDefinition = "text", nullable = true)
	private String contentElement;

    @Column(columnDefinition = "text", nullable = true)
	private String contentXpath;

    @Column(columnDefinition = "text", nullable = true)
	private String authorElement;

    @Column(columnDefinition = "text", nullable = true)
	private String authorXpath;

    @Column(columnDefinition = "text", nullable = true)
	private String dateElement;

    @Column(columnDefinition = "text", nullable = true)
	private String dateXpath;

    @Column(columnDefinition = "text", nullable = false)
	private String info;

    @Builder
	public ScrapJob(Long seq, Long scrapSeq, int jobOrder, String domainUrl, String domainUri
                    , String queyString, String scrapType, String titleElement, String titleXpath
                    , String contentElement, String contentXpath, String authorElement, String authorXpath
                    , String dateElement, String dateXpath, String info) {
        this.seq = seq;
        this.scrapSeq = scrapSeq;
        this.jobOrder = jobOrder;
        this.domainUrl = domainUrl;
        this.domainUri = domainUri;
        this.queryString = queyString;
        this.scrapType = scrapType;
        this.titleElement = titleElement;
        this.titleXpath = titleXpath;
        this.contentElement = contentElement;
        this.contentXpath = contentXpath;
        this.authorElement = authorElement;
        this.authorXpath = authorXpath;
        this.dateElement = dateElement;
        this.dateXpath = dateXpath;
        this.info = info;
	}

	public ScrapJob toEntity(ScrapJob scrapJob) {
        return ScrapJob.builder()
                .scrapSeq(scrapJob.getScrapSeq())
                .jobOrder(scrapJob.getJobOrder())
                .domainUrl(scrapJob.getDomainUrl())
                .domainUri(scrapJob.getDomainUri())
                .queyString(scrapJob.getQueryString())
                .scrapType(scrapJob.getScrapType())
                .titleElement(scrapJob.getTitleElement())
                .titleXpath(scrapJob.getTitleXpath())
                .contentElement(scrapJob.getContentElement())
                .contentXpath(scrapJob.getContentXpath())
                .authorElement(scrapJob.getAuthorElement())
                .authorXpath(scrapJob.getAuthorXpath())
                .dateElement(scrapJob.getDateElement())
                .dateXpath(scrapJob.getDateXpath())
                .info(scrapJob.getInfo())
				.build();
    }

	public ScrapJob toEntityUpdate(ScrapJob scrapJob) {
        return ScrapJob.builder()
                .seq(scrapJob.getSeq())
                .scrapSeq(scrapJob.getScrapSeq())
                .jobOrder(scrapJob.getJobOrder())
                .domainUrl(scrapJob.getDomainUrl())
                .domainUri(scrapJob.getDomainUri())
                .queyString(scrapJob.getQueryString())
                .scrapType(scrapJob.getScrapType())
                .titleElement(scrapJob.getTitleElement())
                .titleXpath(scrapJob.getTitleXpath())
                .contentElement(scrapJob.getContentElement())
                .contentXpath(scrapJob.getContentXpath())
                .authorElement(scrapJob.getAuthorElement())
                .authorXpath(scrapJob.getAuthorXpath())
                .dateElement(scrapJob.getDateElement())
                .dateXpath(scrapJob.getDateXpath())
                .info(scrapJob.getInfo())
				.build();
    }
}
