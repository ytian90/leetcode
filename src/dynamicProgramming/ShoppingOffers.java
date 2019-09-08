package dynamicProgramming;

import java.util.*;

/**
 * 638. Shopping Offers
 * @author ytian
 *
 */
public class ShoppingOffers {

	public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		Map<List<Integer>, Integer> memo = new HashMap<>();
		return helper(price, special, needs, memo);
	}

	private static int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs,
							  Map<List<Integer>, Integer> memo) {
		if (memo.containsKey(needs)) {
			return memo.get(needs);
		}
		int j = 0, res = sum(needs, price);
		for (List<Integer> s : special) {
			List<Integer> newNeeds = new ArrayList<>(needs);
			for (j = 0; j < needs.size(); j++) {
				int diff = newNeeds.get(j) - s.get(j);
				if (diff < 0) break;
				newNeeds.set(j, diff);
			}
			if (j == needs.size()) {
				res = Math.min(res, s.get(j) + helper(price, special, newNeeds, memo));
			}
		}
		memo.put(needs, res);
		return res;
	}

	public static int sum(List<Integer> a, List<Integer> b) {
		int res = 0;
		for (int i = 0; i < a.size(); i++) {
			res += a.get(i) * b.get(i);
		}
		return res;
	}

	public static void main(String[] args) {
		List<Integer> p1 = Arrays.asList(2, 5);
		List<List<Integer>> s1 = Arrays.asList(
				Arrays.asList(3, 0, 5),
				Arrays.asList(1, 2, 10));
		List<Integer> n1 = Arrays.asList(3, 2);
		System.out.println(shoppingOffers(p1, s1, n1));

		List<Integer> p2 = Arrays.asList(2, 3, 4);
		List<List<Integer>> s2 = Arrays.asList(
				Arrays.asList(1, 1, 0, 4),
				Arrays.asList(2, 2, 1, 9));
		List<Integer> n2 = Arrays.asList(1, 2, 1);
		System.out.println(shoppingOffers(p2, s2, n2));

	}

	public static int shoppingOffers1(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int res = Integer.MAX_VALUE;
        int k = needs.size();
        for (int i = 0; i < special.size(); i++) {
        	List<Integer> offer = special.get(i);
        	int validOffer = -1;
        	for (int j = 0; j < k; j++) {
        		if (needs.get(j) < offer.get(j)) {
        			validOffer = j;
        			break;
        		}
        		needs.set(j, needs.get(j) - offer.get(j));
        	}
        	// if isMidValTooSmall offer, add offer price and recurse remaining needs
        	if (validOffer == -1) {
        		res = Math.min(res, shoppingOffers(price, special, needs) + offer.get(offer.size() - 1));
        		validOffer = k;
        	}
        	for (int j = 0; j < validOffer; j++) {  // reset the needs
        		needs.set(j, needs.get(j) + offer.get(j));
        	}
        }
        // choose b/w offer and non offer
        int nonOfferPrice = 0;
        for (int i = 0; i < needs.size(); i++) {
        	nonOfferPrice += price.get(i) * needs.get(i);
        }
        return Math.min(res, nonOfferPrice);
    }


}
