package com.dailydatahub.dailydatahub.domain;

import com.dailydatahub.dailydatahub.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@ToString
@Table(indexes = @Index(name = "idxSeq", columnList = "seq"))
public class Crawl extends BaseTimeEntity{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;

	@Column(columnDefinition = "text", nullable = false)
	private String categoryCode;

	@Column(columnDefinition = "text", nullable = false)
	private String info;

	@Builder
	public Crawl(Long seq, String categoryCode, String info) {
		this.seq = seq;
		this.categoryCode = categoryCode;
		this.info = info;
	}

	public Crawl toEntity(Crawl crawl) {
        return Crawl.builder()
				.categoryCode(crawl.getCategoryCode())
				.info(crawl.getInfo())
				.build();
    }

	public Crawl toEntityUpdate(Crawl crawl) {
        return Crawl.builder()
				.seq(crawl.getSeq())
				.categoryCode(crawl.getCategoryCode())
				.info(crawl.getInfo())
				.build();
    }
}
