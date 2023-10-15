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
	private String info;

	@Column(columnDefinition = "text", nullable = false , length = 500)
	private String email;

	@Builder
	public User(Long seq, String id, String password, String name, String info, String email) {
		this.seq = seq;
		this.id = id;
		this.password = password;
		this.name = name;
		this.info = info;
		this.email = email;
	}

	public User toEntity(User user) {
        return User.builder()
				.id(user.getId())
				.password(user.getPassword())
				.name(user.getName())
				.info(user.getInfo())
				.email(user.getEmail())
				.build();
    }

	public User toEntityUpdate(User user) {
        return User.builder()
				.seq(user.getSeq())
				.id(user.getId())
				.password(user.getPassword())
				.name(user.getName())
				.info(user.getInfo())
				.email(user.getEmail())
				.build();
    }
}