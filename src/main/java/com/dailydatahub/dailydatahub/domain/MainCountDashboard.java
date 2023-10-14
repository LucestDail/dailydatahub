package com.dailydatahub.dailydatahub.domain;

import com.dailydatahub.dailydatahub.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@ToString
@Table(indexes = @Index(name = "idxSeq", columnList = "seq"))
public class MainCountDashboard extends BaseTimeEntity{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;

	@Column(columnDefinition = "text", nullable = false)
	private String category;

	@Column(columnDefinition = "int", nullable = false)
	private int totalSnsCount;

	@Column(columnDefinition = "int", nullable = false)
	private int totalSnsAnalysisCount;

	@Column(columnDefinition = "int", nullable = false)
	private int totalSnsAnalysisRatio;

	@Column(columnDefinition = "int", nullable = false)
	private int todaySnsCount;

	@Column(columnDefinition = "int", nullable = false)
	private int todaySnsAnalysisCount;

	@Column(columnDefinition = "int", nullable = false)
	private int todaySnsAnalysisRatio;

	@Builder
	public MainCountDashboard(Long seq, String category, int totalSnsCount, int totalSnsAnalysisCount, int totalSnsAnalysisRatio, int todaySnsCount, int todaySnsAnalysisCount, int todaySnsAnalysisRatio) {
		this.seq = seq;
		this.category = category;
		this.totalSnsCount = totalSnsCount;
		this.totalSnsAnalysisCount = todaySnsAnalysisCount;
		this.todaySnsAnalysisRatio = todaySnsAnalysisRatio;
		this.todaySnsCount = todaySnsCount;
		this.todaySnsAnalysisCount = todaySnsAnalysisCount;
		this.todaySnsAnalysisRatio = todaySnsAnalysisRatio;
	}

	public MainCountDashboard toEntity(MainCountDashboard mainCountDashboard) {
        return MainCountDashboard.builder()
				.category(mainCountDashboard.getCategory())
				.totalSnsCount(mainCountDashboard.getTotalSnsCount())
				.totalSnsAnalysisCount(mainCountDashboard.getTotalSnsAnalysisCount())
				.totalSnsAnalysisRatio(mainCountDashboard.getTotalSnsAnalysisRatio())
				.todaySnsCount(mainCountDashboard.getTodaySnsCount())
				.todaySnsAnalysisCount(mainCountDashboard.getTodaySnsAnalysisCount())
				.todaySnsAnalysisRatio(mainCountDashboard.getTodaySnsAnalysisRatio())
				.build();
    }

	public MainCountDashboard toEntityUpdate(MainCountDashboard mainCountDashboard) {
        return MainCountDashboard.builder()
				.seq(mainCountDashboard.getSeq())
				.category(mainCountDashboard.getCategory())
				.totalSnsCount(mainCountDashboard.getTotalSnsCount())
				.totalSnsAnalysisCount(mainCountDashboard.getTotalSnsAnalysisCount())
				.totalSnsAnalysisRatio(mainCountDashboard.getTotalSnsAnalysisRatio())
				.todaySnsCount(mainCountDashboard.getTodaySnsCount())
				.todaySnsAnalysisCount(mainCountDashboard.getTodaySnsAnalysisCount())
				.todaySnsAnalysisRatio(mainCountDashboard.getTodaySnsAnalysisRatio())
				.build();
    }
}
