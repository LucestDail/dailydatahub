package com.dailydatahub.dailydatahub.domain;

import com.dailydatahub.dailydatahub.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@ToString
@Table(indexes = @Index(name = "idxSeq", columnList = "seq"))
public class MainNotice extends BaseTimeEntity{
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;

	@Column(columnDefinition = "text", nullable = false)
	private String title;

	@Column(columnDefinition = "LONGTEXT")
	private String content;

    @Column(columnDefinition = "text", nullable = false)
	private String author;

	@Builder
	public MainNotice(Long seq, String title, String content, String author) {
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.author = author;
	}

    public MainNotice toEntity(MainNotice mainNotice) {
        return MainNotice.builder()
				.title(mainNotice.getTitle())
				.content(mainNotice.getContent())
				.author(mainNotice.getAuthor())
				.build();
    }

	public MainNotice toEntityUpdate(MainNotice mainNotice) {
        return MainNotice.builder()
				.seq(mainNotice.getSeq())
				.title(mainNotice.getTitle())
				.content(mainNotice.getContent())
				.author(mainNotice.getAuthor())
				.build();
    }
}
