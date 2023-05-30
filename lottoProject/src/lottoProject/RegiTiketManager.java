package lottoProject;

import java.util.Map;
import java.util.Set;

public class RegiTiketManager {
	LottoPaper lottopaper = new LottoPaper();
	Map<String, Set<Integer>> lotto;
	
	

	// 리턴 해줘서 불륜값에 따라 등록하기
	public boolean 티켓등록(int numbers) {
		if (numbers < 6) {
			return false;
		}
		return true;
	}

	// 얘로 선택 방식 확인 및 리턴
	public String 자동버튼(int count) {
		if (count < 6 && count > 0) {
			return "반자동";
		} else if (count == 6) {
			return "수동";
		} else {
			return "자동";
		}
	}
	
	
}
