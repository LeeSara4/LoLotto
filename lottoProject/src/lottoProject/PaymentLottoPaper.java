package lottoProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PaymentLottoPaper {
	private Map<String, Set<Integer>> lotto;
	private List<Integer> count;

	public PaymentLottoPaper() {
		this.lotto = new HashMap<>();
		count = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "PaymentLottoPaper [lotto=" + lotto + ", count=" + count + "]";
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentLottoPaper other = (PaymentLottoPaper) obj;
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

}
