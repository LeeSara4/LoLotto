// 임태경
package lottoProject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PaymentTicketManager {
	PaymentLottoPaper pmLottoPaper = new PaymentLottoPaper();
	Map<String, Set<Integer>> lotto;

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

	public static void main(String[] args) {
		PaymentTicketManager a = new PaymentTicketManager();
		a.lotto = new HashMap<>();
		HashSet<Integer> test = new HashSet<>();
		test.add(1);
		test.add(3);
		test.add(5);
		test.add(6);
		test.add(20);
		test.add(30);

		a.lotto.put("1", test);
		System.out.println(a.lotto.get("1"));
		/*
		 * Iterator<Entry<String, Set<Integer>>> entries =
		 * a.lotto.entrySet().iterator(); while (entries.hasNext()) {
		 * System.out.println(entries.next().getValue() + " " +
		 * entries.next().getKey()); }
		 */
	}
}
