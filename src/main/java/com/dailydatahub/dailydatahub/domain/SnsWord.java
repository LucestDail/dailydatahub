package com.dailydatahub.dailydatahub.domain;

import com.dailydatahub.dailydatahub.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@ToString
@Table(indexes = @Index(name = "idxSeq", columnList = "seq"))
public class SnsWord extends BaseTimeEntity{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;

    @Column(columnDefinition = "bigint", nullable = false)
	private Long snsSeq;
	
    @Column(columnDefinition = "text", nullable = false)
	private String word;

    @Column(columnDefinition = "int", nullable = false)
	private int wordCount;

	@Builder
	public SnsWord(Long seq, Long snsSeq, String word, int wordCount) {
        this.seq = seq;
        this.snsSeq = snsSeq;
        this.word = word;
        this.wordCount = wordCount;
	}

    public SnsWord toEntity(SnsWord snsWord) {
        return SnsWord.builder()
                .snsSeq(snsWord.getSnsSeq())
                .word(snsWord.getWord())
                .wordCount(snsWord.getWordCount())
				.build();
    }

    public SnsWord toEntityUpdate(SnsWord snsWord) {
        return SnsWord.builder()
                .seq(snsWord.getSeq())
                .snsSeq(snsWord.getSnsSeq())
                .word(snsWord.getWord())
                .wordCount(snsWord.getWordCount())
				.build();
    }
}
