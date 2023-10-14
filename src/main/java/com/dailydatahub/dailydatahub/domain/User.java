package com.dailydatahub.dailydatahub.domain;

import com.dailydatahub.dailydatahub.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@ToString
@Table(indexes = @Index(name = "idxSeq", columnList = "seq"))
public class User extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;

	@Column(columnDefinition = "text", nullable = false , length = 500)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@Column(columnDefinition = "text", nullable = false , length = 500)
	private String password;

	@Column(columnDefinition = "text", nullable = false , length = 500)
	private String name;

	@Column(columnDefinition = "text", nullable = false , length = 500)
	private String teamSeq;
	
	@Column(columnDefinition = "text", nullable = false , length = 500)
	private String info;

	@Builder
	public User(Long seq, String id, String password, String name, String teamSeq, String info) {
		this.seq = seq;
		this.id = id;
		this.password = password;
		this.name = name;
		this.teamSeq = teamSeq;
		this.info = info;
	}

	public User toEntity(User user) {
        return User.builder()
				.id(user.getId())
				.password(user.getPassword())
				.name(user.getName())
				.teamSeq(user.getTeamSeq())
				.info(user.getInfo())
				.build();
    }

	public User toEntityUpdate(User user) {
        return User.builder()
				.seq(user.getSeq())
				.id(user.getId())
				.password(user.getPassword())
				.name(user.getName())
				.teamSeq(user.getTeamSeq())
				.info(user.getInfo())
				.build();
    }
}