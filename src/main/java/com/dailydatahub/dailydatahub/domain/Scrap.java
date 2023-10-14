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

	@Column(columnDefinition = "text", nullable = false)
	private String categoryCode;

	@Column(columnDefinition = "text", nullable = false)
	private String info;

	@Builder
	public Scrap(Long seq, String categoryCode, String info) {
		this.seq = seq;
		this.categoryCode = categoryCode;
		this.info = info;
	}

	public Scrap toEntity(Scrap scrap) {
        return Scrap.builder()
				.categoryCode(scrap.getCategoryCode())
				.info(scrap.getInfo())
				.build();
    }

	public Scrap toEntityUpdate(Scrap scrap) {
        return Scrap.builder()
				.seq(scrap.getSeq())
				.categoryCode(scrap.getCategoryCode())
				.info(scrap.getInfo())
				.build();
    }
}
