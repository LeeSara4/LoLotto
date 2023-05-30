// 임태경
package lottoProject;

import java.util.Map;
import java.util.Set;

public class PaymentTicketManager {
	PaymentLottoPaper pmLottoPaper = new PaymentLottoPaper();
	Map<String, Set<Integer>> lotto;
	private LottoBuyingList lottoList;

	public void addLotto(LottoPaper lotto) {
		lottoList.getBuyList().add(lotto);
	}

	// 등록한 티켓 정보 가져오기
	public void setRegiTicket(Map<String, Set<Integer>> lotto) {
		this.lotto = lotto;
	}

	// 결제한 맵 가져오기
	public Map<String, Set<Integer>> getPmTicket() {
		return this.lotto;
	}
	/*
	 * // 결제예정 티켓 초기화 public String pmTicketReset(int i) {
	 * 
	 * }
	 */
}
