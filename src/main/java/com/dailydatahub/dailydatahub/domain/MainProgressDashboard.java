package com.dailydatahub.dailydatahub.domain;

import com.dailydatahub.dailydatahub.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@ToString
@Table(indexes = @Index(name = "idxSeq", columnList = "seq"))
public class MainProgressDashboard extends BaseTimeEntity{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;

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
	public MainProgressDashboard(Long seq, int totalSnsCount, int totalSnsAnalysisCount, int totalSnsAnalysisRatio, int todaySnsCount, int todaySnsAnalysisCount, int todaySnsAnalysisRatio) {
		this.seq = seq;
		this.totalSnsCount = totalSnsCount;
		this.totalSnsAnalysisCount = todaySnsAnalysisCount;
		this.todaySnsAnalysisRatio = todaySnsAnalysisRatio;
		this.todaySnsCount = todaySnsCount;
		this.todaySnsAnalysisCount = todaySnsAnalysisCount;
		this.todaySnsAnalysisRatio = todaySnsAnalysisRatio;
	}

	public MainProgressDashboard toEntity(MainProgressDashboard mainProgressDashboard) {
        return MainProgressDashboard.builder()
				.totalSnsCount(mainProgressDashboard.getTotalSnsCount())
				.totalSnsAnalysisCount(mainProgressDashboard.getTotalSnsAnalysisCount())
				.totalSnsAnalysisRatio(mainProgressDashboard.getTotalSnsAnalysisRatio())
				.todaySnsCount(mainProgressDashboard.getTodaySnsCount())
				.todaySnsAnalysisCount(mainProgressDashboard.getTodaySnsAnalysisCount())
				.todaySnsAnalysisRatio(mainProgressDashboard.getTodaySnsAnalysisRatio())
				.build();
    }

	public MainProgressDashboard toEntityUpdate(MainProgressDashboard mainProgressDashboard) {
        return MainProgressDashboard.builder()
				.seq(mainProgressDashboard.getSeq())
				.totalSnsCount(mainProgressDashboard.getTotalSnsCount())
				.totalSnsAnalysisCount(mainProgressDashboard.getTotalSnsAnalysisCount())
				.totalSnsAnalysisRatio(mainProgressDashboard.getTotalSnsAnalysisRatio())
				.todaySnsCount(mainProgressDashboard.getTodaySnsCount())
				.todaySnsAnalysisCount(mainProgressDashboard.getTodaySnsAnalysisCount())
				.todaySnsAnalysisRatio(mainProgressDashboard.getTodaySnsAnalysisRatio())
				.build();
    }
}
