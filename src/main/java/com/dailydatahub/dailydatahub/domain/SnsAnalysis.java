package com.dailydatahub.dailydatahub.domain;

import com.dailydatahub.dailydatahub.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@ToString
@Table(indexes = @Index(name = "idxSeq", columnList = "seq"))
public class SnsAnalysis extends BaseTimeEntity{
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;
	
    @Column(columnDefinition = "text", nullable = false)
	private String category;

    @Column(columnDefinition = "text", nullable = false)
	private String url;

    @Column(columnDefinition = "text", nullable = false)
	private String urlId;

    @Column(columnDefinition = "text", nullable = false)
	private String title;

	@Column(columnDefinition = "LONGTEXT")
	private String contentAnalysis;

    @Column(columnDefinition = "text", nullable = false)
	private String author;

    @Column(columnDefinition = "text", nullable = false)
	private String indexStatus;

	@Builder
	public SnsAnalysis(Long seq, String category, String url, String urlId, String title, String contentAnalysis, String author, String indexStatus) {
		this.seq = seq;
        this.category = category;
        this.url = url;
        this.urlId = urlId;
        this.title = title;
        this.contentAnalysis = contentAnalysis;
        this.author = author;
        this.indexStatus = indexStatus;
	}

    public SnsAnalysis toEntity(SnsAnalysis snsAnalysis) {
        return SnsAnalysis.builder()
                .category(snsAnalysis.getCategory())
                .url(snsAnalysis.getUrl())
                .urlId(snsAnalysis.getUrlId())
                .title(snsAnalysis.getTitle())
                .contentAnalysis(snsAnalysis.getContentAnalysis())
                .author(snsAnalysis.getAuthor())
                .indexStatus(snsAnalysis.getIndexStatus())
				.build();
    }

    public SnsAnalysis toEntityUpdate(SnsAnalysis snsAnalysis) {
        return SnsAnalysis.builder()
                .seq(snsAnalysis.getSeq())
                .category(snsAnalysis.getCategory())
                .url(snsAnalysis.getUrl())
                .urlId(snsAnalysis.getUrlId())
                .title(snsAnalysis.getTitle())
                .contentAnalysis(snsAnalysis.getContentAnalysis())
                .author(snsAnalysis.getAuthor())
                .indexStatus(snsAnalysis.getIndexStatus())
				.build();
    }
}
