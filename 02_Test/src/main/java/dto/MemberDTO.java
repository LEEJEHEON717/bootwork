package dto;

import com.khit.board.entity.Member;

import lombok.Data;

@Data
public class MemberDTO {
	private Long id;
	private String memberName;
	private String memberPassword;
	private String memberEmail;
	
	public static MemberDTO toSaveDTO(Member member) {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(member.getId());
		memberDTO.setMemberName(member.getMemberName());
		memberDTO.setMemberPassword(member.getMemberPassword());
		memberDTO.setMemberEmail(member.getMemberEmail());
				
		return memberDTO;
	}	
}
