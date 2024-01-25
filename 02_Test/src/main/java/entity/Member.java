package entity;

import com.khit.board.dto.MemberDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "table_member")
@Entity
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String username;

	@Column(nullable = false)
	private String password;

	@Column
	private String email;

	public static Member toSaveEntity(MemberDTO memberDTO) {
		Member member = new Member();
		member.setMemberUsername(memberDTO.getMemberUsername());
		member.setMemberPassword(memberDTO.getMemberPassword());
		member.setMemberEmail(memberDTO.getMemberEmail());
		
		return member;
	}
}

