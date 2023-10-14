package com.dailydatahub.dailydatahub.domain;

import com.dailydatahub.dailydatahub.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@ToString
@Table(indexes = @Index(name = "idxSeq", columnList = "seq"))
public class SnsRaw extends BaseTimeEntity{
    
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
	private String contentRaw;

    @Column(columnDefinition = "text", nullable = false)
	private String author;

    @Column(columnDefinition = "text", nullable = false)
	private String indexStatus;

	@Builder
	public SnsRaw(Long seq, String category, String url, String urlId, String title, String contentRaw, String author, String indexStatus) {
		this.seq = seq;
        this.category = category;
        this.url = url;
        this.urlId = urlId;
        this.title = title;
        this.contentRaw = contentRaw;
        this.author = author;
        this.indexStatus = indexStatus;
	}

    public SnsRaw toEntity(SnsRaw snsRaw) {
        return SnsRaw.builder()
                .category(snsRaw.getCategory())
                .url(snsRaw.getUrl())
                .urlId(snsRaw.getUrlId())
                .title(snsRaw.getTitle())
                .contentRaw(snsRaw.getContentRaw())
                .author(snsRaw.getAuthor())
                .indexStatus(snsRaw.getIndexStatus())
				.build();
    }

     public SnsRaw toEntityUpdate(SnsRaw snsRaw) {
        return SnsRaw.builder()
                .seq(snsRaw.getSeq())
                .category(snsRaw.getCategory())
                .url(snsRaw.getUrl())
                .urlId(snsRaw.getUrlId())
                .title(snsRaw.getTitle())
                .contentRaw(snsRaw.getContentRaw())
                .author(snsRaw.getAuthor())
                .indexStatus(snsRaw.getIndexStatus())
				.build();
    }
}