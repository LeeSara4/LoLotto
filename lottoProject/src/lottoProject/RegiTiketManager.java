package lottoProject;

import java.util.Map;
import java.util.Set;

public class RegiTiketManager {
	LottoPaper lottopaper = new LottoPaper();
	Map<String, Set<Integer>> lotto;
	String lineKey;

	// 리턴 해줘서 불륜값에 따라 등록하기
	public boolean 티켓등록(int numbers) {
		if (numbers < 6) {
			return false;
		}
		return true;
	}

	// 얘로 자동인지 확인
	public String 자동버튼(int count) {
		if (count < 6 && count > 0) {
			return "반자동";
		} else if (count == 6) {
			return "수동";
		} else {
			return "자동";
		}
	}

	/*
	 * // lottoPaper 넘겨주기 public 구매내역반환(맵타입 받기) { lotto = new HashMap<>();
	 * Set<Integer> numbers = new TreeSet<>(); numbers.add(getValue); // 정령되면서 리스트
	 * 입력
	 * 
	 * return 맵타입 구매내역반환 } public void 초기화() { }
	 * 
	 */
}
