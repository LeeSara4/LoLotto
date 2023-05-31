package lottoProject;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoPaper {
	private Map<Integer, Set<Integer>> lotto;
	private List<Integer> count; // 생성된 로또 번호의 수동,자동,반자동 확인용
	private LocalDate nowDate;
	private LocalTime nowTime;

	public LottoPaper() {
		// 생성시 초기화
		this.lotto = new HashMap<>();
		count = new ArrayList<>();
	}

	public Map<Integer, Set<Integer>> getLotto() {
		return lotto;
	}

	public void setLotto(Map<Integer, Set<Integer>> lotto) {
		this.lotto = lotto;
	}

	public List<Integer> getCount() {
		return count;
	}

	public void setCount(List<Integer> count) {
		this.count = count;
	}

	public LocalDate getNowDate() {
		return nowDate;
	}

	public void setNowDate(LocalDate nowDate) {
		this.nowDate = nowDate;
	}

	public LocalTime getNowTime() {
		return nowTime;
	}

	public void setNowTime(LocalTime nowTime) {
		this.nowTime = nowTime;
	}

	@Override
	public String toString() {
		return "LottoPaper [lotto=" + lotto + ", count=" + count + "]";

	}
}
