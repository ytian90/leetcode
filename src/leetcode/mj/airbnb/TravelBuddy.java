package leetcode.mj.airbnb;

import java.util.*;

/**
 * 6. Travel Buddy
 */
public class TravelBuddy {

    class Buddy implements Comparable<Buddy> {
        String name;
        int similarity;
        Set<String> wishList;

        Buddy(String name, int similarity, Set<String> wishList) {
            this.name = name;
            this.similarity = similarity;
            this.wishList = wishList;
        }

        @Override
        public int compareTo(Buddy that) {
            return that.similarity - this.similarity;
        }
    }

    private List<Buddy> buddies;
    private Set<String> myWishList;

    public TravelBuddy(Set<String> myWishList, Map<String, Set<String>> friendWishList) {
        this.buddies = new ArrayList<>();
        this.myWishList = myWishList;
        for (String name : friendWishList.keySet()) {
            Set<String> wishList = friendWishList.get(name);
            Set<String> intersection = new HashSet<>(wishList);
            intersection.retainAll(myWishList);
            int similarity = intersection.size();
            if (similarity >= wishList.size() / 2) {
                buddies.add(new Buddy(name, similarity, wishList));
            }
        }
    }

    public List<Buddy> getSortedBuddies() {
        Collections.sort(buddies);
        List<Buddy> res = new ArrayList<>(buddies);
        return res;
    }

    public List<String> recommendCities(int k) {
        List<String> res = new ArrayList<>();
        List<Buddy> buddies = getSortedBuddies();

        int i = 0;
        while (k > 0 && i < buddies.size()) {
            Set<String> diff = new HashSet<>(buddies.get(i).wishList);
            diff.removeAll(myWishList);
            if (diff.size() <= k) {
                res.addAll(diff);
                k -= diff.size();
                i++;
            } else {
                Iterator<String> iter = diff.iterator();
                while (k > 0) {
                    res.add(iter.next());
                    k--;
                }
            }
        }
        return res;
    }
}
