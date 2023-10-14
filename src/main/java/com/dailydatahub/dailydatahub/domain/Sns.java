package com.dailydatahub.dailydatahub.domain;

import com.dailydatahub.dailydatahub.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@ToString
@Table(indexes = @Index(name = "idxSeq", columnList = "seq"))
public class Sns extends BaseTimeEntity{

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
	private String content;

    @Column(columnDefinition = "text", nullable = false)
	private String author;

    @Column(columnDefinition = "text", nullable = false)
	private String indexStatus;

	@Builder
	public Sns(Long seq, String category, String url, String urlId, String title, String content, String author, String indexStatus) {
		this.seq = seq;
        this.category = category;
        this.url = url;
        this.urlId = urlId;
        this.title = title;
        this.content = content;
        this.author = author;
        this.indexStatus = indexStatus;
	}

    public Sns toEntity(Sns sns) {
        return Sns.builder()
                .category(sns.getCategory())
                .url(sns.getUrl())
                .urlId(sns.getUrlId())
                .title(sns.getTitle())
                .content(sns.getContent())
                .author(sns.getAuthor())
                .indexStatus(sns.getIndexStatus())
				.build();
    }

    public Sns toEntityUpdate(Sns sns) {
        return Sns.builder()
                .seq(sns.getSeq())
                .category(sns.getCategory())
                .url(sns.getUrl())
                .urlId(sns.getUrlId())
                .title(sns.getTitle())
                .content(sns.getContent())
                .author(sns.getAuthor())
                .indexStatus(sns.getIndexStatus())
				.build();
    }
}
