package lottoProject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoPaper {
	private Map<String, Set<Integer>> lotto;
	private List<Integer> count; // 생성된 로또 번호의 수동,자동,반자동 확인용

	public LottoPaper() {
		// 생성시 초기화
		this.lotto = new HashMap<>();
		count = new ArrayList<>();
	}

	public Map<String, Set<Integer>> getLotto() {
		return lotto;
	}

	public void setLotto(Map<String, Set<Integer>> lotto) {
		this.lotto = lotto;
	}

	public List<Integer> getCount() {
		return count;
	}

	public void setCount(List<Integer> count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "LottoPaper [lotto=" + lotto + ", count=" + count + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((lotto == null) ? 0 : lotto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof LottoPaper))
			return false;
		LottoPaper other = (LottoPaper) obj;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (lotto == null) {
			if (other.lotto != null)
				return false;
		} else if (!lotto.equals(other.lotto))
			return false;
		return true;
	}

}
