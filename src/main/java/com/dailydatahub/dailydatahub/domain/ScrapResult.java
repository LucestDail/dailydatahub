package com.dailydatahub.dailydatahub.domain;

import com.dailydatahub.dailydatahub.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@ToString
@Table(indexes = @Index(name = "idxSeq", columnList = "seq"))
public class ScrapResult extends BaseTimeEntity{
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;

	@Column(columnDefinition = "bigint", nullable = false)
	private Long scrapSeq;

	@Column(columnDefinition = "int", nullable = false)
	private int jobOrder;

	@Column(columnDefinition = "text", nullable = false)
	private String result;

	@Builder
	public ScrapResult(Long seq, Long scrapSeq, int jobOrder, String result) {
		this.seq = seq;
		this.scrapSeq = scrapSeq;
		this.jobOrder = jobOrder;
		this.result = result;
	}

	public ScrapResult toEntity(ScrapResult scrapResult) {
        return ScrapResult.builder()
				.scrapSeq(scrapResult.getScrapSeq())
				.jobOrder(scrapResult.getJobOrder())
				.result(scrapResult.getResult())
				.build();
    }

	public ScrapResult toEntityUpdate(ScrapResult scrapResult) {
        return ScrapResult.builder()
				.seq(scrapResult.getSeq())
				.scrapSeq(scrapResult.getScrapSeq())
				.jobOrder(scrapResult.getJobOrder())
				.result(scrapResult.getResult())
				.build();
    }
}
