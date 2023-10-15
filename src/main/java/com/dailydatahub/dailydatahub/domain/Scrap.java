package com.dailydatahub.dailydatahub.domain;

import com.dailydatahub.dailydatahub.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@ToString
@Table(indexes = @Index(name = "idxSeq", columnList = "seq"))
public class Scrap extends BaseTimeEntity{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;

	@Column(columnDefinition = "bigint", nullable = false)
	private Long crawlSeq;

	@Column(columnDefinition = "text", nullable = false)
	private String categoryCode;

	@Column(columnDefinition = "text", nullable = false)
	private String info;

	@Builder
	public Scrap(Long seq, Long crawlSeq, String categoryCode, String info) {
		this.seq = seq;
		this.crawlSeq = crawlSeq;
		this.categoryCode = categoryCode;
		this.info = info;
	}

	public Scrap toEntity(Scrap scrap) {
        return Scrap.builder()
				.crawlSeq(scrap.getCrawlSeq())
				.categoryCode(scrap.getCategoryCode())
				.info(scrap.getInfo())
				.build();
    }

	public Scrap toEntityUpdate(Scrap scrap) {
        return Scrap.builder()
				.seq(scrap.getSeq())
				.crawlSeq(scrap.getCrawlSeq())
				.categoryCode(scrap.getCategoryCode())
				.info(scrap.getInfo())
				.build();
    }
}
