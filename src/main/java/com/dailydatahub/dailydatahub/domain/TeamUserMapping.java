package com.dailydatahub.dailydatahub.domain;

import com.dailydatahub.dailydatahub.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@ToString
@Table(indexes = @Index(name = "idxSeq", columnList = "seq"))
public class TeamUserMapping extends BaseTimeEntity{
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;
	
	@NonNull
	private Long teamSeq;
	
	@NonNull
	private Long userSeq;
	
	@Builder
	public TeamUserMapping(Long seq, Long teamSeq, Long userSeq) {
		this.seq = seq;
		this.teamSeq = teamSeq;
		this.userSeq = userSeq;
	}
}
