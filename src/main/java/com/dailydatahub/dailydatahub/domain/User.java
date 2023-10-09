package com.dailydatahub.dailydatahub.domain;


import com.dailydatahub.dailydatahub.util.BaseTimeEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@ToString
public class User extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberSeq;

	@Column(length = 500)
	@NonNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@Column(length = 500)
	@NonNull
	private String password;

	@Column(length = 500)
	@NonNull
	private String name;

	@Column(length = 500)
	@NonNull
	private String team;
	
	@Column(length = 500)
	@NonNull
	private String info;

	@Builder
	public User(Long memberSeq, String id, String password, String name, String team, String info) {
		this.memberSeq = memberSeq;
		this.id = id;
		this.password = password;
		this.name = name;
		this.team = team;
		this.info = info;
	}
}