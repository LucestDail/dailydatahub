package com.dailydatahub.dailydatahub.domain;

import com.dailydatahub.dailydatahub.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@ToString
@Table(indexes = @Index(name = "idxSeq", columnList = "seq"))
public class Category extends BaseTimeEntity{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;

	@Column(columnDefinition = "text", nullable = false)
	private String categoryCode;

	@Column(columnDefinition = "text", nullable = false)
	private String categoryName;

	@Column(columnDefinition = "text", nullable = false)
	private String categoryInfo;

	@Builder
	public Category(Long seq, String categoryCode, String categoryName, String categoryInfo) {
	}

	public Category toEntity(Category category) {
        return Category.builder()
				.categoryCode(category.getCategoryCode())
				.categoryName(category.getCategoryName())
				.categoryInfo(category.getCategoryInfo())
				.build();
    }

	public Category toEntityUpdate(Category category) {
        return Category.builder()
				.seq(category.getSeq())
				.categoryCode(category.getCategoryCode())
				.categoryName(category.getCategoryName())
				.categoryInfo(category.getCategoryInfo())
				.build();
    }
}
